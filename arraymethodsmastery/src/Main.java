import java.util.Arrays;

public class Main {
    public static String[] createSeatingChart(String[] names, int[] grades) {

        String[] chart = new String[names.length];
        for (int i = 0; i < chart.length; i++) {
            chart[i] = names[i] + ": " + grades[i];
        }
        Arrays.sort(chart);
        return chart;
    }

    public static String[] findTopStudents(int[] grades) {
        String[] letters = new String[grades.length];
        for (int i = 0; i < letters.length; i++) {
            if (grades[i] >= 90) {
                letters[i] = "A+";
            }
            else {
                letters[i] = "A";
            }
        }
        return letters;
    }

    public static boolean isClassEqual(int[] grades, int[] grades2) {
        return Arrays.equals(grades, grades2);
    }


    public static void main(String[] args) {
        // Test arrays
        String[] names = {"Tom", "Alice", "Bob"};
        int[] grades = {85, 92, 78};
        int[] grades2 = {85, 92, 78};

        // Test first method
        String[] seatingChart = createSeatingChart(names, grades);
        System.out.print("Seating Chart: ");
        System.out.println(Arrays.toString(seatingChart));

        // Test second method
        String[] gradeLetters = findTopStudents(grades);
        System.out.print("Grade Letters: ");
        System.out.println(Arrays.toString(gradeLetters));

        // Test third method
        boolean equalClasses = isClassEqual(grades, grades2);
        System.out.println("Classes Equal: " + equalClasses);
    }


}