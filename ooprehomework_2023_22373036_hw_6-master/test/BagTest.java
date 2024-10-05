import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {
    Adventurer adv = new Adventurer(55555,"aaa");
    Bag bag = new Bag();
    @Test
    public void getBottles() {
        Bottle bottle = new Bottle(4, "E",1,1);
        adv.getBag().getBottles().put(4,bottle);
    }

    @Test
    public void getEquipments() {
        Equipment equipment = new Equipment(4, "E",1,1);
        adv.getBag().getEquipments().put(4,equipment);
    }

    @Test
    public void getFoods() {
        Food food = new Food(4, "E",1,1);
        adv.getBag().getFoods().put(4,food);
    }



}