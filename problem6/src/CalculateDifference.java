public class CalculateDifference {

    public static long calculateDifference(long limit) {
        long sum = 0;

        long sumOfSquares = 0;

        long i;

        for (i = 1; i <= limit; i++) {
            sum += i;
            sumOfSquares += i * i;
        }

        long squareOfSum = sum * sum;

        long result = squareOfSum - sumOfSquares;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculateDifference(100));
    }
}
