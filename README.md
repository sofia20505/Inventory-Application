import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
         // Create an Inventory object to manage products
        Inventory inventory = new Inventory();
         // Boolean flag to control the main loop
        boolean running = true;
        while (running) {
            // Display the menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Name");
            System.out.println("5. Display All Products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            try {
                // Read the user's choice
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Perform actions based on user's choice
                switch (choice) {
                    case 1:
                        // Add a new product
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter price: $");
                        double price = scanner.nextDouble();
                        System.out.print("Enter quantity: ");
                        // Create a new Product object and add it to the inventory
                        int quantity = scanner.nextInt();
                        Product newProduct = new Product(id, name, price, quantity);
                        inventory.addProduct(newProduct);
                        System.out.println("Product added successfully.");
                        break;
                    case 2:
                        // Remove a product
                        System.out.print("Enter ID of product to remove: ");
                        int removeID = scanner.nextInt();
                        inventory.removeProduct(removeID);
                        break;
                    case 3:
                        // Search for a product by ID
                        System.out.print("Enter ID to search: ");
                        int searchID = scanner.nextInt();
                        Product foundByID = inventory.searchByID(searchID);
                        if (foundByID != null) {
                            System.out.println("Product found: " + foundByID);
                        } else {
                            System.out.println("No product found with ID: " + searchID);
                        }
                        break;
                    case 4:
                        // Search for products by name
                        System.out.print("Enter name to search: ");
                        scanner.nextLine(); // Consume newline character
                        String searchName = scanner.nextLine();
                        ArrayList<Product> foundByName = inventory.searchByName(searchName);
                        if (!foundByName.isEmpty()) {
                            System.out.println("Products found with name '" + searchName + "':");
                            for (Product product : foundByName) {
                                System.out.println(product);
                            }
                        } else {
                            System.out.println("No product found with name: " + searchName);
                        }
                        break;
                    case 5:
                        // Display all products in the inventory
                        System.out.println("All Products:");
                        inventory.displayAllProducts();
                        break;
                    case 6:
                        // Exit the program
                        running = false;
                        break;
                    default:
                        // Invalid choice
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        scanner.close();
    }
