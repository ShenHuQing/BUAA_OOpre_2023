import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;

public class Log {
    private String date;
    private int fighterID;
    private int loserID;
    private String loserName;
    private ArrayList<Integer> lsID;
    private String bottleName;
    private String fighterName;
    private ArrayList<String> lsName;
    private String equName;
    private  String userName;
    private  int userID;
    private int func;
    private ArrayList<Log> logs;

    public Log(Matcher matcher,int function) {
        if (function == 1) {
            this.date = matcher.group(1);
            this.userName = matcher.group(4);
            this.bottleName = matcher.group(5);
            this.func = 1;
        } else if (function == 2) {
            this.date = matcher.group(1);
            this.fighterName = matcher.group(4);
            this.loserName = matcher.group(5);
            this.equName = matcher.group(6);
            this.func = 2;
        } else if (function == 3) {
            this.date = matcher.group(1);
            this.fighterName = matcher.group(4);
            this.equName = matcher.group(5);
            ArrayList<Integer> lsID = new ArrayList<>();
            this.lsID = lsID;
            ArrayList<String> lsName = new ArrayList<>();
            this.lsName = lsName;
            this.func = 3;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFighterID() {
        return fighterID;
    }

    public void setFighterID(int fighterID) {
        this.fighterID = fighterID;
    }

    public int getLoserID() {
        return loserID;
    }

    public void setLoserID(int loserID) {
        this.loserID = loserID;
    }

    public String getLoserName() {
        return loserName;
    }

    public void setLoserName(String loserName) {
        this.loserName = loserName;
    }

    public ArrayList<Integer> getLsID() {
        return lsID;
    }

    public void setLsID(ArrayList<Integer> lsID) {
        this.lsID = lsID;
    }

    public String getBottleName() {
        return bottleName;
    }

    public void setBottleName(String bottleName) {
        this.bottleName = bottleName;
    }

    public String getFighterName() {
        return fighterName;
    }

    public void setFighterName(String fighterName) {
        this.fighterName = fighterName;
    }

    public ArrayList<String> getLsName() {
        return lsName;
    }

    public void setLsName(ArrayList<String> lsName) {
        this.lsName = lsName;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getFunc() {
        return func;
    }

    public void setFunc(int func) {
        this.func = func;
    }

    public static void match1(Matcher matcher1, Manager manager, HashMap<Integer,
            Adventurer> adventurers, ArrayList<Log> logs, String[] fightname) {
        boolean a = Arrays.asList(fightname).contains(matcher1.group(4));
        if (a) {
            int advID = Main.findadvID(adventurers,matcher1.group(4));
            Adventurer adventurer = adventurers.get(advID);
            if ((adventurer != null && adventurer.getBag() != null
                    && adventurer.getBag().getBottles() != null)) {
                HashMap<Integer, Bottle> advbottle = adventurer.getBag().getBottles();
                int b = Main.findMinbotlleKey(advbottle, matcher1.group(5));
                if (b != -1) {
                    int change = manager.useBottle(advID, matcher1.group(5), adventurers);
                    Log log = new Log(matcher1,1);
                    log.setUserID(advID);
                    logs.add(log);
                    adventurer.setChangeHit(adventurer.getChangeHit() + change);
                }
                else {
                    System.out.println("Fight log error");
                }
            }
            else {
                System.out.println("Fight log error");
            }
        }
        else {
            System.out.println("Fight log error");
        }
    }

    //Pattern pattern2 = Pattern.compile("((\\d{4})/(\\d{2}))-(.+?)@(.+?)-(.+)");
    public static void match2(Matcher matcher2, Manager manager, HashMap<Integer,
            Adventurer> adventurers, ArrayList<Log> logs, String[] fightname) {
        boolean a = Arrays.asList(fightname).contains(matcher2.group(4));
        boolean c = Arrays.asList(fightname).contains(matcher2.group(5));
        if (a && c) {
            int advID1 = Main.findadvID(adventurers, matcher2.group(4));
            int advID2 = Main.findadvID(adventurers, matcher2.group(5));
            Adventurer fighter = adventurers.get(advID1);
            Adventurer loser = adventurers.get(advID2);
            HashMap<Integer, Equipment> advEquip = fighter.getBag().getEquipments();
            int b = Main.findequipID(advEquip, matcher2.group(6));
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
                loser.setChangeHit(loser.getChangeHit() - hitPoint);
                System.out.println(loser.getId() + " " + loser.getHitpoint());
                Log log = new Log(matcher2,2);
                log.setFighterID(advID1);
                log.setLoserID(advID2);
                logs.add(log);
            } else {
                System.out.println("Fight log error");
            }
        } else {
            System.out.println("Fight log error");
        }
    }

    public static void match3(Matcher matcher3, Manager manager, HashMap<Integer,
            Adventurer> adventurers, ArrayList<Log> logs, String[] fightname, int m) {
        boolean a = Arrays.asList(fightname).contains(matcher3.group(4));
        if (a) {
            int advID1 = Main.findadvID(adventurers,matcher3.group(4));
            Adventurer fighter = adventurers.get(advID1);
            HashMap<Integer,Equipment> advEquip = fighter.getBag().getEquipments();
            int b = Main.findequipID(advEquip,matcher3.group(5));
            if (b != -1) {
                int equipLevel = advEquip.get(b).getStar();
                Equipment equipment = advEquip.get(b);
                int advLevel = fighter.getLevel();
                Log log = new Log(matcher3,3);
                log.setFighterID(advID1);
                int k = 0;
                for (int i3 = 0;i3 < m;i3++) {
                    if (!Objects.equals(fightname[i3], matcher3.group(4))) {
                        int advID = Main.findadvID(adventurers,fightname[i3]);
                        Adventurer loser = adventurers.get(advID);
                        int hitPoint = 0;
                        if (equipment instanceof RegularEquipment) {
                            hitPoint = equipLevel * advLevel;
                        }
                        else if (equipment instanceof EpicEquipment) {
                            hitPoint = (int)(loser.getHitpoint() *
                                    ((EpicEquipment) equipment).getRatio());
                        }
                        else if (equipment instanceof CritEquipment) {
                            int crit = (int)(((CritEquipment) equipment).getCritical());
                            hitPoint = equipLevel * advLevel + crit;
                        }
                        loser.setHitpoint(loser.getHitpoint() - hitPoint);
                        loser.setChangeHit(loser.getChangeHit() - hitPoint);
                        System.out.print(loser.getHitpoint() + " ");
                        log.getLsName().add(fightname[i3]);
                        log.getLsID().add(advID);
                    }
                }
                System.out.println();
                logs.add(log);
            }
            else {
                System.out.println("Fight log error");
            }
        }
        else {
            System.out.println("Fight log error");

        }
    }
}
