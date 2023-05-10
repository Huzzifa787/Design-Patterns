

class Database<ab> {

    private static Database db;
    private Database() {
        //private Constructor
    }

    public static Database getInstance() {
        if (db == null) {
            db = new Database();
        }
        return db;

    }
    public void query(String select){
        System.out.println(select);
    }
}

public class Main {
    public static void main(String[] args) {

        Database db = Database.getInstance();
        db.query("Select");
        //System.out.println("Hello world!");
        Database dbo = Database.getInstance();
        dbo.query("Hello");
    }
}