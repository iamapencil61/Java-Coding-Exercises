
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestPrintCombinations {
    public static void main(String[] args) {
        System.out.println("Testing PrintCombinations with num = 3...");
        
        // Use a separate thread to handle the potential infinite loop
        Thread thread = new Thread(() -> {
            try {
                PrintCombinations.printCombinations(3);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        });
        
        thread.start();
        
        try {
            thread.join(2000); // Wait for 2 seconds
            if (thread.isAlive()) {
                System.err.println("FAILURE: Code is stuck in an infinite loop!");
                thread.interrupt();
                System.exit(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Test finished (check output manually if needed, but it currently prints nothing).");
    }
}
