public class Main {
    public static void values(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        values(numbers);
    }
}