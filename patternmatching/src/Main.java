import java.util.Scanner;

public class Main {
    public static String processValue(Object value) {
        return switch (value) {
            case Integer i -> "Number: " + (i * 2);
            case String s -> "Text: " + s.toUpperCase();
            case Boolean b -> "Boolean: " + !b;
            default -> "Unknown";
        };
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

        System.out.println(processValue(value));
    }
}