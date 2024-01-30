package ca.cmpt213.p4_BadStyle;

/**
 * Demonstrate the course's Java coding standard and test the Person class
 * @author Brian Fraser
 *
 */
public class PersonTest {

	public static void main(String[] args) {
		pickYourCodingStyle();
		
		person bob = new person("Bob", 10);
		System.out.println("At start:  " + bob);
		
		try {
			bob.setAge(1000);
			System.out.println("NO EXCEPTION!   " + bob);
		} catch (RuntimeException exception) {
			System.out.println("Exception: " + bob);			
		}

		bob.setAge(100);
		System.out.println("At end:    " + bob);
		

	}

	private static void pickYourCodingStyle() {
		// Option 1:
		final String HIGHEST_PRIORITY = "clean code";
		System.out.println("My priority: " + HIGHEST_PRIORITY + ".");

		// Option 2:
		char[]w="\0rd0ct33lri".toCharArray();
		for(int x=0xA;w[x]>0;System.out.print(w[x--]));
		
		System.out.println();
		System.out.println();
	}

}
