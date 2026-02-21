import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Main {
    public static void printInventoryKeySet(HashMap<String, Integer> inventory) {
        for (String product : inventory.keySet()) {
            int quantity = inventory.get(product);

            System.out.println("Product: " + product + ", Quantity: " + quantity);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read JSON string input representing the inventory HashMap
        String inventoryString = scanner.nextLine();

        // Convert JSON string to HashMap<String, Integer>
        Type mapType = new TypeToken<HashMap<String, Integer>>() {
        }.getType();
        HashMap<String, Integer> inventory = new Gson().fromJson(inventoryString, mapType);

        printInventoryKeySet(inventory);
    }
}