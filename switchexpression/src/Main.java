import java.util.Scanner;

public class Main {
    public static String getDayType(int day, boolean abbreviated) {

        switch (day) {
            case 1, 2, 3, 4, 5:
                if (abbreviated) {
                    return "WKD";
                }
                else {
                    return "WORKDAY";
                }
            case 6, 7:
                if (abbreviated) {
                    return "WKND";
                }
                else {
                    return "WEEKEND";
                }
            default:
                if (abbreviated) {
                    return "INV";
                }
                else {
                    return "INVALID";
                }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = Integer.parseInt(scanner.nextLine());
        boolean abbreviated = Boolean.parseBoolean(scanner.nextLine());

        System.out.println(getDayType(day, abbreviated));
    }
}