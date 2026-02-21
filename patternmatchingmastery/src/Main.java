import java.util.Scanner;

public class Main {
    public static String processExtendedValue(Object value) {
        switch (value) {
            case Integer i:
                if (i % 2 == 0) {
                    return "Even Number: " + (i * 3);
                }
                else {
                    return "Odd Number: " + (i * 2);
                }
            case String s:
                if (s.length() > 5) {
                    return "Long Text: " + s.toLowerCase();
                }
                else {
                    return "Short Text: " + s.toUpperCase();
                }
            case Boolean b:
                if (b) {
                    return "Boolean: Yes";
                }
                else {
                    return "Boolean: No";
                }
            default:
                return "Unsupported Type";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String inputValue = scanner.nextLine();

        Object value = switch(type) {
            case "Integer" -> Integer.parseInt(inputValue);
            case "String" -> inputValue;
            case "Boolean" -> Boolean.parseBoolean(inputValue);
            default -> inputValue;
        };

        System.out.println(processExtendedValue(value));
    }
}
