package org.example.inventory;
public class Main{
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addProduct(() -> new Product("Laptop", 1200.00, 10));
        inventory.addProduct(() -> new Product("Mouse", 25.00, 100));
        inventory.addProduct(() -> new Product("Keyboard", 50.00, 75));
        inventory.addProduct(() -> new Product("Monitor", 300.00, 20));

        System.out.println("Products with price greater than $100:");
        inventory.filterProducts(p -> p.getPrice() > 100);

        System.out.println("\nProduct Details:");
        inventory.printProducts(product ->
                System.out.println(product.getName() + ": $" + product.getPrice() + ", Quantity: " + product.getQty())
        );

        String productList = inventory.productToString(product ->
                String.format("Product: %s, Price: %.2f, Quantity: %d", product.getName(), product.getPrice(), product.getQty())
        );
        System.out.println("\nFormatted Product List:\n" + productList);

        double totalPrice = inventory.calculateTotalPrice(p -> p.getPrice() > 20.00);
        System.out.printf("\nTotal price of products above $20: $%.2f%n", totalPrice);


    }


}
