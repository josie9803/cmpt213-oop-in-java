package ui;

import java.util.Scanner;

/**
 * GeneralTextMenu class displays and manages options of a menu
 * It contains methods to read the input from keyboard and handle errors
 * These methods that can be reused by @GameTextUI
 */
public class GeneralTextMenu {
    public GeneralTextMenu() {
    }
    public String getString(String prompt){
        boolean isCorrectName = false;
        String input = "";
        while(!isCorrectName) {
            System.out.print(prompt);
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            if (!input.isEmpty()) {
                isCorrectName = true;
            } else {
                System.out.println("ERROR: Name must be at least 1 character long.");
            }
        }
        return input;
    }
    public double getDouble(String prompt, double min, double max){
        while(true) {
            System.out.print(prompt);
            Scanner in = new Scanner(System.in);
            double userInput = in.nextDouble();
            if (userInput >= min && userInput <= max) {
                return userInput;
            } else {
                System.out.println("ERROR: Weight must be between " + min + " and " + max);
            }
        }
    }
    public int getIndexInteger(String prompt, int min, int max){
        System.out.print(prompt);
        Scanner in = new Scanner(System.in);
        while(true) {
            int userInput = in.nextInt();
            if (userInput == 0) {
                return -1;
            } else if (userInput >= min && userInput <= max) {
                return userInput - 1;
            } else {
                System.out.println("Error: Please enter a selection between " + min + " and " + max);
                System.out.print("> ");
            }
        }
    }
    public void displayOptions(){
        String prompt = "* Main Menu *";

        printStarSymbol(prompt);
        System.out.println(prompt);
        printStarSymbol(prompt);

        System.out.println(
                "1. List games\n" +
                "2. Add a new game\n" +
                "3. Remove a game\n" +
                "4. Record that you played a game\n" +
                "5. DEBUG: Dump objects (toString)\n" +
                "6. Exit");
    }
    public void displayTitle(){
        String prompt = "Welcome to the Board Game Tracker";

        printStarSymbol(prompt);
        System.out.println(prompt);
        System.out.println("by Josie");
        printStarSymbol(prompt);
    }
    public void printStarSymbol(String prompt){
        for (int i = 0; i < prompt.length(); i++){
            System.out.print("*");
        }
        System.out.println();
    }
}
