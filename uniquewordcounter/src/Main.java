import java.util.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String[] words = text.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();

        for (String original : words) {
            String processed = original
                    .replaceAll("[^a-zA-Z]", "")
                    .toLowerCase();

            if (!processed.isEmpty()) {
                freq.put(processed, freq.getOrDefault(processed, 0) + 1);
            }
        }

        int totalWords = 0;
        for (int count : freq.values()) {
            totalWords += count;
        }

        int uniqueWords = freq.size();

        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Word statistics:");

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freq.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        for (Map.Entry<String, Integer> e : entryList) {
            String w = e.getKey();
            int count = e.getValue();
            double percent = (count * 100.0) / totalWords;

            String pct = String.format(Locale.US, "%.2f", percent);

            System.out.println(w + ": " + count + " (" + pct + "%)");
        }
    }
}
