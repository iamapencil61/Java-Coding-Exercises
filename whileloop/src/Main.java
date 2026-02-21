import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();

        while (number >= 3.5) {
            number /= 2;
        }
        System.out.println(number);

        scanner.close();
    }
}