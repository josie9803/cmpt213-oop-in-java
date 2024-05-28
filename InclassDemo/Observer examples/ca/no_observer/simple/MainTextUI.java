package ca.no_observer.simple;

import ca.observer.simple.NumberList;

import java.util.Scanner;

public class MainTextUI {
    private NumberList list = new NumberList();

    public static void main(String args[]) {
        MainTextUI ui = new MainTextUI();
        ui.run();
    }

    private void run() {

        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter next value: ");
            int nextVal = scan.nextInt();
            list.insert(nextVal);

            printList();
        } while (true);
    }

    private void printList() {
        System.out.print("List is: ");
        for (int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
