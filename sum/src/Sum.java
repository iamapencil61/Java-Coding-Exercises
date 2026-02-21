class Sum {
    public int calc(int a, int b) {
        return a + b;
    }

    public int calc(int a, int b, int c) {
        return a + b + c;
    }

    public int calc(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public int calc(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    public int calc(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }

    public int calc(int a, int b, int c, int d, int e, int f) {
        return a + b + c + d + e + f;
    }

    public int calc(int a, int b, int c, int d, int e, int f, int g) {
        return a + b + c + d + e + f + g;
    }

    public int calc(int a, int b, int c, int d, int e, int f, int g, int h) {
        return a + b + c + d + e + f + g + h;
    }

    static void main(String[] args) {
        Sum sum = new Sum();
        System.out.println(sum.calc(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(sum.calc(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(sum.calc(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(sum.calc(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        System.out.println(sum.calc(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    }
}
