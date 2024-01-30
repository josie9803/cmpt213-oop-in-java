public class PetRock {
    private String name;
    private double weight;
    private Location location;

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public Location getLocation() {
        return location;
    }

    public PetRock(String name, double weight, Location location) {
        this.name = name;
        this.weight = weight;
        this.location = location;
    }

    @Override
    public String toString() {
        return "PetRock{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", location=" + location +
                '}';
    }
}
