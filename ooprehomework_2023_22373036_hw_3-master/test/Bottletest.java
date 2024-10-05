import org.junit.Test;
import static org.junit.Assert.*;
public class Bottletest {
    @Test
    public void getId() {
        Bottle bottle = new Bottle(123, "bot",123);
        int id = bottle.getId();
        assertEquals(id,123);
    }
    @Test
    public void getName() {
        Bottle bottle = new Bottle(123, "bot",123);
        String name = bottle.getName();
        assertEquals(name, "bot");
    }

    @Test
    public void getCapacity() {
        Bottle bottle = new Bottle(123, "bot",123);
        int cap = bottle.getCapacity();
        assertEquals(cap ,123);
    }
}
