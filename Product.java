public class Product {
    private final int ID;
    private final String name;
    private final double price;
    private final int quantity;

    // Parameterized constructor
    public Product(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    // toString method to represent the product as a string
    @Override
    public String toString() {
        return "Product [ID=" + ID + ", name=" + name + ", price=$" + price + ", quantity=" + quantity + "]";
    }
}