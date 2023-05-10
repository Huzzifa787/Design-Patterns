
interface SortingStrategy{
    void sort(int[] data);
}

class BubbleSort implements SortingStrategy{

    @Override
    public void sort(int[] data) {
        System.out.println("Sorting Using Bubble Sort");

    }
}

class MergeSort implements SortingStrategy{

    @Override
    public void sort(int[] data) {
        System.out.println("Sorting Using Merge Sort");
    }
}
class QuickSort implements SortingStrategy{

    @Override
    public void sort(int[] data) {
        System.out.println("Sorting Using Quick Sort");
    }
}

class Sorter{
    private SortingStrategy sortingStrategy;

    void setStrategy(SortingStrategy strategy){
        this.sortingStrategy = strategy;
    }
    void sort(int[] data){
        sortingStrategy.sort(data);
    }

}
public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        int[] data ={10,1,8,90,5,2,5,12,9};

        sorter.setStrategy(new BubbleSort());
        sorter.sort(data);
        for (int d : data){
            System.out.print(d+" ");
        }

        sorter.setStrategy(new MergeSort());
        sorter.sort(data);

        sorter.setStrategy(new QuickSort());
        sorter.sort(data);


//        System.out.println("Hello world!");
    }
}