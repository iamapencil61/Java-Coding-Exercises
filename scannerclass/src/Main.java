import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("");
        String name = scanner.nextLine();
        System.out.println("Enter your name: Hello, " + name);

        scanner.close();
    }
}