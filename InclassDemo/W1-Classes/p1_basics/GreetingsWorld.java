package ca.cmpt213.p1_basics;

/**
 * Create a greeting from a named source.
 * Supports brief and full descriptions
 */
public class GreetingsWorld {
	private String name;
	private boolean isShortGreeting;


	public GreetingsWorld(String name) {
		this.name = name;
		this.isShortGreeting = false;
	}

	public GreetingsWorld(String name, boolean isShortGreeting) {
		this.name = name;
		this.isShortGreeting = isShortGreeting;
	}

	public String getGreeting() {
		// Not a great way to design the code, but shows calling private methods.
		if (isShortGreeting) {
			return createBriefGreeting();
		} else {
			return createFullGreeting();
		}
	}

	private String createBriefGreeting() {
		return "Yo, from " + name;
	}

	private String createFullGreeting() {
		return "Hello Java World, from " + name;
	}
}
