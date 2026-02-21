public class Main {

    public static String formatCourseInfo(String courseStr) {

        String[] parts = courseStr.split(":");
        String code = parts[0];
        String name = parts[1];
        String days = parts[2];
        String time = parts[3];

        String result =
                "Course Code: " + code + "\n" +
                        "Course Name: " + name + "\n" +
                        "Days: " + days + "\n" +
                        "Time: " + time;

        return result;
    }

    public static String createCourseList(String[] courseCodes) {

        String joined = String.join(", ", courseCodes);
        String result = "Available Courses: " + joined;

        return result;

    }

    public static String formatSchedule(String daysStr) {
        String[] days = daysStr.split(",");

        String result = String.join(" | ", days);

        return result;
    }


    public static void main(String[] args) {
        // Test data
        String courseInfo = "MATH101:Algebra:Monday,Wednesday:9AM";
        String[] courseCodes = {"MATH101", "ENG202", "HIST101"};
        String days = "Monday,Wednesday,Friday";

        // Test your methods
        System.out.println("Course Information:");
        System.out.println(formatCourseInfo(courseInfo));

        System.out.println("\nCourse List:");
        System.out.println(createCourseList(courseCodes));

        System.out.println("\nSchedule Format:");
        System.out.println(formatSchedule(days));
    }
}