public class Main {
    public static void main(String[] args) {
        System.out.println("Multiplication Table (1-5):");
        System.out.println("-------------------------");

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                int product = i * j;

                if (j == 5)
                    System.out.print(product);
                else
                if (product < 10)
                    System.out.print(product + "  ");
                else
                    System.out.print(product + " ");

            }
            System.out.println();
        }
    }
}