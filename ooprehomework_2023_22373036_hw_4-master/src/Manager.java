import java.util.ArrayList;
import java.util.Arrays;
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
        if (adventurer.getBag().getBottles().get(botId) != null && adventurer.getBag() != null
                && adventurer.getBag().getBottles() != null) {
            adventurer.getBag().getBottles().remove(botId);
        }
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
            int count = countKeysByValue(adventurer.getBag().getBottles(), target);
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

    public static int findadvID(HashMap<Integer,Adventurer> hashMap, String targetValue) {
        boolean found = false;
        for (Map.Entry<Integer, Adventurer> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            Adventurer adventurer = entry.getValue();
            if (Objects.equals(adventurer.getName(), targetValue)) {
                return key;
            }
        }
        return -1;
    }

    public static int findequipID(HashMap<Integer,Equipment> hashMap, String targetValue) {
        boolean found = false;
        for (Map.Entry<Integer, Equipment> entry : hashMap.entrySet()) {
            int key = entry.getKey();
            Equipment equipment = entry.getValue();
            if (equipment.getName().equals(targetValue)) {
                return key;
            }
        }
        return -1;
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

    public void type14(ArrayList<String> tmp, Scanner scanner, Manager manager,
                       HashMap<Integer, Adventurer> adventurers,
                       ArrayList<Log> logs) {
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
                match3(matcher3, manager, adventurers, logs,fightname,m);
            }
            else if (matcher2.find()) {
                match2(matcher2, manager, adventurers, logs,fightname);
            }
            else if (matcher1.find()) {
                match1(matcher1, manager, adventurers, logs,fightname);

            }
            else {
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

    public void match1(Matcher matcher1, Manager manager, HashMap<Integer, Adventurer> adventurers,
                       ArrayList<Log> logs,String[] fightname) {
        boolean a = Arrays.asList(fightname).contains(matcher1.group(4));
        if (a) {
            int advID = Manager.findadvID(adventurers,matcher1.group(4));
            Adventurer adventurer = adventurers.get(advID);
            if ((adventurer != null && adventurer.getBag() != null
                    && adventurer.getBag().getBottles() != null)) {
                HashMap<Integer, Bottle> advbottle = adventurer.getBag().getBottles();
                int b = Manager.findMinbotlleKey(advbottle, matcher1.group(5));
                if (b != -1) {
                    manager.useBottle(advID, matcher1.group(5), adventurers);
                    Log log = new Log(matcher1,1);
                    log.setUserID(advID);
                    logs.add(log);
                }
                else {
                    System.out.println("Fight log error");
                }
            }
            else {
                System.out.println("Fight log error");
            }
        }
        else {
            System.out.println("Fight log error");
        }
    }

    //Pattern pattern2 = Pattern.compile("((\\d{4})/(\\d{2}))-(.+?)@(.+?)-(.+)");
    public void match2(Matcher matcher2, Manager manager, HashMap<Integer, Adventurer> adventurers,
                       ArrayList<Log> logs,String[] fightname) {
        boolean a = Arrays.asList(fightname).contains(matcher2.group(4));
        boolean c = Arrays.asList(fightname).contains(matcher2.group(5));
        if (a && c) {
            int advID1 = Manager.findadvID(adventurers, matcher2.group(4));
            int advID2 = Manager.findadvID(adventurers, matcher2.group(5));
            Adventurer fighter = adventurers.get(advID1);
            Adventurer loser = adventurers.get(advID2);
            HashMap<Integer, Equipment> advEquip = fighter.getBag().getEquipments();
            int b = Manager.findequipID(advEquip, matcher2.group(6));
            if (b != -1) {
                int equipLevel = advEquip.get(b).getStar();
                int advLevel = fighter.getLevel();
                loser.setHitpoint(loser.getHitpoint() - equipLevel * advLevel);
                System.out.println(loser.getId() + " " + loser.getHitpoint());
                Log log = new Log(matcher2,2);
                log.setFighterID(advID1);
                log.setLoserID(advID2);
                logs.add(log);
            } else {
                System.out.println("Fight log error");
            }
        } else {
            System.out.println("Fight log error");
        }
    }

    public void match3(Matcher matcher3, Manager manager, HashMap<Integer, Adventurer> adventurers,
                       ArrayList<Log> logs,String[] fightname,int m) {
        boolean a = Arrays.asList(fightname).contains(matcher3.group(4));
        if (a) {
            int advID1 = Manager.findadvID(adventurers,matcher3.group(4));
            Adventurer fighter = adventurers.get(advID1);
            HashMap<Integer,Equipment> advEquip = fighter.getBag().getEquipments();
            int b = Manager.findequipID(advEquip,matcher3.group(5));
            if (b != -1) {
                int equipLevel = advEquip.get(b).getStar();
                int advLevel = fighter.getLevel();
                Log log = new Log(matcher3,3);
                log.setFighterID(advID1);
                int k = 0;
                for (int i3 = 0;i3 < m;i3++) {
                    if (!Objects.equals(fightname[i3], matcher3.group(4))) {
                        int advID = Manager.findadvID(adventurers,fightname[i3]);
                        Adventurer loser = adventurers.get(advID);
                        loser.setHitpoint(loser.getHitpoint() - equipLevel * advLevel);
                        System.out.print(loser.getHitpoint() + " ");
                        log.getLsName().add(fightname[i3]);
                        log.getLsID().add(advID);
                    }
                }
                System.out.println();
                logs.add(log);
            }
            else {
                System.out.println("Fight log error");
            }
        }
        else {
            System.out.println("Fight log error");

        }
    }
}


