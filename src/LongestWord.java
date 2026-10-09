import java.util.StringTokenizer;

public class LongestWord implements TextTask{
    private String longest = "";

    @Override
    public void process(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line);

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            if (word.length() > longest.length()
                    || (word.length() == longest.length()
                    && word.compareTo(longest) < 0)) {
                longest = word;
            }
        }
    }

    @Override
    public String result() {
        return longest;
    }
}
