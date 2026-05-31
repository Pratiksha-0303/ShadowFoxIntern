import java.util.ArrayList;

public class InventoryManager {

    private static InventoryManager instance;
    private ArrayList<Product> products;

    private InventoryManager() {
        products = new ArrayList<>();
    }

    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void deleteProduct(int index) {
        products.remove(index);
    }
}