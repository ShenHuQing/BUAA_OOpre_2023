public class ReinforcedBottle extends Bottle {
    private double ratio;

    public ReinforcedBottle(int id, String name, int capacity, long price) {
        super(id, name, capacity, price);
        this.ratio = -1;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}