import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstInput = scanner.nextInt();

        int count = firstInput;

        int sum = 0;

        for (int i = 1; i <= count; i++) {
            int nextNumber = scanner.nextInt();
            sum += nextNumber;
        }
        System.out.println(sum);


    }
}
