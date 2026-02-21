import org.w3c.dom.DOMStringList;

public class Main {
    public static String checkLength(String username) {
        int length = username.length();
        boolean isLongEnough = (length >= 6);

        String message = ("Username length: " + length + "\n");
        message += "Long enough: " + isLongEnough;

        return message;
    }

    public static String checkStart(String username) {

        String startsUser = String.valueOf(username.startsWith("user_"));
        String startsAdmin = String.valueOf(username.startsWith("admin_"));

        String message = "Starts with user_: " + startsUser + "\n";
        message += "Starts with admin_: " + startsAdmin;

        return message;
    }

    public static String modifyUsername(String username) {

        String firstFive = username.substring(0, 5);
        String upper = firstFive.toUpperCase();

        String message = "First 5 chars: " + firstFive + "\n";
        message += "Uppercase: " + upper;

        return message;
    }


    public static void main(String[] args) {
        // Test with this username
        String username = "user_123admin";

        System.out.println("Length Check:");
        System.out.println(checkLength(username));

        System.out.println("\nPrefix Check:");
        System.out.println(checkStart(username));

        System.out.println("\nModified Username:");
        System.out.println(modifyUsername(username));
    }
}