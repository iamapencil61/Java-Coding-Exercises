class FindIndex {
    public static int findIndex(String s, char c) {
        return helper(s, c, 0);
    }

    public static int helper(String s, char c, int index) {

        if (index == s.length()) return -1;
        if (s.charAt(index) == c) return index;

        return helper(s, c, index + 1);
    }
}