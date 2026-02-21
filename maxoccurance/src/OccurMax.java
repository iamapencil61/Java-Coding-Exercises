import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.MIN_VALUE;

class OccurMax {
    public static int occurMax(int[] a) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : a) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }
        int maxCount = MIN_VALUE;
        int result = a[0];

        for (int num : a) {
            int count = freq.get(num);

            if (count > maxCount) {
                maxCount = count;
                result = num;
            }
        }

        return result;
    }
}