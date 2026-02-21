class Convert {
    public static int[] convert(int n) {

        String str = String.valueOf(n);
        if (str.startsWith("-")) {
            str = str.substring(1);
        }

        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Character.getNumericValue(str.charAt(i));
        }
        return result;
    }
}