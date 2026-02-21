public class Main {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = false;

        boolean b4 = b1 && b2 && (!b3);
        System.out.println("b4 = " + b4);
    }
}
