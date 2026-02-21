class Min {
    public static int min(int[] arr) {
        int minimum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        return minimum;
    }
}