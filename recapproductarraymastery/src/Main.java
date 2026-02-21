public class Main {
    public static void main(String[] args) {
        // Don't modify these arrays!
        boolean[] signal_A = {false, false, true, true};
        boolean[] signal_B = {false, true, false, true};

        // Calculate outputs for each combination
        boolean[] output1 = new boolean[4];  // A && B
        boolean[] output2 = new boolean[4];  // A || B
        boolean[] output3 = new boolean[4];  // !A && B
        boolean[] output4 = new boolean[4];  // !(A || B)
        boolean[] output5 = new boolean[4];  // !A || !B

        // Fill in the truth tables
        for (int i = 0; i < 4; i++) {
            output1[i] = signal_A[i] && signal_B[i];
            output2[i] = signal_A[i] || signal_B[i];
            output3[i] = !signal_A[i] && signal_B[i];
            output4[i] = !(signal_A[i] || signal_B[i]);
            output5[i] = (!signal_A[i]) || (!signal_B[i]);
        }

        // Don't modify the code below
        System.out.println("Truth Table Results:");
        System.out.println("-------------------");
        System.out.println("A\tB\tA&&B\tA||B\t!A&&B\t!(A||B)\t!A||!B");
        for (int i = 0; i < 4; i++) {
            System.out.println(signal_A[i] + "\t" + signal_B[i] + "\t" +
                    output1[i] + "\t" + output2[i] + "\t" +
                    output3[i] + "\t" + output4[i] + "\t" +
                    output5[i]);
        }
    }
}