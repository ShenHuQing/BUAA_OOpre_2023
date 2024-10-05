import java.util.HashMap;
import java.util.Objects;

public class Bottle implements Commodity {
    private int id;
    private String name;
    private int capacity;
    private long price;
    private int isEmpty = 0;

    public Bottle(int id, String name, int capacity, long price) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.isEmpty = 0;
    }

    public int getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(int isEmpty) {
        this.isEmpty = isEmpty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public long getValue() {
        return price;
    }

    public static void addRegularBottle(int advId, int botId, String name, int capacity,
                                        long price, String type,
                                        HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        RegularBottle bottle = new RegularBottle(botId, name, capacity, price);
        adventurer.getBottles().put(botId, bottle);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount + 1);
        adventurer.enhanceBottleValue(bottle);
    }

    public static void addImBottle(int advId, int botId, String name, int capacity, long price,
                                   String type, double ratio,
                                   HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        if (Objects.equals(type, "ReinforcedBottle")) {
            ReinforcedBottle bottle = new ReinforcedBottle(botId, name, capacity, price);
            bottle.setRatio(ratio);
            adventurer.getBottles().put(botId, bottle);
            int valueCount = adventurer.getValueCount();
            adventurer.setValueCount(valueCount + 1);
            adventurer.enhanceBottleValue(bottle);
        }
        else if (Objects.equals(type, "RecoverBottle")) {
            RecoverBottle bottle = new RecoverBottle(botId, name, capacity, price);
            bottle.setRatio(ratio);
            adventurer.getBottles().put(botId, bottle);
            int valueCount = adventurer.getValueCount();
            adventurer.setValueCount(valueCount + 1);
            adventurer.enhanceBottleValue(bottle);
        }
    }

    public static void removeBottle(int advId, int botId, HashMap<Integer,
            Adventurer> adventurers, Shop shop) {
        Adventurer adventurer = adventurers.get(advId);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount - 1);
        Bottle bottle = adventurer.getBottles().get(botId);
        adventurer.deleteBottleValue(bottle);
        String botName = adventurer.getBottles().get(botId).getName();
        adventurer.getBottles().remove(botId);
        System.out.println(adventurer.getBottles().size() + " " + botName);
        shop.calculateAllBottlePrice(bottle.getValue());
        shop.calculateAllBottleCap(bottle.getCapacity());
        shop.setBottleNum(shop.getBottleNum() + 1);
        adventurer.setMoney(adventurer.getMoney() + bottle.getValue());
        if (adventurer.getBag().getBottles().get(botId) != null && adventurer.getBag() != null
                && adventurer.getBag().getBottles() != null) {
            adventurer.getBag().getBottles().remove(botId);
        }
    }

    public static void saleRemoveBottle(int advId, int botId, HashMap<Integer,
            Adventurer> adventurers, Shop shop) {
        Adventurer adventurer = adventurers.get(advId);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount - 1);
        Bottle bottle = adventurer.getBottles().get(botId);
        adventurer.deleteBottleValue(bottle);
        String botName = adventurer.getBottles().get(botId).getName();
        adventurer.getBottles().remove(botId);
        //SHOP
        shop.calculateAllBottlePrice(bottle.getValue());
        shop.calculateAllBottleCap(bottle.getCapacity());
        shop.setBottleNum(shop.getBottleNum() + 1);
        adventurer.setMoney(adventurer.getMoney() + bottle.getValue());
        if (adventurer.getBag().getBottles().get(botId) != null && adventurer.getBag() != null
                && adventurer.getBag().getBottles() != null) {
            adventurer.getBag().getBottles().remove(botId);
        }
    }
}



