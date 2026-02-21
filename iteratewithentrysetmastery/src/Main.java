import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void printMostStockedProduct(HashMap<String, Integer> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }

        String maxProduct = null;
        int maxQuantity = -1;

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();

            if (quantity > maxQuantity) {
                maxQuantity = quantity;
                maxProduct = product;
            }
        }

        System.out.println("Most Stocked Product: " + maxProduct + ", Quantity: " + maxQuantity);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read JSON string input representing the inventory HashMap
        String inventoryString = scanner.nextLine();

        // Convert JSON string to HashMap<String, Integer>
        Type mapType = new TypeToken<HashMap<String, Integer>>(){}.getType();
        HashMap<String, Integer> inventory = new Gson().fromJson(inventoryString, mapType);

        printMostStockedProduct(inventory);
    }
}
