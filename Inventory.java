import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int ID) {
        for (Product product : products) {
            if (product.getID() == ID) {
                products.remove(product);
                System.out.println("Product removed: " + product);
                return;
            }
        }
        System.out.println("Product not found with ID: " + ID);
    }

    public Product searchByID(int ID) {
        for (Product product : products) {
            if (product.getID() == ID) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> searchByName(String name) {
        ArrayList<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public void displayAllProducts() {
        for (Product product : products) {
            System.out.println(product);}
    }
}