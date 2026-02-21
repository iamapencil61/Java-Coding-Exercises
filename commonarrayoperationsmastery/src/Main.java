import java.util.*;

public class Main {

    // 1) Class stats
    public static String getClassStats(int[] grades) {
        int sum = 0;
        int max = grades[0];
        int min = grades[0];
        int passing = 0;

        for (int g : grades) {
            sum += g;
            if (g > max) max = g;
            if (g < min) min = g;
            if (g >= 60) passing++;
        }

        double avg = (double) sum / grades.length;

        // Ortalama örnekte 85.5 gibi 1 ondalık gösteriliyor.
        return String.format(
                "Class Average: %.1f%n" +
                        "Highest Grade: %d%n" +
                        "Lowest Grade: %d%n" +
                        "Passing Grades: %d/%d",
                avg, max, min, passing, grades.length
        );
    }

    // 2) Letter grade distribution (IMPORTANT: returns ONE multi-line String)
    public static String getLetterGrades(int[] grades) {
        int A = 0, B = 0, C = 0, D = 0, F = 0;

        for (int g : grades) {
            if (g >= 90) A++;
            else if (g >= 80) B++;
            else if (g >= 70) C++;
            else if (g >= 60) D++;
            else F++;
        }

        return String.format(
                "A (90-100): %d%n" +
                        "B (80-89): %d%n" +
                        "C (70-79): %d%n" +
                        "D (60-69): %d%n" +
                        "F (0-59): %d",
                A, B, C, D, F
        );
    }

    // 3) Improvement stats
    public static String getImprovement(int[] startGrades, int[] endGrades) {
        int total = startGrades.length;
        int sumImprovement = 0;
        int mostImproved = endGrades[0] - startGrades[0];
        int improvedCount = 0;

        for (int i = 0; i < total; i++) {
            int diff = endGrades[i] - startGrades[i];
            sumImprovement += diff;

            if (diff > mostImproved) mostImproved = diff;
            if (diff > 0) improvedCount++;
        }

        double avgImprovement = (double) sumImprovement / total;

        return String.format(
                "Average Improvement: %.1f points%n" +
                        "Most Improved: %d points%n" +
                        "Students Improved: %d/%d",
                avgImprovement, mostImproved, improvedCount, total
        );
    }

    public static void main(String[] args) {
    }
}
