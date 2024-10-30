package com.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InventoryManager {

	// Method to add a new product
	public void addProduct(Product product) {
		String sql = "INSERT INTO products (product_id, product_name, quantity, price) VALUES (?, ?, ?, ?)";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getProductName());
			pstmt.setInt(3, product.getQuantity());
			pstmt.setDouble(4, product.getPrice());

			int rowsInserted = pstmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Product added successfully!");
			}
		} catch (SQLException e) {
			System.out.println("Error adding product: " + e.getMessage());
		}
	}

	// Method to update a product’s quantity
	public void updateProductQuantity(int productId, int quantity) {
		String sql = "UPDATE products SET quantity = ? WHERE product_id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, quantity);
			pstmt.setInt(2, productId);

			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Product quantity updated successfully!");
			} else {
				System.out.println("Product not found!");
			}
		} catch (SQLException e) {
			System.out.println("Error updating product quantity: " + e.getMessage());
		}
	}

	// Method to list all products
	public void displayProducts() {
		// Use SQL SELECT command here
		String sql = "SELECT * FROM products";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	        System.out.printf("%-10s %-15s %-10s %-10s%n", "ID", "Name", "Quantity", "Price");
	        System.out.println("------------------------------------------------");

	        while (rs.next()) {
	            int id = rs.getInt("product_id");
	            String name = rs.getString("product_name");
	            int quantity = rs.getInt("quantity");
	            double price = rs.getDouble("price");

	            System.out.printf("%-10d %-15s %-10d $%-10.2f%n", id, name, quantity, price);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error displaying products: " + e.getMessage());
	    }
	}
	
	// Method to delete product
	public void deleteProduct(int productId) {
	    String sql = "DELETE FROM products WHERE product_id = ?";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, productId);

	        int rowsDeleted = pstmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("Product deleted successfully!");
	        } else {
	            System.out.println("Product not found!");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error deleting product: " + e.getMessage());
	    }
	}


}
