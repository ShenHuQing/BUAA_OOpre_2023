import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

public class adventurerTest {

    @Test
    public void getId() {
        Adventurer adventurer = new Adventurer(123, "adv");
        int id = adventurer.getId();
        assertEquals(id ,123);
    }
    @Test
    public void getName() {
        Adventurer adventurer = new Adventurer(123, "adv");
        String name = adventurer.getName();
        assertEquals(name , "adv");
    }
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
        Food food1 = adventurer.getFoods().put(3, food);
        assertTrue(adventurer.getFoods().containsKey(3));
    }

    @Test
    public void getLevel() {
        Adventurer adventurer = new Adventurer(123, "adv");
        adventurer.setLevel(5);
        int lev = adventurer.getLevel();
        assertEquals(lev , 5);
    }

    @Test
    public void setLevel() {
        Adventurer adventurer = new Adventurer(123, "adv");
        adventurer.setLevel(5);
        int lev = adventurer.getLevel();
        assertEquals(lev,5);
        return ;
    }

    @Test
    public void getHitpoint() {
        Adventurer adventurer = new Adventurer(123, "adv");
        adventurer.setHitpoint(2);
        int Hitpoint = adventurer.getHitpoint();
        assertEquals (Hitpoint,2);
    }

    @Test
    public void setHitpoint() {
        Adventurer adventurer = new Adventurer(123, "adv");
        adventurer.setHitpoint(2);
        int Hitpoint = adventurer.getHitpoint();
        assertEquals(Hitpoint, 2);
    }
}
