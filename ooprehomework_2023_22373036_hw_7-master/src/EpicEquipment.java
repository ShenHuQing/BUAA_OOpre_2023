public class EpicEquipment extends Equipment {
    private double ratio;

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public EpicEquipment(int id, String name, int star, long price) {
        super(id, name, star, price);
        this.ratio = -1;
    }

}
