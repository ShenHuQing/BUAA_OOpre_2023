import java.util.ArrayList;
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

    public ArrayList<Log> getLogs() {
        return logs;
    }

    public void setLogs(ArrayList<Log> logs) {
        this.logs = logs;
    }
}
