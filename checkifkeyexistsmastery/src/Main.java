import java.util.HashMap;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void updateInventory(HashMap<String, Integer> inventory, String productName, int quantityToAdd) {

        if (inventory.containsKey(productName)) {
            int currentQuantity = inventory.get(productName);
            int newQuantity = quantityToAdd + currentQuantity;

            inventory.put(productName, newQuantity);
        }

        else {
            inventory.put(productName, quantityToAdd);
        }

        System.out.println(new Gson().toJson(inventory));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inventoryString = scanner.nextLine();
        String productName = scanner.nextLine();
        int quantityToAdd = scanner.nextInt();

        // Convert JSON string to HashMap
        Type mapType = new TypeToken<HashMap<String, Integer>>(){}.getType();
        HashMap<String, Integer> inventory = new Gson().fromJson(inventoryString, mapType);

        updateInventory(inventory, productName, quantityToAdd);
    }
}