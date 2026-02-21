package structures;

class IsPalindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int n = s.length();

        Stack stack = new Stack();

        for (int i = 0; i < n / 2; i++) {
            stack.push(s.charAt(i));
        }

        int start = n / 2;
        if (n % 2 == 1) {
            start += 1;
        }
        for (int i = start; i < n; i++) {
            if (stack.empty()) {
                return false;
            }
            int popped = stack.pop();

            if (popped != s.charAt(i)) {
                return false;
            }
        }
        return stack.empty();
    }
}