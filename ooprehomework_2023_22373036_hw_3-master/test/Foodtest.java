import org.junit.Test;
import static org.junit.Assert.*;
public class Foodtest {
    @Test
    public void getId() {
        Food food = new Food(123, "FOOD",123);
        int id =food.getId();
        assertEquals(id , 123);
    }
    @Test
    public void getName() {
        Food food = new Food(123, "bot",123);
        String name = food.getName();
        assertEquals(name,"bot");
    }

    @Test
    public void getEnergy() {
        Food food = new Food(123, "FOOD",123);
        int ene = food.getEnergy();
        assertEquals(ene, 123);
    }
    @Test
    public void setEnergy() {
        Food food = new Food(123, "FOOD",123);
        food.setEnergy(100);
        int ene = food.getEnergy();
        assertEquals(ene ,100);
    }

}
