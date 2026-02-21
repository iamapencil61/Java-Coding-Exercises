class ProcessMatrix {
    public static int[] processMatrix(int[][] matrix) {
        int sum = 0;
        int max = matrix[0][0];
        int evenCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                int value = matrix[i][j];
                sum += value;

                if (value > max) {
                    max = value;
                }
                if (value % 2 == 0) {
                    evenCount += 1;
                }
            }
        }

        int[] result = new int[3];
        result[0] = sum;
        result[1] = max;
        result[2] = evenCount;

        return result;
    }
}