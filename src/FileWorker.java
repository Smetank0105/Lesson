import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWorker  implements Runnable{
    private final Path file;
    private final GlobalStats globalStats;
    private final ProcessingRun processingRun;

    FileWorker(
            Path file,
            GlobalStats globalStats,
            ProcessingRun processingRun
    ) {
        this.file = file;
        this.globalStats = globalStats;
        this.processingRun = processingRun;
    }

    @Override
    public void run() {
        WordCounter wordCounter = new WordCounter();
        LongestWord longestWord = new LongestWord();

        try (BufferedReader reader = Files.newBufferedReader(
                file,
                StandardCharsets.UTF_8
        )) {
            String line;

            while ((line = reader.readLine()) != null) {
                wordCounter.process(line);
                longestWord.process(line);
            }

            globalStats.merge(wordCounter.getCounts());
            processingRun.updateLongestWord(
                    longestWord.result()
            );

        } catch (IOException e) {
            processingRun.error.compareAndSet(null, e);
        }
    }
}
