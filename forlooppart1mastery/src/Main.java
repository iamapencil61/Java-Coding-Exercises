public class Main {
    public static void main(String[] args) {

        // Initialize variables
        int number = 7;
        int sum = 0;

        System.out.println("Multiplication Table for " + number);
        System.out.println("---------------------------");

        for (int i = 1; i <= 12; i++) {
            int result = number * i;
            System.out.println(number + " x " + i + " = " + result);
            sum += result;
        }

        System.out.println("---------------------------");
        System.out.println("Sum of all results: " + sum);
    }
}