import java.util.Scanner;

public class Main {
    public static String processNumber(String number, boolean shouldThrow) {
        int result = 0;

        try {
            if (shouldThrow) {
                int temp = 10 / 0;
            }
            else {
                result = Integer.parseInt(number);

            }
        }
        catch (Exception e) {
            result = -1;
        }
        finally {
            result += 100;
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        boolean shouldThrow = Boolean.parseBoolean(scanner.nextLine());

        System.out.println(processNumber(number, shouldThrow));
    }
}