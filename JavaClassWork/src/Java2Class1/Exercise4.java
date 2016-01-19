/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author fista
 */
public class Exercise4 {
    
    private int usrInput;
    private Scanner sc;
    private int[] numbers = new int[5];
    private int[] numbers2 = new int[5];
    
    
    public Exercise4(){
        super();
    }
    
    public void perform(){
        System.out.println("Please enter 5 Integers between 0 and 9: ");
        getInput();
        System.out.println("Please enter another 5 Integers between 0 and 9: ");
        getInput();
        System.err.println("Are they equal? " + equals(numbers, numbers2));
    }
    
    public void getInput(){
        sc = new Scanner(System.in);
        
        for (int i = 0; i < numbers.length; i++) {
          // Read and store numbers in an array if it is new
          numbers[i] = sc.nextInt();
        }
    }
    
    public static boolean equals(int[] list1, int[] list2){
        
        Arrays.sort(list1);
        Arrays.sort(list2);
        
        if (list1.length != list2.length){
            return false;
        }
        
        for (int i = 0; i < list1.length; i++){
            if (list1[i] != list2[i]){
                return false;
            }
        }
        
        return true;
    }
    
    

    
    
    public static void main(String[] args){
        Exercise4 Test = new Exercise4();
        Test.perform();
        System.exit(0);
    }
    
}
