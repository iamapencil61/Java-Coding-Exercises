class Fact {
    public static int fact(int num) {
        if (num == 0 || num == 1) return 1;

        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}