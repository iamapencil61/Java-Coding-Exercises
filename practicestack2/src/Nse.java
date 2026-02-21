import structures.Stack;

class Nse {
    public static int[] nse(int[] a) {
        if (a == null) {
            return null;
        }

        int n = a.length;
        int[] result = new int[n];

        Stack stack = new Stack();
        int current = 0;
        for (int i = 0; i < n; i++) {
            current = a[i];

            while (!stack.empty() && stack.top() >= current) {
                stack.pop();
            }

            if (stack.empty()) {
                result[i] = -1;
            } else {
                result[i] = stack.top();
            }
            stack.push(current);
        }
        return result;
    }
}