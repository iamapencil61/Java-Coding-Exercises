import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, Integer> processHashMap(HashMap<String, Integer> data, String[] operations) {
        for (String operation : operations) {

            String[] parts = operation.split(" ");
            String action = parts[0];
            String key = parts[1];

            if (action.equals("GET")) {
                if (data.containsKey(key)) {
                    System.out.println(data.get(key));
                }
                else {
                    System.out.println("Not found");
                }
            }
            else if (action.equals("CHECK")) {
                if (data.containsKey(key)) {
                    System.out.println("Exists");
                }
                else {
                    System.out.println("Not found");
                }
            }
            else if (action.equals("MODIFY")) {
                int targetValue = Integer.parseInt(parts[2]);
                if (data.containsKey(key)) {
                    int currentValue = data.get(key);

                    if (currentValue == targetValue) {
                        data.replace(key, currentValue + 1);
                    }
                    else {
                        data.remove(key);
                    }
                }
                else {
                    data.put(key, targetValue);
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hashMapString = scanner.nextLine();
        String operationsString = scanner.nextLine();

        // Convert String of HashMap to HashMap
        Type mapType = new TypeToken<HashMap<String, Integer>>(){}.getType();
        HashMap<String, Integer> data = new Gson().fromJson(hashMapString, mapType);

        // Convert String of Array to Array
        String[] operations = new Gson().fromJson(operationsString, String[].class);

        HashMap<String, Integer> result = processHashMap(data, operations);
        System.out.println(new Gson().toJson(result));
    }
}