import java.util.Map;

public class ProcessingResult {
    final Map<String, Integer> counts;
    final String longestWord;

    ProcessingResult(
            Map<String, Integer> counts,
            String longestWord
    ) {
        this.counts = counts;
        this.longestWord = longestWord;
    }
}
