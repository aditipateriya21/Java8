package org.example.inventory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Function;

public class InventoryManagement {
    private List<Product> inventory = new ArrayList<>();

    public void addProduct(Supplier<Product> productSupplier) {
        inventory.add(productSupplier.get());
    }

    public void filterProducts(Predicate<Product> condition) {
        for (Product product : inventory) {
            if (condition.test(product)) {
                System.out.println(product.getName() + " meets the condition.");
            }
        }
    }

    public void printProducts(Consumer<Product> printer) {
        for (Product product : inventory) {
            printer.accept(product);
        }
    }

    public String productToString(Function<Product, String> productFormatter) {
        StringBuilder sb = new StringBuilder();
        for (Product product : inventory) {
            sb.append(productFormatter.apply(product)).append("\n");
        }
        return sb.toString();
    }

    public double calculateTotalPrice(Predicate<Product> condition) {
        return inventory.stream()
                .filter(condition)
                .mapToDouble(Product::getPrice)
                .sum();
    }

}
