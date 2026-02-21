class MatrixOperation {

    public static int[][] matrixOperation(int[][] matrix1, int[][] matrix2, String operator) {
        int[][] result = new int[3][3];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {

                if (operator.equals("add")) {
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
                else if (operator.equals("subtract")) {
                    result[i][j] = matrix1[i][j] - matrix2[i][j];
                }
                else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }
}