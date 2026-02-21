public class Main {
    public static void printHeader() {
        System.out.println("=================");
        System.out.println("Event Schedule");
        System.out.println("=================");
    }

    public static void printEvent() {
        System.out.println(">> Main Event <<");
        System.out.println("Time: 7:00 PM");
        System.out.println("Location: Hall A");
    }

    public static void printFooter() {
        System.out.println("=================");
        System.out.println("Thank You!");
        System.out.println("=================");
    }

    public static void main(String[] args) {
        printHeader();

        for (int i = 1; i <= 3; i++) {
            printEvent();
        }

        printFooter();

    }
}