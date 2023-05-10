
class SubSystemA{
    public void Initialize(){
        System.out.println("Initializng SubSytem A...... ");
    }
    public void start(){
        System.out.println("Starting SubSystem A...");
    }
}
class SubSystemB{
    public void Initialize(){
        System.out.println("Initializng SubSytem B...... ");
    }
    public void start(){
        System.out.println("Starting SubSystem B...");
    }
}
class SubSystemC{
    public void Initialize(){
        System.out.println("Initializng SubSytem C...... ");
    }
    public void start(){
        System.out.println("Starting SubSystem C...");
    }
}

class SystemFacade{
    protected SubSystemA subSystemA;
    private SubSystemB subSystemB;
    private SubSystemC subSystemC;

    public SystemFacade()
    {
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
        subSystemC = new SubSystemC();
    }
    public void Initialize(){
        subSystemA.Initialize();
        subSystemB.Initialize();
        subSystemC.Initialize();
    }
    public void start(){
        subSystemA.start();
        subSystemB.start();
        subSystemC.start();
    }
}
public class Main {
    public static void main(String[] args) {
        SystemFacade facade = new SystemFacade();
        facade.Initialize();
        facade.start();
    }
}
