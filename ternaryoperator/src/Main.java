import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String result = "";

        result = (number > 0 ? "positive" : (number < 0) ? "negative" : "zero");


        System.out.println("The number is " + result);
        scanner.close();
    }
}