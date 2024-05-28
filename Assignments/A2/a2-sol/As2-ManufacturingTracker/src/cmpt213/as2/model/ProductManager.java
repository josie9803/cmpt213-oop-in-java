package cmpt213.as2.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

/**
 * Store a collection of products.
 */
public class ProductManager implements Iterable<Product>{
    private List<Product> products = new ArrayList<>();

    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }

    public Iterable<Product> sortedBy(Comparator<Product> comparator) {
        List<Product> dupeList = new ArrayList<>(products);
        Collections.sort(dupeList, comparator);
//        Collections.sort(dupeList, new Comparator<Product>() {
//            @Override
//            public int compare(Product o1, Product o2) {
//                return 0;
//            }
//        });
        return dupeList;
    }

    public boolean containsBySerialNumber(String serial) {
        for (Product p : products) {
            if (p.getSerialNumber().equals(serial)) {
                return true;
            }
        };
        return false;


//        long num = products.stream()
//                .filter(p -> p.getSerialNumber().equals(serial))
//                .count();
//        return num > 0;
    }

    public void add(Product p) {
        products.add(p);
    }

    public Product findOrThrow(String serial) {
        for (Product p : products) {
            if (p.getSerialNumber().equals(serial)) {
                return p;
            }
        }
        throw new NoSuchElementException("No product found matching serial number " + serial);
    }

    public void populateFromJSON(String json) {
        // source: https://howtodoinjava.com/gson/gson-parse-json-array/#12-converting-json-array-to-list-of-objects
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
        Type productListType = new TypeToken<ArrayList<Product>>(){}.getType();
        products = gson.<ArrayList<Product>>fromJson(json, productListType);
    }
    public String getJSON() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
        return gson.toJson(products);
    }

    public int countProducts() {
        return products.size();
    }
}
