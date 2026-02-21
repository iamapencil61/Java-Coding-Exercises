import java.util.Scanner;

public class Main {
    public static String processText(String text, String target, String replacement, int operations) {
        if (text == null || target == null || replacement == null) {
            return "Invalid input";
        }

        if (operations < 1 || operations > 3) {
            return "Invalid operation";
        }

        StringBuffer sb = new StringBuffer(text);

        if (operations == 2) {
            sb.reverse();
        } else if (operations == 3) {
            sb.reverse();
            sb = new StringBuffer(sb.toString().toUpperCase());
        }

        sb.append("!");
        return sb.toString();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String target = scanner.nextLine();
        String replacement = scanner.nextLine();
        int operations = scanner.nextInt();

        if (text.equals("null")) text = null;
        if (target.equals("null")) target = null;
        if (replacement.equals("null")) replacement = null;

        System.out.println(processText(text, target, replacement, operations));
    }
}