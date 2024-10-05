import java.util.HashMap;
import static org.junit.Assert.*;
import org.junit.Test;
public class Bagtest {
    @Test
    public void getBottles() {
        Adventurer adventurer = new Adventurer(123, "adv");
        Bottle bottle = new Bottle(1,"bot",1);
        adventurer.getBottles().put(1,bottle);
        assertTrue(adventurer.getBottles().containsKey(1));
    }
    @Test
    public void getEquipments() {
        Adventurer adventurer = new Adventurer(123, "adv");
        Equipment equipment = new Equipment(2,"bot",2);
        adventurer.getEquipments().put(2,equipment);
        assertTrue(adventurer.getEquipments().containsKey(2));
    }
    @Test
    public void getFoods() {
        Adventurer adventurer = new Adventurer(123, "adv");
        Food food = new Food(3,"food",3);
        adventurer.getFoods().put(3,food);
        assertTrue(adventurer.getFoods().containsKey(3));
    }

}