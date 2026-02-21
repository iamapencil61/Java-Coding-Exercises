import java.util.Scanner;

public class Main {
    public static String validatePassword(String password) {
        if (password == null) return "Invalid input";

        if (password.length() < 8) return "Too short";

        if (password.length() > 20) return "Too long";

        if (password.contains(" ")) return "Contains space";

        if (!password.matches(".*[A-Z].*")) {
            return "No uppercase";
        }

        if (!password.matches(".*[a-z].*")) {
            return "No lowercase";
        }

        if (!password.matches(".*[0-9].*")) {
            return "No digit";
        }

        if (!password.matches(".*[@#$%^&+=].*")) {
            return "No special character";
        }

        return "Valid";
    }

    public static String getPasswordStrength(String password) {
        if (password == null) return "Weak";

        if (!validatePassword(password).equals("Valid")) return "Weak";

        int countSpecial = 0;
        String specials = "@#$%^&+=";
        for (char c : password.toCharArray()) {
            if (specials.indexOf(c) != -1) {
                countSpecial++;
            }
        }

        int length = password.length();

        // 4. Strong
        if (length > 16 && countSpecial >= 3) {
            return "Strong";
        }

        // 3. Medium
        if (length > 12 && countSpecial >= 2) {
            return "Medium";
        }

        // 2. Weak (Valid condition check)
        if (length >= 8 && countSpecial >= 1) {
            return "Weak";
        }

        // 5. Varsayılan
        return "Weak";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (password.equals("null")) password = null;

        String validation = validatePassword(password);
        System.out.println(validation);

        if (validation.equals("Valid")) {
            System.out.println(getPasswordStrength(password));
        }
    }
}