class Merge {
    public static int[] merge(int[] a1, int[] a2) {
        return helper(a1, 0, a2, 0);
    }

    public static int[] helper(int[] a1, int i, int[] a2, int j) {

        if (i == a1.length) {
            int[] result = new int[a2.length - j];
            System.arraycopy(a2, j, result, 0, result.length);
            return result;
        }

        if (j == a2.length) {
            int[] result = new int[a1.length - i];
            System.arraycopy(a1, i, result, 0, result.length);
            return result;
        }

        if (a1[i] <= a2[j]) {
            int[] rest = helper(a1, i + 1, a2, j);
            int[] merged = new int[rest.length + 1];
            merged[0] = a1[i];
            System.arraycopy(rest, 0, merged, 1, rest.length);
            return merged;
        } else {
            int[] rest = helper(a1, i, a2, j + 1);
            int[] merged = new int[rest.length + 1];
            merged[0] = a2[j];
            System.arraycopy(rest, 0, merged, 1, rest.length);
            return merged;
        }

    }
}