package ModelView;

import ModelView.model.Door;
import ModelView.model.DoorManager;
import ModelView.ui.DoorTextUI;

public class Main {
    public static void main(String args[]){
        //1.create model
        DoorManager manager = new DoorManager();
//        manager.add(new Door(false, 12345));
//
//        for (Door d : manager){
//            System.out.println("Door is: " + d);
//        }

        //2.create UI
        DoorTextUI ui = new DoorTextUI(manager);

        //3.launch
        ui.show();
    }
}
