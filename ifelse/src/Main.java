import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wind = scanner.nextInt();
        String status = "unset";

        if (wind < 8) {
            status = "Calm";
        }

        else if (wind >= 8 && wind <= 31) {
            status = "Breeze";
        }

        else if (wind >= 32 && wind <= 63) {
            status = "Gale";
        }

        else {
            status = "Storm";
        }



        System.out.println("status = " + status);
        scanner.close();
    }
}