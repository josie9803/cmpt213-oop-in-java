package ca.cmpt213.p3_class;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PizzaTest {
	private static final int MAX_NUMBER_PIZZAS = 10000;

	public static void main(String[] args) {
		Pizza pizza = new Pizza(2);
		System.out.println("Area is: " + pizza.calculateArea());
		
		demoPassByValue();
		doOrder();
		demoOrder();
		testPizzaOrder();
		demoObject();
		createPizzaFromKeyboard();

	}

	private static void demoOrder() {
		PizzaOrder myOrder = new PizzaOrder(5);
		myOrder.printSizes();
	}

	private static void doOrder() {
		Pizza[] order = new Pizza[MAX_NUMBER_PIZZAS];
		order[0] = new Pizza(10);
//		order[MAX_NUMBER_PIZZAS] = new Pizza(0);
		order[MAX_NUMBER_PIZZAS-1] = new Pizza(0);
		
	}
	
	private static void demoPassByValue() {
		int myFavNum = 42;
		changeNumber(myFavNum);
		System.out.println("Modified number is: " + myFavNum);

		Pizza myPizza = new Pizza(18);
		modifyPizza(myPizza);
		System.out.println("Modified area is: " + myPizza.calculateArea());

		changeWhichPizza(myPizza);
		System.out.println("Different pizza area is: " + myPizza.calculateArea());		
	}

	
	private static void changeNumber(int x) {
		x = 0;
	}

	private static void modifyPizza(Pizza pizza) {
		pizza.setDiameter(2);
	}
	
	private static void changeWhichPizza(Pizza pizza) {
		Pizza newOne = new Pizza(10);
		pizza = newOne;
	}
	


	private static void demoObject() {
		Object myPizza = new Pizza(10);
		
		System.out.println("The pizza is: " + myPizza);
	}

	private static void createPizzaFromKeyboard() {
		System.out.println("Please enter the pizza size:");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		// Option 0: (Runtime error on bad type)
//		int diameter = scanner.nextInt();

		// Option 1:
		int diameter = 0;
		try {
			diameter = scanner.nextInt();
		} catch (InputMismatchException exception) {
			System.out.println("I can't accept bad data.");
		}
		
		// Option 2:
//		int diameter = 0;
//		if (scanner.hasNextInt()) {
//			diameter = scanner.nextInt();
//		} else {
//			System.out.println("I can't accept bad data.");			
//		}
		
		Pizza pizza = new Pizza(diameter);
		System.out.println("Your pizza is area: " 
				+ pizza.calculateArea());
		
		System.out.print("Enter age: ");
		int age = scanner.nextInt();
		System.out.print("Enter name: ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Hello " + name + " of age " + age);
		
		// Don't close a scanner built from System.in 
		//(stream must remain open for later keyboard scanners in program)
		scanner.close();

		scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		scanner.nextLine();
		name = scanner.nextLine();
		System.out.println("Your name is: " + name);
		
		// Don't close a scanner built from System.in 
		//(stream must remain open for later keyboard scanners in program)
		scanner.close();
	}

	
	
//	private static void demoFiles() {
//		Pizza pizza = new Pizza(42);
//		File file = new File("C:\\t\\pizza.txt");
//		try {
//			pizza.writeToFile(file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	

	private static void testPizzaOrder() {
		final int NUM_PIZZAS = 5;
		PizzaOrder order = new PizzaOrder(NUM_PIZZAS);

		for (int i = 0; i < NUM_PIZZAS; i++) {
			order.add(new Pizza(10+i));
		}

		System.out.println("Number of pizzas is: " + order.getNumberPizzas());
		order.printSizes();
	}

	
	
	
}
