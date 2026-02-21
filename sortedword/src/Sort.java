import java.util.Arrays;

class Sort {
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        String result = new String(chars);

        return result;
    }
}