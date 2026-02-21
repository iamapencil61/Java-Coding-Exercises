import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "";

        if (input.equals("1")) {
            result = "T";
        }
        else {
            result = "F";
        }

        System.out.println(result);

        scanner.close();
    }
}