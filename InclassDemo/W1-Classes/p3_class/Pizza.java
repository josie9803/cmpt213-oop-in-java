package ca.cmpt213.p3_class;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// TODO: What should we remove from this class?
public class Pizza {
	private int diameter = 0;

	public Pizza(int diameter) {
		this.diameter = diameter;
	}

	public double calculateArea() {
		double radius = (double)diameter / 2;
		double area = Math.PI * Math.pow(radius, 2);
		return area;
	}

	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	@Override
	public String toString() {
		return getClass().getName() 
				+ " [diameter=" + diameter + "]";
	}

	// File access methods
	public void writeToFile(File file) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(file);
		writer.println(diameter);
		writer.close();
	}

	public static Pizza makePizzaFromFile(File file) throws Exception {
		Scanner scanner = null;
		Pizza newPizza = null;
		try {
			scanner = new Scanner(file);
			if (scanner.hasNextInt()) {
				int readDiameter = scanner.nextInt();
				newPizza = new Pizza(readDiameter);
			} else {
				// Should create custom type!
				throw new Exception("Invalid file format.");
			}

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return newPizza;
	}
}
