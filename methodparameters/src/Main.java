import java.util.Scanner;

public class Main {
    public static void multiplyNumbers(int a, int b) {
        int result = a * b;
        System.out.println(result);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        multiplyNumbers(a, b);

        scanner.close();
    }
}