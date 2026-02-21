import java.util.Scanner;

public class Main {
    public static double bigger(double arg1, double arg2) {
        if (arg1 >= arg2) {
            return arg1;
        }
        else {
            return arg2;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        for (int i = 0; i < iterations; i++) {
            double maxValue = bigger(num1, num2);
            double newValue = maxValue / 2;

            if (maxValue == num1) {
                num1 = newValue;
            }
            else {
                num2 = newValue;
            }

            System.out.println(newValue);

            if (num1 < 2 || num2 < 2) {
                break;
            }
        }

    }
}