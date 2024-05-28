package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {
    public static <T> List<T> makeIntoList(T obj1, T obj2){
        List<T> myList = new ArrayList<>();
        myList.add(obj1);
        myList.add(obj2);
        return myList;
    }

    public static void main(String[] args) {
        // Call makeIntoList() on Strings
        List<String> myStrings = makeIntoList("Hello", "World");

        // Call makeIntoList() on Cars
        Car car1 = new Car("Forester", 2050);
        Car car2 = new Car("Model T", 1920);
        List<Car> myCars = makeIntoList(car1, car2);
    }
}
