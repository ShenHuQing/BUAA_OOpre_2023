import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerTest {
    Manager manager = new Manager();
    Shop shop = new Shop();
    HashMap<Integer, Adventurer> adventurers = new HashMap<>();

    @Test
    public void addAdventurer() {
        manager.addAdventurer(1, "A", adventurers);
        HashMap adventurers = new HashMap();
        String nextLine = "3 A"; // 读取本行指令
        String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>();
        inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
        ArrayList<String> tmp = inputInfo.get(0);
    }

    @Test
    public void addRegularBottle() {
        Adventurer adv = new Adventurer(1, "a");
        Bottle bottle = new Bottle(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getBottles().put(2, bottle);
        if (!Objects.equals("RecoverBottle", "RegularBottle")) {
            Bottle.addImBottle(1, 2, "3", 4, 5, "RecoverBottle", 7, adventurers);
        }
        Bottle.removeBottle(1, 2, adventurers,shop);
    }

    @Test
    public void addImBottle() {
        if (!Objects.equals("RegularBottle", "RegularBottle")) {
            Bottle.addImBottle(1, 2, "3", 4, 5, "RecoverBottle", 7, adventurers);
        }
    }

    @Test
    public void addImBottle1() {
        Adventurer adventurer = new Adventurer(1,"a");
        adventurers.put(1,adventurer);
        Bottle.addImBottle(1, 2, "3", 4, 5, "ReinforcedBottle", 7, adventurers);
    }

    @Test
    public void removeewe() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        adv.getBag().getEquipments().put(2,equipment);
        Equipment.addImRegularEquipment(1, 2, "3", 4, 1, "RecoverEquipment", 1, adventurers);
        Equipment.removeEquipment(1, 2, adventurers,shop);
    }
@Test
    public void removeeswe() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        adv.getBag().getEquipments().put(2,equipment);
        Equipment.addImRegularEquipment(1, 2, "3", 4, 1, "RecoverEquipment", 1, adventurers);
        Equipment.saleRemoveEquipment(1, 2, adventurers,shop);
    }

    @Test
    public void removeBottlea() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        Equipment.saleRemoveEquipment(1, 2, adventurers,shop);
    }
    @Test
    public void removeBottleb() {
        Adventurer adv = new Adventurer(1, "a");
        Bottle bottle = new Bottle(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getBottles().put(2, bottle);
        Bottle.saleRemoveBottle(1, 2, adventurers,shop);
    }

    @Test
    public void useBottleb() {
        Adventurer adv = new Adventurer(1, "a");
        adventurers.put(1, adv);
        Bottle.addRegularBottle(1,2,"A",1,1,"RegularBottle",adventurers);
        Manager.carryBottle(1,2,adventurers);
        Manager.useBottle(1,"A",adventurers);
    }
    @Test
    public void useBottl1eb() {
        Adventurer adv = new Adventurer(1, "a");
        adventurers.put(1, adv);
        Bottle.addImBottle(1,2,"A",1,1,"RecoverBottle",1,adventurers);
        Manager.carryBottle(1,2,adventurers);
        Manager.useBottle(1,"A",adventurers);
    }
    @Test
    public void useBottl2eb() {
        Adventurer adv = new Adventurer(1, "a");
        adventurers.put(1, adv);
        Bottle.addImBottle(1,2,"A",1,1,"ReinforcedBottle",1,adventurers);
        Manager.carryBottle(1,2,adventurers);
        Manager.useBottle(1,"A",adventurers);
        Manager.useBottle(1,"A",adventurers);
        Manager.useBottle(1,"b",adventurers);
    }
    @Test

    public void removeBottlebB() {
        Adventurer adv = new Adventurer(1, "a");
        Bottle bottle = new Bottle(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getBottles().put(2, bottle);
        adv.getBag().getBottles().put(2,bottle);
        Bottle.removeBottle(1, 2, adventurers,shop);
    }
    @Test

    public void removeBottlebBb() {
        Adventurer adv = new Adventurer(1, "a");
        Bottle bottle = new Bottle(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getBottles().put(2, bottle);
        adv.getBag().getBottles().put(2,bottle);
        Bottle.saleRemoveBottle(1, 2, adventurers,shop);
    }
    @Test
    public void addImRegularEquipment() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        if (!Objects.equals("RecoverEquipment", "RegularEquipment")) {
            Equipment.addImRegularEquipment(1, 2, "3", 4, 1, "RecoverEquipment", 1, adventurers);
        }
    }
    @Test
    public void addImRegularEquipment1() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        Equipment.addImRegularEquipment(1, 2, "3", 4, 1, "EpicEquipment", 1, adventurers);

    }

    @Test
    public void addRegularEquipment() {
    }

    @Test
    public void removeEquipment() {
    }

    @Test
    public void enhanceEquipmentStar() {
    }

    @Test
    public void addFood() {
    }

    @Test
    public void removeFood() {
    }

    @Test
    public void carryEquipment() {
    }

    @Test
    public void replaceEqu() {
    }

    @Test
    public void carryBottle() {
    }

    @Test
    public void carryFood() {
    }

    @Test
    public void useBottle() {
    }

    @Test
    public void useFood() {
        Adventurer adventurer = new Adventurer(123, "aaa");
        adventurers.put(123,adventurer);
        Food e1 = new Food(11, "a1", 1, 1);
        Food e2 = new Food(21, "a2", 1, 1);
        Food e3 = new Food(31, "a3", 1, 1);
        Food e4 = new Food(41, "a4", 1, 1);
        adventurer.getFoods().put(11, e1);
        adventurer.getFoods().put(21, e2);
        adventurer.getFoods().put(31, e3);
        adventurer.getFoods().put(41, e4);
        adventurer.getBag().getFoods().put(11, e1);
        adventurer.getBag().getFoods().put(21, e2);
        adventurer.getBag().getFoods().put(31, e3);
        Manager.useFood(123,"a1",adventurers);
        Manager.useFood(123,"e5",adventurers);
    }

    @Test
    public void type14() {
        ArrayList<Log> logs = new ArrayList<>();
        int m = 2;
        int k = 1;
        String[] fightname = new String[m];
        int j = 0;
        fightname[0] = "A";
        fightname[1] = "B";
        String logline;
        for (int i2 = 0; i2 < k; i2++) {
            logline = "2022/09-advName1-botName";
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
                Log.match3(matcher3, manager, adventurers, logs, fightname, m);
            } else if (matcher2.find()) {
                Log.match2(matcher2, manager, adventurers, logs, fightname);
            } else if (matcher1.find()) {
                Log.match1(matcher1, manager, adventurers, logs, fightname);
            } else {
                System.out.println("Fight log error");
            }
        }
    }

    @Test
    public void outDate() {
    }

    @Test
    public void outFighter() {
    }

    @Test
    public void outLoser() {
    }

    @Test
    public void hireAdv() {
    }

    @Test
    public void countValue() {
    }

    @Test
    public void printValue() {
    }

    @Test
    public void findMaxValuer() {
    }

    @Test
    public void find() {

        Adventurer adventurer = new Adventurer(123, "aaa");
        adventurers.put(123,adventurer);
        Bottle.addRegularBottle(123,11,"AA",1,1,"RegularBottle",adventurers);
        Bottle.addImBottle(123,22,"bb",1,1,"RecoverBottle",3,adventurers);
        Bottle.addImBottle(123,33,"cc",1,1,"ReinforcedBottle",3,adventurers);
        Food e1 = new Food(111, "a1", 1, 1);
        Food e2 = new Food(21, "a2", 1, 1);
        Food e3 = new Food(31, "a3", 1, 1);
        Food e4 = new Food(41, "a4", 1, 1);
        adventurer.getFoods().put(111, e3);
        adventurer.getFoods().put(21, e2);
        adventurer.getFoods().put(31, e3);
        adventurer.getFoods().put(41, e4);
        Adventurer ff = new Adventurer(34,"d");
        adventurer.getEmployees().put(34,ff);
        adventurers.put(34,ff);
        Equipment.addRegularEquipment(123,1,"A",1,1,"RegularEquipment",adventurers);
        Equipment.addImRegularEquipment(123,2,"B",1,1,"EpicEquipment",3,adventurers);
        Equipment.addImRegularEquipment(123,3,"C",1,1,"CritEquipment",3,adventurers);
        manager.findClassName(123,1, adventurers) ;
        manager.findClassName(123,2, adventurers) ;
        manager.findClassName(123,3, adventurers) ;
        manager.findClassName(123,11, adventurers) ;
        manager.findClassName(123,22, adventurers) ;
        manager.findClassName(123,33, adventurers) ;
        manager.findClassName(123,111, adventurers) ;
        manager.findClassName(123,1111, adventurers) ;
    }
@Test
    public void find2() {
        Bottle b1 = new Bottle(1, "A", 1, 1);
        Bottle b2 = new Bottle(2, "Aa", 1, 1);
        Bottle b3 = new Bottle(3, "Aaa", 1, 131);
        Adventurer adventurer = new Adventurer(123, "aaa");
        adventurers.put(123,adventurer);
        adventurer.getBottles().put(1, b1);
        adventurer.getBottles().put(2, b2);
        adventurer.getBottles().put(3, b3);
        Food e1 = new Food(11, "a1", 1, 1);
        Food e2 = new Food(21, "a2", 1, 1);
        Food e3 = new Food(31, "a3", 1, 1);
        Food e4 = new Food(41, "a4", 1, 1353);
        adventurer.getFoods().put(11, e3);
        adventurer.getFoods().put(21, e2);
        adventurer.getFoods().put(31, e3);
        adventurer.getFoods().put(41, e4);
    Equipment ee1 = new Equipment(15, "a1", 1, 1);
    Equipment ee2 = new Equipment(25, "a2", 1, 15);
    Equipment ee3 = new Equipment(5, "a3", 1, 1);
    Equipment ee4 = new Equipment(45, "a4", 1, 1);
    adventurer.getEquipments().put(15, ee1);
    adventurer.getEquipments().put(25, ee2);
    adventurer.getEquipments().put(5, ee3);
    adventurer.getEquipments().put(45, ee4);
        Adventurer ff = new Adventurer(34,"d");
        ff.setMoney(5);
        adventurer.getEmployees().put(34,ff);
        adventurers.put(34,ff);
        manager.findMaxValuer(123,adventurers);
    }

    @Test
    public void find3() {
        Bottle b1 = new Bottle(1, "A", 1, 1);
        Bottle b2 = new Bottle(2, "Aa", 1, 1);
        Bottle b3 = new Bottle(3, "Aaa", 1, 1);
        Adventurer adventurer = new Adventurer(123, "aaa");
        adventurers.put(123,adventurer);
        adventurer.getBottles().put(1, b1);
        adventurer.getBottles().put(2, b2);
        adventurer.getBottles().put(3, b3);
        adventurer.getBottles().put(1, b1);
        adventurer.getBag().getBottles().put(2, b2);
        adventurer.getBag().getBottles().put(3, b3);
        Food e1 = new Food(11, "a1", 1, 1);
        Food e2 = new Food(21, "a2", 1, 1);
        Food e3 = new Food(31, "a3", 1, 1);
        Food e4 = new Food(41, "a4", 1, 1);
        adventurer.getFoods().put(11, e3);
        adventurer.getFoods().put(21, e2);
        adventurer.getFoods().put(31, e3);
        adventurer.getFoods().put(41, e4);
        adventurer.getBag().getFoods().put(11, e3);
        adventurer.getBag().getFoods().put(21, e2);
        adventurer.getBag().getFoods().put(31, e3);
        adventurer.getBag().getFoods().put(41, e4);
        Adventurer ff = new Adventurer(34,"d");
        adventurer.getEmployees().put(34,ff);
        adventurers.put(34,ff);
        Equipment ee1 = new Equipment(15, "a1", 1, 1);
        Equipment ee2 = new Equipment(25, "a2", 1, 15);
        Equipment ee3 = new Equipment(5, "a3", 1, 1);
        Equipment ee4 = new Equipment(45, "a4", 1, 1);
        adventurer.getEquipments().put(15, ee1);
        adventurer.getEquipments().put(25, ee2);
        adventurer.getEquipments().put(5, ee3);
        adventurer.getEquipments().put(45, ee4);
        adventurer.getBag().getEquipments().put(15, ee1);
        manager.saleAllCarryItem(123,adventurers,shop);
    }
    @Test
    public void buy3() {
        Adventurer adventurer = new Adventurer(123, "aaa");
        adventurers.put(123,adventurer);
        shop.setBottleNum(1);
        shop.setFoodNum(1);
        shop.setEquipmentNum(1);
        Manager.buyItem(123,1,"a","Food",adventurers,shop,0);
        Manager.buyItem(123,2,"B","RegularEquipment",adventurers,shop,0);
        Manager.buyItem(123,11,"a","CritEquipment",adventurers,shop,0);
        Manager.buyItem(123,21,"B","EpicEquipment",adventurers,shop,0);
        Manager.buyItem(123,111,"a","ReinforcedBottle",adventurers,shop,0);
        Manager.buyItem(123,211,"B","RecoverBottle",adventurers,shop,0);
        Manager.buyItem(123,1111,"a","RegularBottle",adventurers,shop,0);
        shop.setAllBottlePrice(2);
        shop.setAllFoodPrice(2);
        shop.setAllEquipmentPrice(3);
        Manager.buyItem(123,16,"a","Food",adventurers,shop,0);
        Manager.buyItem(123,26,"B","RegularEquipment",adventurers,shop,0);
        Manager.buyItem(123,116,"a","CritEquipment",adventurers,shop,0);
        Manager.buyItem(123,216,"B","EpicEquipment",adventurers,shop,0);
        Manager.buyItem(123,1116,"a","ReinforcedBottle",adventurers,shop,0);
        Manager.buyItem(123,2116,"B","RecoverBottle",adventurers,shop,0);
        Manager.buyItem(123,6,"a","RegularBottle",adventurers,shop,0);

    }

}