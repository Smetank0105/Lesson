void main() throws IOException, InterruptedException {
    Path stockFile = Path.of("stock.csv");
    Path reportFile = Path.of("report.txt");

    List<Product> products = Arrays.asList(
            new Product("SKU001", "Ноутбук", new BigDecimal("899.99")),
            new Product("SKU002", "Смартфон", new BigDecimal("599.50")),
            new Product("SKU003", "Наушники", new BigDecimal("79.90")),
            new Product("SKU004", "Клавиатура", new BigDecimal("45.00")),
            new Product("SKU005", "Мышь", new BigDecimal("29.99")),
            new Product("SKU006", "Монитор", new BigDecimal("249.90")),
            new Product("SKU007", "Принтер", new BigDecimal("159.00")),
            new Product("SKU008", "Флешка", new BigDecimal("12.50")),
            new Product("SKU009", "Веб-камера", new BigDecimal("54.90"))
    );

    List<String> stockLines = new ArrayList<>();
    for (Product product : products) {
        int quantity = ThreadLocalRandom.current().nextInt(10, 31);
        stockLines.add(product.sku() + ";" + product.name() + ";" + quantity);
    }

    Files.write(
            stockFile,
            stockLines,
            StandardCharsets.UTF_8,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
    );

    Warehouse warehouse = Warehouse.fromCsv(stockFile, products);

    Supplier supplier = new Supplier(warehouse);
    List<Customer> customers = new ArrayList<>();
    List<Thread> customerThreads = new ArrayList<>();

    supplier.start();

    for (int i = 1; i <= 5; i++) {
        Customer customer = new Customer("Customer-" + i, warehouse);
        customers.add(customer);
        Thread thread = new Thread(customer);
        customerThreads.add(thread);
        thread.start();
    }

    for (Thread thread : customerThreads) {
        thread.join();
    }

    supplier.close();
    supplier.join();

    List<String> report = new ArrayList<>();
    report.add("Остатки:");

    for (Product product : products) {
        report.add(
                product.sku() + ";" +
                        product.name() + ";" +
                        warehouse.getStock(product.sku())
        );
    }

    int successfulOrders = customers.stream()
            .mapToInt(Customer::getSuccessfulOrders)
            .sum();

    int failedOrders = customers.stream()
            .mapToInt(Customer::getFailedOrders)
            .sum();

    report.add("");
    report.add("Успешные заказы: " + successfulOrders);
    report.add("Неуспешные заказы: " + failedOrders);
    report.add("Выручка: " + warehouse.getRevenue());
    report.add("");
    report.add("Проверка остатков:");

    for (Product product : products) {
        int initial = warehouse.getInitialStock(product.sku());
        int supplied = warehouse.getSuppliedStock(product.sku());
        int sold = warehouse.getSoldStock(product.sku());
        int finalStock = warehouse.getStock(product.sku());

        report.add(
                product.sku() + ": " +
                        initial + " + " +
                        supplied + " - " +
                        sold + " = " +
                        finalStock
        );
    }

    Files.write(
            reportFile,
            report,
            StandardCharsets.UTF_8,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
    );
}

