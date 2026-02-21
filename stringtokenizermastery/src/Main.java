import java.util.*;

import java.util.StringTokenizer;

public class Main {

    public static String normalize(String token, boolean caseSensitive) {
        if (!caseSensitive) {
            return token.toLowerCase();
        }
        return token;
    }

    public static String categoryOf(String token) {
        if (token.matches("^[0-9]+$")) {
            return "NUMBER";
        }

        else if (token.matches("^[A-Za-z]+$")) {
            return "WORD";
        }

        else if (token.matches(".*[A-Za-z].*") && token.matches(".*[0-9].*")) {
            return "MIXED";
        }

        else {
            return "SPECIAL";
        }
    }

    public static String analyzeTokens(String text, String delimiter, boolean caseSensitive) {
        if (text == null) {
            return "Invalid text";
        }

        if (delimiter == null) {
            delimiter = " ";
        }

        StringTokenizer st = new StringTokenizer(text, delimiter);

        Map<String, Integer> freq = new LinkedHashMap<>();
        Set<String> unique = new HashSet<>();

        int totalTokens = 0;
        int totalLen = 0;

        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;

        String shortest = null;
        String longest = null;

        List<String> numbers = new ArrayList<>();
        List<String> words = new ArrayList<>();
        List<String> mixed = new ArrayList<>();
        List<String> special = new ArrayList<>();

        String mostFreqToken = null;
        int mostFreqCount = -1;

        while (st.hasMoreTokens()) {
            String raw = st.nextToken();                 // ORIJINAL
            String key = normalize(raw, caseSensitive);  // ANALIZ KEY

            totalTokens++;
            totalLen += raw.length();

            unique.add(key);
            freq.put(key, freq.getOrDefault(key, 0) + 1);

            int current = freq.get(key);
            if (current > mostFreqCount) {
                mostFreqCount = current;
                mostFreqToken = raw; // ORIJINAL
            }

            if (raw.length() < minLen) {
                minLen = raw.length();
                shortest = raw;
            }
            if (raw.length() > maxLen) {
                maxLen = raw.length();
                longest = raw;
            }

            String cat = categoryOf(raw); // kategori ORIJINAL ile
            if (cat.equals("NUMBER")) numbers.add(raw);
            else if (cat.equals("WORD")) words.add(raw);
            else if (cat.equals("MIXED")) mixed.add(raw);
            else special.add(raw);
        }



        double avgLen;
        if (totalTokens == 0) {
            avgLen = 0.0;
            shortest = "";
            longest = "";
            mostFreqToken = "";
            mostFreqCount = 0;
        } else {
            avgLen = totalLen / (double) totalTokens;
        }

        StringBuilder report = new StringBuilder();

        report.append("Basic Analysis:\n");
        report.append("Total tokens: ").append(totalTokens).append("\n");
        report.append("Unique tokens: ").append(unique.size()).append("\n");
        report.append("Most frequent: ").append(mostFreqToken)
                .append(" (").append(mostFreqCount).append(" times)\n\n");

        report.append("Categories:\n");
        report.append("Numbers: ").append(numbers.size()).append(" ").append(numbers).append("\n");
        report.append("Words: ").append(words.size()).append(" ").append(words).append("\n");
        report.append("Mixed: ").append(mixed.size()).append(" ").append(mixed).append("\n");
        report.append("Special: ").append(special.size()).append(" ").append(special).append("\n\n");

        report.append("Statistics:\n");
        report.append("Average length: ").append(String.format("%.2f", avgLen)).append("\n");
        report.append("Longest token: ").append(longest).append("\n");
        report.append("Shortest token: ").append(shortest).append("\n");


        return report.toString().trim();


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String delimiter = scanner.nextLine();
        boolean caseSensitive = scanner.nextBoolean();

        if (text.equals("null")) text = null;
        if (delimiter.equals("null")) delimiter = null;

        System.out.println(analyzeTokens(text, delimiter, caseSensitive));
    }
}