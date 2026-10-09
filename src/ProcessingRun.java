import java.util.concurrent.atomic.AtomicReference;

public class ProcessingRun {
    volatile boolean done = false;

    final AtomicReference<Throwable> error =
            new AtomicReference<>();

    private String longestWord = "";

    synchronized void updateLongestWord(String candidate) {
        if (candidate.length() > longestWord.length()
                || (candidate.length() == longestWord.length()
                && candidate.compareTo(longestWord) < 0)) {
            longestWord = candidate;
        }
    }

    synchronized String getLongestWord() {
        return longestWord;
    }
}
