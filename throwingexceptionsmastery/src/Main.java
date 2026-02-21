import java.util.Scanner;

public class Main {
    public static String validateSalary(int salary, boolean strict) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }

        if (salary > 1000000) {
            throw new IllegalArgumentException("Salary cannot be greater than 1000000");
        }

        if (strict && salary == 0) {
            throw new IllegalArgumentException("Salary cannot be zero in strict mode");
        }

        return Integer.toString(salary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int salary = Integer.parseInt(scanner.nextLine());
        boolean strict = Boolean.parseBoolean(scanner.nextLine());

        try {
            System.out.println(validateSalary(salary, strict));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
