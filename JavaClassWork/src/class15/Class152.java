/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class15;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author st_morr
 */
public class Class152 {
    Scanner sc = new Scanner(System.in);
    int usr1 = 0;
    int usr2 = 0;
    
     public void perform(){
         testMethod();
         System.out.println(usr1 + " " + usr2);
         
        
    }
    
       public void testMethod(){
        System.out.println("Enter 2 Ints: ");
        
        while(true){
        try{
            usr1 = sc.nextInt();
            usr2 = sc.nextInt();
            break;
        }
        catch(Exception e){
            System.out.println("Invalid, please enter Ints again: ");
            sc.nextLine();
        }
        }
        
        
        }
       
       
       
    public static void main (String[] args){
        Class152 Test = new Class152();
        Test.perform();
    }
}
