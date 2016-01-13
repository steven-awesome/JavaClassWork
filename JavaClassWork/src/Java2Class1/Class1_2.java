/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class1;

import java.util.Scanner;

/**
 *
 * @author ST_MORR
 */
public class Class1_2 {
    private int usrInput;
    private Scanner sc;
    private static String s;
    public static int temp;
    
    
    public Class1_2(){
        super();
    }
    
    public void perform(){
        sc = new Scanner(System.in);
        System.out.println("Please enter an integer: ");
        usrInput = sc.nextInt();
        
        System.out.println("Total of digits is: " + sumDigits(usrInput));
    }
    
    public static int sumDigits(long n){
        temp = 0;
        while (n != 0){
            temp +=  n%10;
            n /= (int) 10;
        }
        return temp;
    }

    
    
    
public static void main(String[] args){
    Class1_2 Test = new Class1_2();
    Test.perform();
    System.exit(0);
}
}
