public class Main {
    public static void main(String[] args) {

        String studentName = "john smith";
        int studentId = 123;
        double mathGrade = 92.5555;
        double scienceGrade = 88.7777;
        double englishGrade = 95.1111;
        double attendance = 0.8523;


        String[] nameParts = studentName.split(" ");

        String capitalizedName = "";


        for (String word : nameParts) {
            String first = word.substring(0, 1).toUpperCase();
            String rest = word.substring(1);

            capitalizedName += first + rest + " ";
        }

        capitalizedName = capitalizedName.trim();

        String idFormatted = String.format("%05d", studentId);
        String headerInfo = String.format("Student: %s, ID: %s", capitalizedName, idFormatted);

        String gradesInfo = String.format("Math: %.2f, Science: %.2f, English: %.2f", mathGrade, scienceGrade, englishGrade);

        double percent = attendance * 100;
        String attendanceInfo = String.format("Attendance: %.1f%%", percent);

        System.out.println("STUDENT REPORT CARD");
        System.out.println("------------------");
        System.out.println(headerInfo);
        System.out.println(gradesInfo);
        System.out.println(attendanceInfo);
    }
}