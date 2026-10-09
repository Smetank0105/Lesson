import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Customer implements Runnable {
    private final String name;
    private final Warehouse warehouse;

    private int successfulOrders;
    private int failedOrders;

    Customer(String name, Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        List<String> skus = warehouse.getProductSkus();
        int orderCount = ThreadLocalRandom.current().nextInt(3, 8);

        for (int i = 0; i < orderCount; i++) {
            String sku = skus.get(
                    ThreadLocalRandom.current().nextInt(skus.size())
            );
            int quantity = ThreadLocalRandom.current().nextInt(1, 4);

            boolean purchased = warehouse.buy(sku, quantity);

            if (purchased) {
                successfulOrders++;
            } else {
                failedOrders++;
            }

            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(50, 200));
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(
                name + ": успешных заказов = " + successfulOrders +
                        ", неуспешных = " + failedOrders
        );
    }

    int getSuccessfulOrders() {
        return successfulOrders;
    }

    int getFailedOrders() {
        return failedOrders;
    }
}