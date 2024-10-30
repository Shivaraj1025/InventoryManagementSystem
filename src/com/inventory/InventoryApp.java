package com.inventory;

import java.util.Scanner;

public class InventoryApp {

	public static void main(String[] args) {
		
		InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. Display All Products");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Product
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();

                    scanner.nextLine(); // Consume the newline

                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    Product newProduct = new Product(productId, productName, quantity, price);
                    manager.addProduct(newProduct);
                    break;

                case 2:
                    // Update Product Quantity
                    System.out.print("Enter Product ID to update: ");
                    int updateId = scanner.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQuantity = scanner.nextInt();

                    manager.updateProductQuantity(updateId, newQuantity);
                    break;

                case 3:
                    // Display All Products
                    manager.displayProducts();
                    break;

                case 4:
                    // Delete Product
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = scanner.nextInt();

                    manager.deleteProduct(deleteId);
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting Inventory Management System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}

}
