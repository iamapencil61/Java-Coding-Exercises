import java.util.Scanner;
import java.time.*;
import java.time.format.*;

public class Main {
    public static String calculateDifference(String start, String end, String unit, String format) {
        final String msgInvalidDate = "Invalid date format";
        final String msgInvalidUnit = "Invalid unit";
        final String msgInvalidFormat = "Invalid format";

        if (start == null || start.trim().isEmpty()) {
            return msgInvalidDate;
        }

        if (end == null || end.trim().isEmpty()) {
            return msgInvalidDate;
        }

        if (unit == null || unit.trim().isEmpty()) {
            return msgInvalidUnit;
        }

        if (format == null || format.trim().isEmpty()) {
            return msgInvalidFormat;
        }

        String unitNormalized = unit.trim().toLowerCase();
        String formatNormalized = format.trim().toLowerCase();

        if (!unitNormalized.equals("period") && !unitNormalized.equals("duration")) {
            return msgInvalidUnit;
        }

        if (!formatNormalized.equals("full") && !formatNormalized.equals("simple")) {
            return msgInvalidFormat;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime startDT = LocalDateTime.parse(start, formatter);
            LocalDateTime endDT = LocalDateTime.parse(end, formatter);

            if (endDT.isBefore(startDT)) {
                LocalDateTime temp = startDT;
                startDT = endDT;
                endDT = temp;
            }

            if (unitNormalized.equals("period")) {
                LocalDate startDate = startDT.toLocalDate();
                LocalDate endDate = endDT.toLocalDate();
                Period periodDiff = Period.between(startDate, endDate);

                int years = periodDiff.getYears();
                int months = periodDiff.getMonths();
                int days = periodDiff.getDays();

                if (formatNormalized.equals("full")) {
                    return "Years: " + years + ", Months: " + months + ", Days: " + days;
                } else {
                    return years + "y" + months + "m" + days + "d";
                }
            } else {
                Duration durationDiff = Duration.between(startDT, endDT);

                long totalMinutes = durationDiff.toMinutes();
                long hours = totalMinutes / 60;
                long minutes = totalMinutes % 60;

                if (formatNormalized.equals("full")) {
                    return "Hours: " + hours + ", Minutes: " + minutes;
                } else {
                    return hours + "h" + minutes + "m";
                }
            }
        } catch (DateTimeParseException e) {
            return msgInvalidDate;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        String end = scanner.nextLine();
        String unit = scanner.nextLine();
        String format = scanner.nextLine();

        System.out.println(calculateDifference(start, end, unit, format));
    }
}