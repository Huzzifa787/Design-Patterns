/*
interface Button{
    public void createButton();
}
class WinBtn implements Button{

    @Override
    public void createButton() {
        System.out.println("Window Button");
    }
}
class MacBtn implements Button{
    @Override
    public void createButton()
    {
        System.out.println("Mac Button");
    }
}

interface Dialogue{

    public Button createButton();

}

class Window implements Dialogue{
    @Override
    public Button createButton()
    {
        return new WinBtn();
    }
}
class Web implements Dialogue{
    @Override
    public Button createButton()
    {
        return new MacBtn();
    }
}*/

/*
import java.util.Scanner;

interface Chair{
    public void prepare();
}
class ArtChair implements Chair{
    @Override
    public void prepare(){
        System.out.println("Preparing Art Deco Chair");
    }
}
class VictorainChair implements Chair{
    @Override
    public void prepare() {
        System.out.println("Preparing Victorian Chair");
    }
}
class ModernChair implements Chair{
    @Override
    public void prepare() {
        System.out.println("Preparing Modern Chair");
    }
}

interface Sofa{
    public void prepare();
}

class ArtSofa implements Sofa{
    @Override
    public void prepare() {
        System.out.println("Preparing Art Deco Sofa");
    }
}
class VictoSofa implements Sofa{
    @Override
    public void prepare() {
        System.out.println("Preparing Victorain Sofa");
    }
}
class ModernSofa implements Sofa{
    @Override
    public void prepare() {
        System.out.println("Preparing Modern Sofa");
    }
}

interface Factory{

    public Chair PrepareChair();
    public Sofa PrepareSofa();
}

class ArtDeco implements Factory{
    @Override
    public Chair PrepareChair() {
        return new ArtChair();
    }

    @Override
    public Sofa PrepareSofa() {
        return new ArtSofa();
    }
}

class Victorain implements Factory{
    @Override
    public Chair PrepareChair() {
        return new VictorainChair();
    }

    @Override
    public Sofa PrepareSofa() {
        return new VictoSofa();
    }
}

class Modern implements Factory{
    @Override
    public Chair PrepareChair() {
        return new ModernChair();
    }

    @Override
    public Sofa PrepareSofa() {
        return new ModernSofa();
    }
}
class MainFactory{
    public static Factory getChoice(int choice){
        if (choice == 1){
            return new ArtDeco();
        }
        else if (choice == 2){
            return new Victorain();
        }
        return new Modern();
    }
}*/
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

interface item{
    public String name();
    public String size();
    public double price();

}
abstract class Pizza implements item{
    public abstract double price();
}

abstract class ColdDrink implements item{
    public abstract double price();
}

abstract class VegPizza extends Pizza{
    public abstract double price();
    public abstract String name();
    public abstract String size();
}
abstract class NonVegPizza extends Pizza{
    public abstract double price();
    public abstract String name();
    public abstract String size();
}

class SmallCheesePizza extends VegPizza{
    @Override
    public double price() {
        return 350.0;
    }
    @Override
    public String name() {
        return "Cheese Pizza";
    }

    @Override
    public String size() {
        return "Small Size";
    }


}
class LargeCheesePizza extends VegPizza{
    @Override
    public double price() {
        return 1200.0;
    }
    @Override
    public String name() {
        return "Cheese Pizza";
    }

    @Override
    public String size() {
        return "Large Size";
    }
}

class SmallOnionPizza extends VegPizza{
    @Override
    public double price() {
        return 250.0;
    }
    @Override
    public String name() {
        return "Onion Pizza";
    }

    @Override
    public String size() {
        return "Small Size";
    }


}
class LargeOnionPizza extends VegPizza{
    @Override
    public double price() {
        return 1000.0;
    }
    @Override
    public String name() {
        return "Onion Pizza";
    }

    @Override
    public String size() {
        return "Large Size";
    }
}

class SmallNonVegPizza extends NonVegPizza{
    @Override
    public double price() {
        return 150.0;
    }
    @Override
    public String name() {
        return "Non-Veg Pizza";
    }

    @Override
    public String size() {
        return "Small Size";
    }


}
class LargeNonVegPizza extends NonVegPizza{
    @Override
    public double price() {
        return 850.0;
    }
    @Override
    public String name() {
        return "Onion Pizza";
    }

    @Override
    public String size() {
        return "Large Size";
    }
}

abstract class Pepsi extends ColdDrink{
    public abstract String name();
    public abstract String size();
    public abstract double price();

}
abstract class Coke extends ColdDrink{
    public abstract String name();
    public abstract String size();
    public abstract double price();

}

class SmallPepsi extends Pepsi{
    @Override
    public double price() {
        return 80;
    }

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public String size() {
        return "Small Pepsi";
    }
}
class LargePepsi extends Pepsi{
    @Override
    public double price() {
        return 160;
    }

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public String size() {
        return "Large Pepsi";
    }
}
class SmallCoke extends Coke{
    @Override
    public double price() {
        return 100;
    }

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public String size() {
        return "Small Coke";
    }
}
class LargeCoke extends Coke{
    @Override
    public double price() {
        return 200;
    }

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public String size() {
        return "Large Pepsi";
    }
}

class OrderedItem{
    List <item> items = new ArrayList<item>();
    public void AddItem(item item)
    {
        items.add(item);
    }
    public double getCost(){
        double cost = 0;
        for (item item:items){
            cost+=item.price();
        }
        return cost;
    }
    public void showitem(){
        for (item item:items){
            System.out.println("Name   :  "+item.name());
            System.out.println("Size   :  "+item.size());
            System.out.println("Price  :  "+item.price());
        }
    }
}
class OrderBuilder{
    public OrderedItem PreparePizza() throws IOException {
        OrderedItem itemOrder = new OrderedItem();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("PRESS 1 FOR VEG PIZZA");
        System.out.println("PRESS 2 FOR NON-VEG PIZZA");
        System.out.println("PRESS 3 FOR EXIT");
        System.out.print("\nEnter Your Choice :  ");
        int choice = Integer.parseInt(br.readLine());
        switch (choice){
            case 1:{
                System.out.println("You Ordered VEG Pizza");
                System.out.println("\n\n");
                System.out.println("PRESS 1 FOR CHEESE PIZZA");
                System.out.println("PRESS 2 FOR ONION PIZZA");
                System.out.println("PRESS 3 FOR EXIT");
                System.out.print("\nEnter Your Choice :  ");
                int veg = Integer.parseInt(br.readLine());
                switch (veg)
                {
                    case 1:{
                        System.out.println("You Ordered CHEESE Pizza");
                        System.out.println("\n\n");
                        System.out.println("PRESS 1 FOR SMALL-CHEESE PIZZA");
                        System.out.println("PRESS 2 FOR LARGE-CHEESE PIZZA");
                        System.out.println("PRESS 3 FOR EXIT");
                        System.out.print("\nEnter Your Choice :  ");
                        int chsize = Integer.parseInt(br.readLine());
                        switch (chsize){
                            case 1:{
                                itemOrder.AddItem(new SmallCheesePizza());
                                break;

                            }
                            case 2:{
                                itemOrder.AddItem(new LargeCheesePizza());
                                break;
                            }
                        }
                        break;
                    }
                    case 2:{
                        System.out.println("You Ordered ONION Pizza");
                        System.out.println("\n\n");
                        System.out.println("PRESS 1 FOR SMALL-ONION PIZZA");
                        System.out.println("PRESS 2 FOR LARGE-ONION PIZZA");
                        System.out.println("PRESS 3 FOR EXIT");
                        System.out.print("\nEnter Your Choice :  ");
                        int onsize = Integer.parseInt(br.readLine());
                        switch (onsize){
                            case 1:{
                                itemOrder.AddItem(new SmallOnionPizza());
                                break;

                            }
                            case 2:{
                                itemOrder.AddItem(new LargeOnionPizza());
                                break;
                            }
                        }
                        break;
                    }

                }
                break;
            }
            case 2:{
                System.out.println("You Ordered NON-VEG Pizza");
                System.out.println("\n\n");
                System.out.println("PRESS 1 FOR SMALL-NONVEG PIZZA");
                System.out.println("PRESS 2 FOR LARGE-NONVEG PIZZA");
                System.out.println("PRESS 3 FOR EXIT");
                System.out.print("\nEnter Your Choice :  ");
                int nonveg = Integer.parseInt(br.readLine());
                switch (nonveg){
                    case 1:{
                        itemOrder.AddItem(new SmallNonVegPizza());
                        break;
                    }
                    case 2:{
                        itemOrder.AddItem(new LargeNonVegPizza());
                        break;
                    }
                }
                break;
            }
            default:{
                break;
            }

        }//First Switch Ends

        System.out.println("PRESS 1 FOR PEPSI");
        System.out.println("PRESS 2 FOR COKE");
        System.out.println("PRESS 3 FOR EXIT");
        System.out.print("\nEnter Your Choice :  ");
        int drink = Integer.parseInt(br.readLine());
        switch (drink){
            case 1:{
                System.out.println("You Selected Pepsi");
                System.out.println("PRESS 1 FOR SMALL PEPSI");
                System.out.println("PRESS 2 FOR LARGE PEPSI");
                System.out.println("PRESS 3 FOR EXIT");
                System.out.print("\nEnter Your Choice :  ");
                int ch = Integer.parseInt(br.readLine());
                switch (ch)
                {
                    case 1:
                    {
                        itemOrder.AddItem(new SmallPepsi());
                        break;
                    }
                    case 2:{
                        itemOrder.AddItem(new LargePepsi());
                        break;
                    }
                }
                break;
            }
            case 2:{
                System.out.println("You Have Selected COKE");
                System.out.println("PRESS 1 FOR SMALL COKE");
                System.out.println("PRESS 2 FOR LARGE COKE");
                System.out.println("PRESS 3 FOR EXIT");
                System.out.print("\nEnter Your Choice :  ");
                int c = Integer.parseInt(br.readLine());
                switch (c)
                {
                    case 1:
                    {
                        itemOrder.AddItem(new SmallCoke());
                        break;
                    }
                    case 2:{
                        itemOrder.AddItem(new LargeCoke());
                        break;
                    }
                }
                break;
            }
            default:{
                break;
            }

        }
        return itemOrder;
    }
}*/
/*
import java.util.ArrayList;
import java.util.List;

class NumberSorter{
    public List<Integer> sort(List<Integer> number){
        return new ArrayList<Integer>();
    }
}
interface Sorter{
    public int[] sort(int[] number);
}

class SortListAdapter implements Sorter{
    @Override
    public int[] sort(int[] number) {
        List<Integer> numberList = new ArrayList<Integer>();
        NumberSorter numberSorter = new NumberSorter();
        numberList = numberSorter.sort(numberList);
        //ArrayList<Integer> no = new List<Integer>();
        return number;
    }
}
*/

interface Color{
    public void applyColor();
}
class Red implements Color{
    @Override
    public void applyColor() {
        System.out.println("Red Color");
    }
}
class Blue implements Color{
    @Override
    public void applyColor() {
        System.out.println("Blue Color");
    }
}
abstract class Shape{
    protected Color color;

    public Shape(Color color){
        this.color = color;
    }
    public abstract void draw();

}
class Square extends Shape{
    public Square(Color color){
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Sqaure Filled with Color");
        color.applyColor();
    }
}
class Circle extends Shape{
    public Circle(Color color){
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Circle Filled with Color");
        color.applyColor();
    }
}


public class Main {
    public static void main(String[] args) {

        /*
        Dialogue c = new Window();
        Button b = c.createButton();
        b.createButton();

        Dialogue d = new Web();
        Button f = d.createButton();
        f.createButton();

        System.out.println("PRESS 1 FOR ARTDECO");
        System.out.println("PRESS 2 FOR VICTORIAN");
        System.out.println("PRESS 3 FOR MODERN");
        System.out.print("\nEnter Your Choice :  ");
        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();
        Factory f  = MainFactory.getChoice(choice);
        Chair c = f.PrepareChair();
        Sofa s = f.PrepareSofa();

        c.prepare();
        s.prepare();

        OrderBuilder builder = new OrderBuilder();
        OrderedItem orderedItems = builder.PreparePizza();
        orderedItems.showitem();
        System.out.println("\n");
        System.out.println("Total Cost is :   "+orderedItems.getCost());*/
/*
        int[] numbers = new int[]{34,2,4,12,1};
        int[] res;
        Sorter sorter = new SortListAdapter();
        res = sorter.sort(numbers);
        for (int number : res){
            System.out.print(number+" ");

        }
*/
        Square sq = new Square(new Red());
        sq.draw();

        Circle c = new Circle(new Blue());
        c.draw();
        //System.out.println("Hello world!");
    }
}