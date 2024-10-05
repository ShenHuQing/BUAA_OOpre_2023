import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ManagerTest {
    Manager manager = new Manager();
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
            manager.addImBottle(1, 2, "3", 4, 5, "RecoverBottle", 7, adventurers);
        }
        manager.removeBottle(1, 2, adventurers);
    }

    @Test
    public void addImBottle() {
        if (!Objects.equals("RegularBottle", "RegularBottle")) {
            manager.addImBottle(1, 2, "3", 4, 5, "RecoverBottle", 7, adventurers);
        }
    }

    @Test
    public void removeBottle() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        if (!Objects.equals("RecoverEquipment", "RegularEquipment")) {
            manager.addImRegularEquipment(1, 2, "3", 4, 1, "RecoverEquipment", 1, adventurers);
        }
        manager.removeEquipment(1, 2, adventurers);
    }

    @Test
    public void addImRegularEquipment() {
        Adventurer adv = new Adventurer(1, "a");
        Equipment equipment = new Equipment(2, "A", 1, 1);
        adventurers.put(1, adv);
        adv.getEquipments().put(2, equipment);
        if (!Objects.equals("RecoverEquipment", "RegularEquipment")) {
            manager.addImRegularEquipment(1, 2, "3", 4, 1, "RecoverEquipment", 1, adventurers);
        }
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
    public void findClassName() {
    }
}