import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrString1 = scanner.nextLine();
        String arrString2 = scanner.nextLine();
        String[] str1 = arrString1.split(",");
        String[] str2 = arrString2.split(",");

        if (str2.length > str1.length) {
            System.out.println(false);
            return;
        }

        for (int i = 0; i <= str1.length - str2.length; i++) {
            boolean match = true;

            for (int j = 0; j < str2.length; j++) {
                if (!str1[i + j].equals(str2[j])) {
                    match = false;
                    break;
                }
            }

            if (match) {
                System.out.println(true);
                return;
            }
        }

        System.out.println(false);
    }
}