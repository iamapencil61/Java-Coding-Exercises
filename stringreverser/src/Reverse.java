class Reverse {
    public static String reverse(String s) {

        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed = reversed + s.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));

        System.out.println(reverse("world"));
        System.out.println(reverse("Emre"));
    }
}