import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static HashMap<String, Object> processHashMap(HashMap<String, Double> products) {
        HashMap<String, Object> result = new HashMap<>();

        if (products.isEmpty()) {
            result.put("Highest", "");
            result.put("Filtered", new TreeMap<String, Double>()); // sıralı boş map
            result.put("Average", 0.0);
            return result;
        }

        String highestName = "";
        double highestPrice = Double.NEGATIVE_INFINITY;

        // TreeMap = alfabetik sıralı
        Map<String, Double> filtered = new TreeMap<>();

        double sum = 0.0;
        int count = 0;

        for (Map.Entry<String, Double> entry : products.entrySet()) {
            String name = entry.getKey();
            double price = entry.getValue();

            if (price > highestPrice) {
                highestPrice = price;
                highestName = name;
            }

            if (price > 50.00) {
                filtered.put(name, price);  // TreeMap→ otomatik sıralı
            }

            sum += price;
            count++;
        }

        double average = sum / count;

        result.put("Highest", highestName);
        result.put("Filtered", filtered);
        result.put("Average", average);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String productsString = scanner.nextLine();

        Type mapType = new TypeToken<HashMap<String, Double>>() {}.getType();
        HashMap<String, Double> products = new Gson().fromJson(productsString, mapType);

        HashMap<String, Object> result = processHashMap(products);

        // Testler HashMap toString() formatı bekliyor:
        System.out.println(result);
    }
}
