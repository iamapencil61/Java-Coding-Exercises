import java.util.Scanner;

public class Main {
    public static String createFormattedString(String productName, int quantity, double unitPrice) {

        double qDouble = (double) quantity;

        String result = String.format(
                "product: %s, Quantity: %.1f, Unit Price: %.5f",
                productName, qDouble, unitPrice
        );
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int qty = scanner.nextInt();
        double price = scanner.nextDouble();
        String formattedString = createFormattedString(product, qty, price);
        System.out.println(formattedString);
    }
}