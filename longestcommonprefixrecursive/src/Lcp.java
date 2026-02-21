import static java.lang.Math.min;

class Lcp {
    public static String lcp(String[] a) {
        if (a.length == 0) {
            return "";
        }
        return helper(a, 1, a[0]);


    }

    public static String helper(String[] a, int index, String prefix) {
        if (index == a.length) {
            return prefix;
        }

        String current = a[index];
        String temp = "";

        int limit = min(current.length(), prefix.length());

        for (int i = 0; i < limit; i++) {
            if (current.charAt(i) == prefix.charAt(i)) {
                temp += current.charAt(i);
            }
            else {
                break;
            }
        }

        if (temp.isEmpty()) {
            return "";
        }

        return helper(a, index + 1, temp);
    }
}