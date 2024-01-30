package model;
/**
 * Game class models the information about a game
 * Data includes name, weight, number of played times
 */
public class Game {
    private final String name;
    private final double weight;
    private int numOfPlayedTimes;

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", numOfPlayedTimes=" + numOfPlayedTimes +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getNumOfPlayedTimes() {
        return numOfPlayedTimes;
    }

    public void increaseNumOfPlayedTimes() {
        this.numOfPlayedTimes++;
        System.out.println(this.getName() + " has been played "
                + this.getNumOfPlayedTimes() + " time(s)");
    }

    public Game(String name, double weight, int numOfPlayedTimes) {
        this.name = name;
        this.weight = weight;
        this.numOfPlayedTimes = numOfPlayedTimes;
    }
}
