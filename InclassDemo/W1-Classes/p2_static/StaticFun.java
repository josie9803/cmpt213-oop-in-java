package ca.cmpt213.p2_static;

/**
 * Toy demo using static methods and fields.
 */
public class StaticFun {
	public static final int TARGET_NUM_HATS = 10;
	private static int countNumMade = 0;
	private int favNum = 0;
	
	public StaticFun() {
		countNumMade++;
	
	
	// Why have an accessor vs just making countNumMade public?
	public static int getNumMade() {
		return countNumMade;
	}
	
	public void changeFavNum(int i) {
		favNum = i;
	}

	
	
	public static void main(String[] args) {
		// Try to access methods and fields (static and non)
		displayInfo();
//		changeFavNum(42);
//		favNum = 10;
		countNumMade = 9;
	}

	private static void displayInfo() {
		System.out.println("TARGET_NUM_HATTS: " + TARGET_NUM_HATS);
		System.out.println("countNumMade:     " + countNumMade);
//		System.out.println("favNum:           " + favNum);
	}	
}
