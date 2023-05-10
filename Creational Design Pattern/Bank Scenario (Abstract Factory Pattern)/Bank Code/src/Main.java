import java.util.Scanner;

interface Bank{
    String getName();
}
class HBL implements Bank{
    @Override
    public String getName()
    {
        return ("HBL Bank");
    }
}
class UBL implements Bank{
    @Override
    public String getName()
    {
        return ("UBL Bank");
    }
}
class ABL implements Bank{
    @Override
    public String getName()
    {
        return ("ABL Bank");
    }
}

interface Loan{
    String getLoan();
}
class Home implements Loan{
    @Override
    public String getLoan()
    {
        return ("Home Loan");
    }
}
class Education implements Loan{
    @Override
    public String getLoan()
    {
        return ("Eduction Loan");
    }
}
class Bussiness implements Loan{
    @Override
    public String getLoan()
    {
        return ("Bussiness Loan");
    }
}

abstract class AbstractFactory{
    abstract Bank getBank(int choice);
    abstract Loan getLoan(int choice);
}

class BankFactory extends AbstractFactory{
//    @Override
    Bank getBank(int choice)
    {

        if (choice == 1)
        {
            return new HBL();
        }
        else if (choice == 2)
        {
            return new UBL();
        }
        else if (choice == 3)
        {
            return new ABL();
        }
        else
        {
            return null;
        }
    }
    Loan getLoan(int choice){
        return null;
    }
}

class LoanFactory extends AbstractFactory{
    @Override
    Bank getBank(int choice)
    {
        return null;
    }
    Loan getLoan(int choice){



        if (choice == 1)
        {
            return new Home();
        }
        else if (choice == 2)
        {
            return new Education();

        }
        else if (choice == 3)
        {
            return new Bussiness();
        }
        else
        {
            return null;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("==============");
        System.out.println("Main Menu");
        System.out.println("==============");
        System.out.println("Press 1 For HBL");
        System.out.println("Press 2 For UBL");
        System.out.println("Press 3 For ABL");
        System.out.println("Enter Your Choice :  ");
        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();

        AbstractFactory a = new BankFactory();
        Bank ab = a.getBank(choice);
//        ab = ab.getBank(choice);
        System.out.println("Selected Bank is  :   "+ab.getName());

        System.out.println("==============");
        System.out.println("Main Menu");
        System.out.println("==============");
        System.out.println("Press 1 For Home Loan");
        System.out.println("Press 2 For Education Loan");
        System.out.println("Press 3 For Bussiness Loan");
        System.out.println("Enter Your Choice :  ");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        AbstractFactory l = new LoanFactory();
        Loan lo = l.getLoan(c);
        System.out.println("Selected Loan Type is :   "+lo.getLoan());

        System.out.println("--------------------------------------");
        System.out.println("You Have Selected "+ab.getName()+" And You Are Requested For "+lo.getLoan());

    }
}