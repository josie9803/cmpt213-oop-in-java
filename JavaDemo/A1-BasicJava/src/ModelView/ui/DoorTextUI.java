package ModelView.ui;

import ModelView.model.Door;
import ModelView.model.DoorManager;

import java.util.Scanner;

public class DoorTextUI {
    private DoorManager manager;

    public DoorTextUI(DoorManager manager) { //dependency injection, since we dont want to instantiate a new object
        this.manager = manager;
    }

    public void show(){
        boolean isDone = false;
        while (!isDone){
            System.out.println("ENTER OPTION (1=add, 2=list, 3=quit):");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter door weight [g]: ");
                    int weightInG = in.nextInt();
                    Door d = new Door(true, weightInG);
                    manager.add(d);
                    break;

                case 2:
                    System.out.println("Doors: ");
                    for (Door door : manager){
                        System.out.println("    " +  door);
                    }
                    break;

                case 3:
                    isDone = true;
                    break;

                default:
                    System.out.println("ERROR! Please enter 1, 2 or 3.");

            }
        }
    }
}
