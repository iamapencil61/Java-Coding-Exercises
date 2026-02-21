import java.util.Scanner;

public class Main {
    public static String validateAge(int age, boolean strict) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        if (age > 150) {
            throw new IllegalArgumentException("Age cannot be greater than 150");
        }

        if (strict && age == 0) {
            throw new IllegalArgumentException("Age cannot be zero in strict mode");
        }

        return String.valueOf(age);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        boolean strict = Boolean.parseBoolean(scanner.nextLine());

        try {
            System.out.println(validateAge(age, strict));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}