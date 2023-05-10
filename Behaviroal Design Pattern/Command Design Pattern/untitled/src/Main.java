import java.util.ArrayList;
import java.util.List;

interface Device{
    void turnon();
    void turnoff();
}

class Television implements Device{

    @Override
    public void turnon() {
        System.out.println("Television is On");
    }

    @Override
    public void turnoff() {
        System.out.println("Television is off");
    }
}

interface Command{
    void excuete();
}

class TurnOnCommand implements Command{

    private Device device;
    public TurnOnCommand(Device d){
        this.device =d;
    }

    @Override
    public void excuete() {
        device.turnon();
    }
}

class TurnOffCommand implements Command{
    private Device device;

    public TurnOffCommand(Device d){
        this.device =d;
    }
    @Override
    public void excuete() {
        device.turnoff();
    }
}

class RemoteControl{
    private List<Command> commands = new ArrayList<>();

    void addCommand(Command command){
        commands.add(command);
    }
    void excueteCommand(){
        for (Command command: commands){
            command.excuete();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Device television = new Television();

        Command turnOnCommand = new TurnOnCommand(television);
        Command turnOffCommand  = new TurnOffCommand(television);

        remoteControl.addCommand(turnOnCommand);
        remoteControl.addCommand(turnOffCommand);

        remoteControl.excueteCommand();
//        System.out.println("Hello world!");
    }
}