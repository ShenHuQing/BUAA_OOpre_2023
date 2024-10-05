import org.junit.Test;

public class ReinforcedBottleTest {
    ReinforcedBottle A = new ReinforcedBottle(1,"a",1,1);
    @Test
    public void getRatio() {
        A.setRatio(3);
        double b = A.getRatio();
    }

    @Test
    public void setRatio() {
        A.setRatio(3);
        double b = A.getRatio();
    }
}