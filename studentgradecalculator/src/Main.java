import java.util.Scanner;

public class Main {

    public static double calculateAverageGrade(int[] grades) {
        int sum = 0;

        for (int grade : grades) {
            sum += grade;
        }

        double average = (double) sum / grades.length;
        return average;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();       // örnek: "90,80,70"
        String[] arr = text.split(",");

        int[] grades = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            grades[i] = Integer.parseInt(arr[i]);
        }

        double avg = calculateAverageGrade(grades);
        System.out.printf("Average grade: %.2f", avg);
    }
}
