package sfu.cmpt213.as1;

/**
 * Store basic information about a board game
 */
public class Game {
	private final String name;
	private final double weight;
	private int playCount;

	public Game(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	
	public int getPlayCount() {
		return playCount;
	}

	public double getWeight() {
		return weight;
	}

	public void incrementGamesPlayed() {
		playCount++;
	}
	
	public String toString() {
		return getClass().getName() + "["
				+ "Name:" + name
				+ ", Weight:" + weight
				+ ", Games played:" + playCount
				+ "]";
	}
}
