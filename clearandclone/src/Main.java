import java.util.HashSet;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    @SuppressWarnings("unchecked")
    public static void processSet(HashSet<String> set) {

        HashSet<String> clonedSet = (HashSet<String>) set.clone();
        set.clear();

        System.out.println("Cloned Set: " + clonedSet);
        System.out.println("Cloned Set Size: " + clonedSet.size());

        System.out.println("Original Set after clear: " + set);
        System.out.println("Original Set Size: " + set.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String setString = scanner.nextLine();

        Type setType = new TypeToken<HashSet<String>>() {}.getType();
        HashSet<String> set = new Gson().fromJson(setString, setType);

        processSet(set);
    }
}
