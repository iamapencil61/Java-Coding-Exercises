class MulWord {
    public static String mulWord(String s, int n) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(s);
        }

        return builder.toString();
    }
}