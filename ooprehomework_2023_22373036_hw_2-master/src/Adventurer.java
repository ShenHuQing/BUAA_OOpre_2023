package src;

import java.util.HashMap;

public class Adventurer {
    private int id;
    private String name;
    private HashMap<Integer, Bottle> bottles;
    private HashMap<Integer, Equipment> equipments;

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.bottles = new HashMap<>();
        this.equipments = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Bottle> getBottles() {
        return bottles;
    }

    public void setBottles(HashMap<Integer, Bottle> bottles) {
        this.bottles = bottles;
    }

    public HashMap<Integer, Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(HashMap<Integer, Equipment> equipments) {
        this.equipments = equipments;
    }
}
