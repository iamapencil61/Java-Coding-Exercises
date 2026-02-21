import java.util.Scanner;

public class Main {
    public static String validateInput(String text, String type) {
        if (text == null) return "Invalid input";

        if (!type.equals("number") && !type.equals("word")
        && !type.equals("email") && !type.equals("phone")) return "Invalid type";

        switch (type) {
            case "number" -> {
                if (text.matches("[0-9]+")) return "Valid";
                return "Invalid";
            }
            case "word" -> {
                if (text.matches("[a-zA-Z]+")) return "Valid";
                return "Invalid";
            }
            case "email" -> {
                if (text.matches(".+@.+")) return "Valid";
                return "Invalid";
            }
        }

        if (text.matches("[0-9]{10}")) return "Valid";
        return "Invalid";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String type = scanner.nextLine();

        if (text.equals("null")) text = null;
        System.out.println(validateInput(text, type));
    }
}