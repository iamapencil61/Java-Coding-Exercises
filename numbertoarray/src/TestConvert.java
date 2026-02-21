public class TestConvert {
    public static void main(String[] args) {
        test(123, new int[]{1, 2, 3});
        test(0, new int[]{0});
        test(-123, new int[]{1, 2, 3});
        test(-456, new int[]{4, 5, 6});
        test(Integer.MIN_VALUE, new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 8});
    }

    private static void test(int n, int[] expected) {
        try {
            int[] result = Convert.convert(n);
            if (java.util.Arrays.equals(result, expected)) {
                System.out.println("PASS: " + n);
            } else {
                System.out.println("FAIL: " + n + ". Expected " + java.util.Arrays.toString(expected) + " but got " + java.util.Arrays.toString(result));
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + n + ". " + e.getMessage());
        }
    }
}
