// --- Modules to convert string of hashmap to hashmap ---
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
// -----------------------------
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static int keyChecker(HashMap<String, Integer> randomValues, String[] keys) {
        int  counter = 0;
        for (String key : keys) {
            if (randomValues.containsKey(key)) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hashMapString = scanner.nextLine();
        String arrayString = scanner.nextLine();

        // Convert String of HashMap to HashMap
        Type mapType = new TypeToken<HashMap<String, Integer>>(){}.getType();
        HashMap<String, Integer> randomValues = new Gson().fromJson(hashMapString, mapType);

        // Convert String of Array to Array
        String[] keys = new Gson().fromJson(arrayString, String[].class);

        int result = keyChecker(randomValues, keys);
        System.out.println(result);
    }
}
