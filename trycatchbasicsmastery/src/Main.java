import java.util.Scanner;

public class Main {
    public static String multiplyNumbers(String num1, String num2, int index) {

        int[] result = new int[3];

        try {
            int value1 = Integer.parseInt(num1);
            int value2 = Integer.parseInt(num2);

            int product = value1 * value2;

            result[index] = product;

            return String.valueOf(result[index]);

        } catch (NumberFormatException e) {
            return "Error: Invalid number format";
        } catch (IndexOutOfBoundsException e) {
            return "Error: Invalid array index";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.nextLine();
        String num2 = scanner.nextLine();
        int index = Integer.parseInt(scanner.nextLine());

        System.out.println(multiplyNumbers(num1, num2, index));
    }
}