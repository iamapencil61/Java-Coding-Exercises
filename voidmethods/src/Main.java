import java.util.Scanner;

public class Main {
    public static void printNTimes(String message, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        int n = scanner.nextInt();

        printNTimes(msg, n);
    }
}