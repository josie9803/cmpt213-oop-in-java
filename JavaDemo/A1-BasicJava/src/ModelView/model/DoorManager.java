package ModelView.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoorManager implements Iterable<Door> {
    private List<Door> doors = new ArrayList<>();

    public void add(Door door){
        doors.add(door);
    }

    @Override
    public Iterator<Door> iterator() {
        return doors.iterator();
    }
}
