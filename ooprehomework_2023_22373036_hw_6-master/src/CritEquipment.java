public class CritEquipment extends Equipment {
    private double critical;

    public double getCritical() {
        return critical;
    }

    public void setCritical(double critical) {
        this.critical = critical;
    }

    public CritEquipment(int id, String name, int star, long price) {
        super(id, name, star, price);
        this.critical = -1;
    }

}
