import java.util.Arrays;

class IsSplitable {
    public static boolean isSplitable(int[] a) {
        if (a == null || a.length < 2) {
            return false;
        }

        int total = Arrays.stream(a).sum();

        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;

        return canMake(a, target, 0);


    }

    public static boolean canMake(int[] a, int target, int index) {
        if (target == 0) {
            return true;
        }
        if (index == a.length || target < 0) {
            return false;
        }

        int current = a[index];

        boolean take = canMake(a, target - current, index + 1);

        if (take) {
            return true;
        }

        boolean skip = canMake(a, target, index + 1);

        return skip;
    }
}