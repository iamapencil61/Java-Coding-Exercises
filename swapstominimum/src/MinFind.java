class MinFind {
    static String best;
    public static int minFind(int num, int k) {
        String s = Integer.toString(num);
        char[] chars = s.toCharArray();
        best = s;
        dfs(chars, k, 0);
        return Integer.parseInt(best);
    }

    private static void dfs(char[] chars, int k, int index) {

        String current = new String(chars);
        if (current.compareTo(best) < 0) {
            best = current;
        }

        if (k == 0 || index == chars.length) {
            return;
        }

        char minDigit = chars[index];

        for (int p = index; p < chars.length; p++) {
            if (chars[p] < minDigit) {
                minDigit = chars[p];
            }
        }
        if (minDigit == chars[index]) {
            dfs(chars, k, index + 1);
            return;
        }
        for (int p = chars.length - 1; p >= index + 1; p--) {
            if (chars[p] == minDigit) {
                swap(chars, index, p);

                dfs(chars, k-1, index+1);

                swap(chars, index, p);

            }
        }
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}