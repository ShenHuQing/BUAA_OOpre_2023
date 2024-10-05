import java.util.HashMap;

public class Adventurer {
    private int id;
    private String name;
    private HashMap<Integer, Bottle> bottles;
    private HashMap<Integer, Equipment> equipments;
    private int level;
    private int hitpoint;
    private HashMap<Integer,Food> foods;
    private Bag bag;

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
        this.foods = new HashMap<>();
        this.level = 1;
        this.hitpoint = 500;
        this.bag = new Bag();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, Bottle> getBottles() {
        return bottles;
    }

    public HashMap<Integer, Equipment> getEquipments() {
        return equipments;
    }

    public HashMap<Integer, Food> getFoods() {
        return foods;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHitpoint() {
        return hitpoint;
    }

    public void setHitpoint(int hitpoint) {
        this.hitpoint = hitpoint;
    }

    public Bag getBag() {
        return bag;
    }

}

