import org.junit.Test;

public class AdventurerTest {
    Adventurer adv = new Adventurer(1,"name");
    @Test
    public void getEmployees() {
        Adventurer employee = new Adventurer(2,"emp");
        adv.getEmployees().put(2,employee);
    }

    @Test
    public void getId() {
        int a = adv.getId();
    }

    @Test
    public void getName() {
        String b = adv.getName();
    }

    @Test
    public void getBottles() {
        Bottle bottle = new Bottle(3,"bo",1,1);
        adv.getBottles().put(3,bottle);
    }

    @Test
    public void getEquipments() {
        Equipment equipment = new Equipment(4,"EQ",1,1);
        adv.getEquipments().put(4,equipment);
    }

    @Test
    public void getFoods() {
        Food food = new Food(5,"FO",1,1);
        adv.getFoods().put(5,food);
    }

    @Test
    public void getLevel() {
        adv.setLevel(1);
        int b = adv.getLevel();
    }

    @Test
    public void setLevel() {
        adv.setLevel(1);
        int b = adv.getLevel();
    }

    @Test
    public void getHitpoint() {
        adv.setHitpoint(1);
        int a = adv.getHitpoint();
    }

    @Test
    public void setHitpoint() {
        adv.setHitpoint(1);
        int a = adv.getHitpoint();
    }

    @Test
    public void getBag() {
        Bag bag = new Bag();
        Bag a = adv.getBag();
    }

    @Test
    public void deleteEquipValue() {
        Equipment equipment = new Equipment(555,"NM",1,1);
        adv.getEquipments().put(55,equipment);
        adv.deleteEquipValue(equipment);
        long a = adv.getValue();
    }

    @Test
    public void setHireValue() {
        adv.setHireValue(1);
    }

    @Test
    public void getValueCount() {
        adv.setValueCount(1);
        int a = adv.getValueCount();
    }

    @Test
    public void setValueCount() {
        adv.setValueCount(1);
        int a = adv.getValueCount();
    }

    @Test
    public void deleteBottleValue() {
        Bottle bottle = new Bottle(1,"a",1,1);
        adv.getBottles().put(1,bottle);
        adv.deleteBottleValue(bottle);
        long a = adv.getValue();
    }

    @Test
    public void deleteFoodValue() {
        Food food = new Food(1,"a",1,1);
        adv.getFoods().put(1,food );
        adv.deleteFoodValue(food);
        long a = adv.getValue();
    }

    @Test
    public void enhanceHireValue() {
        Adventurer adventurer = new Adventurer(2 ,"NN");
        adv.enhanceHireValue(adventurer);
    }

    @Test
    public void enhanceEquipValue() {
        Equipment equipment = new Equipment(3,"F",1,1);
        adv.enhanceEquipValue(equipment);
    }

    @Test
    public void enhanceBottleValue() {
        Bottle bottle = new Bottle(4, "E",1,1);
        adv.enhanceBottleValue(bottle);
    }

    @Test
    public void enhanceFoodValue() {
        Food food = new Food(4,"6",1,1);
        adv.enhanceFoodValue(food);
    }

    @Test
    public void getValue() {
        long a = adv.getValue();
    }
}