
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amin Ranj Bar
 */
public class Exercise3 {

   // class variables go here
    // should always be private
    private Scanner input;
    private int[] numbers = new int[10];

    
    /**
     * Constructor for now just make sure you have one that looks like this
     */
    public Exercise3() {
        super();
    }

    
    // here getting all the input
    
    public void gettingInput(){
        input = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");

        for (int i = 0; i < numbers.length; i++) {
          // Read and store numbers in an array if it is new
          numbers[i] = input.nextInt();
        }

    }
    /**
     * Here is out work area for now
     */
    
    public static int[] eliminateDuplicates(int[] numbers) {  
        int[] temp = new int[numbers.length];
        int size = 0;
        for (int i = 0; i < numbers.length; i++) {         
          boolean isInArray = false;
          for (int j = 0; j < i && !isInArray; j++)
            if (numbers[j] == numbers[i]) {
              isInArray = true;
            }

          if (!isInArray) {
            temp[size] = numbers[i];
            size++;
          }
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++) 
          result[i] =temp[i];

        return result;
  }


    
    public void perform() {
       gettingInput();
       int[] result = eliminateDuplicates(numbers);
    
        System.out.println(
          "The number of distinct values is " + result.length);
        for (int i = 0; i < result.length; i++)
          System.out.print(result[i] + " ");
             
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
        Exercise3 e3 = new Exercise3();
        // Call the method that runs the show
        e3.perform();
        // End the program
        System.exit(0);
    }
    
}






