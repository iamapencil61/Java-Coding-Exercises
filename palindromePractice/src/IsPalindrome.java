class IsPalindrome {
    public static boolean isPalindrome(int num) {
        String str = Integer.toString(num);

        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        if (reversed.equals(str)) {
            return true;
        }
        else {
            return false;
        }
    }
}