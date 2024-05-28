package cmpt213.as2.videodemos;


public class PetRock {
    private String name;
    private double weight;
    private Location location;

    public PetRock(String name, double weight, Location location) {
        this.name = name;
        this.weight = weight;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Rock{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", location=" + location +
                '}';
    }
}
