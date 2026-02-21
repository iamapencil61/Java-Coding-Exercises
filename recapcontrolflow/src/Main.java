import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {

    public static String processArray(Object[] data, String type) {

        if (data == null || data.length == 0) return "Invalid input";
        if (type == null || (!type.equals("sum") && !type.equals("find"))) return "Invalid type";

        return switch (type) {

            case "sum" -> {
                double total = 0.0;

                for (Object item : data) {
                    if (item instanceof Integer i) total += i;
                    else if (item instanceof Double d) total += d;
                    // else ignore
                }

                yield "Sum: " + total;
            }

            case "find" -> {
                int foundIndex = -1;

                search:
                for (int i = 0; i < data.length; i++) {
                    Object item = data[i];

                    if (item instanceof Integer n && n > 100) { foundIndex = i; break search; }
                    if (item instanceof Double x && x > 100) { foundIndex = i; break search; }
                }

                yield (foundIndex == -1) ? "Not found" : String.valueOf(foundIndex);
            }

            default -> "Invalid type";
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataJson = scanner.nextLine();
        String type = scanner.nextLine();

        Type arrayType = new TypeToken<Object[]>(){}.getType();
        Object[] data = new Gson().fromJson(dataJson, arrayType);

        System.out.println(processArray(data, type));
    }
}
