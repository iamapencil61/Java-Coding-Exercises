class Fact {
    public static int fact(int num) {
        if (num == 0 || num == 1) return 1;

        int small = fact(num - 1);

        int result = num * small;

        return result;
    }
}