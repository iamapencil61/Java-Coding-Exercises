class Remove {
    public static String remove(String str, int i) {

        if (i < 0 || i >= str.length()) {
            return str;
        }

        String part1 = str.substring(0, i);
        String part2 = str.substring(i + 1);

        String result = part1 + part2;

        return result;
    }
}