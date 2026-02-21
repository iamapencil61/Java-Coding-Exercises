
class GetElement {
    public static int getElement(int[][] matrix, int rowIndex, int colIndex) {

        if (rowIndex < 0 || rowIndex >= matrix.length) {
            return -1;
        }
        if (colIndex < 0 || colIndex >= matrix[0].length) {
            return -1;
        }

        return matrix[rowIndex][colIndex];
    }
}