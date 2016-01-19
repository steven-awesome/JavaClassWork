package Java2Class2;

// Code is organized into directories called packages
// The first line of a file must declare the package this 
// class belongs to




/**
 * 
 *
 * 
 */
public class Exercise6 {

    // class variables go here
    // should always be private
    // Students' answers to the questions
    private char[][] answers = {
      {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
      {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
      {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
      {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
      {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

    // Key to the questions
    private char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};

    
    /**
     * Constructor for now just make sure you have one that looks like this
     */
    public Exercise6() {
        super();
    }
    
    /**
     * Here is out work area for now
     */
    public void perform() {
       // Grade all answers
        for (int i = 0; i < answers.length; i++) {
          // Grade one student
          int correctCount = 0;
          for (int j = 0; j < answers[i].length; j++) {
            if (answers[i][j] == keys[j])
              correctCount++;
          }

          System.out.println("Student " + i + "'s correct count is " +
            correctCount);
        }
 
                
    }
    
    /**
     * The main method is where a program starts. While you can write any code
     * that you want in the main method you should not. This method just gets
     * the ball rolling and waits for the program to end.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Instantiate the first or primary object
        Exercise6 myApp = new Exercise6();
        // Call the method that runs the show
        myApp.perform();
        // End the program
        System.exit(0);
    }
}
