
interface VendingMachineState{
    void insertMoney();
    void ejectMoney();
    void selectProduct();
    void dispense();
}

class ReadyState implements VendingMachineState{

    @Override
    public void insertMoney() {
        System.out.println("Money Inserted");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Money Ejected");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product Selected");
    }

    @Override
    public void dispense() {
        System.out.println("Payment Required");
    }
}

class DispensingState implements VendingMachineState{

    @Override
    public void insertMoney() {
        System.out.println("Please wait, currently dispensing a product");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Please wait, currently dispensing a product");
    }

    @Override
    public void selectProduct() {
        System.out.println("Please wait, currently dispensing a product");
    }

    @Override
    public void dispense() {
        System.out.println("Product Dispensed");
    }
}

class VendingMachine{
    private VendingMachineState currentState;

    public VendingMachine(){
        currentState = new ReadyState();
    }
    void setState (VendingMachineState state){
        currentState = state;
    }
    void insertMoney(){
        currentState.insertMoney();
    }
    void ejectMoney(){
        currentState.ejectMoney();
    }
    void selectProduct(){
        currentState.selectProduct();
        setState(new DispensingState());
    }
    void dispense(){
        currentState.dispense();
    }
}

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertMoney();
        vendingMachine.selectProduct();
        vendingMachine.dispense();

        vendingMachine.insertMoney();
        vendingMachine.ejectMoney();
        vendingMachine.selectProduct();
        vendingMachine.dispense();

//        System.out.println("Hello world!");
    }
}