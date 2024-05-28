package generics;

import java.util.ArrayList;
import java.util.List;

public class OnlineBatchAuction<T> {

    private List<T> things;
    private Describer<T> titleDescriber;
    private Describer<T> itemDescriber;

    // Create an object that, given an item,
    // provides the description you want.
    public interface Describer<T> {
        String getDescription(T item);
    }

    public OnlineBatchAuction(
            List<T> things,
            Describer<T> titleDescriber,
            Describer<T> itemDescriber
    ) {
        this.things = things;
        this.titleDescriber = titleDescriber;
        this.itemDescriber = itemDescriber;
    }

    void printAuction() {
        for (T item : things) {
            System.out.println();
            System.out.println("New auction!");
            System.out.println("  Title: " + titleDescriber.getDescription(item));
            System.out.println("  Info:  " + itemDescriber.getDescription(item));
            System.out.println("  (Imagine some really interesting display code here...)");
        }
    }


    // Some client code
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Pinto", 1970));
        cars.add(new Car("Corvette", 1969));
        cars.add(new Car("Corolla", 2004));

        Describer<Car> forTitle = (c) -> "One " + c.getModel() + "!";
        Describer<Car> forBody = (c) -> c.getYear() < 2000 ? "It's old!" : "Pretty recent!";
        // Anon class that implement the Describer interface, create describer (above is lambda expression)
        Describer<Car> forBodyAnon = new Describer<Car>() {
            @Override
            public String getDescription(Car item) {
                return "This is the implementation of Anon class";
            }
        };

        OnlineBatchAuction<Car> auction = new OnlineBatchAuction(cars, forTitle, forBody);
        auction.printAuction();



        List<TeddyBear> bears = new ArrayList<>();
        bears.add(new TeddyBear("Alpha", "Brand X"));
        bears.add(new TeddyBear("Huggle Buggle Bear", "Brand Y"));
        Describer<TeddyBear> bearTitleDescriber = (b) -> "Buy a " + b.getBrand();

        Describer<TeddyBear> bearItemDescriber = (b) -> "This bear, named " + b.getName()
                + ", needs a good home.";
        OnlineBatchAuction<TeddyBear> bearAuction = new OnlineBatchAuction<>(
                bears, bearTitleDescriber, bearItemDescriber
        );
        bearAuction.printAuction();

    }


}
