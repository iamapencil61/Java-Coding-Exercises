class SubMatrices {
    public static int[][] subMatrices(int[][] matrix1, int[][] matrix2) {

        if (matrix1.length != matrix2.length) {
            return new int[0][0];
        }
        if (matrix1[0].length != matrix2[0].length) {
            return new int[0][0];
        }

        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
}
