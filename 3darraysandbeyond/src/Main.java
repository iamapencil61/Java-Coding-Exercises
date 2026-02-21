import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int depth = scanner.nextInt();
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][][] array3D = new int[depth][rows][cols];

        for (int d = 0; d < depth; d++) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int value = (d + 1) * (r + 1) * (c + 1);
                    array3D[d][r][c] = value;
                }
            }
        }

        for (int d = 0; d < depth; d++) {
            System.out.println("Depth " + d + ":");
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.print(array3D[d][r][c] + " ");
                }
                System.out.println();
            }
        }
    }
}