public class TestRunner {
    public static void main(String[] args) {
        test("abc", "abc", true);
        test("abc", "a.c", true);
        test("abc", "a*c", true); // Matches 'b'
        test("abc", "a?c", true); // Matches 'b' or empty, here matches 'b'
        test("abc", "ab", false);
        test("abc", "abcd", false);
        test("a b1", "a.b.", true);
        test("a b1", "a*1", true); // Matches ' b'
        test("a b1", "a?1", true); // Matches ' b'
        test("a!b", "a.b", false); // '!' is not allowed
        test("abc", "a.c", true);
        test("", "*", false); // * is now 1+
        test("", "?", true);  // ? is still 0+
        test(" ", ".", true);
        test("123", "...", true);
        test("abc", "a*bc", false); // * is 1+, cannot match empty between 'a' and 'b'
        test("abc", "a?bc", true);  // ? is 0+, can match empty

        // New test cases from issue description
        test("My name is Jake", "My name is *", true);
        test("Your...", "My name is *", false);
        test("Maximum", "M..imum", true);
        test("Mimum", "M?imum", true);
        test("Minimum", "K?imum", false);
        
        System.out.println("All tests completed.");
    }

    private static void test(String s, String p, boolean expected) {
        boolean result = Test.test(s, p);
        if (result == expected) {
            System.out.println("PASS: s=\"" + s + "\", p=\"" + p + "\" -> " + result);
        } else {
            System.err.println("FAIL: s=\"" + s + "\", p=\"" + p + "\" -> expected " + expected + ", got " + result);
        }
    }
}
