public class Main {
    public static void main(String[] args) {
        int number = 97;
        boolean isPrime = true;

        System.out.println("Checking if " + number + " is prime...");

        for (int divisor = 2; divisor <= number / 2; divisor++) {
            System.out.println("Checking divisor: " + divisor);

            if (number % divisor == 0) {
                System.out.println("Found divisor " + divisor);
                isPrime = false;
                break;
            }
        }

        System.out.println(number + " is " + (isPrime ? "prime!" : "not prime!"));
    }
}
