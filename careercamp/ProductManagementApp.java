package careercamp;

import java.util.Scanner;
import java.util.List;


public class ProductManagementApp {
    public static void main(String[] args) throws ProductNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ProductDatabase productDatabase = new ProductDatabase();

        while (true) {
            System.out.println("Product Management Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product by ID");
            System.out.println("3. Update Product");
            System.out.println("4. Search Product by ID");
            System.out.println("5. Search Product by Name");
            System.out.println("6. Display Products by Ascending Price");
            System.out.println("7. Display Products by Descending Discount");
            System.out.println("8. Display All Products");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of products to add: ");
                    int numProducts = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    for (int i = 0; i < numProducts; i++) {
                        System.out.println("Product " + (i + 1));
                        System.out.print("Enter product ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Enter product quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Enter product discount: ");
                        double discount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character

                        Product newProduct = new Product(id, name, price, quantity, discount);
                        productDatabase.addProduct(newProduct);
                        System.out.println("Product added successfully.");
                    }
                    break;
               

                case 2:
                    // Delete Product
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    try {
                        productDatabase.deleteProduct(deleteId);
                        System.out.println("Product deleted successfully.");
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    // Update Product
                    System.out.print("Enter product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    try {
                        Product existingProduct = productDatabase.searchProductById(updateId);
                        System.out.print("Enter updated product name: ");
                        String updatedName = scanner.nextLine();

                        System.out.print("Enter updated product price: ");
                        double updatedPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Enter updated product quantity: ");
                        int updatedQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Enter updated product discount: ");
                        double updatedDiscount = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character

                        Product updatedProduct = new Product(updateId, updatedName, updatedPrice, updatedQuantity, updatedDiscount);
                        productDatabase.updateProduct(updatedProduct);
                        System.out.println("Product updated successfully.");
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    // Search Product by ID
                    System.out.print("Enter product ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    try {
                        Product foundProduct = productDatabase.searchProductById(searchId);
                        System.out.println("Found Product: " + foundProduct);
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    // Search Product by Name
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();

                    List<Product> foundProductsByName = productDatabase.searchProductByName(searchName);
                    if (!foundProductsByName.isEmpty()) {
                        System.out.println("Found Products by Name:");
                        for (Product product : foundProductsByName) {
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("No products found with the specified name.");
                    }
                    break;

                case 6:
                    // Display Products by Ascending Price
                    List<Product> productsByPriceAscending = productDatabase.getProductsByPrice(true);
                    System.out.println("Products by Ascending Price:");
                    for (Product product : productsByPriceAscending) {
                        System.out.println(product);
                    }
                    break;

                case 7:
                    // Display Products by Descending Discount
                    List<Product> productsByDiscountDescending = productDatabase.getProductsByDiscount(false);
                    System.out.println("Products by Descending Discount:");
                    for (Product product : productsByDiscountDescending) {
                        System.out.println(product);
                    }
                    break;

                case 8:
                    // Display All Products
                    List<Product> allProducts = productDatabase.getAllProducts();
                    System.out.println("All Products:");
                    for (Product product : allProducts) {
                        System.out.println(product);
                    }
                    break;
                
                case 9:
                    // Exit the program
                    scanner.close();
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

