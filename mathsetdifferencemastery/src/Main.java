import java.util.HashSet;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void twoWaySetDifference(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> diff1 = new HashSet<>(set1);
        diff1.removeAll(set2);

        HashSet<Integer> diff2 = new HashSet<>(set2);
        diff2.removeAll(set1);

        if (diff1.isEmpty() && diff2.isEmpty()) {
            System.out.println("No difference between sets.");
        } else {
            System.out.println("Difference (Set 1 - Set 2): " + diff1);
            System.out.println("Difference (Set 2 - Set 1): " + diff2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String set1String = scanner.nextLine();
        String set2String = scanner.nextLine();

        Type setType = new TypeToken<HashSet<Integer>>(){}.getType();
        HashSet<Integer> set1 = new Gson().fromJson(set1String, setType);
        HashSet<Integer> set2 = new Gson().fromJson(set2String, setType);

        twoWaySetDifference(set1, set2);
    }
}