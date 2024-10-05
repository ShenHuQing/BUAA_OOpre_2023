import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShopTest {
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
    @Test
    public void calculateAllBottlePrice() {
        long price = 1;
        allBottlePrice = 0;
        shop.calculateAllBottlePrice(price);
    }

    @Test
    public void getBottleShopPrice() {
        shop.setBottleShopPrice(1L);
        shop.setBottleNum(2);
        shop.setAllBottlePrice(3);
        long a = shop.getBottleShopPrice();
    }

    @Test
    public void calculateAllEquipmentPrice() {
        long price = 1;
        allEquipmentPrice= 0;
        shop.calculateAllEquipmentPrice(price);
    }

    @Test
    public void calculateEquipmentShopPrice() {
        shop.setEquipmentNum(2);
        shop.setAllEquipmentPrice(3);
        long a = shop.calculateEquipmentShopPrice();

    }

    @Test
    public void calculateAllFoodPrice() {
        long price = 1;
        allFoodPrice= 0;
        shop.calculateAllFoodPrice(price);
    }

    @Test
    public void getFoodShopPrice() {
        shop.setFoodShopPrice(1L);
        shop.setFoodNum(2);
        shop.setAllFoodPrice(3);
        long a = shop.getFoodShopPrice();
    }

    @Test
    public void calculateAllBottleCap() {
        int price = 1;
        allBottleCap = 0;
        shop.calculateAllBottleCap(price);
    }

    @Test
    public void getBottleShopCap() {
        shop.setBottleShopCap(1L);
        shop.setBottleNum(2);
        shop.setAllBottleCap(3);
        long a = shop.getBottleShopCap();
    }

    @Test
    public void calculateAllEquipmentCap() {
        int price = 1;
        allEquipmentCap = 0;
        shop.calculateAllEquipmentCap(price);
    }

    @Test
    public void getEquipmentShopCap() {
        shop.setEquipmentShopCap(1L);
        shop.setEquipmentNum(2);
        shop.setAllEquipmentCap(3);
        long a = shop.getEquipmentShopCap();
    }

    @Test
    public void calculateAllFoodCap() {
        int price = 1;
        allFoodCap = 0;
        shop.calculateAllFoodCap(price);
    }

    @Test
    public void getFoodShopCap() {
        shop.setFoodShopCap(1L);
        shop.setFoodNum(2);
        shop.setAllFoodCap(3);
        long a = shop.getFoodShopCap();
    }

    @Test
    public void getAllBottlePrice() {
        shop.setAllBottlePrice(1L);
        shop.getAllBottlePrice();
    }

    @Test
    public void setAllBottlePrice() {
        shop.setAllBottlePrice(1L);
        shop.getAllBottlePrice();
    }

    @Test
    public void getBottleNum() {
        shop.setBottleNum(1);
        shop.getBottleNum();
    }

    @Test
    public void setBottleNum() {
        shop.setBottleNum(1);
        shop.getBottleNum();
    }

    @Test
    public void setBottleShopPrice() {
        shop.setBottleShopPrice(1L);
        shop.getBottleShopPrice();
    }

    @Test
    public void getAllEquipmentPrice() {
        shop.setAllEquipmentPrice(1L);
        shop.getAllEquipmentPrice();
    }

    @Test
    public void setAllEquipmentPrice() {
        shop.setAllEquipmentPrice(1L);
        shop.getAllEquipmentPrice();
    }

    @Test
    public void getEquipmentNum() {
        shop.setBottleNum(1);
        shop.getBottleNum();
    }

    @Test
    public void setEquipmentNum() {
        shop.setBottleNum(1);
        shop.getBottleNum();
    }

    @Test
    public void getEquipmentShopPrice() {
        shop.setEquipmentShopPrice(1L);
        shop.getEquipmentShopPrice();
    }

    @Test
    public void setEquipmentShopPrice() {
    }

    @Test
    public void getAllFoodPrice() {
        shop.setAllFoodPrice(1L);
        shop.getAllFoodPrice();
    }

    @Test
    public void setAllFoodPrice() {
    }

    @Test
    public void getFoodNum() {
        shop.setFoodNum(1);
        shop.getFoodNum();
    }

    @Test
    public void setFoodNum() {
    }

    @Test
    public void setFoodShopPrice() {
        shop.setFoodShopPrice(1);
    }

    @Test
    public void setFoodShopCap() {
        shop.setFoodShopCap(1);
    }

    @Test
    public void setBottleShopCap() {
        shop.setBottleShopCap(1);
    }

    @Test
    public void setEquipmentShopCap() {
        shop.setEquipmentShopCap(1);
    }

    @Test
    public void getAllFoodCap() {
        shop.setAllFoodCap(1);
        shop.getAllFoodCap();
    }

    @Test
    public void setAllFoodCap() {
    }

    @Test
    public void getAllBottleCap() {
        shop.setAllBottleCap(1);
        shop.getAllBottleCap();
    }

    @Test
    public void setAllBottleCap() {
    }

    @Test
    public void getAllEquipmentCap() {
        shop.setAllEquipmentCap(1);
        shop.getAllEquipmentCap();
    }

    @Test
    public void setAllEquipmentCap() {
    }
}