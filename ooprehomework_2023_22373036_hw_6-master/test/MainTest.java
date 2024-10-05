import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class MainTest {
    Manager manager = new Manager();
    HashMap<Integer, Adventurer> adventurers = new HashMap<>();
    final InputStream originalIn = System.in;
    final PrintStream originalOut = System.out;

    @Test
    public void testMain() throws FileNotFoundException {
        String s = "2\n" +
                "1 123456 advName\n" +
                "2 123456 123 bottleName 40";
        System.out.println(s);
        System.setIn(new ByteArrayInputStream(s.getBytes()));
        Main test = new Main();
    }

    @Test
    public void op1() {
        manager.addAdventurer(1, "A", adventurers);
        HashMap adventurers = new HashMap();
        String nextLine = "3 A"; // 读取本行指令
        String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>();
        inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
        ArrayList<String> tmp = inputInfo.get(0);
    }

    @Test
    public void op2() {
        if (!Objects.equals("RegularBottle", "RegularBottle")) {
            manager.addImBottle(1, 2, "3", 4, 5, "RecoverBottle", 7, adventurers);
        }
        op8();
    }

    @Test
    public void op3() {
        Adventurer adv = new Adventurer(1, "a");
        Bottle bottle = new Bottle(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getBottles().put(2, bottle);
        if (!Objects.equals("RecoverBottle", "RegularBottle")) {
            manager.addImBottle(1, 2, "3", 4, 5, "RecoverBottle", 7, adventurers);
        }
        manager.removeBottle(1, 2, adventurers);
    }

    @Test
    public void op4() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        if (!Objects.equals("RecoverEquipment", "RegularEquipment")) {
            manager.addImRegularEquipment(1, 2, "3", 4, 1, "RecoverEquipment", 1, adventurers);
        }
        op2();
    }

    @Test
    public void op5() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        if (!Objects.equals("RecoverEquipment", "RegularEquipment")) {
            manager.addImRegularEquipment(1, 2, "3", 4, 1, "RecoverEquipment", 1, adventurers);
        }
        manager.removeEquipment(1, 2, adventurers);
        op6();
    }

    @Test
    public void op6() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        manager.enhanceEquipmentStar(1, 2, adventurers);
    }

    @Test
    public void op7() {
        Adventurer adv = new Adventurer(1, "a");
        adventurers.put(1, adv);
        manager.addFood(1, 2, "A", 3, 4, adventurers);
    }

    @Test
    public void op8() {
        Adventurer adv = new Adventurer(1, "a");
        Food food = new Food(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getFoods().put(2, food);
        manager.removeFood(1, 2, adventurers);
    }

    @Test
    public void op9() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        manager.carryEquipment(1, 2, adventurers);
    }

    @Test
    public void op10() {
        Adventurer adv = new Adventurer(1, "a");
        Bottle bottle = new Bottle(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getBottles().put(2, bottle);
        if (Objects.equals("RegularBottle", "RegularBottle")) {
            manager.addRegularBottle(1, 2, "3", 4, 5, "RegularBottle", adventurers);
        }
        manager.carryBottle(1, 2, adventurers);
    }

    @Test
    public void op11() {
        Adventurer adv = new Adventurer(1, "a");
        adventurers.put(1, adv);
        manager.addFood(1, 2, "A", 3, 4, adventurers);
        manager.carryFood(1, 2, adventurers);
    }

    @Test
    public void op12() {
        Adventurer adv = new Adventurer(1, "a");
        Bottle bottle = new Bottle(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getBottles().put(2, bottle);
        if (Objects.equals("RegularBottle", "RegularBottle")) {
            manager.addRegularBottle(1, 2, "3", 4, 5, "RegularBottle", adventurers);
        }
        manager.carryBottle(1, 2, adventurers);
        manager.useBottle(1, "3", adventurers);
    }

    @Test
    public void op13() {
        Adventurer adv = new Adventurer(1, "a");
        adventurers.put(1, adv);
        manager.addFood(1, 2, "A", 3, 4, adventurers);
        manager.carryFood(1, 2, adventurers);
        manager.useFood(1, "A", adventurers);
    }

    @Test
    public void op14() {
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
    public void op15() {
        ArrayList<Log> logs = new ArrayList<>();
        int found = 0;
        for (int i = 0; i < logs.size(); i++) {
            Log log = logs.get(i);
            if (Objects.equals(log.getDate(), 2022 / 03)) {
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

    @Test
    public void op16() {
        ArrayList<Log> logs = new ArrayList<>();
        int found = 0;
        for (int i = 0; i < logs.size(); i++) {
            Log log = logs.get(i);
            if (log.getFighterID() != -1) {
                if (log.getFighterID() == 1) {
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

    @Test
    public void op17() {
        ArrayList<Log> logs = new ArrayList<>();
        int found = 0;
        for (int i = 0; i < logs.size(); i++) {
            Log log = logs.get(i);
            if (log.getFunc() == 2) {
                if (log.getLoserID() == 2) {
                    found = 1;
                    {
                        System.out.println(log.getDate() + " " + log.getFighterName() +
                                " attacked " + log.getLoserName() + " with "
                                + log.getEquName());
                    }
                }
            } else if (log.getFunc() == 3) {
                for (int j = 0; j < log.getLsID().size(); j++) {
                    int loserId = log.getLsID().get(j);
                    if (loserId == 2) {
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

    @Test
    public void op18() {
        Adventurer a1 = new Adventurer(1, "a");
        Adventurer a2 = new Adventurer(2, "b");
        adventurers.put(1, a1);
        adventurers.put(2, a2);
        int flag = 0;
        Adventurer employer = adventurers.get(1);
        Adventurer employee = adventurers.get(2);
        if (employer.getEmployees().containsKey(2)) {
            flag = 1;
        }
        if (flag == 0) {
            employer.getEmployees().put(2, employee);
            int valuecount = employer.getValueCount();
            employer.setValueCount(valuecount + 1);
            employer.enhanceHireValue(employee);
        }
        int flag1 = 0;
        employer = adventurers.get(1);
        employee = adventurers.get(2);
        if (employer.getEmployees().containsKey(2)) {
            flag1 = 1;
        }
        if (flag1 == 0) {
            employer.getEmployees().put(2, employee);
            int valuecount = employer.getValueCount();
            employer.setValueCount(valuecount + 1);
            employer.enhanceHireValue(employee);
        }
    }


    @Test
    public void op19() {
        Adventurer a1 = new Adventurer(1, "a");
        Adventurer a2 = new Adventurer(2, "b");
        adventurers.put(1, a1);
        Adventurer adventurer = adventurers.get(1);
        int count = adventurer.getValueCount();
        long value = 2;
        System.out.println(count + " " + value);
    }

    @Test
    public void op20() {
        Adventurer a1 = new Adventurer(1, "a");
        Adventurer a2 = new Adventurer(2, "b");
        adventurers.put(1, a1);
        adventurers.put(2, a2);
        int flag = 0;
        Adventurer employer = adventurers.get(1);
        Adventurer employee = adventurers.get(2);
        if (employer.getEmployees().containsKey(2)) {
            flag = 1;
        }
        if (flag == 0) {
            employer.getEmployees().put(2, employee);
            int valuecount = employer.getValueCount();
            employer.setValueCount(valuecount + 1);
            employer.enhanceHireValue(employee);
        }
        Bottle bottle1 = new Bottle(5, "aa", 1, 1);
        Equipment equipment1 = new Equipment(6, "bb", 1, 1);
        Food food1 = new Food(7, "cc", 1, 1);
        a1.getFoods().put(7, food1);
        a1.getEquipments().put(6, equipment1);
        a1.getBottles().put(5, bottle1);
        Long max = 0L;
        HashMap<Integer, Adventurer> employees = a1.getEmployees();
        for (Map.Entry<Integer, Adventurer> entry : employees.entrySet()) {
            Adventurer a3 = entry.getValue();
            int empId = employee.getId();
            Long price = 1L;
            if (price > max) {
                max = price;
            }
        }
        HashMap<Integer, Equipment> equipments = a1.getEquipments();
        for (Map.Entry<Integer, Equipment> entry : equipments.entrySet()) {
            Equipment equipment = entry.getValue();
            Long price = equipment.getValue();
            if (price > max) {
                max = price;
            }
        }
        HashMap<Integer, Bottle> bottles = a1.getBottles();
        for (Map.Entry<Integer, Bottle> entry : bottles.entrySet()) {
            Bottle bottle = entry.getValue();
            Long price = bottle.getValue();
            if (price > max) {
                max = price;
            }
        }
        HashMap<Integer, Food> foods = a1.getFoods();
        for (Map.Entry<Integer, Food> entry : foods.entrySet()) {
            Food food = entry.getValue();
            Long price = food.getValue();
            if (price > max) {
                max = price;
            }
        }
        System.out.println(max);
    }

    @Test
    public void op21() {
        Adventurer a1 = new Adventurer(1, "a");
        Adventurer a2 = new Adventurer(2, "b");
        adventurers.put(1, a1);
        adventurers.put(2, a2);
        int flag1 = 0;
        Adventurer employer = adventurers.get(1);
        Adventurer employee = adventurers.get(2);
        if (employer.getEmployees().containsKey(2)) {
            flag1 = 1;
        }
        if (flag1 == 0) {
            employer.getEmployees().put(2, employee);
            int valuecount = employer.getValueCount();
            employer.setValueCount(valuecount + 1);
            employer.enhanceHireValue(employee);
        }
        RegularBottle bottle1 = new RegularBottle(5, "aa", 1, 1);
        Equipment equipment1 = new Equipment(6, "bb", 1, 1);
        Food food1 = new Food(7, "cc", 1, 1);
        a1.getFoods().put(7, food1);
        a1.getEquipments().put(6, equipment1);
        a1.getBottles().put(5, bottle1);
        String flag = "0";
        HashMap<Integer, Adventurer> employees = a1.getEmployees();
        for (Map.Entry<Integer, Adventurer> entry : employees.entrySet()) {
            int key = entry.getKey();
            if (Objects.equals(key, 5)) {
                flag = "Adventurer";
            }
        }
        HashMap<Integer, Equipment> equipments = a1.getEquipments();
        for (Map.Entry<Integer, Equipment> entry : equipments.entrySet()) {
            int key = entry.getKey();
            Equipment equipment = entry.getValue();
            if (Objects.equals(key, 5)) {
                if (equipment instanceof RegularEquipment) {
                    flag = "RegularEquipment";
                } else if (equipment instanceof EpicEquipment) {
                    flag = "EpicEquipment";
                } else if (equipment instanceof CritEquipment) {
                    flag = "CritEquipment";
                }
            }
        }
        HashMap<Integer, Bottle> bottles = a1.getBottles();
        for (Map.Entry<Integer, Bottle> entry : bottles.entrySet()) {
            int key = entry.getKey();
            Bottle bottle = entry.getValue();
            if (Objects.equals(key, 5)) {
                if (bottle instanceof RegularBottle) {
                    flag = "RegularBottle";
                } else if (bottle instanceof ReinforcedBottle) {
                    flag = "ReinforcedBottle";
                } else if (bottle instanceof RecoverBottle) {
                    flag = "RecoverBottle";
                }
            }
        }
        HashMap<Integer, Food> foods = a1.getFoods();
        for (Map.Entry<Integer, Food> entry : foods.entrySet()) {
            int key = entry.getKey();
            if (Objects.equals(key, 5)) {
                flag = "Food";
            }
        }
        System.out.println("Commodity whose id is " + 5 + " belongs to " + flag);
    }


    @Test
    public void match1() {
    }

    @Test
    public void match2() {
    }

    @Test
    public void match3() {
    }

    @Test
    public void findMinbotlleKey() {
        Bottle b1 = new Bottle(1, "A", 1, 1);
        Bottle b2 = new Bottle(2, "Aa", 1, 1);
        Bottle b3 = new Bottle(3, "Aaa", 1, 1);
        Adventurer adventurer = new Adventurer(123, "aaa");
        adventurer.getBottles().put(1, b1);
        adventurer.getBottles().put(2, b2);
        adventurer.getBottles().put(3, b3);
        int minKey = Integer.MAX_VALUE;
        boolean found = false;

        for (Map.Entry<Integer, Bottle> entry : adventurer.getBottles().entrySet()) {
            int key = entry.getKey();
            Bottle bottle = entry.getValue();
            if (bottle.getName().equals("Aaa")) {
                if (key < minKey) {
                    minKey = key;
                    found = true;
                }
            }

        }

    }

    @Test
    public void findadvID() {
        HashMap<Integer, Adventurer> adventurerHashMap = new HashMap<>();
        Adventurer a1 = new Adventurer(1, "a1");
        Adventurer a2 = new Adventurer(2, "a2");
        Adventurer a3 = new Adventurer(3, "a3");
        Adventurer a4 = new Adventurer(4, "a4");
        adventurerHashMap.put(1, a1);
        adventurerHashMap.put(2, a2);
        adventurerHashMap.put(3, a3);
        adventurerHashMap.put(4, a4);
        boolean found = false;
        for (Map.Entry<Integer, Adventurer> entry : adventurerHashMap.entrySet()) {
            int key = entry.getKey();
            Adventurer adventurer = entry.getValue();
            if (Objects.equals(adventurer.getName(), a4)) {
                int a = key;
            }
        }
    }

    @Test
    public void findequipID() {
        Adventurer A = new Adventurer(11, "AA");
        Equipment e1 = new Equipment(1, "a1", 1, 1);
        Equipment e2 = new Equipment(2, "a2", 1, 1);
        Equipment e3 = new Equipment(3, "a3", 1, 1);
        Equipment e4 = new Equipment(4, "a4", 1, 1);
        A.getEquipments().put(1, e1);
        A.getEquipments().put(2, e2);
        A.getEquipments().put(3, e3);
        A.getEquipments().put(4, e4);
        boolean found = false;
        for (Map.Entry<Integer, Equipment> entry : A.getEquipments().entrySet()) {
            int key = entry.getKey();
            int a = 0;
            Equipment equipment = entry.getValue();
            if (equipment.getName().equals(e3)) {
                a = key;
            }
        }
    }

    @Test
    public void findMinfoodKey() {
        Adventurer A = new Adventurer(11, "AA");
        Food e1 = new Food(1, "a1", 1, 1);
        Food e2 = new Food(2, "a2", 1, 1);
        Food e3 = new Food(3, "a3", 1, 1);
        Food e4 = new Food(4, "a4", 1, 1);
        A.getFoods().put(1, e3);
        A.getFoods().put(2, e2);
        A.getFoods().put(3, e3);
        A.getFoods().put(4, e4);
        int minKey = Integer.MAX_VALUE;
        boolean found = false;

        for (Map.Entry<Integer, Food> entry : A.getFoods().entrySet()) {
            int key = entry.getKey();
            Food food = entry.getValue();
            if (food.getName().equals(e3)) {
                if (key < minKey) {
                    minKey = key;
                    found = true;
                }
            }

        }
        if (found) {
            minKey = minKey;
        } else {
            minKey = -1;
        }
    }

    @Test
    public void countKeysByValue() {
        Bottle b1 = new Bottle(1, "A", 1, 1);
        Bottle b2 = new Bottle(2, "Aa", 1, 1);
        Bottle b3 = new Bottle(3, "Aaa", 1, 1);
        Adventurer adventurer = new Adventurer(123, "aaa");
        adventurer.getBottles().put(1, b1);
        adventurer.getBottles().put(2, b2);
        adventurer.getBottles().put(3, b3);
        int count = 0;
        for (Bottle bottle : adventurer.getBottles().values()) {
            if (bottle.getName().equals("A")) {
                count++;
            }

        }
    }
}