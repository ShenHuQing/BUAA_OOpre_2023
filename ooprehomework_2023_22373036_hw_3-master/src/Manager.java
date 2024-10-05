import java.util.HashMap;
import java.util.Map;

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

    public void addFood(int advId, int foodId, String name, int energy,
                        HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Food food = new Food(foodId, name, energy);
        adventurer.getFoods().put(foodId, food);
    }

    public void removeFood(int advId, int foodId, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        String foodName = adventurer.getFoods().get(foodId).getName();
        int previousFoodCount = adventurer.getFoods().size();
        // 删除食物
        adventurer.getFoods().remove(foodId);
        adventurer.getBag().getFoods().remove(foodId);
        // 打印删除后的食物数量
        System.out.println(previousFoodCount - 1 + " " + foodName);
    }

    @SuppressWarnings("checkstyle:WhitespaceAround")
    public void carryEquipment(int advId, int equId, HashMap<Integer,
            Adventurer> adventurers) {

        Adventurer adventurer = adventurers.get(advId);
        Bag bag = adventurer.getBag();
        adventurer.getBag().clearEquipment(bag);
        Equipment equipment = adventurer.getEquipments().get(equId);
        adventurer.getBag().getEquipments().put(equId, equipment);

    }

    public void carryBottle(int advId, int bottleId, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        int level = adventurer.getLevel();
        int maxBottles = level / 5 + 1;// 先计算最多带几个，然后根据id找value，看有几个value
        String target = adventurer.getBottles().get(bottleId).getName();
        int count = countKeysByValue(adventurer.getBag().getBottles(), target);
        if (count >= maxBottles) {
            return;
        }
        else {
            Bottle bottle = adventurer.getBottles().get(bottleId);
            adventurer.getBag().getBottles().put(bottleId,bottle);
        } //是否可以携带

    }

    public void carryFood(int advId, int foodId, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Food food = adventurer.getFoods().get(foodId);
        adventurer.getBag().getFoods().put(foodId,food);
    }

    public void useBottle(int advId, String bottleName, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        HashMap<Integer,Bottle> bottleMap = adventurer.getBag().getBottles();
        int count = findMinbotlleKey(bottleMap, bottleName);
        if (count == -1) {
            System.out.println("fail to use " + bottleName);
        }
        else {
            Bottle bottle = bottleMap.get(count);
            int cap = bottleMap.get(count).getCapacity();
            if (cap == 0) {
                int point = adventurer.getHitpoint();
                int bottleID = bottleMap.get(count).getId();
                System.out.println(bottleID + " " + point);
                bottleMap.remove(count);
                adventurer.getBottles().remove(count);
            } else {
                adventurer.setHitpoint(adventurer.getHitpoint() + cap);
                int point = adventurer.getHitpoint();
                int bottleID = bottleMap.get(count).getId();
                System.out.println(bottleID + " " + point);
                bottleMap.get(count).setCapacity(0);
            }
            //体力值未设置equipment.setStar(equipment.getStar() + 1);
        }
        //能使用要判断bottle是否为空
    }

    public void useFood(int advId, String foodName, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        HashMap<Integer,Food> foodMap = adventurer.getBag().getFoods();
        int count = findMinfoodKey(foodMap, foodName);
        if (count == -1) {
            System.out.println("fail to eat " + foodName);
        }
        else {
            Food food = foodMap.get(count);
            int cap;
            cap = foodMap.get(count).getEnergy();
            adventurer.setLevel(adventurer.getLevel() + cap);
            int point = adventurer.getLevel();
            int foodID = foodMap.get(count).getId();
            System.out.println(foodID + " " + point);
            foodMap.remove(count);
            adventurer.getFoods().remove(count);

        }

    }

    public static int findMinbotlleKey(HashMap<Integer,Bottle> hashMap, String targetValue) {
        int minKey = Integer.MAX_VALUE;
        boolean found = false;

        for (Map.Entry<Integer, Bottle> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            Bottle bottle = entry.getValue();
            if (bottle.getName().equals(targetValue)) {
                if (key < minKey) {
                    minKey = key;
                    found = true;
                }
            }

        }
        if (found) {
            return minKey;
        }
        else {
            return -1;
        }
    }

    public static int findMinfoodKey(HashMap<Integer,Food> hashMap, String targetValue) {
        int minKey = Integer.MAX_VALUE;
        boolean found = false;

        for (Map.Entry<Integer, Food> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            Food food = entry.getValue();
            if (food.getName().equals(targetValue)) {
                if (key < minKey) {
                    minKey = key;
                    found = true;
                }
            }

        }
        if (found) {
            return minKey;
        }
        else {
            return -1;
        }
    }

    public static int countKeysByValue(HashMap<Integer, Bottle> hashMap, String targetValue) {
        int count = 0;
        for (Bottle bottle : hashMap.values()) {
            if (bottle.getName().equals(targetValue)) {
                count++;
            }
        }
        return count;
    }

}
