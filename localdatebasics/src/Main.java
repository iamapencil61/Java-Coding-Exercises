import java.time.Duration;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static String processDate(String dateStr, int days, String operation) {
        LocalDate date;
        try {
            date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            return "Invalid date format";
        }

        LocalDate newDate;
        if (operation.equalsIgnoreCase("add")) {
            newDate = date.plusDays(days);
        } else if (operation.equalsIgnoreCase("subtract")) {
            newDate = date.minusDays(days);
        } else {
            return "Invalid operation";
        }

        String dayName = newDate.getDayOfWeek().name();

        return String.format("Original: %s, New: %s, Day of week: %s", date, newDate, dayName);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateStr = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();

        System.out.println(processDate(dateStr, days, operation));
    }
}