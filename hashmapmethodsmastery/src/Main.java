// --- Modules to convert string of hashmap to hashmap ---
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
// -----------------------------
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void modifyAndResetHashMap(HashMap<String, Integer> data) {
        if (data.isEmpty()) {
            System.out.println("Is empty: true");
        }
        else {
            System.out.println("Is empty: false");
        }

        int sizeValue = data.size();
        System.out.println("Size: " + sizeValue);

        if (!(data.containsKey("Reset"))) {
            data.put("Reset", 0);
        }

        int newSize = data.size();
        System.out.println("Size after modification: " + newSize);


        data.clear();


        if (data.isEmpty()) {
            System.out.println("Is empty after clear: true");
        }
        else {
            System.out.println("Is empty after clear: false");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hashMapString = scanner.nextLine();

        // Convert String of HashMap to HashMap
        Type mapType = new TypeToken<HashMap<String, Integer>>(){}.getType();
        HashMap<String, Integer> data = new Gson().fromJson(hashMapString, mapType);

        modifyAndResetHashMap(data);
    }
}