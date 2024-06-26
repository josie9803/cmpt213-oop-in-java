package ca.cmpt213.as5courseplanner.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Read a CSV and allow access to each line of the file (a CSVFileLine object).
 * Note: Pre-reads entire file when created so may affect performance.
 */
public class CSVFileReader implements Iterable<CSVFileLine> {
	List<CSVFileLine> lines = new LinkedList<>();

	public CSVFileReader(File file) throws FileNotFoundException {
		FileReader reader = new FileReader(file);
		Scanner scanner = new Scanner(reader);
		
		skipHeader(scanner);
		readAllLines(scanner);
		
		scanner.close();
	}
	private void skipHeader(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
	}
	private void readAllLines(Scanner scanner) {
		while (scanner.hasNextLine()) {
			String text = scanner.nextLine();
			CSVFileLine fileLine = new CSVFileLine(text);
			lines.add(fileLine);
		}
	}
	
	public Iterator<CSVFileLine> iterator() {
		return Collections.unmodifiableList(lines).iterator();
	}

}
