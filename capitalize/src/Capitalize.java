class Capitalize {
    public static String capitalize(String s) {

        if (s == null) {
            return null;
        }

        String[] words = s.split(" ");

        String result = "";
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }

            String first = String.valueOf(word.charAt(0));
            first = first.toUpperCase();

            String rest = word.substring(1);
            String capitalized = first + rest;

            result = result + capitalized + " ";
        }

        result = result.trim();
        return result;
    }
}