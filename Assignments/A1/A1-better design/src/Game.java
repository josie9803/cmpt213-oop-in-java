public class Game {
    public static final double MIN_GAME_WEIGHT = 1.0;
    public static final double MAX_GAME_WEIGHT = 5.0;
    private final String name;
    private final double weight;
    private int playCount;
    private int numPlayers;

    public Game(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Game(String name, double weight, int playCount, int numPlayers) {
        this.name = name;
        this.weight = weight;
        this.playCount = playCount;
        this.numPlayers = numPlayers;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getPlayCount() {
        return playCount;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void incrementGamesPlayed(){
        playCount++;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", playCount=" + playCount +
                ", numPlayers=" + numPlayers +
                '}';
    }
}
