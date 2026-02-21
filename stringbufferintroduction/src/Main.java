import java.util.Scanner;

public class Main {
    public static String modifyText(String text, String target, String replacement) {

        if (text == null || target == null || replacement == null) return "Invalid input";

        StringBuffer sb = new StringBuffer(text);

        int index = text.indexOf(target);

        if (index == -1) {
            sb.append("!");
            return sb.toString();
        }

        sb.replace(index, index + target.length(), replacement);

        sb.append("!");

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String target = scanner.nextLine();
        String replacement = scanner.nextLine();

        if (text.equals("null")) text = null;
        if (target.equals("null")) target = null;
        if (replacement.equals("null")) replacement = null;

        System.out.println(modifyText(text, target, replacement));
    }
}