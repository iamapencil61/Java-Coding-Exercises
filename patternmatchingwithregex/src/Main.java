import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static String findWords(String text, String word) {
        if (text == null || word == null) return "Invalid input";

        Pattern pattern = Pattern.compile(word);

        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();

        boolean found = false;
        while (matcher.find()) {
            found = true;
            int position = matcher.start();

            result.append(position);
            result.append(" ");
        }

        if (!found) return "Not found";

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String word = scanner.nextLine();

        if (text.equals("null")) text = null;
        if (word.equals("null")) word = null;

        System.out.println(findWords(text, word));
    }
}