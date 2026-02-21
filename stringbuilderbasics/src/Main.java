import java.util.Scanner;

public class Main {
    public static String buildPhrase(String start, String middle, String end) {
        if (start == null || middle == null || end == null) {
            return "Invalid input";
        }

        StringBuilder sb = new StringBuilder(start);
        sb.append(" ");
        sb.append(middle);

        sb.append(" ");
        sb.append(end);

        sb.append("!");

        return sb.toString();


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        String middle = scanner.nextLine();
        String end = scanner.nextLine();

        if (start.equals("null")) start = null;
        if (middle.equals("null")) middle = null;
        if (end.equals("null")) end = null;

        System.out.println(buildPhrase(start, middle, end));
    }
}