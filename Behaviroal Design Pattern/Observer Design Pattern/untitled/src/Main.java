import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(String breakingNews);
}

class Subscriber implements Observer{

    private String name;
    public Subscriber(String n){
        this.name=n;
    }
    @Override
    public void update(String breakingNews) {
        System.out.println(name+" received breaking news :   "+breakingNews);
    }
}

interface NewsAgency{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void notifyObserver(String breakingNews);
}

class ABCNews implements NewsAgency{
    private List<Observer> subscriber = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        subscriber.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        subscriber.remove(observer);
    }

    @Override
    public void notifyObserver(String breakingNews) {
        for (Observer observer: subscriber){
            observer.update(breakingNews);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        NewsAgency abcNews = new ABCNews();

        Observer subscriber1 = new Subscriber("John");
        Observer subscriber2 = new Subscriber("Sarah");

        abcNews.registerObserver(subscriber1);
        abcNews.registerObserver(subscriber2);

        abcNews.notifyObserver("Breaking news: The sun is shinning today!");
        abcNews.removeObserver(subscriber1);
        abcNews.notifyObserver("Breaking news: A new resturanent has opened today!");

//        System.out.println("Hello world!");
    }
}