import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void skipNumber(int[][] grid, int skipValue, boolean skipRow) {
        outer:
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                if (grid[row][col] == skipValue) {
                    if (skipRow) {
                        System.out.println("Skipping row: " + row);
                        continue outer;   // tüm satırı atla
                    } else {
                        continue;        // sadece bu hücreyi atla
                    }
                }

                System.out.println("Visited: " + row + "," + col);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String gridString = scanner.nextLine();
        int skipValue = Integer.parseInt(scanner.nextLine());
        boolean skipRow = Boolean.parseBoolean(scanner.nextLine());

        Type gridType = new TypeToken<int[][]>(){}.getType();
        int[][] grid = new Gson().fromJson(gridString, gridType);

        skipNumber(grid, skipValue, skipRow);
    }
}
