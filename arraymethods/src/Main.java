import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static String[] merge(String[] arr1, String[] arr2) {
        int newLength = arr1.length + arr2.length;
        String[] merged = new String[newLength];

        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);

        Arrays.sort(merged);

        return merged;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textArr1 = scanner.nextLine();
        String textArr2 = scanner.nextLine();
        String[] arr1 = textArr1.split(",");
        String[] arr2 = textArr2.split(",");

        String[] mergedArray = merge(arr1, arr2);
        System.out.println(Arrays.toString(mergedArray));
    }
}