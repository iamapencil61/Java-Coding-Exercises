class Rotate {
    public static int[] rotate(int[] arr) {
        int[] result = new int[arr.length];

        result[0] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            result[i] = arr[i - 1];
        }
        return result;
    }
}