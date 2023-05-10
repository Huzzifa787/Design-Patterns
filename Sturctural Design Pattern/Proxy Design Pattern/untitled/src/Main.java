

interface Image{
    public void display();
    public void loadImage();
}

class RealImage implements Image{

    private String filename;

    public RealImage(String name){
        this.filename  = name;
        loadImage();
    }
    @Override
    public void display() {
        System.out.println("Displaying Image:  "+filename);
    }

    @Override
    public void loadImage() {
        System.out.println("Loading Image :  "+filename);
    }
}

class ProxyImage implements Image{

    private String filename;

    private RealImage realImage;

    public ProxyImage(String name){
        this.filename=name;
    }
    @Override
    public void display() {
        if (realImage==null){
            realImage = new RealImage(filename);
        }
        realImage.display();
    }

    @Override
    public void loadImage() {
        if (realImage==null){
            realImage=new RealImage(filename);
        }

    }
}

public class Main {
    public static void main(String[] args) {
        Image[] images={
                new ProxyImage("Image1.jpg"),
                new ProxyImage("Image2.jpg"),
                new RealImage("Image3.jpg"),
                new ProxyImage("Image4.jpg")
        };

        for (Image img : images){
            img.display();
        }

        //        System.out.println("Hello world!");
    }
}