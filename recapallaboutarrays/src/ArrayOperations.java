import java.util.Arrays;
class ArrayOperations {
    public static void arrayOperations(int[][] matrix) {

        int sum = 0;
        int max = matrix[0][0];

        int[] rowSums =  new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];

                sum += value;
                rowSums[i] += value;

                if (value > max) {
                    max = value;
                }
            }
        }


        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + max);
        System.out.println("Row Sums: " + Arrays.toString(rowSums));

    }
}