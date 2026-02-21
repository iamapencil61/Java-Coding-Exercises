import java.util.HashSet;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void checkProperSubsetSuperset(HashSet<String> setA, HashSet<String> setB) {

        boolean isSubset = setB.containsAll(setA);
        System.out.println("setA is a subset of setB: " + isSubset);

        boolean isSuperset = setA.containsAll(setB);
        System.out.println("setA is a superset of setB: " + isSuperset);

        boolean isProperSubset = isSubset && (setA.size() < setB.size());
        System.out.println("setA is a proper subset of setB: " + isProperSubset);

        boolean isProperSuperset = isSuperset && (setA.size() > setB.size());
        System.out.println("setA is a proper superset of setB: " + isProperSuperset);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String setAString = scanner.nextLine();
        String setBString = scanner.nextLine();

        Type setType = new TypeToken<HashSet<String>>(){}.getType();
        HashSet<String> setA = new Gson().fromJson(setAString, setType);
        HashSet<String> setB = new Gson().fromJson(setBString, setType);

        checkProperSubsetSuperset(setA, setB);
    }
}