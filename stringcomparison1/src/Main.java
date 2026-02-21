import java.util.Scanner;

public class Main {
    public static void compareStrings(String str1, String str2) {

        String eq = String.valueOf(str1.equals(str2));
        String eqIgnore = String.valueOf(str1.equalsIgnoreCase(str2));

        String cmp = String.valueOf(str1.compareTo(str2));
        String cmpIgnore = String.valueOf(str1.compareToIgnoreCase(str2));

        System.out.println(str1 + " equals " + str2 + ": " + eq);
        System.out.println(str1 + " equalsIgnoreCase " + str2 + ": " + eqIgnore);
        System.out.println(str1 + " compareTo " + str2 + ": " + cmp);
        System.out.println(str1 + " compareToIgnoreCase " + str2 + ": " + cmpIgnore);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        compareStrings(str1, str2);
    }
}