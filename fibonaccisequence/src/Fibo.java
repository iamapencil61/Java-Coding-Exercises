class Fibo {
    public static int fibo(int i) {
        if (i == 0) {
            return 0;
        }

        if (i == 1) {
            return 1;
        }

        int left = fibo(i - 1);
        int right = fibo(i - 2);

        int result = left + right;
        return result;
    }
}