class RepeatedSubseq {
    public static String repeatedSubseq(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        int i;
        int j;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                dp[i][j] = (s.charAt(i - 1) == s.charAt(j - 1) && i != j) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        if (dp[n][n] < 2) {
            return "";
        }
        i = n;
        j = n;

        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s.charAt(i-1) == s.charAt(j-1) && i != j  && dp[i][j] == dp[i-1][j-1] + 1) {
                sb.append(s.charAt(i - 1));
                i -= 1;
                j -= 1;
            } else {
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i = i - 1;
                } else {
                    j = j - 1;
                }
            }
        }
        return sb.reverse().toString();
    }
}