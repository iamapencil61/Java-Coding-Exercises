package exercises;

import structures.Stack;

class Reverse {
    public static int[] reverse(int[] a) {

        Stack stack = new Stack();

        for (int x : a) {
            stack.push(x);
        }

        int[] result = new int[a.length];
        int index = 0;

        while (!stack.empty()) {
            result[index] = stack.pop();
            index++;
        }

        return result;
    }
}