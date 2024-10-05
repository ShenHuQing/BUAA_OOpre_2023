import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static HashMap<Integer, Adventurer> adventurers = new HashMap<>();
    private static ArrayList<Log> logs = new ArrayList<>();
    private static Manager manager = new Manager();
    private static ArrayList<ArrayList<String>> inputInfo = new ArrayList<>();
    private static ArrayList<String> tmp = new ArrayList<>();
    private static String[] strings;
    private static Scanner scanner;
    private static Shop shop = new Shop();

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            strings = nextLine.trim().split(" +"); // 按空格对行进行分割
            inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
            int type = Integer.parseInt(inputInfo.get(i).get(0));
            tmp = inputInfo.get(i);
            switch (type) {
                case 1: op1(tmp);
                    break;
                case 2: op2(tmp);
                    break;
                case 3: op3(tmp);
                    break;
                case 4: op4(tmp);
                    break;
                case 5: op5(tmp);
                    break;
                case 6: op6(tmp);
                    break;
                case 7: op7(tmp);
                    break;
                case 8: op8(tmp);
                    break;
                case 9: op9(tmp);
                    break;
                case 10: op10(tmp);
                    break;
                case 11: op11(tmp);
                    break;
                case 12: op12(tmp);
                    break;
                case 13: op13(tmp);
                    break;
                case 14: op14(tmp);
                    break;
                case 15: op15(tmp);
                    break;
                case 16: op16(tmp);
                    break;
                case 17: op17(tmp);
                    break;
                case 18: op18(tmp);
                    break;
                case 19: op19(tmp);
                    break;
                case 20: op20(tmp);
                    break;
                case 21: op21(tmp);
                    break;
                case 22: op22(tmp);
                    break;
                case 23: op23(tmp);
                    break;
                default: System.out.println("error");
            }

        }
    }

    public static void op1(ArrayList<String> tmp) {
        manager.addAdventurer(Integer.parseInt(tmp.get(1)), tmp.get(2), adventurers);
    }

    public static void op2(ArrayList<String> tmp) {
        if (!Objects.equals(tmp.get(6), "RegularBottle")) {
            Bottle.addImBottle(Integer.parseInt(tmp.get(1)),
                    Integer.parseInt(tmp.get(2)), tmp.get(3), Integer.parseInt(tmp.get(4)),
                    Integer.parseInt(tmp.get(5)), tmp.get(6),
                    Double.parseDouble(tmp.get(7)),adventurers);
        }
        else {
            Bottle.addRegularBottle(Integer.parseInt(tmp.get(1)),
                    Integer.parseInt(tmp.get(2)), tmp.get(3),
                    Integer.parseInt(tmp.get(4)),Integer.parseInt(tmp.get(5)),
                    tmp.get(6),adventurers);
        }
    }

    public static void op3(ArrayList<String> tmp) {
        Bottle.removeBottle(Integer.parseInt(tmp.get(1)), Integer.parseInt(tmp.get(2)),
                adventurers, shop);
    }

    public static void op4(ArrayList<String> tmp) {
        if (!Objects.equals(tmp.get(6), "RegularEquipment")) {
            Equipment.addImRegularEquipment(Integer.parseInt(tmp.get(1)),
                    Integer.parseInt(tmp.get(2)), tmp.get(3),
                    Integer.parseInt(tmp.get(4)),Integer.parseInt(tmp.get(5)),
                    tmp.get(6), Double.parseDouble(tmp.get(7)),adventurers);
        }
        else {
            Equipment.addRegularEquipment(Integer.parseInt(tmp.get(1)),
                    Integer.parseInt(tmp.get(2)), tmp.get(3), Integer.parseInt(tmp.get(4)),
                    Integer.parseInt(tmp.get(5)), tmp.get(6),adventurers);
        }
    }

    public static void op5(ArrayList<String> tmp) {
        Equipment.removeEquipment(Integer.parseInt(tmp.get(1)),
                Integer.parseInt(tmp.get(2)), adventurers, shop);
    }

    public static void op6(ArrayList<String> tmp) {
        Equipment.enhanceEquipmentStar(Integer.parseInt(tmp.get(1)),
                Integer.parseInt(tmp.get(2)), adventurers);
    }

    public static void op7(ArrayList<String> tmp) {
        manager.addFood(Integer.parseInt(tmp.get(1)), Integer.parseInt(tmp.get(2)), tmp.get(3),
                Integer.parseInt(tmp.get(4)), Integer.parseInt(tmp.get(5)), adventurers);
    }

    public static void op8(ArrayList<String> tmp) {
        manager.removeFood(Integer.parseInt(tmp.get(1)),
                Integer.parseInt(tmp.get(2)), adventurers,shop);
    }

    public static void op9(ArrayList<String> tmp) {
        manager.carryEquipment(Integer.parseInt(tmp.get(1)),
                Integer.parseInt(tmp.get(2)), adventurers);
    }

    public static void op10(ArrayList<String> tmp) {
        manager.carryBottle(Integer.parseInt(tmp.get(1)),
                Integer.parseInt(tmp.get(2)), adventurers);
    }

    public static void op11(ArrayList<String> tmp) {
        manager.carryFood(Integer.parseInt(tmp.get(1)),
                Integer.parseInt(tmp.get(2)), adventurers);
    }

    public static void op12(ArrayList<String> tmp) {
        manager.useBottle(Integer.parseInt(tmp.get(1)), tmp.get(2), adventurers);
    }

    public static void op13(ArrayList<String> tmp) {
        manager.useFood(Integer.parseInt(tmp.get(1)), tmp.get(2), adventurers);
    }

    public static void op14(ArrayList<String> tmp) {
        Main.type14(tmp,scanner,manager,adventurers,logs);
    }

    public static void op15(ArrayList<String> tmp) {
        manager.outDate(logs,tmp.get(1));
    }

    public static void op16(ArrayList<String> tmp) {
        manager.outFighter(logs,Integer.parseInt(tmp.get(1)));
    }

    public static void op17(ArrayList<String> tmp) {
        manager.outLoser(logs,Integer.parseInt(tmp.get(1)));
    }

    public static void op18(ArrayList<String> tmp) {
        manager.hireAdv(Integer.parseInt(tmp.get(1)), Integer.parseInt(tmp.get(2)), adventurers);
    }

    public static void op19(ArrayList<String> tmp) {
        manager.printValue(Integer.parseInt(tmp.get(1)), adventurers);
    }

    public static void op20(ArrayList<String> tmp) {
        manager.findMaxValuer(Integer.parseInt(tmp.get(1)), adventurers);
    }

    public static void op21(ArrayList<String> tmp) {
        manager.findClassName(Integer.parseInt(tmp.get(1)),
                Integer.parseInt(tmp.get(2)), adventurers);
    }

    public static void op22(ArrayList<String> tmp) {
        manager.saleAllCarryItem(Integer.parseInt(tmp.get(1)),adventurers,shop);
    }

    public static void op23(ArrayList<String> tmp) {
        if (tmp.size() == 6) {
            manager.buyItem(Integer.parseInt(tmp.get(1)),Integer.parseInt(tmp.get(2)),
                    tmp.get(3),tmp.get(4),adventurers,shop, Double.parseDouble(tmp.get(5)));
        }
        else {
            manager.buyItem(Integer.parseInt(tmp.get(1)),Integer.parseInt(tmp.get(2)),
                    tmp.get(3),tmp.get(4),adventurers,shop, 0);
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

    public static void type14(ArrayList<String> tmp, Scanner scanner, Manager manager,
                              HashMap<Integer, Adventurer> adventurers, ArrayList<Log> logs) {
        System.out.println("Enter Fight Mode");
        int m = Integer.parseInt(tmp.get(1));
        int k = Integer.parseInt(tmp.get(2));
        String[] fightname = new String[m];
        ArrayList<Integer> fightHalfHit = new ArrayList<>();
        int j = 0;
        for (int i1 = 3; i1 < 3 + m; i1++) {
            fightname[j] = tmp.get(i1);
            int advId = Main.findadvID(adventurers,fightname[j]);
            fightHalfHit.add(adventurers.get(advId).getHitpoint() / 2);
            adventurers.get(advId).setChangeHit(0);
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
        for (int i2 = 0; i2 < j; i2++) {
            int advId = Main.findadvID(adventurers,fightname[i2]);
            Adventurer adventurer = adventurers.get(advId);
            if (adventurer.getHitpoint() <= fightHalfHit.get(i2)) {
                int change = adventurer.getChangeHit();
                long payouts = Math.abs(change) * 10000L;
                HashMap<Integer, Adventurer> employees = adventurer.getEmployees();
                for (Map.Entry<Integer, Adventurer> entry : employees.entrySet()) {
                    Adventurer employee = entry.getValue();
                    int empId = employee.getId();
                    if (payouts > employee.getMoney()) {
                        adventurer.setMoney(adventurer.getMoney() + employee.getMoney());
                        employee.setMoney(0);
                    }
                    else {
                        employee.setMoney(employee.getMoney() - payouts);
                        adventurer.setMoney(adventurer.getMoney() + payouts);
                    }
                }

            }
        } //存入战斗名字
    }
}