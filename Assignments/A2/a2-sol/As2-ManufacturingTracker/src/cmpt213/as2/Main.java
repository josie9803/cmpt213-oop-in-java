package cmpt213.as2;

import cmpt213.as2.model.Product;
import cmpt213.as2.model.ProductManager;
import cmpt213.as2.ui.TextUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Start the application
 */
public class Main {
    public static void main(String[] args) {
        ProductManager model = new ProductManager();
        TextUI ui = new TextUI(model);
        ui.start();

        ProductManager model2 = new ProductManager();
        for (Product m : model2){
            //do something
        }

        List<Product> products = new ArrayList<>();
        for (Product p : products){
            
        }
    }
}
