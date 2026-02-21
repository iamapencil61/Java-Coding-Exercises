import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = scanner.nextInt();
        int remaining = 120 - age;

        System.out.println(remaining + " years till 120");
    }
}
