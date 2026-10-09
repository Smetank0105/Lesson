import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCounter implements TextTask{
    private final Map<String, Integer> counts = new HashMap<>();

    @Override
    public void process(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            counts.put(
                    word,
                    counts.getOrDefault(word, 0) + 1
            );
        }
    }

    @Override
    public String result() {
        return counts.toString();
    }

    public Map<String, Integer> getCounts() {
        return counts;
    }
}
