import org.junit.Test;

public class CritEquipmentTest {
    CritEquipment a = new CritEquipment(1,"a",1,1);
    @Test
    public void getCritical() {
        a.setCritical(1);
        double b = a.getCritical();

    }

    @Test
    public void setCritical() {
        a.setCritical(1);
        double b = a.getCritical();
    }
}