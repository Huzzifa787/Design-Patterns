
interface HousePlan{
    public void setBasement(String basement);
    public void setStructure(String struct);
    public void setRoof(String roof);

    public void setInterior(String interior);
}
class House implements HousePlan {
    private String basement;
    private String struct;
    private String roof;
    private String interior;
    @Override
    public void setBasement(String basement)
    {
        this.basement = basement;
    }
    public void setStructure(String struct){
        this.struct=struct;
    }
    public void setRoof(String roof)
    {
        this.roof=roof;
    }
    public void setInterior(String interior)
    {
        this.interior=interior;
    }
}

interface HouseBuilder {
    public void buildBasement();
    public void buildStructure();

    public void buildRoof();
    public void buildInterior();
    public House gethouse();
}

class IgloHouse implements HouseBuilder {
    private House house;

    public IgloHouse()
    {
        this.house= new House();
    }
    @Override
    public void buildBasement() {
        house.setBasement("Ice Bars");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Ice Blocks");
    }

    public void buildRoof()
    {
        house.setRoof("Ice Dome");
    }
    public void buildInterior()
    {
        house.setInterior("Ice Craving");
    }

    public House gethouse()
    {
        return this.house;
    }
}

class TipiHouse implements HouseBuilder{

    private House house;

    public TipiHouse()
    {
        this.house= new House();
    }
    @Override
    public void buildBasement() {
        house.setBasement("Wooden Poles");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Wood and Ice");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Fire Wood");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Wood, cariboue and seal skins");
    }

    public House gethouse()
    {
        return this.house;
    }
}

class CivilEngineer
{
    private HouseBuilder houseBuilder;

    public CivilEngineer(HouseBuilder houseBuilder)
    {
        this.houseBuilder=houseBuilder;
    }
    public House gethouse()
    {
        return this.houseBuilder.gethouse();
    }

    public void constructHouse()
    {
        this.houseBuilder.buildBasement();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildInterior();
        this.houseBuilder.buildRoof();
    }
}


public class Main {
    public static void main(String[] args) {
        HouseBuilder builder1 = new IgloHouse();
        CivilEngineer civil = new CivilEngineer(builder1);
        civil.constructHouse();
        House house = civil.gethouse();
        System.out.println("House Builder is :  "+house);
    }
}