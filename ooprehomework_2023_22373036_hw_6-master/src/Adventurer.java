import java.util.HashMap;

public class Adventurer implements Commodity {
    private int id;
    private String name;
    private HashMap<Integer, Bottle> bottles;
    private HashMap<Integer, Equipment> equipments;
    private HashMap<Integer, Adventurer> employees;
    private int level;
    private int hitpoint;
    private HashMap<Integer,Food> foods;
    private Bag bag;
    private long equipValue = 0L;
    private long foodValue = 0L;
    private long bottleValue = 0L;
    private long hireValue = 0L;
    private int valueCount = 0;

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
        this.foods = new HashMap<>();
        this.employees = new HashMap<>();
        this.level = 1;
        this.hitpoint = 500;
        this.bag = new Bag();
        this.valueCount = 0;
        this.bottleValue = 0L;
        this.foodValue = 0L;
        this.hireValue = 0L;
        this.equipValue = 0L;
    }

    public HashMap<Integer, Adventurer> getEmployees() {
        return employees;
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

    public void deleteEquipValue(Equipment equipment) {
        equipValue -= equipment.getValue();
    }

    public void setHireValue(long hireValue) {
        this.hireValue = hireValue;
    }

    public int getValueCount() {
        return valueCount;
    }

    public void setValueCount(int valueCount) {
        this.valueCount = valueCount;
    }

    public void deleteBottleValue(Bottle bottle) {
        bottleValue -= bottle.getValue();
    }

    public void deleteFoodValue(Food food) {
        foodValue -= food.getValue();
    }

    public void enhanceHireValue(Adventurer adventurer) {
        hireValue += adventurer.getValue();
    }

    public void enhanceEquipValue(Equipment equipment) {
        equipValue += equipment.getValue();
    }

    public void enhanceBottleValue(Bottle bottle) {
        bottleValue += bottle.getValue();
    }

    public void enhanceFoodValue(Food food) {
        foodValue += food.getValue();
    }

    @Override
    public long getValue() {
        return equipValue + foodValue + bottleValue + hireValue;
    }
}
