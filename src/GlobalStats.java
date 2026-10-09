import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GlobalStats {
    private final Map<String, Integer> globalCounts =
            new HashMap<>();

    private final AtomicInteger processedFiles =
            new AtomicInteger();

    public synchronized void merge(
            Map<String, Integer> local
    ) {
        for (Map.Entry<String, Integer> entry : local.entrySet()) {
            globalCounts.merge(
                    entry.getKey(),
                    entry.getValue(),
                    Integer::sum
            );
        }

        processedFiles.incrementAndGet();
    }

    public synchronized Map<String, Integer> snapshot() {
        return new HashMap<>(globalCounts);
    }

    public int getProcessedFiles() {
        return processedFiles.get();
    }
}
