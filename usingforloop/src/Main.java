import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] arr = text.split(",");

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 5) {
                count++;
            }
        }

        String[] arr2 = new String[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 5) {
                arr2[index] = arr[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(arr2));


    }
}