public class TestStrength {
    public static void main(String[] args) {
        test("1234567@", "Weak"); // len 8, special 1 -> Weak
        test("123456789012@", "Weak"); // len 13, special 1 -> Weak
        test("123456789012@@", "Medium"); // len 14, special 2 -> Medium
        test("1234567890123456@@", "Medium"); // len 18, special 2 -> Medium
        test("1234567890123456@@@", "Strong"); // len 19, special 3 -> Strong
        test("abc", "Weak"); // default
    }

    private static void test(String p, String expected) {
        String result = Main.getPasswordStrength(p);
        if (result.equals(expected)) {
            System.out.println("PASS: " + p + " -> " + result);
        } else {
            System.out.println("FAIL: " + p + " -> Expected " + expected + " but got " + result);
        }
    }
}
