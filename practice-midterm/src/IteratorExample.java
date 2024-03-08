import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorExample {
    public static int sum(List<Integer> data){
        Iterator<Integer> itr = data.iterator();
        int sum = 0;
        while (itr.hasNext()) {
            sum += itr.next();
        }
        return sum;
    }

    public static void main(String[] arg) {
// Create the list
        List<String> data = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            data.add("Value " + i);
        }
// Standard for loop
        for (int i = 0; i < data.size(); i++) {
            System.out.printf("%d = %s%n", i, data.get(i));
        }
        // Iterator
        Iterator<String> itr = data.iterator();
        while (itr.hasNext()) {
            System.out.printf("%s%n", itr.next());
        }
        List<Integer> intArray = new ArrayList<>();
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        System.out.println(sum(intArray));

    }
}