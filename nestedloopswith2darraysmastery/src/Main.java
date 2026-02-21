import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void printSum(int[][] array) {
        int row = array.length;

        for (int i = 0; i < row; i++) {
            int sum = 0;

            int cols =  array[i].length;
            for (int j = 0; j < cols; j++) {
                sum += array[i][j];
            }
            System.out.println("Row " + i + " sum: " + sum);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrayString = scanner.nextLine();

        Type arrayType = new TypeToken<int[][]>(){}.getType();
        int[][] array = new Gson().fromJson(arrayString, arrayType);

        printSum(array);
    }
}