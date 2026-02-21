import java.util.HashSet;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void unionWithSubsetCheck(HashSet<Integer> set1, HashSet<Integer> set2) {
        if (set2.containsAll(set1)) {
            System.out.println("Set 1 is a subset of Set 2");
        }
        else if (set1.containsAll(set2)) {
            System.out.println("Set 2 is a subset of Set 1");
        }
        else {
            System.out.println("No subset relation");
        }

        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read JSON string representing the first set (e.g., [1,2])
        String set1String = scanner.nextLine();
        // Read JSON string representing the second set (e.g., [2,3])
        String set2String = scanner.nextLine();

        Type setType = new TypeToken<HashSet<Integer>>(){}.getType();
        HashSet<Integer> set1 = new Gson().fromJson(set1String, setType);
        HashSet<Integer> set2 = new Gson().fromJson(set2String, setType);

        unionWithSubsetCheck(set1, set2);
    }
}