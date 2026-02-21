class Alternate {
    public static int[] alternate(int[] a1, int[] a2) {

        int resultLength = a1.length + a2.length;
        int[] result = new int[resultLength];

        int k = 0;

        for (int i = 0; i < a1.length; i++) {
            result[k] = a1[i];
            k++;

            result[k] = a2[i];
            k++;
        }

        return result;
    }
}