package cmpt213.as2.ui;

import java.util.Scanner;

/**
 * Display a text menu, and read in a menu selection from the keyboard.
 */
public class TextMenu {
	private static final int EXTRA_CHARACTERS_IN_TITLE = 4;
	private static final int MINIMUM_SELECTION_NUMBER = 1;

	public enum MenuMode {
		MODE_STAY_UNTIL_EXIT,
		MODE_ONE_SHOT,
	}
	
	private final String title;
	private final MenuEntry[] entries;
	private MenuMode mode;

	// Utility class to bundle a text string and runnable for each menu entry
	public static class MenuEntry {
		private final String text;
		private final Runnable runner;

		public MenuEntry(String text, Runnable runner) {
			this.text = text;
			this.runner = runner;
		}
	}

	public TextMenu(String title, MenuEntry[] entries, MenuMode mode) {
		this.title = title;
		this.entries = entries;
		this.mode = mode;
	}

	public TextMenu(String title, MenuEntry[] entries) {
		this(title, entries, MenuMode.MODE_STAY_UNTIL_EXIT);
	}

	public void doMenu() {
		do {
			display();
			int option = getSelection();
			Runnable runner = entries[option - 1].runner;
			if (runner == null) {
				return;
			} else {
				runner.run();
			}
		} while (mode == MenuMode.MODE_STAY_UNTIL_EXIT);
	}

	private void display() {
		// Header
		System.out.println();
		displayRowOfStars(title.length());
		displayHeaderTextRow();
	 	displayRowOfStars(title.length());

		// Menu entries
		for (int i = 0; i < entries.length; i++) {
			int num = i + MINIMUM_SELECTION_NUMBER;
			System.out.println(num + ". " + entries[i].text);
		}
	}
	public static void displayRowOfStars(int length) {
		for (int i = 0; i < length + EXTRA_CHARACTERS_IN_TITLE; i++) {
			System.out.print("*");
		}
		System.out.println();		
	}
	private void displayHeaderTextRow() {
		System.out.println("* " + title + " *");
	}

	public int getSelection() {
		return getNumberBetween(MINIMUM_SELECTION_NUMBER, getNumOptions());
	}
	
	static public int getNumberBetween(int min, int max) {
		Scanner keyboard = new Scanner(System.in);
		boolean inputOk = false;
		int selection = 0;
		do {
			System.out.print("> ");			
			selection = keyboard.nextInt();			
			inputOk = (selection >= min && selection <= max); 
			if (!inputOk) {
				System.out.println("Error: Please enter a selection between " 
						+ min + " and " + max);
			}
		} while (!inputOk);

		// Consume end of line
		keyboard.nextLine();
		return selection;
	}

	private int getNumOptions() {
		return entries.length;
	}

	static public boolean readYesNoOrNothing(boolean defaultValue) {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			String passStr = keyboard.nextLine().trim();

			if (passStr.isBlank()) {
				return defaultValue;
			} else if (passStr.compareToIgnoreCase("Y") == 0) {
				return true;
			} else if (passStr.compareToIgnoreCase("N") == 0) {
				return false;
			} else {
				System.out.print("Error: Please enter [Y]es or [N]o: ");
			}
		}
	}
}
