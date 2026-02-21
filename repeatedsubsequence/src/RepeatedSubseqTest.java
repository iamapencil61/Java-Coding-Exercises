import java.util.Objects;

public class RepeatedSubseqTest {
    public static void main(String[] args) {
        test("AABEBCDD", "ABD");
        test("aabb", "ab");
        test("abc", "");
        test("aaaa", "aaa");
        test("aab", ""); // based on < 2 check in original code
    }

    private static void test(String input, String expected) {
        String result = RepeatedSubseq.repeatedSubseq(input);
        if (Objects.equals(result, expected)) {
            System.out.println("[DEBUG_LOG] TEST PASSED: input='" + input + "', expected='" + expected + "', result='" + result + "'");
        } else {
            System.out.println("[DEBUG_LOG] TEST FAILED: input='" + input + "', expected='" + expected + "', result='" + result + "'");
        }
    }
}
