import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {

    public static HashMap<String, Integer> manageWarehouse(HashMap<String, Integer> warehouse, String[] operations) {
        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String action = parts[0];

            if (action.equals("ADD")) {
                String product = parts[1];
                int quantity = Integer.valueOf(parts[2]);

                if (warehouse.containsKey(product)) {
                    warehouse.put(product, warehouse.get(product) + quantity);
                } else {
                    warehouse.put(product, quantity);
                }

            } else if (action.equals("REMOVE")) {
                String product = parts[1];
                int quantity = Integer.valueOf(parts[2]);

                if (warehouse.containsKey(product)) {
                    int newAmount = warehouse.get(product) - quantity;

                    if (newAmount <= 0) {
                        warehouse.remove(product);
                    } else {
                        warehouse.put(product, newAmount);
                    }
                }

            } else if (action.equals("CHECK")) {
                String product = parts[1];
                System.out.println(warehouse.containsKey(product) ? "true" : "false");

            } else if (action.equals("PRINT")) {
                for (Map.Entry<String, Integer> entry : warehouse.entrySet()) {
                    System.out.println("Product: " + entry.getKey() + ", Quantity: " + entry.getValue());
                }
            }
        }
        return warehouse;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String warehouseString = scanner.nextLine();
        String operationsString = scanner.nextLine();

        Type mapType = new TypeToken<HashMap<String, Integer>>() {}.getType();
        HashMap<String, Integer> warehouse = new Gson().fromJson(warehouseString, mapType);

        String[] operations = new Gson().fromJson(operationsString, String[].class);

        HashMap<String, Integer> result = manageWarehouse(warehouse, operations);

        // Eğer platform final map’i istiyorsa:
        // System.out.println(new Gson().toJson(result));
    }
}
