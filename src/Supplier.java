import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Supplier extends Thread {
    private final Warehouse warehouse;
    private volatile boolean running = true;

    Supplier(Warehouse warehouse) {
        super("Supplier");
        this.warehouse = warehouse;
    }

    void close() {
        running = false;
        interrupt();
    }

    @Override
    public void run() {
        List<String> skus = warehouse.getProductSkus();

        while (running) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(100, 300));

                String sku = skus.get(
                        ThreadLocalRandom.current().nextInt(skus.size())
                );
                int quantity = ThreadLocalRandom.current().nextInt(1, 6);

                warehouse.supply(sku, quantity);
            } catch (InterruptedException exception) {
                if (running) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
}