public class Main {
    public static void main(String[] args) {

        int score = 85;
        String grade = "";
        String message = "";

        grade = (score >= 90) ? "A":
                (score >= 80) ? "B":
                (score >= 70) ? "C":
                (score >= 60) ? "D":
                                "F";

        message = (grade.equals("A")) ? "Excellent!" :
                    (grade.equals("B") || grade.equals("C")) ? "Good job!" :
                    (grade.equals("D")) ? "You need to study more" :
                                "Please see the teacher";

        System.out.println("Student Score: " + score);
        System.out.println("Grade: " + grade);
        System.out.println("Message: " + message);
    }
}
