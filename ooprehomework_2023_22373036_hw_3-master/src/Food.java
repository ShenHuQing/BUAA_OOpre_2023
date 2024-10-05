public class Food {
    private int id;
    private int energy;
    private String name;

    public Food(int id, String name, int energy) {
        this.id = id;
        this.name = name;
        this.energy = energy;
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

}
