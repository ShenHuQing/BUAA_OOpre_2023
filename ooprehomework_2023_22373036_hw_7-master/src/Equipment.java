import java.util.HashMap;
import java.util.Objects;

public class Equipment implements Commodity {
    private int id;
    private String name;
    private int star;
    private long price;

    public Equipment(int id, String name, int star, long price) {
        this.id = id;
        this.name = name;
        this.star = star;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    @Override
    public long getValue() {
        return price;
    }

    public static void addImRegularEquipment(int advId, int equId, String name,
                                             int star, long price, String type, double others,
                                             HashMap<Integer, Adventurer> adventurers) {
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

    public static void addRegularEquipment(int advId, int equId, String name, int star, long price,
                                           String type, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        RegularEquipment equipment = new RegularEquipment(equId, name, star, price);
        adventurer.getEquipments().put(equId, equipment);
        adventurer.enhanceEquipValue(equipment);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount + 1);
    }

    public static void removeEquipment(int advId, int equId, HashMap<Integer,
            Adventurer> adventurers, Shop shop) {
        Adventurer adventurer = adventurers.get(advId);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount - 1);
        //价值体-1
        Equipment equipment = adventurer.getEquipments().get(equId);
        adventurer.deleteEquipValue(equipment);
        //装备价值-
        String equName = equipment.getName();
        adventurer.getEquipments().remove(equId);
        //移除装备
        System.out.println(adventurer.getEquipments().size() + " " + equName);
        shop.calculateAllEquipmentPrice(equipment.getValue());
        shop.calculateAllEquipmentCap(equipment.getStar());
        //商店获得价值
        shop.setEquipmentNum(shop.getEquipmentNum() + 1);
        adventurer.setMoney(adventurer.getMoney() + equipment.getValue());
        //加钱
        if (adventurer.getBag().getEquipments().get(equId) != null && adventurer.getBag() != null
                && adventurer.getBag().getEquipments() != null) {
            adventurer.getBag().getEquipments().remove(equId);
        }
    }

    public static void saleRemoveEquipment(int advId, int equId, HashMap<Integer,
            Adventurer> adventurers, Shop shop) {
        Adventurer adventurer = adventurers.get(advId);
        int valueCount = adventurer.getValueCount();
        adventurer.setValueCount(valueCount - 1);
        //价值体-1
        Equipment equipment = adventurer.getEquipments().get(equId);
        adventurer.deleteEquipValue(equipment);
        //装备价值-
        String equName = equipment.getName();
        adventurer.getEquipments().remove(equId);
        //移除装备
        shop.calculateAllEquipmentPrice(equipment.getValue());
        shop.calculateAllEquipmentCap(equipment.getStar());
        //商店获得价值
        shop.setEquipmentNum(shop.getEquipmentNum() + 1);
        adventurer.setMoney(adventurer.getMoney() + equipment.getValue());
        //加钱
        if (adventurer.getBag().getEquipments().get(equId) != null && adventurer.getBag() != null
                && adventurer.getBag().getEquipments() != null) {
            adventurer.getBag().getEquipments().remove(equId);
        }
    }

    public static void enhanceEquipmentStar(int advId, int equId, HashMap<Integer,
            Adventurer> adventurers) {
        Adventurer adventurer = adventurers.get(advId);
        Equipment equipment = adventurer.getEquipments().get(equId);
        equipment.setStar(equipment.getStar() + 1);
        System.out.println(equipment.getName() + " " + equipment.getStar());
    }
}

