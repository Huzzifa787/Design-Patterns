import java.util.ArrayList;
import java.util.List;

abstract class Vehicle{
    // Class Variable
    protected int seats;
    protected int tyres;
    protected String color;
    protected String fuel;
    public Vehicle()
    {
        //Default Constructor
    }
    public Vehicle(Vehicle v)
    {
        // Parametrized Constructor
        if (v != null)
        {
            // Copying values from original object
            this.seats=v.seats;
            this.tyres=v.tyres;
            this.color=v.color;
            this.fuel=v.fuel;
        }

    }
    //Abstract Clone Method for Child Classes
    public abstract Vehicle clone();

    @Override
    public String toString()
    {
        return "Seats : "+this.seats+"\nTyres : "+this.tyres+"\nColor : "+this.color+"\nFuel :  "+this.fuel;
    }
}

class Bike extends Vehicle{

    public Bike(){
        //Default Constructor

    }
    public Bike(Bike b)
    {
        //Calling Parent Object To Inialize Objects
        super(b);
    }

    @Override
    public Vehicle clone()
    {
        return new Bike(this);
    }
}

class Car extends Vehicle{

    public Car(){
        //Default Constructor
    }
    public Car(Car c)
    {
        //Calling Parent Object To Inialize Objects
        super(c);
    }

    @Override
    public Vehicle clone()
    {
        return new Car(this);
    }
}



public class Main{
    public static void main(String[] args) {

        // List of Original Objects
        List<Vehicle> vehicles = new ArrayList<>();
        // List of Cloned Objects
        List<Vehicle> vehiclesCopy = new ArrayList<>();

        // Bike
        Bike b1 = new Bike();
        b1.seats = 1;
        b1.tyres = 2;
        b1.color = "Black";
        b1.fuel = "Petrol";
        vehicles.add(b1);

        // Car
        Car c1 = new Car();
        c1.seats = 5;
        c1.tyres = 4;
        c1.color = "Yellow";
        c1.fuel = "Electric";
        vehicles.add(c1);

        for (Vehicle vehicle : vehicles)
        {
            // Cloning Each Object
            vehiclesCopy.add(vehicle.clone());
        }
        System.out.println("\t\tOriginal Objects are   \n");

        for (Vehicle vehicle : vehicles)
        {
            System.out.println(vehicle.toString());
            System.out.println("----------------------------------------");
        }
        System.out.println("\t\tPrototyped Objects are \n");
        for (Vehicle vehicle : vehicles)
        {
            System.out.println(vehicle.toString());
            System.out.println("----------------------------------------");
        }


    }
}