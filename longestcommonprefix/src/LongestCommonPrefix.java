class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] a) {
        return longestCommonPrefix(a, 0);
    }

    public static String longestCommonPrefix(String[] a, int index) {
        if (a == null || a.length == 0) return "";
        if (index >= a.length) return "";
        if (index == a.length - 1) return a[index];

        String nextPrefix = longestCommonPrefix(a, index + 1);

        String current = a[index];
        String temp = "";

        int limit = Math.min(current.length(), nextPrefix.length());

        for (int i = 0; i < limit; i++) {
            if (current.charAt(i) == nextPrefix.charAt(i)) {
                temp += current.charAt(i);
            }
            else {
                break;
            }

        }
        return temp;
    }
}