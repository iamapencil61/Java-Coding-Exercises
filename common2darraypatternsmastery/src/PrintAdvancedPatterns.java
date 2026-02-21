class PrintAdvancedPatterns {
    public static void printAdvancedPatterns(int[][] matrix) {

        int n = matrix.length;

        // ---------- Both Diagonals ----------
        StringBuilder diag = new StringBuilder();
        diag.append("Both Diagonals: ");

        // Main diagonal
        for (int i = 0; i < n; i++) {
            diag.append(matrix[i][i]).append(" ");
        }

        // Anti-diagonal (skip center if overlaps)
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (i == j) continue;              // merkez elemanı ikinci kez yazdırma
            diag.append(matrix[i][j]).append(" ");
        }

        // remove trailing space
        if (diag.length() > 0 && diag.charAt(diag.length() - 1) == ' ') {
            diag.deleteCharAt(diag.length() - 1);
        }

        System.out.println(diag.toString());

        // ---------- Spiral Order ----------
        StringBuilder spiral = new StringBuilder();
        spiral.append("Spiral Order: ");

        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {

            // top row
            for (int c = left; c <= right; c++) {
                spiral.append(matrix[top][c]).append(" ");
            }
            top++;

            // right column
            for (int r = top; r <= bottom; r++) {
                spiral.append(matrix[r][right]).append(" ");
            }
            right--;

            // bottom row
            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    spiral.append(matrix[bottom][c]).append(" ");
                }
                bottom--;
            }

            // left column
            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    spiral.append(matrix[r][left]).append(" ");
                }
                left++;
            }
        }

        // remove trailing space
        if (spiral.length() > 0 && spiral.charAt(spiral.length() - 1) == ' ') {
            spiral.deleteCharAt(spiral.length() - 1);
        }

        System.out.println(spiral.toString());
    }
}
