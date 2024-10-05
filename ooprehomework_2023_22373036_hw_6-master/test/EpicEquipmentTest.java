import org.junit.Test;

import static org.junit.Assert.*;

public class EpicEquipmentTest {
    EpicEquipment b = new EpicEquipment(1,"a",1,1);
    @Test
    public void getRatio() {
        b.setRatio(1);
        double c = b.getRatio();
    }

    @Test
    public void setRatio() {
        b.setRatio(1);
        double c = b.getRatio();
    }
}