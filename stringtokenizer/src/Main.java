import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static String tokenizeText(String text, String delimiter) {
        if (text == null) return "Invalid text";

        if (delimiter == null) delimiter = " ";

        StringTokenizer tokenizer = new StringTokenizer(text, delimiter);
        int count = tokenizer.countTokens();

        String result = "Token count: " + count + "\n";

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            result += "Token: " + token + "\n";
        }

        result = result.trim();
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String delimiter = scanner.nextLine();

        if (text.equals("null")) text = null;
        if (delimiter.equals("null")) delimiter = null;

        System.out.println(tokenizeText(text, delimiter));
    }
}