package ca.cmpt213.p1_basics;

import java.util.Scanner;

/**
 * Simple operations on a rectangle.
 * Demo for debugging.
 * IntelliJ Break on uncaught exception:
 *  - Run --> View Breakpoints
 *    --> Any Exception
 *    --> Enable, and "Uncaught Exception"
 */
public class IntegratedDebuggerRectangle {
	private int width = 0;
	private int height = 0;
	
	public IntegratedDebuggerRectangle(int width, int height) {
		this.height = height;
	}

	public double getArea() {
		return width * height / 2;
	}
	
	public double getAspectRatio() {
		return (double) (height / width);
	}
	
	public static void main(String[] args) {
		System.out.print("Enter a width and height: ");
		Scanner scan = new Scanner(System.in);
		int userWidth = scan.nextInt();
		int userHeight = scan.nextInt();

		IntegratedDebuggerRectangle rect = new IntegratedDebuggerRectangle(userWidth, userHeight);
		System.out.println("Ratio: " + rect.getAspectRatio());
		System.out.println("Area: " + rect.getArea());
	}
}
