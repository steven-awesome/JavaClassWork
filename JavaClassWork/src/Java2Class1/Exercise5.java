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
public class Exercise5 {
    
    private int usrInput;
    private Scanner sc;
    private int[][] array;
    
    
    public Exercise5(){
        super();
    }
    //===============Perform method where it all comes together=====================
    public void perform(){
        System.out.println("two single digit integers: ");
        int usr1 = getInput();
        int usr2 = getInput();
        array = new int[usr1][usr2];
        randomizeArray();
        System.out.println(sumElements(array));
        System.out.println(Arrays.deepToString(array));
    }
    
    
    //==================Methods that perform tasks in Perform method================
    
    public int getInput(){
        sc = new Scanner(System.in);
        usrInput = sc.nextInt();
        return usrInput;
    }
    
    public void randomizeArray(){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = (int) (Math.random() * 100);
            }
        }
    }
    
    public int sumElements(int[][] arrayTemp){
        int total = 0;
        for (int i = 0; i < arrayTemp.length; i++){
            for (int j = 0; j < arrayTemp[i].length; j++){
                total += arrayTemp[i][j];
            }
        }
        return total;
    }
    
    
    
    //==============Main method================
    public static void main(String[] args){
        Exercise5 Test = new Exercise5();
        Test.perform();
        System.exit(0);
    }
    
}
