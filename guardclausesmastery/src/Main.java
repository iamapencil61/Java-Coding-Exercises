import java.util.Scanner;

public class Main {
    public static String validateUsername(String username) {

        if (username == null) {
            return "Username cannot be null";
        }

        if (username.isEmpty()) {
            return "Username cannot be empty";
        }

        char firstChar = username.charAt(0);
        if (!Character.isLetter(firstChar)) {
            return "Username must start with a letter";
        }

        for (char c : username.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return "Username cannot contain special characters";
            }
        }


        if (username.length() < 5 || username.length() > 15) {
            return "Username must be between 5 and 15 characters";
        }

        return "Valid username";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        if (username.equals("null")) {
            username = null;
        }
        System.out.println(validateUsername(username));
    }
}