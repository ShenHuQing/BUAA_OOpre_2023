public class Food implements Commodity {
    private int id;
    private int energy;
    private String name;
    private long price;

    public Food(int id, String name, int energy, long price) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    @Override
    public long getValue() {
        return price;
    }
}
