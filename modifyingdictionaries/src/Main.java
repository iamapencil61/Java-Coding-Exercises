// --- Modules to convert string of hashmap to hashmap ---
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
// -----------------------------
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, Integer> modifyMap(HashMap<String, Integer> data, String key, int newValue) {
        if (data.containsKey(key)) {

            int existingValue = data.get(key);

            if (existingValue ==  newValue) {
                data.replace(key, existingValue + 1);
            }
            else {
                data.remove(key);
            }
        }
        else {
            data.put(key, newValue);
        }
        return data;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hashMapString = scanner.nextLine();
        String key = scanner.nextLine();
        int newValue = scanner.nextInt();

        // Convert String of HashMap to HashMap
        Type mapType = new TypeToken<HashMap<String, Integer>>(){}.getType();
        HashMap<String, Integer> data = new Gson().fromJson(hashMapString, mapType);

        HashMap<String, Integer> result = modifyMap(data, key, newValue);
        System.out.println(new Gson().toJson(result));
    }
}
