import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void printNestedInventory(HashMap<String, HashMap<String, Integer>> inventory) {
        for (Map.Entry<String, HashMap<String, Integer>> outerEntry : inventory.entrySet()) {

            String category = outerEntry.getKey();
            HashMap<String, Integer> innerMap = outerEntry.getValue();

            System.out.println("Category: " + category);

            if (innerMap == null || innerMap.isEmpty()) {
                System.out.println("  (No products)");
            } else {
                for (Map.Entry<String, Integer> innerEntry : innerMap.entrySet()) {
                    String product = innerEntry.getKey();
                    int price = innerEntry.getValue();

                    System.out.println("  Product: " + product + ", Price: " + price);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inventoryString = scanner.nextLine();

        Type inventoryType = new TypeToken<HashMap<String, HashMap<String, Integer>>>() {}.getType();
        HashMap<String, HashMap<String, Integer>> inventory = new Gson().fromJson(inventoryString, inventoryType);

        printNestedInventory(inventory);
    }
}
