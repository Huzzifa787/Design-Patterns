
interface pizza{
    public String getDescription();
    public double getCost();
}

class PlainPizza implements pizza{

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 4.00;
    }
}

abstract class PizzaDecorate implements pizza{
    protected pizza pizza;

    public PizzaDecorate(pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

class Cheese extends PizzaDecorate{

    public Cheese(pizza pizza){
        super(pizza);
    }
    @Override
    public String getDescription() {
        return super.getDescription()+", cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50;
    }
}
class peproni extends PizzaDecorate{


    public peproni(pizza pizza)
    {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return super.getDescription()+ ",Pepproni ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 4.00;
    }
}

public class Main {
    public static void main(String[] args) {

        pizza pizza = new Cheese(new peproni(new PlainPizza()));
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());
        System.out.println("Hello world!");
    }
}