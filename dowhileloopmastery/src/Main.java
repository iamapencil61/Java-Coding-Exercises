public class Main {
    public static void main(String[] args) {
        // Initialize starting number
        int number = 16;

        System.out.println("Starting countdown...");

        do {
            System.out.println("Number is: " + number);

            if (number % 2 == 0) {
                number /= 2;
            }
            else  {
                number -= 1;
            }
        }
        while (number > 1);

        System.out.println("Final number is: " + number);
        System.out.println("Countdown finished!");
    }
}