import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static String processDateTime(String dateTimeStr, int amount, String unit, String operation) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); // <-- FIX

        if (dateTimeStr == null) {
            return "Invalid date time format";
        }

        LocalDateTime dt;
        try {
            dt = LocalDateTime.parse(dateTimeStr, formatter);
        } catch (DateTimeParseException e) {
            return "Invalid date time format";
        }

        if (!unit.equals("days") && !unit.equals("hours") && !unit.equals("months")) {
            return "Invalid unit";
        }

        if (!operation.equals("add") && !operation.equals("subtract")) {
            return "Invalid operation";
        }

        LocalDateTime newDt = dt;

        if (operation.equals("add")) {
            newDt = switch (unit) {
                case "hours" -> dt.plusHours(amount);
                case "days" -> dt.plusDays(amount);
                case "months" -> dt.plusMonths(amount);
                default -> newDt;
            };
        } else { // subtract
            newDt = switch (unit) {
                case "hours" -> dt.minusHours(amount);
                case "days" -> dt.minusDays(amount);
                case "months" -> dt.minusMonths(amount);
                default -> newDt;
            };
        }

        String dayName = newDt.getDayOfWeek().toString();
        String formattedOriginal = dt.format(formatter);
        String formattedNew = newDt.format(formatter);

        return "Original: " + formattedOriginal + ", New: " + formattedNew + ", Day: " + dayName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateTimeStr = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());
        String unit = scanner.nextLine();
        String operation = scanner.nextLine();

        System.out.println(processDateTime(dateTimeStr, amount, unit, operation));
    }
}
