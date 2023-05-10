
interface Expression{
    boolean interpret(String context);
}

class TerminalExpression implements  Expression{

    private String data;
    public TerminalExpression(String data){
        this.data = data;
    }
    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}

class OrExpression implements Expression{

    private Expression exp1;
    private Expression exp2;

    public OrExpression(Expression exp1,Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    @Override
    public boolean interpret(String context) {
        return exp1.interpret(context) || exp2.interpret(context);
    }
}

class AndExpression implements Expression{

    private Expression exp1;
    private Expression exp2;

    public AndExpression(Expression exp1,Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    @Override
    public boolean interpret(String context) {
        return exp1.interpret(context) && exp2.interpret(context);
    }
}

public class Main {

    public static Expression getMaleExpression(){
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert,john);
    }
    public static Expression getMarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie,married);
    }

    public static void main(String[] args) {

        Expression isMale = getMaleExpression();
        Expression isMarriedWomen = getMarriedWomanExpression();

        System.out.println(" John is male? "+isMale.interpret("John"));
        System.out.println(" Julie is married Women? "+isMarriedWomen.interpret(" Married Julie"));

    }
}