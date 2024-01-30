package ca.cmpt213.p1_basics;

/**
 * Demonstrate some basics of Java
 */
public class BasicsDemo {

	private static final int WIDTH = 10;
	private static final int HEIGHT = 20;

	// Static functions to run from main
	public static void main(String[] args) {
		GreetingsWorld greeter = new GreetingsWorld("CMPT 213");
		String message = greeter.getGreeting();
		System.out.println(message);
//		System.out.println("Name is: " + greeter.name);
		// TODO: Move above code into its own method.

//		demoMultipleReferences();
//		demoExceptions();
//		demoControlStructures();
//		demoGuessOutput();
//		demoStringConcat();
	}


	private static void demoMultipleReferences() {
		GreetingsWorld world1 = new GreetingsWorld("Just One");
		GreetingsWorld world2 = world1;
		if (world1 == world2) {
			System.out.println("SAME OBJECT!");
		}
	}

	private static void demoExceptions() {
		GreetingsWorld nullWorld = null;
		nullWorld.getGreeting();
		throw new RuntimeException("Uh dude! It didn't work!");
	}
	
	private static void demoControlStructures() {
		boolean hasSeenElvis = true;
		int age = 15;
		
		// TODO: Use explanatory variable
		if (hasSeenElvis == true || age > 65) {
			System.out.println("You are wise.");
		}
		// boolean isSenior = age > 65
		// if (hasSeenElvis || isSenior)
		long complexCounter = 10;
		for (int i = 0; i < 5; i++) { //always declare var in minimum scope
			System.out.println("Current number: " + i );

			// ?? What's wrong with this code?
			System.out.println("  Counter is  : " + complexCounter--);
			System.out.println("  Counter is  : " + --complexCounter);
		}
	}
	
	private static void demoGuessOutput() {
		// TODO: Figure out the output before running
		int count = 10;
		while (count > 0) {
			count--;
			if (count == 5) {
				continue;
			}

			System.out.println(count);

			if (count % 3 == 0 && count < 5) {
				break;
			}
		}
	}

	static void demoStringConcat() {
		// String concatenation with numbers.
		String guess1 = "hello " + 42;
		String guess2 = "hello " + 4 + 2;
		String guess3 = 42 + "hello";
		String guess4 = 4 + 2 + "hello";
		String guess5 = new Integer(42).toString();

		System.out.println("Guess 1: " + guess1);
		System.out.println("Guess 2: " + guess2);
		System.out.println("Guess 3: " + guess3);
		System.out.println("Guess 4: " + guess4);
		System.out.println("Guess 5: " + guess5);
	}
}