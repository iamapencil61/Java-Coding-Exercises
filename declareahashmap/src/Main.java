import java.util.HashMap;

public class Main {
    public static HashMap<String, String> createStringStringMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("banana", "yellow");
        map.put("apple", "red");
        map.put("grape", "purple");

        return map;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createStringStringMap();

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}