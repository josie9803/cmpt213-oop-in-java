package generics;

public class ShippingCrate<T> {
    private T item;

    public ShippingCrate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void printLabel() {
        System.out.println();
        System.out.println("One shipping crate containing: ");
        System.out.println("     " + item.toString());
    }


    public static void main(String[] args) {
        Car myCar = new Car("Gremlin", 1977);
        ShippingCrate<Car> myCrate = new ShippingCrate<>(myCar);
        myCrate.printLabel();

        TeddyBear snuffy = new TeddyBear("Snuffy the Elephant", "Gund");
        ShippingCrate<TeddyBear> bearCrate = new ShippingCrate<>(snuffy);
        bearCrate.printLabel();
    }

}
