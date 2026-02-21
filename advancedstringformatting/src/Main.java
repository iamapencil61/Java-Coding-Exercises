import java.util.Scanner;
import static java.lang.String.format;

public class Main {
    public static String formatData(String name, double price, int quantity, String format) {
        if (name == null || format == null) {
            return "Invalid input";
        }

        if (quantity < 0 || price < 0) {
            return "Invalid input";
        }

        String formattedPrice = format("$%.2f", price);
        double total = price * quantity;
        String formattedTotal = format("$%.2f", total);

        switch (format) {
            case "basic":
                return "ITEM: " + name + ", PRICE: " + formattedPrice;

            case "detailed":
                return "PRODUCT: " + name + "\n" +
                        "PRICE: " + formattedPrice + "\n" +
                        "QUANTITY: " + quantity;

            case "total":
                return "TOTAL FOR " + quantity + "x " +
                        name + ": " + formattedTotal;

            default:
                return "Invalid input";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double price = Double.parseDouble(scanner.nextLine());
        int quantity = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        if (name.equals("null")) name = null;
        if (format.equals("null")) format = null;

        System.out.println(formatData(name, price, quantity, format));
    }
}