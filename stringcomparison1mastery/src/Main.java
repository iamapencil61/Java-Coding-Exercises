public class Main {

    public static String checkExactMatch(String stored, String attempt) {
        boolean result = stored.equals(attempt);
        return "Password match (exact): " + result;

    }


    public static String checkIgnoreCase(String stored, String attempt) {
        boolean result = stored.equalsIgnoreCase(attempt);
        return "Password match (ignore case): " + result;

    }


    public static String comparePasswords(String stored, String attempt) {

        int cmp = attempt.compareTo(stored);

        if (cmp == 0) {
            return "Password comparison: Exact match";
        } else if (cmp < 0) {
            return "Password comparison: Before";
        } else {
            return "Password comparison: After";
        }

    }

    public static void main(String[] args) {
        // Initialize passwords - don't modify these!
        String storedPassword = "SecurePass123";
        String userAttempt1 = "securepass123";
        String userAttempt2 = "SecurePass123";
        String userAttempt3 = "SecurePass12";
        String[] commonPasswords = {"password123", "12345678", "qwerty123"};

        // Create your validation methods
        String exactCheck = checkExactMatch(storedPassword, userAttempt1);
        String caseCheck = checkIgnoreCase(storedPassword, userAttempt1);
        String comparison = comparePasswords(storedPassword, userAttempt3);

        // Don't modify the code below
        System.out.println("Password Validation Results:");
        System.out.println("---------------------------");
        System.out.println(exactCheck);
        System.out.println(caseCheck);
        System.out.println(comparison);
    }
}