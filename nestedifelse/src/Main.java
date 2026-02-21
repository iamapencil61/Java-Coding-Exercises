import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        int height = scanner.nextInt();
        boolean hasAdult = scanner.nextBoolean();

        if (age < 12) {
            System.out.println("Sorry, you're too young");
        }

        else if (height < 150) {
            System.out.println("Sorry, you're not tall enough");
        }

        else if (age < 15) {
            if (hasAdult == false) {
                System.out.println("Sorry, you need an adult with you");
            } else if (hasAdult == true) {
                System.out.println("You can ride with adult supervision!");
            }

        }

        else {
            System.out.println("You can ride by yourself!");
        }

        scanner.close();
    }
}
