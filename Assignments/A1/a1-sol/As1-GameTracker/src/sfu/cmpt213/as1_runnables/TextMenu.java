package sfu.cmpt213.as1_runnables;

import java.util.Scanner;

/**
 * Display a text menu, and read in a menu selection from the keyboard.
 */
public class TextMenu {
	private static final int EXTRA_CHARACTERS_IN_TITLE = 4;
	private static final int MINIMUM_SELECTION_NUMBER = 1;
	
	private final String title;
	private final MenuEntry[] entries;

	/**
	 * Utility class to bundle a text string and runnable for each menu entry
 	 */
	public static class MenuEntry {
		private final String text;
		private final Runnable runner;

		public MenuEntry(String text, Runnable runner) {
			this.text = text;
			this.runner = runner;
		}
	}

	public TextMenu(String title, MenuEntry[] entries) {
		this.title = title;
		this.entries = entries;
	}

	public void doMenu() {
		while(true) {
			display();
			int option = getSelection();
			Runnable runner = entries[option - 1].runner;
			if (runner == null) {
				return;
			} else {
				runner.run();
			}
		}
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
	private void displayRowOfStars(int length) {
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
		return selection;
	}

	private int getNumOptions() {
		return entries.length;
	}
}
