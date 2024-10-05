import org.junit.Test;
import static org.junit.Assert.*;
public class Equipmenttset{
        @Test
        public void getName() {
            Equipment equip = new Equipment(123, "eqq",123);
            String name = equip.getName();
            assertEquals(name ,"eqq");
        }

        @Test
        public void getStar() {
            Equipment equip = new Equipment(123, "eqq",123);
            int cap = equip.getStar();
            assertEquals(cap,123);
        }
}
