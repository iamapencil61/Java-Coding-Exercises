public class Main {
    public static void main(String[] args) {

        String item1 = "T-shirt";
        String item2 = "Jeans";
        String item3 = "Hat";
        double price1 = 19.99;
        double price2 = 45.50;
        double price3 = 12.00;


        double subtotal = price1 + price2 + price3;
        double tax = subtotal * 0.08;
        double total = subtotal + tax;

        System.out.println("“STORE RECEIPT”");
        System.out.println("-------------");
        System.out.printf("T-shirt: $%.2f\n",price1);
        System.out.printf("Jeans: $%.2f\n",price2);
        System.out.printf("Hat: $%.2f\n",price3);
        System.out.println("-------------");
        System.out.printf("Subtotal: $%.2f\n",subtotal);
        System.out.printf("Tax(8%%): $%.2f\n",tax);
        System.out.printf("Total: $%.2f\n",total);


    }
}
