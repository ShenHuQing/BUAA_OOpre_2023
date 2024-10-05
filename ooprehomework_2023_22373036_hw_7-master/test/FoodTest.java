import org.junit.Test;

public class FoodTest {
    Food food = new Food(1,"s",1,1);
    @Test
    public void getId() {
        int a = food.getId();
    }

    @Test
    public void getEnergy() {
        food.setEnergy(3);
        int a = food.getEnergy();
    }

    @Test
    public void setEnergy() {
        food.setEnergy(3);
        int a = food.getEnergy();
    }

    @Test
    public void getName() {
        String a = food.getName();
    }

    @Test
    public void getValue() {
        double a = food.getValue();
    }
}