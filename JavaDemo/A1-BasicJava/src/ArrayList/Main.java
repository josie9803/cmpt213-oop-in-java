package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]){
        List<Door> doors = new ArrayList<>(); //instead of ArrayList<Door> doors = new ArrayList<>();
        if (doors.isEmpty()){
            System.out.println("No doors yet!");
        }

        doors.add(new Door(true, 1000));
        doors.add(new Door(false, 42000000));
        doors.add(new Door(false, 1));

        //First & Last
        System.out.println("First is: " + doors.get(0));
        System.out.println("Last is: " + doors.get(doors.size() - 1));

        printDoors(doors); //Option + Enter to show suggestions on fixing problem

        List<Door> heavyDoors = getHeavyDoors(doors);
        System.out.println("Heavy doors are: ");
        printDoors(heavyDoors);

        heavyDoors.get(0).setOpen(true);

        System.out.println("All doors AFTER OPEN: ");
        printDoors(doors);
        System.out.println("Heavy doors AFTER OPEN: ");
        printDoors(heavyDoors);
    }

    private static List<Door> getHeavyDoors(List<Door> doors) {
        List<Door> heavyDoors = new ArrayList<>();
        for (Door door : doors){
            if (door.getWeightInG() > 2000){
                heavyDoors.add(door); //note: the "door" is referenced to both List "doors" and List "heavyDoors"
            }
        }
        return heavyDoors;
    }

    private static void printDoors(List<Door> doors) {
//        //for loop
//        for (int i = 0; i < doors.size(); i++){
//            System.out.println("Door " + i + " = " + doors.get(i));
//        }
        //for each loop
        int countOfHeavy = 0;
        for (Door door : doors){
            System.out.println("Door = " + door);
            if (door.getWeightInG() > 2000){
                countOfHeavy++;
            }
        }
        System.out.println("Num heavy doors: " + countOfHeavy);
    }
}
