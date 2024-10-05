import java.util.Objects;

public class Soldier {
    private String name;
    private String incantation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIncantation() {
        return incantation;
    }

    public void setIncantation(String incantation) {
        this.incantation = incantation;
    }

    public Soldier(String name, String incantation) {
        this.name = name;
        this.incantation = incantation;
    }

    public void cutIncantation(int a, int b) {
        if (incantation != "") {
            if (a > b) {
                incantation = "";
            }
            else {
                if (a > incantation.length() - 1) {
                    incantation = "";
                }
                else {
                    incantation = incantation.substring(a,
                            Integer.min(b + 1, incantation.length()));
                }

            }
        }
        else {
            return;
        }
    }

    //  2 means "to" , you will see it in the os codes  next semester
    public void appendStr2Incantation(String str) {
        incantation += str;
    }

    public Soldier cloneSoldier() {
        return new Soldier(this.name, this.incantation);
    }

    public boolean notQualifiedByStandard(int standard) {
        int head = 0;
        int tail = 1;
        int totalCount = 0;
        if (incantation != null) {
            while (tail < incantation.length()) {
                if (incantation.charAt(tail) != '@') {
                    tail++;
                    continue;
                }
                int count = 0;
                for (int i = head; i <= tail; i++) {
                    if (incantation.charAt(i) >= 'A' && incantation.charAt(i) <= 'Z') {
                        count++;
                    }
                    if (incantation.charAt(i) >= 'a' && incantation.charAt(i) <= 'z') {
                        count--;
                    }
                }
                if (incantation.charAt(head) == '@' && count >= 0) {
                    totalCount++;
                }
                head = tail;
                tail = tail + 1;
            }
            return totalCount < standard;
        }
        return 0 < standard;
    }

    public boolean hasString(String str) {
        if (incantation != "") {
            return incantation.contains(str);
        } else {
            return false;
        }
    }

    public boolean equal(Soldier soldier) {
        if (this.incantation != "" && soldier.incantation != "") {
            return (Objects.equals(this.name, soldier.name)
                    && this.incantation.equals(soldier.incantation));
        } else if (this.incantation == "" && soldier.incantation == "") {
            return this.name.equals(soldier.name);
        } else {
            return false;
        }
    }
}

