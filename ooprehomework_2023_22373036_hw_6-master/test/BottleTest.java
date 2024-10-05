import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {
    Bottle bot = new Bottle(4, "E",1,1);
    @Test
    public void getId() {
        int a = bot.getId();
    }

    @Test
    public void getName() {
        String b = bot.getName();
    }

    @Test
    public void getCapacity() {
        bot.setCapacity(1);
        int a = bot.getCapacity();
    }

    @Test
    public void setCapacity() {
        bot.setCapacity(1);
        int a = bot.getCapacity();
    }

    @Test
    public void getValue() {
        long a = bot.getValue();
    }
}