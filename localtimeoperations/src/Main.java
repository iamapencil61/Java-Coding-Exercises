import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static String processTime(String timeStr, int amount, String unit, String operation) {
        LocalTime time;

        try {
            time = LocalTime.parse(timeStr, TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            return "Invalid time format";
        }

        if (!"hours".equals(unit) && !"minutes".equals(unit)) {
            return "Invalid unit";
        }

        if (!"add".equals(operation) && !"subtract".equals(operation)) {
            return "Invalid operation";
        }

        LocalTime newTime = time;
        if ("hours".equals(unit)) {
            newTime = "add".equals(operation)
                    ? newTime.plusHours(amount)
                    : newTime.minusHours(amount);
        } else {
            newTime = "add".equals(operation)
                    ? newTime.plusMinutes(amount)
                    : newTime.minusMinutes(amount);
        }

        String formattedNewTime = newTime.format(TIME_FORMATTER);
        return "Original: " + timeStr + ", New: " + formattedNewTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String timeStr = scanner.nextLine();
        int amount = Integer.parseInt(scanner.nextLine());
        String unit = scanner.nextLine();
        String operation = scanner.nextLine();

        System.out.println(processTime(timeStr, amount, unit, operation));
    }
}
