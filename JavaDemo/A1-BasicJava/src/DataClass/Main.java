package DataClass;

public class Main {
    public static void main(String args[]){
        //Create a door
        Door door = new Door(false, 10000); //press Command + P to show method parameters
        System.out.println("Door's toString: " + door);
        System.out.println("You need " + door.getMinNumHinges() + " hinges!");

        door.setOpen(true);
        if (door.isOpen()){
            System.out.println("Door is open");
        }
    }
}
