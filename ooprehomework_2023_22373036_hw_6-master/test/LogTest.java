import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class LogTest {
    Pattern pattern1 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
            "([^@\\-#\\s]{1,40}?)-([^@\\-#\\s]{1,40})");
    Matcher matcher1 = pattern1.matcher("2022/09-adv-bot");
    Pattern pattern2 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
            "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
    Matcher matcher2 = pattern2.matcher("2022/09-advName2@-equName");
    Pattern pattern3 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
            "([^@\\-#\\s]{1,40}?)@#-([^@\\-#\\s]{1,40})");
    Matcher matcher3 = pattern3.matcher("2022/09-advName2@#-equName");

    @Test
    public void getDate() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            String date = log1.getDate();
        }
       else System.out.println("1");
    }

    @Test
    public void setDate() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setDate("2021/09");
            String date = log1.getDate();
        }
    }

    @Test
    public void getFighterID() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            int ID = log1.getFighterID();
        }
    }

    @Test
    public void setFighterID() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setFighterID(2);
            int ID = log1.getFighterID();
        }
    }

    @Test
    public void getLoserID() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setLoserID(2);
            int ID = log1.getLoserID();
        }
    }

    @Test
    public void setLoserID() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setLoserID(2);
            int ID = log1.getLoserID();
        }
    }

    @Test
    public void getLoserName() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setLoserName("2");
            String ID = log1.getLoserName();
        }
    }

    @Test
    public void setLoserName() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setLoserName("2");
            String ID = log1.getLoserName();
        }
    }

    @Test
    public void getLsID() {
        if(matcher1.find()) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(2);
            Log log1= new Log(matcher1,1);
            log1.setLsID(a);
            int b = log1.getLsID().get(0);
        }
    }

    @Test
    public void setLsID() {
        if(matcher1.find()) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(2);
            Log log1= new Log(matcher1,1);
            log1.setLsID(a);
        }
    }

    @Test
    public void getBottleName() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setBottleName("2");
            String ID = log1.getBottleName();
        }
    }

    @Test
    public void setBottleName() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setBottleName("2");
            String ID = log1.getBottleName();
        }
    }

    @Test
    public void getFighterName() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setFighterName("2");
            String ID = log1.getFighterName();
        }
    }

    @Test
    public void setFighterName() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setFighterName("2");
            String ID = log1.getFighterName();
        }
    }

    @Test
    public void getLsName() {
        if(matcher1.find()) {
            ArrayList<String> a = new ArrayList<>();
            a.add("2");
            Log log1= new Log(matcher1,1);
            log1.setLsName(a);
            String b = log1.getLsName().get(0);
        }
    }

    @Test
    public void setLsName() {
        if(matcher1.find()) {
            ArrayList<String> a = new ArrayList<>();
            a.add("2");
            Log log1= new Log(matcher1,1);
            log1.setLsName(a);
            String b = log1.getLsName().get(0);
        }
    }

    @Test
    public void getEquName() {
        if(matcher3.find()) {
            Log log3= new Log(matcher3,3);
            String A = log3.getEquName();
        }
    }

    @Test
    public void setEquName() {
        if(matcher3.find()) {
            Log log3= new Log(matcher3,3);
            log3.setEquName("b");
            String A = log3.getEquName();
        }
    }

    @Test
    public void getUserName() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setUserName("2");
            String ID = log1.getUserName();
        }

    }

    @Test
    public void setUserName() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setUserName("2");
            String ID = log1.getUserName();
        }
    }

    @Test
    public void getUserID() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setUserID(2);
            int ID = log1.getUserID();
        }
    }

    @Test
    public void setUserID() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setUserID(2);
            int ID = log1.getUserID();
        }
    }

    @Test
    public void getFunc() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setFunc(1);
            int ID = log1.getFunc();
        }
    }

    @Test
    public void setFunc() {
        if(matcher1.find()) {
            Log log1= new Log(matcher1,1);
            log1.setFunc(1);
            int ID = log1.getFunc();
        }
    }

    @Test
    public void match1() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer a = new Adventurer(1,"AA");
        adventurers.put(1,a);
        Bottle bottle = new Bottle(3,"22",2,2);
        a.getBag().getBottles().put(3,bottle);
        String p1 = "(\\d{4})/(1[0-2]|0[1-9])-([^@\\-#\\s]{1,40}?)-([^@\\-#\\s]{1,40})";
        Pattern pattern1 = Pattern.compile(p1);
        Matcher matcher1 = pattern1.matcher("2023/10-AA-22");
        matcher1.find();
        boolean c = adventurers.containsKey(1);
        if (c) {
            Adventurer adventurer = adventurers.get(1);
            if ((adventurer != null && adventurer.getBag() != null
                    && adventurer.getBag().getBottles() != null)) {
                HashMap<Integer, Bottle> advbottle = adventurer.getBag().getBottles();
                int b = Main.findMinbotlleKey(advbottle,"22");
                if (b != -1) {
                    manager.useBottle(1, "22", adventurers);
                    if(matcher1.find()){
                        Log log = new Log(matcher1,1);
                        log.setUserID(1);
                        logs.add(log);
                    }

                }
                else {
                    System.out.println("Fight log error1");
                }
            }
            else {
                System.out.println("Fight log error2");
            }
        }
        else {
            System.out.println("Fight log error3");
        }
    }

    @Test
    public void match2() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);

        manager.addImRegularEquipment(1,55,"equip",1,1,"CritEquipment",1,adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern2 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
        Matcher matcher2 = pattern2.matcher("2022/09-fighter@loser-equip");
        boolean a = true;
        boolean c = true;
        if (a && c) {
            int advID1 = Main.findadvID(adventurers, "fighter");
            int advID2 = Main.findadvID(adventurers, "loser");
            Adventurer fighter = adventurers.get(advID1);
            Adventurer loser = adventurers.get(advID2);
            HashMap<Integer, Equipment> advEquip = fighter.getBag().getEquipments();
            int b = Main.findequipID(advEquip, "equip");
            if (b != -1) {
                int equipLevel = advEquip.get(b).getStar();
                Equipment equipment = advEquip.get(b);
                int advLevel = fighter.getLevel();
                int hitPoint = 0;
                if (equipment instanceof RegularEquipment) {
                    hitPoint = equipLevel * advLevel;
                }
                else if (equipment instanceof EpicEquipment) {
                    hitPoint = (int)(loser.getHitpoint() * ((EpicEquipment) equipment).getRatio());
                }
                else if (equipment instanceof CritEquipment) {
                    int crit = (int)(((CritEquipment) equipment).getCritical());
                    hitPoint = equipLevel * advLevel + crit;
                }
                loser.setHitpoint(loser.getHitpoint() - hitPoint);
                System.out.println(loser.getId() + " " + loser.getHitpoint());
                if(matcher2.find()){
                    Log log = new Log(matcher2,2);
                    log.setFighterID(advID1);
                    log.setLoserID(advID2);
                    logs.add(log);
                }

            } else {
                System.out.println("Fight log error");
            }
        } else {
            System.out.println("Fight log error");
        }
    }

    @Test
    public void match3() {
    }
}