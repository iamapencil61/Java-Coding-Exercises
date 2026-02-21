import java.util.Scanner;

public class Main {
    // Method declaration
    public static void sumNumbers() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;

        }
        System.out.println(sum);

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            sumNumbers();
        }

        scanner.close();
    }
}