
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThreadExample {

    public static void main(String[] args) {
        // Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable printC = new PrintChar('C', 100);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(printC);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// The task for printing a specified character in specified times
class PrintChar implements Runnable {

    private char charToPrint; // The character to print
    private int times; // The times to repeat

    /**
     * Construct a task with specified character and number of times to print
     * the character
     */

    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    /**
     * Override the run() method to tell the system what the task to perform
     */

    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
            if (i > 50){
                try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintChar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
        }
    }
}



