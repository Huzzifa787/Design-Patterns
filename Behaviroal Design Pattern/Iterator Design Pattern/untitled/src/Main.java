import java.util.ArrayList;
import java.util.List;

interface Iterator{
    boolean hasNext();
    Object next();
}

class StringIterator implements Iterator{

    private List<String> strings;
    private int positon =0;
    public  StringIterator(List<String> s){
        this.strings =s;
    }
    @Override
    public boolean hasNext() {
        return positon<strings.size();
    }

    @Override
    public Object next() {
        String str = strings.get(positon);
        positon++;
        return str;
    }
}

interface Collection {
    void addStrings(String str);
    Iterator iterator();
}

class StringCollection implements Collection{
    private List<String> strings =new ArrayList<>();
    public void addStrings(String str){
        strings.add(str);
    }

    public Iterator iterator(){
        return new StringIterator(strings);
    }
}



public class Main {
    public static void main(String[] args) {

        StringCollection collection = new StringCollection();

        collection.addStrings("Hello");
        collection.addStrings("World");
        collection.addStrings("!");

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            String str = (String) iterator.next();
            System.out.println(str);
        }
//        System.out.println("Hello world!");
    }
}