public class Main {
    public static void main(String[] args) {

        double itemPrice = 12.99;
        int quantity = 5;
        double taxRate = 0.08;
        double discount = 2.50;

        double subtotal = itemPrice * quantity;
        double taxAmount = subtotal * taxRate;
        double discountedAmount = subtotal - discount;
        double finalTotal = discountedAmount + taxAmount;

        System.out.println("Shopping Calculator Results:");
        System.out.println("-------------------------");
        System.out.println("Item Price: $" + itemPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Tax Amount: $" + taxAmount);
        System.out.println("Discounted Amount: $" + discountedAmount);
        System.out.println("Final Total: $" + finalTotal);
    }
}
