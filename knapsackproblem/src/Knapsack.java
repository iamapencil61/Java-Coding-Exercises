class Knapsack {
    public static int knapsack(int W, int[] values, int[] weights) {
        return helper(W, values, weights, 0);
    }

    public static int helper(int W, int[] values, int[] weights, int index) {
        if (index == values.length) return 0;
        if (weights[index] > W) return helper(W, values, weights, index + 1);

        int takeValue = values[index] + helper(W - weights[index], values, weights, index + 1);
        int skipValue = helper(W, values, weights, index + 1);

        return Math.max(takeValue, skipValue);
    }
}