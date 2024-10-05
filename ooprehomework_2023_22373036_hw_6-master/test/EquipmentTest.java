import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {
    Equipment ep = new Equipment(1,"e",1,1);
    @Test
    public void getName() {
        String a = ep.getName();
    }

    @Test
    public void getStar() {
        ep.setStar(3);
        int a = ep.getStar();
    }

    @Test
    public void setStar() {
        ep.setStar(3);
        int a = ep.getStar();

    }

    @Test
    public void getValue() {
        long a = ep.getValue();
    }
}