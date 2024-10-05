import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("A");
        Main.op1(tmp);
    }

    @Test
    public void op2() {
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RecoverBottle");
        tmp.add("7");
        Main.op2(tmp);
    }
    @Test
    public void op22() {
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RegularBottle");
        tmp.add("7");
        Main.op2(tmp);
    }

    @Test
    public void op3() {
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RegularBottle");
        tmp.add("7");
        Main.op2(tmp);
        ArrayList<String> tmp3 = new ArrayList<>();
        tmp3.add("0");
        tmp3.add("3");
        tmp3.add("2");
        Main.op3(tmp);
    }

    @Test
    public void op4() {
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RegularEquipment");
        tmp.add("7");
        Main.op4(tmp);
    }

    @Test
    public void op5() {
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RegularEquipment");
        tmp.add("7");
        Main.op4(tmp);
        ArrayList<String> tmp4 = new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("2");
        Main.op5(tmp);
    }
    @Test
    public void op55() {
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RegularEquipment");
        tmp.add("7");
        Main.op4(tmp);
        ArrayList<String> tmp4 = new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("3");
        Main.op5(tmp);
    }
    @Test
    public void op4_1() {
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RecoverEquipment");
        tmp.add("7");
        Main.op4(tmp);
    }


    @Test
    public void op6() {
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RegularEquipment");
        tmp.add("7");
        Main.op4(tmp);
        ArrayList<String> tmp4 = new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("2");
        Main.op6(tmp);
    }

    @Test
    public void op7() {
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        Main.op7(tmp);
    }

    @Test
    public void op8() {
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        Main.op7(tmp);
        ArrayList<String> tmp4 = new ArrayList<>();
        tmp4.add("2");
        tmp4.add("3");
        tmp4.add("2");
        Main.op8(tmp4);
    }

    @Test
    public void op9() {
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RegularEquipment");
        tmp.add("7");
        Main.op4(tmp);
        ArrayList<String> tmp4 = new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("2");
        Main.op9(tmp4);
    }

    @Test
    public void op10() {
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RecoverBottle");
        tmp.add("7");
        Main.op2(tmp);
        ArrayList<String> tmp4 = new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("2");
        Main.op10(tmp4);
    }

    @Test
    public void op11() {
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        Main.op7(tmp);
        ArrayList<String> tmp4 = new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("2");
        Main.op11(tmp4);
    }

    @Test
    public void op12() {
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        tmp.add("RecoverBottle");
        tmp.add("7");
        Main.op2(tmp);
        ArrayList<String> tmp4 = new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("2");
        Main.op10(tmp4);
        ArrayList<String> tmp5= new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("2");
        Main.op12(tmp4);

    }

    @Test
    public void op13() {
        HashMap adventurers = new HashMap();
        ArrayList<String> tmp1 = new ArrayList<>();
        tmp1.add("0");
        tmp1.add("3");
        tmp1.add("A");
        Main.op1(tmp1);
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("3");
        tmp.add("2");
        tmp.add("3");
        tmp.add("4");
        tmp.add("5");
        Main.op7(tmp);
        ArrayList<String> tmp4 = new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("2");
        Main.op11(tmp4);
        ArrayList<String> tmp5= new ArrayList<>();
        tmp4.add("0");
        tmp4.add("3");
        tmp4.add("3");
        Main.op13(tmp4);
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
        Bottle b1 = new Bottle(11, "A", 1, 1);
        Bottle b2 = new Bottle(2, "Aa", 1, 1);
        Bottle b3 = new Bottle(43, "Aaa", 1, 1);
        Bottle b4 = new Bottle(3, "Aaa", 1, 1);
        Adventurer adventurer = new Adventurer(123, "aaa");
        adventurer.getBottles().put(1, b1);
        adventurer.getBottles().put(2, b2);
        adventurer.getBottles().put(43, b3);
        adventurer.getBottles().put(3, b4);
        Main.findMinbotlleKey(adventurer.getBottles(),"Aaa");
        Main.findMinbotlleKey(adventurer.getBottles(),"A0");
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
        Main.findadvID(adventurers,"a1");
        Main.findadvID(adventurers,"a2");
    }
    @Test
    public void countskey() {
        HashMap<Integer, Adventurer> adventurerHashMap = new HashMap<>();
        Adventurer a1 = new Adventurer(1, "a1");
        Adventurer a2 = new Adventurer(2, "a2");
        Adventurer a3 = new Adventurer(3, "a3");
        Adventurer a4 = new Adventurer(4, "a4");
        adventurerHashMap.put(1, a1);
        adventurerHashMap.put(2, a2);
        adventurerHashMap.put(3, a3);
        adventurerHashMap.put(4, a4);
        a1.getEmployees().put(2, a2);
        a1.getEmployees().put(3, a3);
        Manager.countValue(1,adventurerHashMap);
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
        Food e1 = new Food(1, "a3", 1, 1);
        Food e2 = new Food(2, "a2", 1, 1);
        Food e3 = new Food(3, "a3", 1, 1);
        Food e4 = new Food(4, "a4", 1, 1);
        A.getFoods().put(3, e3);
        A.getFoods().put(2, e2);
        A.getFoods().put(1, e1);
        A.getFoods().put(4, e4);
        Main.findMinfoodKey(A.getFoods(),"a3");
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