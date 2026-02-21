import java.util.Scanner;

public class Main {
    public static String validatePassword(String password) {
        if (password == null) {
            return "Password cannot be null";
        }

        if (password.isEmpty()) {
            return "Password cannot be empty";
        }

        if (password.length() < 8) {
            return "Password must be at least 8 characters";
        }

        if (password.contains(" ")) {
            return "Password cannot contain spaces";
        }
        return "Valid password";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (password.equals("null")) {
            password = null;
        }
        System.out.println(validatePassword(password));
    }
}