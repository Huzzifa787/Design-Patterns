import java.util.ArrayList;
//
//interface Component{
//    public void display();
//    public String getName();
//}
//
//class MenuItems implements Component{
//    private String name;
//
//    public MenuItems(String name){
//        this.name = name;
//    }
//    @Override
//    public void display() {
//        System.out.println(name);
//    }
//
//    @Override
//    public String getName() {
//        return name;
//    }
//}
//class Menu implements Component{
//    private String name;
//    private ArrayList<Component> components = new ArrayList<Component>();
//    public Menu(String name){
//        this.name = name;
//    }
//    public void add(Component c){
//        components.add(c);
//    }
//    public void remove(Component c){
//        components.remove(c);
//    }
//    @Override
//    public void display() {
//        System.out.println(name);
//        for(Component c :components){
//            c.display();
//        }
//    }
//
//
//    @Override
//    public String getName() {
//        return name;
//    }
//}

abstract class EmployeeComponent {
    private String name;

    public EmployeeComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void display();
}

class Department extends EmployeeComponent {
    private ArrayList<EmployeeComponent> employees = new ArrayList<EmployeeComponent>();

    public Department(String name) {
        super(name);
    }

    public void add(EmployeeComponent employee) {
        employees.add(employee);
    }

    public void remove(EmployeeComponent employee) {
        employees.remove(employee);
    }

    public void display() {
        System.out.println(getName());
        for (EmployeeComponent employee : employees) {
            employee.display();
        }
    }
}

class Manager extends EmployeeComponent {
    private ArrayList<EmployeeComponent> employees = new ArrayList<EmployeeComponent>();

    public Manager(String name) {
        super(name);
    }

    public void add(EmployeeComponent employee) {
        employees.add(employee);
    }

    public void remove(EmployeeComponent employee) {
        employees.remove(employee);
    }

    public void display() {
        System.out.println(getName() + " (Manager)");
        for (EmployeeComponent employee : employees) {
            employee.display();
        }
    }
}

class Employee extends EmployeeComponent {
    public Employee(String name) {
        super(name);
    }

    public void display() {
        System.out.println(getName());
    }
}
public class Main {
    public static void main(String[] args) {

        // Create departments
        Department sales = new Department("Sales");
        Department marketing = new Department("Marketing");

        // Create managers
        Manager salesManager = new Manager("John Smith");
        Manager marketingManager = new Manager("Mary Johnson");

        // Create employees
        Employee employee1 = new Employee("Bob Jones");
        Employee employee2 = new Employee("Alice Lee");

        // Add employees to managers
        salesManager.add(employee1);
        marketingManager.add(employee2);

        // Add managers to departments
        sales.add(salesManager);
        marketing.add(marketingManager);

        // Display company hierarchy
        sales.display();
        marketing.display();

//        Menu menu1 = new Menu("Main Menu");
//        Menu menu2 = new Menu("Sub Menu");
//        Component menuItem1 = new MenuItems("Menu Items 1");
//        Component menuItem2 = new MenuItems("Menu Items 2");
//
//        menu2.add(menuItem1);
//        menu2.add(menuItem2);
//
//        menu1.add(menu2);
//
//        menu1.display();
//        System.out.println("Hello world!");
    }
}