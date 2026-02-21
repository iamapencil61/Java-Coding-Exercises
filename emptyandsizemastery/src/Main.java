import java.util.HashSet;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void compareSets(HashSet<String> set1, HashSet<String> set2) {
        System.out.println("Set 1 Empty: " + set1.isEmpty());
        System.out.println("Set 2 Empty: " + set2.isEmpty());

        System.out.println("Set 1 Size: " + set1.size());
        System.out.println("Set 2 Size: " + set2.size());

        if (set1.size() == set2.size()) {
            System.out.println("Same Size: true");
        }
        else {
            System.out.println("Same Size: false");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read JSON string representing two HashSets (e.g., ["Apple","Banana"])
        String set1String = scanner.nextLine();
        String set2String = scanner.nextLine();

        Type setType = new TypeToken<HashSet<String>>(){}.getType();
        HashSet<String> set1 = new Gson().fromJson(set1String, setType);
        HashSet<String> set2 = new Gson().fromJson(set2String, setType);

        compareSets(set1, set2);
    }
}