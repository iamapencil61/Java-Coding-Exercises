class PrintPatterns {
    public static void printPatterns(int[][] matrix) {
        int n = matrix.length;
        System.out.print("Main Diagonal: ");

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        System.out.print("Anti-Diagonal: ");

        for (int i = 0; i < n; i++) {
            int col = n - 1 - i;
            System.out.print(matrix[i][col] + " ");
        }
        System.out.println();

        System.out.print("Top Border: ");

        for (int c = 0; c < n; c++) {
            System.out.print(matrix[0][c] + " ");
        }
        System.out.println();

        System.out.print("Bottom Border: ");

        for (int c = 0; c < n; c++) {
            System.out.print(matrix[n - 1][c] + " ");
        }
        System.out.println();

        System.out.print("Left Border: ");

        for (int r = 0; r < n; r++) {
            System.out.print(matrix[r][0] + " ");
        }
        System.out.println();

        System.out.print("Right Border: ");

        for (int r = 0; r < n; r++) {
            System.out.print(matrix[r][n - 1] + " ");
        }
    }
}