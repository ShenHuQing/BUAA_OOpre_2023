import org.junit.Test;

public class RecoverBottleTest {
    RecoverBottle a = new RecoverBottle(1,"a",1,1);
    @Test
    public void getRatio() {
        a.setRatio(3);
        double b = a.getRatio();
    }

    @Test
    public void setRatio() {
        a.setRatio(3);
        double b = a.getRatio();
    }
}