import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static class CategoryResult {
        int count;
        List<Integer> positions;
        List<String> found;

        CategoryResult() {
            this.count = 0;
            this.positions = new ArrayList<>();
            this.found = new ArrayList<>();
        }
    }

    public static String analyzeText(String text) {
        if (text == null) return "Invalid input";
        if (text.isEmpty()) return "Empty text";

        LinkedHashMap<String, String> patterns = new LinkedHashMap<>();
        patterns.put("Words",   "\\b[a-zA-Z]+\\b");
        patterns.put("Numbers", "\\b\\d+(\\.\\d+)?\\b");
        patterns.put("Emails",  "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
        patterns.put("URLs", "https?://[\\w.-]+\\.[\\w.-]+\\b");


        LinkedHashMap<String, CategoryResult> results = new LinkedHashMap<>();

        for (Map.Entry<String, String> entry : patterns.entrySet()) {
            String category = entry.getKey();
            String regex = entry.getValue();

            CategoryResult r = new CategoryResult();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                r.count++;
                if (r.positions.size() < 3) {
                    r.positions.add(matcher.start());
                    r.found.add(matcher.group());
                }
            }
            results.put(category, r);
        }

        StringBuilder out = new StringBuilder();
        boolean printed = false;
        for (Map.Entry<String, CategoryResult> entry : results.entrySet()) {
            CategoryResult r = entry.getValue();
            if (r.count == 0) continue;
            printed = true;
            out.append(entry.getKey()).append(": ")
               .append(r.count).append(", positions: ")
               .append(formatIntList(r.positions)).append(", found: ")
               .append(formatStringList(r.found)).append("\n");
        }

        if (!printed) return "No matches found";

        return out.toString().trim();
    }

    public static String formatIntList(List<Integer> list) {
        return list.toString();
    }

    public static String formatStringList(List<String> list) {
        return list.toString();
    }

    public static boolean validateMatches(String text) {
        if (text == null) return false;
        if (text.isEmpty()) return true;

        // 1) Unsafe URL var mı?
        if (Pattern.compile("\\bhttp://\\S+\\b").matcher(text).find()) {
            return false;
        }

        // 2) Negatif sayı var mı?
        if (Pattern.compile("(^|\\s)-\\d+(\\.\\d+)?").matcher(text).find()) {
            return false;
        }

        // 3) Kısa kelime var mı? (len < 3)
        Matcher wordMatcher = Pattern.compile("\\b[a-zA-Z]+\\b").matcher(text);
        while (wordMatcher.find()) {
            if (wordMatcher.group().length() < 3) {
                return false;
            }
        }

        // 4) Uygunsuz email var mı?
        Matcher emailMatcher = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b").matcher(text);
        while (emailMatcher.find()) {
            String e = emailMatcher.group().toLowerCase();
            if (!(e.endsWith(".com") || e.endsWith(".org") || e.endsWith(".net"))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        if (text.equals("null")) text = null;

        System.out.println(analyzeText(text));
        System.out.println(validateMatches(text));
    }
}