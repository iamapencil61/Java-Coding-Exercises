import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Main {
    public static String formatDate(String dateStr, String inputPattern, String outputPattern) {
        final String msgInvalidDate = "Invalid date format";
        final String msgInvalidPattern = "Invalid pattern";

        if (dateStr == null || dateStr.trim().isEmpty()) {
            return msgInvalidDate;
        }
        if (inputPattern == null || inputPattern.trim().isEmpty()) {
            return msgInvalidPattern;
        }
        if (outputPattern == null || outputPattern.trim().isEmpty()) {
            return msgInvalidPattern;
        }


        String inputNormalized = inputPattern.trim().toLowerCase();
        String outputNormalized = outputPattern.trim().toLowerCase();


        String realInputPattern;
        String realOutputPattern;

        if (inputNormalized.equals("basic")) {
            realInputPattern = "yyyy-MM-dd";
        } else if (inputNormalized.equals("long")) {
            realInputPattern = "MMMM d, yyyy";
        } else if (inputNormalized.equals("short")) {
            realInputPattern = "MM/dd/yy";
        } else if (inputNormalized.equals("custom")) {

            realInputPattern = inputPattern;
        } else {
            return msgInvalidPattern;
        }

        // OUTPUT mapping
        if (outputNormalized.equals("basic")) {
            realOutputPattern = "yyyy-MM-dd";
        } else if (outputNormalized.equals("long")) {
            realOutputPattern = "MMMM d, yyyy";
        } else if (outputNormalized.equals("short")) {
            realOutputPattern = "MM/dd/yy";
        } else if (outputNormalized.equals("custom")) {

            realOutputPattern = outputPattern;
        } else {
            realOutputPattern = outputPattern.trim();
        }

        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(realInputPattern, Locale.ENGLISH);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(realOutputPattern, Locale.ENGLISH);

            LocalDate parsedDate = LocalDate.parse(dateStr, inputFormatter);
            return parsedDate.format(outputFormatter);

        } catch (DateTimeParseException e) {
            return msgInvalidDate;
        } catch (IllegalArgumentException e) {

            return msgInvalidPattern;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateStr = scanner.nextLine();
        String inputPattern = scanner.nextLine();
        String outputPattern = scanner.nextLine();

        System.out.println(formatDate(dateStr, inputPattern, outputPattern));
    }
}
