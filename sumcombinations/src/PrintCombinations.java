import java.util.List;

class PrintCombinations {
    public static void printCombinations(int num) {
        List<Integer> path = new java.util.ArrayList<>();
        backtrack(num, path);
    }

    public static void backtrack(int remaining, List<Integer> path) {
        if (remaining == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) {
                    sb.append(" ");
                }
                sb.append(path.get(i));
            }
            System.out.println(sb.toString());
            return;
        }

        if (remaining < 0) {
            return;
        }

        for (int i = remaining; i >= 1; i--) {
            path.add(i);
            backtrack(remaining - i, path);
            path.remove(path.size() - 1);

        }
    }
}