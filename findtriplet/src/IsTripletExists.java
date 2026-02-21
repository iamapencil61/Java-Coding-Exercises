import java.util.Arrays;

class IsTripletExists {
    public static boolean isTripletExists(int[] arr, int k) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int target = k - arr[i];

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == target) {
                    return true;
                }
                else if (sum < target) {
                    left += 1;
                }
                else {
                    right -= 1;
                }
            }
        }
        return false;
    }
}