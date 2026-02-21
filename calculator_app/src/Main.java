import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Calculator App");

        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double sum = a + b;
        double difference = a - b;
        double product = a * b;
        double quotient = a / b;

        System.out.printf("Sum: %.2f\n", sum);
        System.out.printf("Difference: %.2f\n", difference);
        System.out.printf("Product: %.2f\n", product);
        System.out.printf("Quotient: %.2f\n", quotient);

        scanner.close();
    }
}
