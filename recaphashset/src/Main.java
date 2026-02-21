import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static String processHashSet(HashSet<Object> set, Object input, String operation) {

        // Guard clauses
        if (set == null) {
            return "Invalid set";
        }

        if (operation == null) {
            return "Invalid operation";
        }

        if (!operation.equals("add") &&
                !operation.equals("remove") &&
                !operation.equals("find") &&
                !operation.equals("count")) {
            return "Invalid operation";
        }

        if (operation.equals("find") && input == null) {
            return "Cannot find null";
        }

        return switch (operation) {

            case "add" -> set.add(input)
                    ? "Added successfully"
                    : "Element already exists";

            case "remove" -> set.remove(input)
                    ? "Removed successfully"
                    : "Element not found";

            case "find" -> {
                int index = 0;

                // labeled BLOCK exactly like the hint
                search: {
                    for (Object obj : set) {
                        if (obj != null && obj.equals(input)) {
                            break search; // found -> exit labeled block
                        }
                        index++;
                    }
                    // if loop finishes, not found
                    index = -1;
                }

                yield (index == -1)
                        ? "Element not found"
                        : "Found at index: " + index;
            }

            case "count" -> {
                int count = 0;
                for (Object obj : set) {
                    if (obj instanceof Integer) {
                        count++;
                    }
                }
                yield "Number of integers: " + count;
            }

            default -> "Invalid operation";
        };
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial set
        String[] items = scanner.nextLine().split(",");
        HashSet<Object> set = new HashSet<>();
        if (!items[0].equals("empty")) {
            for (String item : items) {
                // Try to parse as integer first
                try {
                    set.add(Integer.parseInt(item));
                } catch (NumberFormatException e) {
                    set.add(item);
                }
            }
        }

        // Read input
        String inputStr = scanner.nextLine();
        Object input;
        try {
            input = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            input = inputStr;
        }

        // Read operation
        String operation = scanner.nextLine();

        System.out.println(processHashSet(set, input, operation));
    }
}