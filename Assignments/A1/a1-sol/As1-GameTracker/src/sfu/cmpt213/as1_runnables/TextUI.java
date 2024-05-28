package sfu.cmpt213.as1_runnables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Application to track games played.
 */
public class TextUI {
	public static final double MIN_GAME_WEIGHT = 1.0;
	public static final double MAX_GAME_WEIGHT = 5.0;

	private List<Game> games = new ArrayList<>();

	public void start() {
		displayWelcomeMessage();

		// MenuEntry: Text and a method reference
		TextMenu.MenuEntry[] menuEntries = new TextMenu.MenuEntry[]{
				// 3 ways of coding the same thing
				new TextMenu.MenuEntry("List games", this::listGames),
				new TextMenu.MenuEntry("Add a new game", this::addGame),
				new TextMenu.MenuEntry("Remove a game", this::removeGame),
				new TextMenu.MenuEntry("Record that you played a game", this::gamePlayed),
				new TextMenu.MenuEntry("DEBUG: Dump objects (toString)", this::debugDumpGames),
				new TextMenu.MenuEntry("Exit", null),
		};

		TextMenu mainMenu = new TextMenu("Main Menu", menuEntries);
		mainMenu.doMenu();
	}

	private void displayWelcomeMessage() {
		System.out.println("**********************************");
		System.out.println("Welcome to the Board Game Tracker ");
		System.out.println("by Your Name Here.");
		System.out.println("**********************************");
	}

	private void listGames() {
		System.out.println();
		System.out.println("List of Games:");
		System.out.println("****************");

		if (games.size() == 0) {
			System.out.println("No games found.");
		} else {
			for (int i = 0; i < games.size(); i++) {
				Game game = games.get(i);
				int displayNum = i + 1;
				System.out.println(displayNum + ". " + game.getName()
						+ ", " + game.getWeight() + " weight"
						+ ", " + game.getPlayCount() + " play(s)"
				);
			}
		}
	}

	private void addGame() {
		Scanner keyboard = new Scanner(System.in);
		String name;
		while (true) {
			System.out.print("Enter the game's name:   ");
			name = keyboard.nextLine();
			if (name.length() == 0) {
				System.out.println("ERROR: Name must be at least 1 character long.");
			} else {
				break;
			}
		}
		double weight = 0;
		while(true) {
			System.out.print("Enter the game's weight: ");
			weight = keyboard.nextDouble();
			if (weight < MIN_GAME_WEIGHT || weight > MAX_GAME_WEIGHT) {
				System.out.println("ERROR: Weight must be between " + MIN_GAME_WEIGHT + " and " + MAX_GAME_WEIGHT);
			} else {
				break;
			}
		}

		Game newGame = new Game(name, weight);
		games.add(newGame);
	}

	private void removeGame() {
		listGames();

		if (games.size() > 0) {
			System.out.println("(Enter 0 to cancel)");
			int selected = sfu.cmpt213.as1.TextMenu.getNumberBetween(0, games.size());
			if (selected > 0) {
				games.remove(selected - 1);
			}
		}
	}

	private void gamePlayed() {
		listGames();
		if (games.size() > 0) {
			System.out.println("(Enter 0 to cancel)");
			int selected = sfu.cmpt213.as1.TextMenu.getNumberBetween(0, games.size());
			if (selected > 0) {
				Game game = games.get(selected - 1);
				game.incrementGamesPlayed();
				System.out.println(game.getName() + " has been played  "
						+ game.getPlayCount() + " time(s)!");
			}
		}
	}

	private void debugDumpGames() {
		System.out.println("All game objects:");
		int count = 1;
		for (Game game : games) {
			System.out.println(count + ". " + game);
			count ++;
		}
	}


}
