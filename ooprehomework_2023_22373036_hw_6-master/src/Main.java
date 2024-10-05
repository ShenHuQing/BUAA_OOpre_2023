import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static HashMap<Integer, Adventurer> adventurers = new HashMap<>();
    private static ArrayList<Log> logs = new ArrayList<>();
    private static Manager manager = new Manager();
    private static ArrayList<ArrayList<String>> inputInfo = new ArrayList<>();
    private static ArrayList<String> tmp = new ArrayList<>();
    private static String[] strings;
    private static Scanner scanner;

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
                default: System.out.println("error");
            }

        }
    }

    public static void op1(ArrayList<String> tmp) {
        manager.addAdventurer(Integer.parseInt(tmp.get(1)), tmp.get(2), adventurers);
    }

    public static void op2(ArrayList<String> tmp) {
        if (!Objects.equals(tmp.get(6), "RegularBottle")) {
            manager.addImBottle(Integer.parseInt(tmp.get(1)),
                    Integer.parseInt(tmp.get(2)), tmp.get(3), Integer.parseInt(tmp.get(4)),
                    Integer.parseInt(tmp.get(5)), tmp.get(6),
                    Double.parseDouble(tmp.get(7)),adventurers);
        }
        else {
            manager.addRegularBottle(Integer.parseInt(tmp.get(1)),
                    Integer.parseInt(tmp.get(2)), tmp.get(3),
                    Integer.parseInt(tmp.get(4)),Integer.parseInt(tmp.get(5)),
                    tmp.get(6),adventurers);
        }
    }

    public static void op3(ArrayList<String> tmp) {
        manager.removeBottle(Integer.parseInt(tmp.get(1)), Integer.parseInt(tmp.get(2)),
                adventurers);
    }

    public static void op4(ArrayList<String> tmp) {
        if (!Objects.equals(tmp.get(6), "RegularEquipment")) {
            manager.addImRegularEquipment(Integer.parseInt(tmp.get(1)),
                    Integer.parseInt(tmp.get(2)), tmp.get(3),
                    Integer.parseInt(tmp.get(4)),Integer.parseInt(tmp.get(5)),
                    tmp.get(6), Double.parseDouble(tmp.get(7)),adventurers);
        }
        else {
            manager.addRegularEquipment(Integer.parseInt(tmp.get(1)),
                    Integer.parseInt(tmp.get(2)), tmp.get(3), Integer.parseInt(tmp.get(4)),
                    Integer.parseInt(tmp.get(5)), tmp.get(6),adventurers);
        }
    }

    public static void op5(ArrayList<String> tmp) {
        manager.removeEquipment(Integer.parseInt(tmp.get(1)),
                Integer.parseInt(tmp.get(2)), adventurers);
    }

    public static void op6(ArrayList<String> tmp) {
        manager.enhanceEquipmentStar(Integer.parseInt(tmp.get(1)),
                Integer.parseInt(tmp.get(2)), adventurers);
    }

    public static void op7(ArrayList<String> tmp) {
        manager.addFood(Integer.parseInt(tmp.get(1)), Integer.parseInt(tmp.get(2)), tmp.get(3),
                Integer.parseInt(tmp.get(4)), Integer.parseInt(tmp.get(5)), adventurers);
    }

    public static void op8(ArrayList<String> tmp) {
        manager.removeFood(Integer.parseInt(tmp.get(1)), Integer.parseInt(tmp.get(2)), adventurers);
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
        manager.type14(tmp,scanner,manager,adventurers,logs);
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
}