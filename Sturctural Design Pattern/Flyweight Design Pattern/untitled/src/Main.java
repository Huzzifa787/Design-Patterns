import java.util.HashMap;
import java.util.Map;

interface GameObject{
    void draw(int x, int y);
}
class Tree implements GameObject{

    private String texture;
    public Tree(String text){
        this.texture = text;
    }
    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a Tree at ("+x+","+y+") with texture "+texture);
    }
}

class GameObjectFactory {
    private static Map<String,GameObject> gameObjectMap= new HashMap<>();

    public static GameObject getGameObject(String texture){
        GameObject gameObject = gameObjectMap.get(texture);

        if (gameObject==null){
            gameObject = new Tree(texture);
            gameObjectMap.put(texture,gameObject);
        }
        return gameObject;
    }
}
public class Main {
    public static void main(String[] args) {
        GameObject gameObject1 = GameObjectFactory.getGameObject("tree.png");
        GameObject gameObject2 = GameObjectFactory.getGameObject("tree.png");
        GameObject gameObject3 = GameObjectFactory.getGameObject("tree.png");

        gameObject1.draw(10,10);
        gameObject2.draw(10,20);
        gameObject3.draw(30,30);

//        System.out.println("Hello world!");
    }
}