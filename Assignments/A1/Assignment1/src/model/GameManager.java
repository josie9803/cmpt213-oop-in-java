package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * GameManager class manages a list of Game objects
 * It includes basic methods such as add, remove, getSize, getGameAtIndex, checkEmpty
 */
public class GameManager implements Iterable<Game>{
    private final List<Game> games = new ArrayList<>();

    public void add(Game game){
        games.add(game);
    }

    public void remove(int index){
        if (index < 0){
            return;
        }
        games.remove(index);
    }

    public boolean isEmpty(){
        return games.isEmpty();
    }

    public int getSize(){
        return games.size();
    }

    public Game getGameAtIndex(int index){
        return games.get(index);
    }

    @Override
    public Iterator<Game> iterator() {
        return games.iterator();
    }
}
