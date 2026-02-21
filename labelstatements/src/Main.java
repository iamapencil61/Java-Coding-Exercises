import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Main {
    public static void findNumber(int[][] grid, int target, boolean breakEarly) {
        searchLoop:
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == target) {
                    System.out.println("Found at: " + row + "," + col);

                    if (breakEarly) {
                        break searchLoop;
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read JSON string representing a 2D array
        String gridString = scanner.nextLine();
        // Read the target number
        int target = Integer.parseInt(scanner.nextLine());
        // Read the breakEarly flag
        boolean breakEarly = Boolean.parseBoolean(scanner.nextLine());

        Type gridType = new TypeToken<int[][]>(){}.getType();
        int[][] grid = new Gson().fromJson(gridString, gridType);

        findNumber(grid, target, breakEarly);
    }
}