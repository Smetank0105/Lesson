import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private final Map<String, Integer> stock = new LinkedHashMap<>();
    private final Map<String, Integer> initialStock = new LinkedHashMap<>();
    private final Map<String, Integer> suppliedStock = new LinkedHashMap<>();
    private final Map<String, Integer> soldStock = new LinkedHashMap<>();
    private final Map<String, Product> products = new LinkedHashMap<>();

    private BigDecimal revenue = BigDecimal.ZERO;

    private Warehouse() {
    }

    static Warehouse fromCsv(Path file, List<Product> productList)
            throws IOException {
        Warehouse warehouse = new Warehouse();

        for (Product product : productList) {
            warehouse.products.put(product.sku(), product);
            warehouse.stock.put(product.sku(), 0);
            warehouse.initialStock.put(product.sku(), 0);
            warehouse.suppliedStock.put(product.sku(), 0);
            warehouse.soldStock.put(product.sku(), 0);
        }

        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);

        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            }

            String[] parts = line.split(";", -1);
            if (parts.length != 3) {
                throw new IOException("Некорректная строка в stock.csv: " + line);
            }

            String sku = parts[0];
            int quantity = Integer.parseInt(parts[2]);

            if (!warehouse.products.containsKey(sku)) {
                throw new IOException("Неизвестный товар: " + sku);
            }

            if (quantity < 0) {
                throw new IOException("Количество не может быть отрицательным: " + line);
            }

            warehouse.stock.put(sku, quantity);
            warehouse.initialStock.put(sku, quantity);
            warehouse.suppliedStock.put(sku, 0);
            warehouse.soldStock.put(sku, 0);
        }

        return warehouse;
    }

    synchronized boolean buy(String sku, int quantity) {
        if (quantity <= 0 || !stock.containsKey(sku)) {
            return false;
        }

        int available = stock.get(sku);
        if (available < quantity) {
            return false;
        }

        Product product = products.get(sku);

        stock.put(sku, available - quantity);
        soldStock.put(sku, soldStock.get(sku) + quantity);

        BigDecimal orderTotal = product.price()
                .multiply(BigDecimal.valueOf(quantity));

        revenue = revenue.add(orderTotal);
        return true;
    }

    synchronized void supply(String sku, int quantity) {
        if (quantity <= 0 || !stock.containsKey(sku)) {
            return;
        }

        stock.put(sku, stock.get(sku) + quantity);
        suppliedStock.put(sku, suppliedStock.get(sku) + quantity);
    }

    synchronized int getStock(String sku) {
        return stock.getOrDefault(sku, 0);
    }

    synchronized int getInitialStock(String sku) {
        return initialStock.getOrDefault(sku, 0);
    }

    synchronized int getSuppliedStock(String sku) {
        return suppliedStock.getOrDefault(sku, 0);
    }

    synchronized int getSoldStock(String sku) {
        return soldStock.getOrDefault(sku, 0);
    }

    synchronized BigDecimal getRevenue() {
        return revenue;
    }

    List<String> getProductSkus() {
        return List.copyOf(products.keySet());
    }

}
