import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read inputs
        String studentId = scanner.nextLine();
        String name = scanner.nextLine();
        int grade = Integer.parseInt(scanner.nextLine());
        String school = scanner.nextLine();

        Student s = new Student(studentId, name, grade, school);
        System.out.println(s.school);
        System.out.println(s.getInfo());

    }
}