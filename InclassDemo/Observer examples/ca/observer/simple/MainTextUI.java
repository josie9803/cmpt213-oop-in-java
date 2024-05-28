package ca.observer.simple;

import java.util.Scanner;

public class MainTextUI {
    private NumberList list = new NumberList();

    public static void main(String args[]) {
        MainTextUI ui = new MainTextUI();
        ui.run();
    }

    private void run() {

        registerObserver();
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter next value: ");
            int nextVal = scan.nextInt();
            list.insert(nextVal);

//            printList();
        } while (true);
    }

    private void registerObserver() {
        NumberListObserver obs = new NumberListObserver() {
            @Override
            public void stateChanged() {
                System.out.println("Observer called!");
                printList();
            }
        };
        list.addObserver(obs);
    }

    private void printList() {
        System.out.print("List is: ");
        for (int i : list) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
