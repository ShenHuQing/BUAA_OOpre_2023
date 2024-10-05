import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Adventurer> adventurers = new HashMap<>();
        ArrayList<Log> logs = new ArrayList<>();
        Manager manager = new Manager();
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>(); // 解析后的输入将会存进该容器中, 类似于c语言的二维数组
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim()); // 读取行数
        for (int i = 0; i < n; ++i) {
            String nextLine = scanner.nextLine(); // 读取本行指令
            String[] strings = nextLine.trim().split(" +"); // 按空格对行进行分割
            inputInfo.add(new ArrayList<>(Arrays.asList(strings))); // 将指令分割后的各个部分存进容器中
            int type = Integer.parseInt(inputInfo.get(i).get(0));
            ArrayList<String> tmp = inputInfo.get(i);
            if (type == 1) {
                manager.addAdventurer(Integer.parseInt(tmp.get(1)), tmp.get(2), adventurers);
            } else if (type == 2) {
                manager.addBottle(Integer.parseInt(tmp.get(1)), Integer.parseInt(tmp.get(2)),
                        tmp.get(3), Integer.parseInt(tmp.get(4)), adventurers);
            } else if (type == 3) {
                manager.removeBottle(Integer.parseInt(tmp.get(1)),
                        Integer.parseInt(tmp.get(2)), adventurers);
            } else if (type == 4) {
                manager.addEquipment(Integer.parseInt(tmp.get(1)), Integer.parseInt(tmp.get(2)),
                        tmp.get(3), Integer.parseInt(tmp.get(4)), adventurers);
            } else if (type == 5) {
                manager.removeEquipment(Integer.parseInt(tmp.get(1)),
                        Integer.parseInt(tmp.get(2)), adventurers);
            } else if (type == 6) {
                manager.enhanceEquipmentStar(Integer.parseInt(tmp.get(1)),
                        Integer.parseInt(tmp.get(2)), adventurers);
            } else if (type == 7) {
                manager.addFood(Integer.parseInt(tmp.get(1)), Integer.parseInt(tmp.get(2)),
                        tmp.get(3), Integer.parseInt(tmp.get(4)), adventurers);
            } else if (type == 8) {
                manager.removeFood(Integer.parseInt(tmp.get(1)),
                        Integer.parseInt(tmp.get(2)), adventurers);
            } else if (type == 9) {
                manager.carryEquipment(Integer.parseInt(tmp.get(1)),
                        Integer.parseInt(tmp.get(2)), adventurers);
            } else if (type == 10) {
                manager.carryBottle(Integer.parseInt(tmp.get(1)),
                        Integer.parseInt(tmp.get(2)), adventurers);
            } else if (type == 11) {
                manager.carryFood(Integer.parseInt(tmp.get(1)),
                        Integer.parseInt(tmp.get(2)), adventurers);
            } else if (type == 12) {
                manager.useBottle(Integer.parseInt(tmp.get(1)), tmp.get(2), adventurers);
            } else if (type == 13) {
                manager.useFood(Integer.parseInt(tmp.get(1)), tmp.get(2), adventurers);
            } else if (type == 14) {
                manager.type14(tmp,scanner,manager,adventurers,logs);
            } else if (type == 15) {
                manager.outDate(logs,tmp.get(1));
            } else if (type == 16) {
                manager.outFighter(logs,Integer.parseInt(tmp.get(1)));
            } else if (type == 17) {
                manager.outLoser(logs,Integer.parseInt(tmp.get(1)));
            }
        }
    }
}
