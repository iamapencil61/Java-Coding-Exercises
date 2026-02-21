import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void printMostExpensiveProducts(HashMap<String, HashMap<String, Integer>> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("No categories in inventory.");
            return;
        }

        for (Map.Entry<String, HashMap<String, Integer>> outerEntry : inventory.entrySet()) {
            String category = outerEntry.getKey();
            HashMap<String, Integer> itemsMap = outerEntry.getValue();

            System.out.println("Category: " + category);

            if (itemsMap ==  null || itemsMap.isEmpty()) {
                System.out.println("  No products available.");
                continue;
            }

            String maxProduct = null;
            int  maxPrice = Integer.MIN_VALUE;

            for (Map.Entry<String, Integer> itemEntry : itemsMap.entrySet()) {
                String product =  itemEntry.getKey();
                int price = itemEntry.getValue();

                if (price > maxPrice) {
                    maxPrice = price;
                    maxProduct = product;
                }
            }
            System.out.println("  Most Expensive Product: " + maxProduct + ", Price: " + maxPrice);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inventoryString = scanner.nextLine();

        // Convert JSON string to Nested HashMap
        Type inventoryType = new TypeToken<HashMap<String, HashMap<String, Integer>>>(){}.getType();
        HashMap<String, HashMap<String, Integer>> inventory = new Gson().fromJson(inventoryString, inventoryType);

        printMostExpensiveProducts(inventory);
    }
}