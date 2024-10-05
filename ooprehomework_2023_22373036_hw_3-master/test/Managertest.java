import java.util.HashMap;
import org.junit.Assert;

public class Managertest {
    public void addAdventurer(int i, String alice, HashMap<Integer, Adventurer> adventurers) {
        int advId = 1;
        String name = "Alice";
        HashMap<Integer, Adventurer> adventurerss = new HashMap<>();
        addAdventurer(1,"Alice", adventurerss);
        Assert.assertTrue(adventurers.containsKey(advId));
        Adventurer addedAdventurer = adventurers.get(advId);
        Assert.assertEquals(name, addedAdventurer.getName());
    }
    public void addBottle(int advId, int botId, String name, int capacity, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = (Adventurer)adventurers.get(advId);
        Bottle bottle = new Bottle(1,"abc", 12);
        adventurer.getBottles().put(1, bottle);
        assert (adventurer.getBottles().containsKey(1));
    }

    public void addEquipment(int advId, int equId, String name, int star, HashMap<Integer, Adventurer> adventurers) {
        Adventurer adventurer = (Adventurer)adventurers.get(advId);
        Equipment equipment = new Equipment(1,"abc", 12);
        adventurer.getEquipments().put(1,equipment);
        assert (adventurer.getEquipments().containsKey(1));
    }


}
