import java.util.HashMap;
import java.util.Map;

class Test {
    public static boolean test(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        Map<String, Boolean> memo = new HashMap<>();
        return match(0, 0, s, p, memo);
    }

    private static boolean match(int i, int j, String s, String p, Map<String, Boolean> memo) {
        String key = i + "," + j;
        boolean ans;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (j == p.length()) {
            ans = (i == s.length());
            memo.put(key, ans);
            return ans;
        }

        char pc = p.charAt(j);
        ans = false;

        if (pc == '.') {
            if (i < s.length() && isAllowed(s.charAt(i))) {
                ans = match(i + 1, j + 1, s, p, memo);
            } else {
                ans = false;
            }
        } else if (pc == '*') {
            if (i < s.length() && isAllowed(s.charAt(i))) {
                boolean optionA = match(i + 1, j, s, p, memo);
                boolean optionB = match(i + 1, j + 1, s, p, memo);
                ans = optionA || optionB;
            } else {
                ans = false;
            }
        } else if (pc == '?') {
            ans = match(i, j + 1, s, p, memo);
            if (!ans && i < s.length() && isAllowed(s.charAt(i))) {
                ans = match(i + 1, j, s, p, memo);
            }
        } else {
            if (i < s.length() && s.charAt(i) == pc) {
                ans = match(i + 1, j + 1, s, p, memo);
            } else {
                ans = false;
            }
        }

        memo.put(key, ans);
        return ans;
    }

    private static boolean isAllowed(char c) {
        return Character.isLetterOrDigit(c) || c == ' ';
    }
}