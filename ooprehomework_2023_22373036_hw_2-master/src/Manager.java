package src;

import java.util.HashMap;

public class Manager {
    public void addAdventurer(int advId, String name, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = new Adventurer(advId, name);
        adventurers.put(advId, adventurer);
    }

    public void addBottle(int advId, int botId, String name, int capacity,
                          HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Bottle bottle = new Bottle(botId, name, capacity);
        adventurer.getBottles().put(botId, bottle);
    }

    public void removeBottle(int advId, int botId, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        String botName = adventurer.getBottles().get(botId).getName();
        adventurer.getBottles().remove(botId);
        System.out.println(adventurer.getBottles().size() + " " + botName);
    }

    public void addEquipment(int advId, int equId, String name, int star,
                             HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Equipment equipment = new Equipment(equId, name, star);
        adventurer.getEquipments().put(equId, equipment);
    }

    public void removeEquipment(int advId, int equId, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        String equName = adventurer.getEquipments().get(equId).getName();
        adventurer.getEquipments().remove(equId);
        System.out.println(adventurer.getEquipments().size() + " " + equName);
    }

    public void enhanceEquipmentStar(int advId, int equId, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Equipment equipment = adventurer.getEquipments().get(equId);
        equipment.setStar(equipment.getStar() + 1);
        System.out.println(equipment.getName() + " " + equipment.getStar());
    }
}
