import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void printInventoryEntrySet(HashMap<String, Integer> inventory) {
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();

            System.out.println("Product: " + product + ", Quantity: " + quantity);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inventoryString = scanner.nextLine();

        // Convert JSON string to HashMap<String, Integer>
        Type mapType = new TypeToken<HashMap<String, Integer>>(){}.getType();
        HashMap<String, Integer> inventory = new Gson().fromJson(inventoryString, mapType);

        printInventoryEntrySet(inventory);
    }
}