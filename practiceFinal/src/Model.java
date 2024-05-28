import java.util.ArrayList;
import java.util.List;

public class Model {
    List<Observer> obs = new ArrayList<>();
    public void addObserver(Observer o){
        obs.add(o);
    }
    public void notifyObserver(String name){
        for (Observer o : obs){
            o.dataChanged(name);
        }
    }
}
