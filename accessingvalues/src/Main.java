import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
// -----------------------------
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static String getCapital(HashMap<String, String> capitals, String country) {
        if (capitals.containsKey(country)) {
            return capitals.get(country);
        }

        return "Not found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hashMapString = scanner.nextLine();
        String country = scanner.nextLine();

        // Convert String of HashMap to HashMap
        Type mapType = new TypeToken<HashMap<String, String>>(){}.getType();
        HashMap<String, String> countryCapitals = new Gson().fromJson(hashMapString, mapType);

        String result = getCapital(countryCapitals, country);
        System.out.println(result);
    }
}