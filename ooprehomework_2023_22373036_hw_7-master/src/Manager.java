import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Manager {
    public void addAdventurer(int advId, String name, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = new Adventurer(advId, name);
        adventurers.put(advId, adventurer);
    }

    public static void addFood(int advId, int foodId, String name, int energy, long price,
                               HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Food food = new Food(foodId, name, energy, price);
        adventurer.getFoods().put(foodId, food);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount + 1);
        adventurer.enhanceFoodValue(food);
    }

    public void removeFood(int advId, int foodId,
                           HashMap<Integer, Adventurer> adventurers, Shop shop) {
        Adventurer adventurer = adventurers.get(advId);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount - 1);
        //价值体-1
        Food food = adventurer.getFoods().get(foodId);
        adventurer.deleteFoodValue(food);
        //食物价值减少
        int previousFoodCount = adventurer.getFoods().size();
        String foodName = adventurer.getFoods().get(foodId).getName();
        adventurer.getFoods().remove(foodId);
        //食物中删除
        if (adventurer.getBag().getFoods().containsKey(foodId)) {
            adventurer.getBag().getFoods().remove(foodId);
        }
        System.out.println(previousFoodCount - 1 + " " + foodName);
        shop.calculateAllFoodPrice(food.getValue());
        shop.calculateAllFoodCap(food.getEnergy());
        //商店价值增加，数量增加
        shop.setFoodNum(shop.getFoodNum() + 1);
        adventurer.setMoney(adventurer.getMoney()
                + food.getValue());
    }

    public void saleRemoveFood(int advId, int foodId,
                               HashMap<Integer, Adventurer> adventurers, Shop shop) {
        Adventurer adventurer = adventurers.get(advId);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount - 1);
        Food food = adventurer.getFoods().get(foodId);
        adventurer.deleteFoodValue(food);
        int previousFoodCount = adventurer.getFoods().size();
        String foodName = adventurer.getFoods().get(foodId).getName();
        adventurer.getFoods().remove(foodId);
        if (adventurer.getBag().getFoods().containsKey(foodId)) {
            adventurer.getBag().getFoods().remove(foodId);
        }
        shop.calculateAllFoodPrice(food.getValue());
        shop.setFoodNum(shop.getFoodNum() + 1);
        adventurer.setMoney(adventurer.getMoney() + food.getValue());
    }

    public void carryEquipment(int advId, int equId, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Bag bag = adventurer.getBag();
        Equipment equipment = adventurer.getEquipments().get(equId);
        String equName = equipment.getName();
        if (adventurer.getBag() != null && adventurer.getBag().getEquipments() != null) {
            replaceEqu(adventurer.getBag().getEquipments(),equName);
        }
        adventurer.getBag().getEquipments().put(equId, equipment);
    }

    public void replaceEqu(HashMap<Integer, Equipment> hashMap, String targetValue) {
        Iterator<Map.Entry<Integer, Equipment>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Equipment> entry = iterator.next();
            Equipment equipment = entry.getValue();
            int key = entry.getKey();
            if (Objects.equals(equipment.getName(), targetValue)) {
                iterator.remove();
            }
        }
    }

    public static void carryBottle(int advId, int bottleId, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        int level = adventurer.getLevel();
        int maxBottles = level / 5 + 1;// 先计算最多带几个，然后根据id找value，看有几个value
        if (adventurer.getBottles().get(bottleId) != null && adventurer.getBottles() != null)
        {
            String target = adventurer.getBottles().get(bottleId).getName();
            int count = Main.countKeysByValue(adventurer.getBag().getBottles(), target);
            if (count >= maxBottles) {
                return;
            }
            else {
                Bottle bottle = adventurer.getBottles().get(bottleId);
                adventurer.getBag().getBottles().put(bottleId,bottle);
            } //是否可以携带
        }
    }

    public void carryFood(int advId, int foodId, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Food food = adventurer.getFoods().get(foodId);
        adventurer.getBag().getFoods().put(foodId,food);
    }

    public static int useBottle(int advId, String bottleName, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        HashMap<Integer,Bottle> bottleMap = adventurer.getBag().getBottles();
        int count = Main.findMinbotlleKey(bottleMap, bottleName);
        if (count == -1) {
            System.out.println("fail to use " + bottleName);
            return 0;
        }
        else {
            Bottle bottle = bottleMap.get(count);
            int empty = bottleMap.get(count).getIsEmpty();
            int cap = bottleMap.get(count).getCapacity();
            if (empty == 1) {
                int point = adventurer.getHitpoint();
                int bottleID = bottleMap.get(count).getId();
                System.out.println(bottleID + " " + point);
                int valueCount = adventurer.getValueCount();
                adventurer.setValueCount(valueCount - 1);
                adventurer.deleteBottleValue(bottle);
                bottleMap.remove(count);
                adventurer.getBottles().remove(count);
            } else {
                int enhanceHit = 0;
                if (bottle instanceof RegularBottle) {
                    enhanceHit = cap;
                }
                else if (bottle instanceof ReinforcedBottle) {
                    double ratio = ((ReinforcedBottle) bottle).getRatio();
                    enhanceHit = (int) ((1 + ratio) * cap);
                }
                else if (bottle instanceof RecoverBottle) {
                    double ratio = (( RecoverBottle) bottle).getRatio();
                    enhanceHit = (int) (ratio * adventurer.getHitpoint());
                }
                adventurer.setHitpoint(adventurer.getHitpoint() + enhanceHit);
                int point = adventurer.getHitpoint();
                int bottleID = bottleMap.get(count).getId();
                System.out.println(bottleID + " " + point);
                bottleMap.get(count).setIsEmpty(1);
                return enhanceHit;
            }
        }
        return 0;
    }

    public static void useFood(int advId, String foodName, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        HashMap<Integer,Food> foodMap = adventurer.getBag().getFoods();
        int count = Main.findMinfoodKey(foodMap, foodName);
        if (count == -1) {
            System.out.println("fail to eat " + foodName);
        }
        else {
            int cap;
            cap = foodMap.get(count).getEnergy();
            adventurer.setLevel(adventurer.getLevel() + cap);
            int point = adventurer.getLevel();
            int foodID = foodMap.get(count).getId();
            int valueCount = adventurer.getValueCount();
            adventurer.setValueCount(valueCount - 1);
            Food food = foodMap.get(count);
            adventurer.deleteFoodValue(food);
            System.out.println(foodID + " " + point);
            foodMap.remove(count);
            adventurer.getFoods().remove(count);
        }
    }

    public  void outDate(ArrayList<Log> logs, String target) {
        int found = 0;
        for (int i = 0;i < logs.size();i++) {
            Log log = logs.get(i);
            if (Objects.equals(log.getDate(), target)) {
                found = 1;
                if (log.getFunc() == 1) {
                    System.out.println(log.getDate() + " " + log.getUserName() +
                            " used " + log.getBottleName());
                }
                if (log.getFunc() == 2) {
                    System.out.println(log.getDate() + " " + log.getFighterName() + " " +
                            "attacked " + log.getLoserName() + " with " + log.getEquName());
                }
                if (log.getFunc() == 3) {
                    System.out.println(log.getDate() + " " + log.getFighterName() +
                            " AOE-attacked" + " with " + log.getEquName());
                }
            }
        }
        if (found == 0) {
            System.out.println("No Matched Log");
        }
    }

    public  void outFighter(ArrayList<Log> logs,int target) {
        int found = 0;
        for (int i = 0; i < logs.size();i++) {
            Log log = logs.get(i);
            if (log.getFighterID() != -1) {
                if (log.getFighterID() == target) {
                    found = 1;
                    if (log.getFunc() == 2) {
                        System.out.println(log.getDate() + " " + log.getFighterName() +
                                " attacked " + log.getLoserName() + " with " + log.getEquName());
                    }
                    if (log.getFunc() == 3) {
                        System.out.println(log.getDate() + " " + log.getFighterName() +
                                " AOE-attacked" + " with " + log.getEquName());
                    }
                }
            }
        }
        if (found == 0) {
            System.out.println("No Matched Log");
        }
    }

    public void outLoser(ArrayList<Log> logs,int target) {
        int found = 0;
        for (int i = 0;i < logs.size();i++) {
            Log log = logs.get(i);
            if (log.getFunc() == 2) {
                if (log.getLoserID() == target) {
                    found = 1;
                    {
                        System.out.println(log.getDate() + " " + log.getFighterName() +
                                " attacked " + log.getLoserName() + " with "
                                + log.getEquName());
                    }
                }
            }
            else if (log.getFunc() == 3) {
                for (int j = 0;j < log.getLsID().size();j++) {
                    int loserId = log.getLsID().get(j);
                    if (loserId == target) {
                        found = 1;
                        System.out.println(log.getDate() + " " + log.getFighterName() +
                                " AOE-attacked" + " with " + log.getEquName());
                        break;
                    }
                }
            }
        }
        if (found == 0) {
            System.out.println("No Matched Log");
        }
    }

    public void hireAdv(int adv1, int adv2, HashMap<Integer, Adventurer> adventurers) {
        int flag = 0;
        Adventurer employer = adventurers.get(adv1);
        Adventurer employee = adventurers.get(adv2);
        if (employer.getEmployees().containsKey(adv2)) {
            flag = 1;
        }
        if (flag == 0) {
            employer.getEmployees().put(adv2,employee);
            int valuecount = employer.getValueCount();
            employer.setValueCount(valuecount + 1);
            employer.enhanceHireValue(employee);
        }
    }

    public static long countValue(int advId, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        long hirevalue = 0;
        HashMap<Integer, Adventurer> employees = adventurer.getEmployees();
        for (Map.Entry<Integer, Adventurer> entry : employees.entrySet()) {
            Adventurer employee = entry.getValue();
            int employeeId = employee.getId();
            hirevalue += countValue(employeeId,adventurers);
            hirevalue += employee.getMoney();

        }
        adventurer.setHireValue(hirevalue);
        long value = adventurer.getValue();
        return value;
    }

    public void printValue(int advId,HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        int count = adventurer.getValueCount();
        long value = countValue(advId, adventurers);
        System.out.println(count + " " + value);
    }

    public void findMaxValuer(int advId,HashMap<Integer, Adventurer> adventurers) {
        Long max = 0L;
        Adventurer adventurer = adventurers.get(advId);
        HashMap<Integer, Adventurer> employees = adventurer.getEmployees();
        for (Map.Entry<Integer, Adventurer> entry : employees.entrySet()) {
            Adventurer employee = entry.getValue();
            int empId = employee.getId();
            Long price = countValue(empId, adventurers);
            price += employee.getMoney();
            if (price > max) {
                max = price;
            }
        }
        HashMap<Integer, Equipment> equipments = adventurer.getEquipments();
        for (Map.Entry<Integer, Equipment> entry : equipments.entrySet()) {
            Equipment equipment = entry.getValue();
            Long price = equipment.getValue();
            if (price > max) {
                max = price;
            }
        }
        HashMap<Integer, Bottle> bottles = adventurer.getBottles();
        for (Map.Entry<Integer, Bottle> entry : bottles.entrySet()) {
            Bottle bottle = entry.getValue();
            Long price = bottle.getValue();
            if (price > max) {
                max = price;
            }
        }
        HashMap<Integer, Food> foods = adventurer.getFoods();
        for (Map.Entry<Integer, Food> entry :foods.entrySet()) {
            Food food = entry.getValue();
            Long price = food.getValue();
            if (price > max) {
                max = price;
            }
        }
        System.out.println(max);
    }

    public void findClassName(int advId,int comId,HashMap<Integer, Adventurer> adventurers) {
        String flag = "0";
        Adventurer adventurer = adventurers.get(advId);
        HashMap<Integer, Adventurer> employees = adventurer.getEmployees();
        for (Map.Entry<Integer, Adventurer> entry : employees.entrySet()) {
            int key = entry.getKey();
            if (Objects.equals(key, comId)) {
                flag = "Adventurer";
            }
        }
        HashMap<Integer, Equipment> equipments = adventurer.getEquipments();
        for (Map.Entry<Integer, Equipment> entry : equipments.entrySet()) {
            int key = entry.getKey();
            Equipment equipment = entry.getValue();
            if (Objects.equals(key, comId)) {
                if (equipment instanceof RegularEquipment) {
                    flag = "RegularEquipment";
                }
                else if (equipment instanceof EpicEquipment) {
                    flag = "EpicEquipment";
                }
                else if (equipment instanceof CritEquipment) {
                    flag = "CritEquipment";
                }
            }
        }
        HashMap<Integer, Bottle> bottles = adventurer.getBottles();
        for (Map.Entry<Integer, Bottle> entry : bottles.entrySet()) {
            int key = entry.getKey();
            Bottle bottle = entry.getValue();
            if (Objects.equals(key, comId)) {
                if (bottle instanceof RegularBottle) {
                    flag = "RegularBottle";
                }
                else if (bottle instanceof ReinforcedBottle) {
                    flag = "ReinforcedBottle";
                }
                else if (bottle instanceof RecoverBottle) {
                    flag = "RecoverBottle";
                }
            }
        }
        HashMap<Integer, Food> foods = adventurer.getFoods();
        for (Map.Entry<Integer, Food> entry :foods.entrySet()) {
            int key = entry.getKey();
            if (Objects.equals(key, comId)) {
                flag = "Food";
            }
        }
        System.out.println("Commodity whose id is " + comId + " belongs to " + flag);
    }

    public void saleAllCarryItem(int advId, HashMap<Integer, Adventurer> adventurers,Shop shop) {
        Adventurer adventurer = adventurers.get(advId);
        Bag bag = adventurer.getBag();
        ArrayList<Integer> sellEquipsID = new ArrayList<>();
        ArrayList<Integer> sellFoodsID = new ArrayList<>();
        ArrayList<Integer> sellBottlesID = new ArrayList<>();
        long getMoney = 0;
        HashMap<Integer, Equipment> equipments = adventurer.getBag().getEquipments();
        for (Map.Entry<Integer, Equipment> entry : equipments.entrySet()) {
            int key = entry.getKey();
            getMoney += equipments.get(key).getValue();
            sellEquipsID.add(key);
        }
        for (int i = 0;i < sellEquipsID.size();i++) {
            Equipment.saleRemoveEquipment(advId,sellEquipsID.get(i),adventurers,shop);
        }
        HashMap<Integer, Bottle> bottles = adventurer.getBag().getBottles();
        for (Map.Entry<Integer, Bottle> entry : bottles.entrySet()) {
            int key = entry.getKey();
            getMoney += bottles.get(key).getValue();
            sellBottlesID.add(key);
        }
        for (int i = 0;i < sellBottlesID.size();i++) {
            Bottle.saleRemoveBottle(advId,sellBottlesID.get(i),adventurers,shop);
        }
        HashMap<Integer, Food> foods = adventurer.getBag().getFoods();
        for (Map.Entry<Integer, Food> entry :foods.entrySet()) {
            int key = entry.getKey();
            getMoney += foods.get(key).getValue();
            sellFoodsID.add(key);
        }
        for (int i = 0;i < sellFoodsID.size();i++) {
            saleRemoveFood(advId,sellFoodsID.get(i),adventurers,shop);
        }
        String advName = adventurer.getName();
        System.out.println(advName + " emptied the backpack " + getMoney);
    }

    public static void buyItem(int advID, int itemID, String name, String type, HashMap<Integer,
            Adventurer> adventurers, Shop shop, double others) {
        Adventurer adventurer = adventurers.get(advID);
        long money = adventurer.getMoney();
        if (Objects.equals(type, "RegularBottle") || Objects.equals(type, "RecoverBottle")
                || Objects.equals(type, "ReinforcedBottle")) {
            long price = shop.getAllBottlePrice() / shop.getBottleNum();
            if (money >= price) {
                long cap = shop.getAllBottleCap() / shop.getBottleNum();
                if (type.equals("RegularBottle")) {
                    Bottle.addRegularBottle(advID,itemID,name, (int) cap,price,type,adventurers);
                }
                else {
                    Bottle.addImBottle(advID,itemID,name, (int) cap,price,type,others,adventurers);
                }
                System.out.println("successfully buy " + name + " for " + price);
                money -= price;
                adventurer.setMoney(money);
            }
            else {
                System.out.println("failed to buy " + name + " for " + price);
            }
        }
        if (Objects.equals(type, "RegularEquipment") ||
                Objects.equals(type, "CritEquipment") || Objects.equals(type, "EpicEquipment")) {
            long price = shop.getAllEquipmentPrice() / shop.getEquipmentNum();
            if (money >= price) {
                long cap = shop.getAllEquipmentCap() / shop.getEquipmentNum();
                if (type.equals("RegularEquipment")) {
                    Equipment.addRegularEquipment(advID,itemID,name,
                            (int) cap,price,type,adventurers);
                }
                else {
                    Equipment.addImRegularEquipment(advID,itemID,name, (int) cap,
                            price,type,others,adventurers);
                }
                System.out.println("successfully buy " + name + " for " + price);
                money -= price;
                adventurer.setMoney(money);
            }
            else {
                System.out.println("failed to buy " + name + " for " + price);
            }
        }
        if (Objects.equals(type, "Food")) {
            long price = shop.getAllFoodPrice() / shop.getFoodNum();
            if (money >= price) {
                long cap = shop.getAllFoodCap() / shop.getFoodNum();
                addFood(advID,itemID,name, (int) cap,price,adventurers);
                System.out.println("successfully buy " + name + " for " + price);
                money -= price;
                adventurer.setMoney(money);
            }
            else {
                System.out.println("failed to buy " + name + " for " + price);
            }
        }
    }
}









