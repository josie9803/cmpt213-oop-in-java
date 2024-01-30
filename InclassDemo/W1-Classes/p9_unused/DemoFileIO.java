package ca.cmpt213.p9_unused;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Demo writing to, and reading from, a text file.
 * Shows File, PrintWriter, and Scanner classes.
 */
public class DemoFileIO {
	public static void main(String[] args) {
		demoWriteToFile();
		demoReadFromFile();
	}
	
	private static void demoWriteToFile() {
		File targetFile = new File("C:\\t\\test.txt");
		try {
			PrintWriter writer = new PrintWriter(targetFile);
			writer.println("Some numbers:");
			for (int i = 0; i < 5; i++) {
				writer.print(i + " ");
			}
			for (int i = 10; i < 15; i++) {
				writer.println(i);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// REVISIT: Do something better here?
			e.printStackTrace();
		}
}
	
	private static void demoReadFromFile() {
		File sourceFile = new File("C:\\t\\test.txt");
		try {
			Scanner scanner = new Scanner(sourceFile);
			// Skip header:
			scanner.nextLine();
			
			// Read all values:
			while (scanner.hasNextInt()) {
				int value = scanner.nextInt();
				System.out.println("Value: " + value);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// REVISIT: Do something better here?
			e.printStackTrace();
		}
	}
}
