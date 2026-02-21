public class Main {
    public static void main(String[] args) {

        int sum = 0;
        int number = 1;

        do {
            sum += number;
            number += 2;
            System.out.println("Sum is: " + sum);
            System.out.println("Num is: " + number);
        }
        while (number <= 50);

        System.out.println("Final Sum: " + sum);
    }
}