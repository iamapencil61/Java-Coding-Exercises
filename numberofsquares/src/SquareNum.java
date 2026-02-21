import java.util.HashMap;
import java.util.Map;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

class SquareNum {
    public static int squareNum(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(n, memo);
    }

    public static int helper(int n, Map<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int best = n;

        int limit = (int) sqrt(n);

        for (int k = 1; k <= limit; k++) {
            int square = k * k;
            int result = 1 + helper(n - square, memo);
            best = Math.min(best, result);
        }
        memo.put(n, best);
        return best;
    }
}