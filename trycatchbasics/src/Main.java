import java.util.Scanner;

public class Main {
    public static String divideNumbers(String num1, String num2, int index) {
        int[] result = new int[2];

        try {
            int value1 = Integer.parseInt(num1);
            int value2 = Integer.parseInt(num2);

            int division = value1 / value2;

            result[index] = division;

            return String.valueOf(result[index]);
        }

        catch (NumberFormatException e) {
            return "Error: Invalid number format";
        }

        catch (ArithmeticException e) {
            return "Error: Division by zero";
        }

        catch (ArrayIndexOutOfBoundsException e) {
            return "Error: Invalid array index";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();
        int index = Integer.parseInt(scanner.nextLine());

        System.out.println(divideNumbers(num1, num2, index));
    }
}