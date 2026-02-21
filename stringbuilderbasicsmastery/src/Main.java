import java.util.Scanner;

public class Main {
    public static String buildMessage(String greeting, String name, String action, boolean excited) {
        if (greeting == null || name == null || action == null) {
            return "Invalid input";
        }

        StringBuilder sb = new StringBuilder(greeting);
        sb.append(", ");
        sb.append(name);
        sb.append(" is ");
        sb.append(action);
        sb.append(".");

        if (excited) sb.append("!");

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String greeting = scanner.nextLine();
        String name = scanner.nextLine();
        String action = scanner.nextLine();
        boolean excited = Boolean.parseBoolean(scanner.nextLine());

        if (greeting.equals("null")) greeting = null;
        if (name.equals("null")) name = null;
        if (action.equals("null")) action = null;

        System.out.println(buildMessage(greeting, name, action, excited));
    }
}
