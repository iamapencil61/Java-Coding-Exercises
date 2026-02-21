class Max {
    public static int max(int a, int b) {

        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        System.out.println(Max.max(132, 154));  // 154
        System.out.println(Max.max(-5, 3));     // 3
        System.out.println(Max.max(100, 100));  // 100

    }
}