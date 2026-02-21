import java.util.HashMap;
import java.util.Map;

class IsInterleaving {
    public static boolean isInterleaving(String s1, String s2, String s3) {

        if (s1.length() != s2.length() + s3.length()) {
            return false;
        }

        Map<String, Boolean> memo = new HashMap<>();

        return helper(0, 0, s1, s2, s3, memo);
    }

    public static boolean helper(int i, int j, String s1, String s2, String s3, Map<String, Boolean> memo) {
        int k = i + j;

        if (k == s1.length()) {
            return true;
        }

        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean canTakeFromS2 = false;
        boolean canTakeFromS3 = false;

        if (i < s2.length() && s2.charAt(i) == s1.charAt(k)) {
            canTakeFromS2 = helper(i + 1, j, s1, s2, s3, memo);
        }

        if (j < s3.length() && s3.charAt(j) == s1.charAt(k)) {
            canTakeFromS3 = helper(i, j + 1, s1, s2, s3, memo);
        }

        boolean answer = canTakeFromS2 || canTakeFromS3;
        memo.put(key, answer);
        return answer;
    }
}