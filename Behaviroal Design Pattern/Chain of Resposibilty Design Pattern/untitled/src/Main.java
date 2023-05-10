enum Priority {
    LOW,
    MEDIUM,
    HIGH
}

class Request {
    private String name;
    private Priority priority;

    public Request(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}

abstract class RequestHandler{
    private RequestHandler nextHandler;

    public void setNextHandler(RequestHandler nextHandler){
        this.nextHandler = nextHandler;
    }
    public void HandleRequest(Request request){
        if(canHandleRequest(request)){
            processRequest(request);
        }
        else if(nextHandler!=null){
            nextHandler.HandleRequest(request);
        }
        else {
            System.out.println("No Handler Found For Request "+request);
        }
    }
    protected abstract boolean canHandleRequest(Request request);

    protected abstract void processRequest(Request request);
}

class LowPriorityHandler extends RequestHandler{

    @Override
    protected boolean canHandleRequest(Request request) {
        return request.getPriority() == Priority.LOW;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("Processing Request "+request+" at Low Priority");
    }
}


class MediumPriorityHandler extends RequestHandler{

    @Override
    protected boolean canHandleRequest(Request request) {
        return request.getPriority() == Priority.MEDIUM;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("Processing Request "+request+" at Medium Priority");
    }
}

class HighPriorityHandler extends RequestHandler{

    @Override
    protected boolean canHandleRequest(Request request) {
        return request.getPriority() == Priority.HIGH;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("Processing Request "+request+" at High Priority");
    }
}
public class Main {
    public static void main(String[] args) {

        RequestHandler LowHandler = new LowPriorityHandler();
        RequestHandler MediumHandler = new MediumPriorityHandler();
        RequestHandler HighHandler = new HighPriorityHandler();

        LowHandler.setNextHandler(MediumHandler);
        MediumHandler.setNextHandler(HighHandler);
        HighHandler.setNextHandler(null);


        Request request1 = new Request("Request 1",Priority.LOW);
        Request request2 = new Request("Request 2",Priority.MEDIUM);
        Request request3 = new Request("Request 3",Priority.HIGH);
        Request request4 = new Request("Request 3",Priority.HIGH);

        LowHandler.HandleRequest(request1);
        LowHandler.HandleRequest(request2);
        LowHandler.HandleRequest(request3);
        LowHandler.HandleRequest(request4);

//        System.out.println("Hello world!");
    }
}