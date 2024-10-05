import org.junit.Test;

import static org.junit.Assert.*;

public class RegularBottleTest {
    Bottle a = new Bottle(1,"a",1,1);
    @Test
    public void getName() {
        String s = a.getName();
    }

}