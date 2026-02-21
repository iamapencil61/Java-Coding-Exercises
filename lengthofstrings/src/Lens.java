class Lens {
    public static int[] lens(String[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length();
            result[i] = len;
        }
        return result;
    }
}