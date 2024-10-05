import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {
    public void addAdventurer(int advId, String name, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = new Adventurer(advId, name);
        adventurers.put(advId, adventurer);
    }

    public void addRegularBottle(int advId, int botId, String name, int capacity,
                                 long price, String type,HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        RegularBottle bottle = new RegularBottle(botId, name, capacity, price);
        adventurer.getBottles().put(botId, bottle);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount + 1);
        adventurer.enhanceBottleValue(bottle);
    }

    public void addImBottle(int advId, int botId, String name, int capacity, long price,
                            String type, double ratio,HashMap<Integer, Adventurer> adventurers) {
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

    public void removeBottle(int advId, int botId, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount - 1);
        Bottle bottle = adventurer.getBottles().get(botId);
        adventurer.deleteBottleValue(bottle);
        String botName = adventurer.getBottles().get(botId).getName();
        adventurer.getBottles().remove(botId);
        System.out.println(adventurer.getBottles().size() + " " + botName);
        if (adventurer.getBag().getBottles().get(botId) != null && adventurer.getBag() != null
                && adventurer.getBag().getBottles() != null) {
            adventurer.getBag().getBottles().remove(botId);
        }
    }

    public void addImRegularEquipment(int advId, int equId, String name, int star,long price,
                             String type, double others, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        if (Objects.equals(type, "CritEquipment")) {
            CritEquipment equipment = new CritEquipment(equId, name, star, price);
            equipment.setCritical(others);
            adventurer.getEquipments().put(equId, equipment);
            adventurer.enhanceEquipValue(equipment);
        }
        else if (Objects.equals(type, "EpicEquipment")) {
            EpicEquipment equipment = new EpicEquipment(equId, name, star, price);
            equipment.setRatio(others);
            adventurer.getEquipments().put(equId, equipment);
            adventurer.enhanceEquipValue(equipment);
        }
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount + 1);
    }

    public void addRegularEquipment(int advId, int equId, String name, int star,long price,
                                      String type, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        RegularEquipment equipment = new RegularEquipment(equId, name, star, price);
        adventurer.getEquipments().put(equId, equipment);
        adventurer.enhanceEquipValue(equipment);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount + 1);
    }

    public void removeEquipment(int advId, int equId, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount - 1);
        adventurer.deleteEquipValue(adventurer.getEquipments().get(equId));
        String equName = adventurer.getEquipments().get(equId).getName();
        adventurer.getEquipments().remove(equId);
        System.out.println(adventurer.getEquipments().size() + " " + equName);
        if (adventurer.getBag().getEquipments().get(equId) != null && adventurer.getBag() != null
                && adventurer.getBag().getEquipments() != null) {
            adventurer.getBag().getEquipments().remove(equId);
        }
    }

    public void enhanceEquipmentStar(int advId, int equId, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Equipment equipment = adventurer.getEquipments().get(equId);
        equipment.setStar(equipment.getStar() + 1);
        System.out.println(equipment.getName() + " " + equipment.getStar());
    }

    public void addFood(int advId, int foodId, String name, int energy,long price,
                        HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Food food = new Food(foodId, name, energy, price);
        adventurer.getFoods().put(foodId, food);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount + 1);
        adventurer.enhanceFoodValue(food);
    }

    public void removeFood(int advId, int foodId, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount - 1);
        Food food = adventurer.getFoods().get(foodId);
        adventurer.deleteFoodValue(food);
        int previousFoodCount = adventurer.getFoods().size();
        String foodName = adventurer.getFoods().get(foodId).getName();
        adventurer.getFoods().remove(foodId);
        adventurer.getBag().getFoods().remove(foodId);
        System.out.println(previousFoodCount - 1 + " " + foodName);
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

    public void carryBottle(int advId, int bottleId, HashMap<Integer,
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

    public void useBottle(int advId, String bottleName, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        HashMap<Integer,Bottle> bottleMap = adventurer.getBag().getBottles();
        int count = Main.findMinbotlleKey(bottleMap, bottleName);
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
                bottleMap.get(count).setCapacity(0);
            }
        }
    }

    public void useFood(int advId, String foodName, HashMap<Integer, Adventurer> adventurers) {
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

    public void type14(ArrayList<String> tmp, Scanner scanner, Manager manager,
                       HashMap<Integer, Adventurer> adventurers, ArrayList<Log> logs) {
        System.out.println("Enter Fight Mode");
        int m = Integer.parseInt(tmp.get(1));
        int k = Integer.parseInt(tmp.get(2));
        String[] fightname = new String[m];
        int j = 0;
        for (int i1 = 3; i1 < 3 + m; i1++) {
            fightname[j] = tmp.get(i1);
            j++;
        } //存入战斗名字
        String logline;
        for (int i2 = 0; i2 < k; i2++) {
            logline = scanner.nextLine();
            Pattern pattern1 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                    "([^@\\-#\\s]{1,40}?)-([^@\\-#\\s]{1,40})");
            Matcher matcher1 = pattern1.matcher(logline);
            Pattern pattern2 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                    "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
            Matcher matcher2 = pattern2.matcher(logline);
            Pattern pattern3 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                    "([^@\\-#\\s]{1,40}?)@#-([^@\\-#\\s]{1,40})");
            Matcher matcher3 = pattern3.matcher(logline);
            if (matcher3.find()) {
                Log.match3(matcher3, manager, adventurers, logs,fightname,m);
            } else if (matcher2.find()) {
                Log.match2(matcher2, manager, adventurers, logs,fightname);
            } else if (matcher1.find()) {
                Log.match1(matcher1, manager, adventurers, logs,fightname);
            } else {
                System.out.println("Fight log error");
            }
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

    public long countValue(int advId,HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        long hirevalue = 0;
        HashMap<Integer, Adventurer> employees = adventurer.getEmployees();
        for (Map.Entry<Integer, Adventurer> entry : employees.entrySet()) {
            Adventurer employee = entry.getValue();
            int employeeId = employee.getId();
            hirevalue +=  countValue(employeeId,adventurers);
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
}









