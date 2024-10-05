package test;

import org.junit.Test;
import src.Adventurer;

public class AdventurerTest {
    @Test
    public void getId() {
        Adventurer adventurer = new Adventurer(666, "fancy");
        int id = adventurer.getId();
        assert (id == 666);
    }
}