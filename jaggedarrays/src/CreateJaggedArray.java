public class CreateJaggedArray {
    public static int[][] createJaggedArray(int n) {

        int[][] jaggedArray = new int[n][];
        for (int i = 0; i < n; i++) {
            int rowLength = i + 1;
            jaggedArray[i] = new int[rowLength];

            for (int j = 0; j < rowLength; j++) {
                int value = (i + 1) * (j + 1);
                jaggedArray[i][j] = value;
            }
        }
        return jaggedArray;
    }
}
