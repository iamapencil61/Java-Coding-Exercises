import java.util.Scanner;

public class Main {
    public static void analyzeString(String str) {
        int len = str.length();
        char ch = str.charAt(4);
        String sub1 = str.substring(7);
        String sub2 = str.substring(3,6);
        String endsDot = String.valueOf(str.endsWith("."));
        String upper = str.toUpperCase();

        System.out.println("Length: " + len);
        System.out.println("Char at 4: " + ch);
        System.out.println("Substring: " + sub1);
        System.out.println("Substring 2: " + sub2);
        System.out.println("Ends with dot: " + endsDot);
        System.out.println("Uppercase: " + upper);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        analyzeString(message);
    }
}