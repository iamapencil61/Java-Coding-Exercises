import java.util.HashSet;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void symmetricDifference(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2);

        HashSet<Integer> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1);

        diff1.addAll(diff2);

        System.out.println("Symmetric Difference: " + diff1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read JSON string for the first set (e.g., [1,2,3])
        String set1String = scanner.nextLine();
        // Read JSON string for the second set (e.g., [2,3,4])
        String set2String = scanner.nextLine();

        Type setType = new TypeToken<HashSet<Integer>>(){}.getType();
        HashSet<Integer> set1 = new Gson().fromJson(set1String, setType);
        HashSet<Integer> set2 = new Gson().fromJson(set2String, setType);

        symmetricDifference(set1, set2);
    }
}