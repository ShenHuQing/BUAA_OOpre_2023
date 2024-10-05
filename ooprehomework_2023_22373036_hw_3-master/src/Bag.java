import java.util.HashMap;

public class Bag {

    private HashMap<Integer, Bottle> bottles;
    private HashMap<Integer, Equipment> equipments;
    private HashMap<Integer,Food> foods;

    public Bag() {
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
        this.foods = new HashMap<>();
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

    public void clearEquipment(Bag bag) {
        bag.getEquipments().clear();
    }

}

