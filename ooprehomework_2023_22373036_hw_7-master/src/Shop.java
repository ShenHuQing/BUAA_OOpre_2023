import java.util.ArrayList;

public class Shop {
    private static Shop shop = new Shop();

    private static ArrayList<Bottle> bottleShop = new ArrayList<>();
    private static ArrayList<Equipment> equipmentShop = new ArrayList<>();
    private static ArrayList<Food> foodShop = new ArrayList<>();
    private long allBottlePrice = 0;
    private int bottleNum = 0;
    private long bottleShopPrice = 0;
    private long allEquipmentPrice = 0;
    private int equipmentNum = 0;
    private long equipmentShopPrice = 0;
    private long allFoodPrice = 0;
    private int foodNum = 0;
    private long foodShopPrice = 0;
    private long foodShopCap = 0;
    private long bottleShopCap = 0;
    private long equipmentShopCap = 0;
    private long allFoodCap = 0;
    private long allBottleCap = 0;
    private long allEquipmentCap = 0;

    public void  calculateAllBottlePrice(long price) {
        allBottlePrice += price;
    }

    public long getBottleShopPrice() {
        bottleShopPrice = allBottlePrice / bottleNum;
        return bottleShopPrice;
    }

    public void calculateAllEquipmentPrice(long price) {
        allEquipmentPrice += price;
    }

    public long calculateEquipmentShopPrice() {
        equipmentShopPrice = allEquipmentPrice / equipmentNum;
        return equipmentShopPrice;
    }

    public void calculateAllFoodPrice(long price) {
        allFoodPrice += price;
    }

    public long getFoodShopPrice() {
        foodShopPrice = allFoodPrice / foodNum;
        return foodShopPrice;
    }

    public void calculateAllBottleCap(int cap) {
        allBottleCap += cap;
    }

    public long getBottleShopCap() {
        bottleShopCap = allBottleCap / bottleNum;
        return bottleShopCap;
    }

    public void calculateAllEquipmentCap(int cap) {
        allEquipmentCap += cap;
    }

    public long getEquipmentShopCap() {
        equipmentShopCap = allEquipmentCap / equipmentNum;
        return equipmentShopCap;
    }

    public void calculateAllFoodCap(int cap) {
        allFoodCap += cap;
    }

    public long getFoodShopCap() {
        foodShopCap = allFoodCap / foodNum;
        return foodShopCap;
    }

    public long getAllBottlePrice() {

        return allBottlePrice;
    }

    public void setAllBottlePrice(long bottlePrice) {
        allBottlePrice = bottlePrice;
    }

    public int getBottleNum() {

        return bottleNum;
    }

    public void setBottleNum(int bottleNum) {

        this.bottleNum = bottleNum;
    }

    public void setBottleShopPrice(long bottleShopPrice) {

        this.bottleShopPrice = bottleShopPrice;
    }

    public long getAllEquipmentPrice() {

        return allEquipmentPrice;
    }

    public void setAllEquipmentPrice(long equipmentPrice) {
        allEquipmentPrice = equipmentPrice;
    }

    public int getEquipmentNum() {

        return equipmentNum;
    }

    public void setEquipmentNum(int equipmentNum) {

        this.equipmentNum = equipmentNum;
    }

    public long getEquipmentShopPrice() {

        return equipmentShopPrice;
    }

    public void setEquipmentShopPrice(long equipmentShopPrice) {

        this.equipmentShopPrice = equipmentShopPrice;
    }

    public long getAllFoodPrice() {

        return allFoodPrice;
    }

    public void setAllFoodPrice(long foodPrice) {
        allFoodPrice = foodPrice;
    }

    public int getFoodNum() {

        return foodNum;
    }

    public void setFoodNum(int foodNum) {

        this.foodNum = foodNum;
    }

    public void setFoodShopPrice(long foodShopPrice) {

        this.foodShopPrice = foodShopPrice;
    }

    public void setFoodShopCap(long foodShopCap) {

        this.foodShopCap = foodShopCap;
    }

    public void setBottleShopCap(long bottleShopCap) {

        this.bottleShopCap = bottleShopCap;
    }

    public void setEquipmentShopCap(long equipmentShopCap) {

        this.equipmentShopCap = equipmentShopCap;
    }

    public long getAllFoodCap() {

        return allFoodCap;
    }

    public void setAllFoodCap(long foodCap) {
        allFoodCap = foodCap;
    }

    public long getAllBottleCap() {

        return allBottleCap;
    }

    public void setAllBottleCap(long bottleCap) {
        allBottleCap = bottleCap;
    }

    public long getAllEquipmentCap() {

        return allEquipmentCap;
    }

    public void setAllEquipmentCap(long equipmentCap) {

        allEquipmentCap = equipmentCap;
    }
}
