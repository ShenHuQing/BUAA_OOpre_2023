import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);
        String[] fightername =  {"fighter", "loser"};
        Bottle bottle = new Bottle(3,"22",2,2);
        fighte.getBag().getBottles().put(3,bottle);
        fighte.getBottles().put(3,bottle);
        String p1 = "(\\d{4})/(1[0-2]|0[1-9])-([^@\\-#\\s]{1,40}?)-([^@\\-#\\s]{1,40})";
        Pattern pattern1 = Pattern.compile(p1);
        Matcher matcher1 = pattern1.matcher("2023/10-fighter-22");
        if(matcher1.find()) {
            Log.match1(matcher1,manager,adventurers,logs,fightername);
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
        String[] fightername =  {"fighter", "loser"};
        Equipment.addImRegularEquipment(1,55,"equip",1,1,"CritEquipment",1,adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern2 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
        Matcher matcher2 = pattern2.matcher("2022/09-fighter@loser-equip");
        if(matcher2.find()){
            Log.match2(matcher2,manager,adventurers,logs,fightername);
        }
        Pattern pattern21 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
        Matcher matcher21 = pattern21.matcher("2022/09-fighter@loser-equiper");
        if(matcher21.find()){
            Log.match2(matcher21,manager,adventurers,logs,fightername);
        }
        Pattern pattern221 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
        Matcher matcher221 = pattern221.matcher("2022/09-fightr@loser-equiper");
        if(matcher221.find()){
            Log.match2(matcher221,manager,adventurers,logs,fightername);
        }

    }
    @Test
    public void mat3ch2() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);
        String[] fightername =  {"fighter", "loser"};
        Equipment.addImRegularEquipment(1,55,"equip",1,1,"EpicEquipment",1,adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern2 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
        Matcher matcher2 = pattern2.matcher("2022/09-fighter@loser-equip");
        if(matcher2.find()){
            Log.match2(matcher2,manager,adventurers,logs,fightername);
        }
        Pattern pattern21 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
        Matcher matcher21 = pattern21.matcher("2022/09-fighter@loser-equiper");
        if(matcher21.find()){
            Log.match2(matcher21,manager,adventurers,logs,fightername);
        }
        Pattern pattern221 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
        Matcher matcher221 = pattern221.matcher("2022/09-fightr@loser-equiper");
        if(matcher221.find()){
            Log.match2(matcher221,manager,adventurers,logs,fightername);
        }

    }
    @Test
    public void match2epu() {
        Manager manager = new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer, Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1, "fighter");
        adventurers.put(1, fighte);
        Adventurer lose = new Adventurer(2, "loser");
        adventurers.put(2, lose);
        String[] fightername = {"fighter", "loser"};
        Equipment.addRegularEquipment(1, 55, "equip", 1, 1, "RegularEquipment", adventurers);
        manager.carryEquipment(1, 55, adventurers);
        Pattern pattern2 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "(.{1,40}?)@(.{1,40}?)-([^@\\-#\\s]{1,40})");
        Matcher matcher2 = pattern2.matcher("2022/09-fighter@loser-equip");
        if (matcher2.find()) {
            Log.match2(matcher2, manager, adventurers, logs, fightername);
        }
    }
    @Test
    public void match3() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);
        String[] fightername =  {"fighter", "loser"};
        Equipment.addImRegularEquipment(1,55,"equip",1,1,"CritEquipment",1,adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern3 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "([^@\\-#\\s]{1,40}?)@#-([^@\\-#\\s]{1,40})");
        Matcher matcher3 = pattern3.matcher("2022/09-fighter@#-equip");
        if(matcher3.find()){
            Log.match3(matcher3,manager,adventurers,logs,fightername,2);
        }

    }
    @Test
    public void match32() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);
        String[] fightername =  {"fighter", "loser"};
        Equipment.addImRegularEquipment(1,55,"equip",1,1,"CritEquipment",1,adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern3 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "([^@\\-#\\s]{1,40}?)@#-([^@\\-#\\s]{1,40})");
        Matcher matcher3 = pattern3.matcher("2022/09-fighter@#-equiper");
        if(matcher3.find()){
            Log.match3(matcher3,manager,adventurers,logs,fightername,2);
        }

    }

    @Test
    public void match312() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);
        String[] fightername =  {"fighter", "loser"};
        Equipment.addRegularEquipment(1,55,"equip",1,1,"RegularEquipment",adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern3 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "([^@\\-#\\s]{1,40}?)@#-([^@\\-#\\s]{1,40})");
        Matcher matcher3 = pattern3.matcher("2022/09-fighter@#-equiper");
        if(matcher3.find()){
            Log.match3(matcher3,manager,adventurers,logs,fightername,2);
        }

    }
    @Test
    public void matbch312() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);
        String[] fightername =  {"fighter", "loser"};
        Equipment.addRegularEquipment(1,55,"equip",1,1,"RegularEquipment",adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern3 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "([^@\\-#\\s]{1,40}?)@#-([^@\\-#\\s]{1,40})");
        Matcher matcher3 = pattern3.matcher("2022/09-fighter@#-equip");
        if(matcher3.find()){
            Log.match3(matcher3,manager,adventurers,logs,fightername,2);
        }

    }
    @Test
    public void match3112() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);
        String[] fightername =  {"fighter", "loser"};
        Equipment.addImRegularEquipment(1,55,"equip",1,1,"EpicEquipment",1,adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern3 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "([^@\\-#\\s]{1,40}?)@#-([^@\\-#\\s]{1,40})");
        Matcher matcher3 = pattern3.matcher("2022/09-fighter@#-equip");
        if(matcher3.find()){
            Log.match3(matcher3,manager,adventurers,logs,fightername,2);
        }

    }

    @Test
    public void match31b112() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);
        String[] fightername =  {"fighter", "loser"};
        Equipment.addImRegularEquipment(1,55,"equip",1,1,"EpicEquipment",1,adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern3 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "([^@\\-#\\s]{1,40}?)@#-([^@\\-#\\s]{1,40})");
        Matcher matcher3 = pattern3.matcher("2022/09-fighter@#-equipe");
        if(matcher3.find()){
            Log.match3(matcher3,manager,adventurers,logs,fightername,2);
        }

    }
    @Test
    public void match33() {
        Manager manager=new Manager();
        ArrayList<Log> logs = new ArrayList<>();
        Bag bag = new Bag();
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        Adventurer fighte = new Adventurer(1,"fighter");
        adventurers.put(1,fighte);
        Adventurer lose = new Adventurer(2,"loser");
        adventurers.put(2,lose);
        String[] fightername =  {"fighter", "lose"};
        Equipment.addImRegularEquipment(1,55,"equip",1,1,"CritEquipment",1,adventurers);
        manager.carryEquipment(1,55,adventurers);
        Pattern pattern3 = Pattern.compile("((\\d{4})/(\\d{2}))-" +
                "([^@\\-#\\s]{1,40}?)@#-([^@\\-#\\s]{1,40})");
        Matcher matcher3 = pattern3.matcher("2022/09-fighter@#-equiper");
        if(matcher3.find()){
            Log.match3(matcher3,manager,adventurers,logs,fightername,2);
        }

    }
}