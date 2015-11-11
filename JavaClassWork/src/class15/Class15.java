/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class15;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeRegExp.test;

/**
 *
 * @author st_morr
 */
public class Class15 {
    double m = Math.random() * 100;
    Scanner sc = new Scanner(System.in);
    double[] arrayTest = new double[100];
    int usr1 = 0;
    int usr2 = 0;
    

     public void perform(){
         
        
        
        for(int i = 0; i <arrayTest.length; i++){
           
            arrayTest[i] = (Math.random() * 100);
        }
        
        
        testMethod();
        
        
    }
    
       public void testMethod(){
        
           
        
           System.out.println("Please enter Array index: ");
           
           while(true){
                try{
                     usr1 = sc.nextInt();
                     System.out.println(arrayTest[usr1] + " " + arrayTest[usr2]);
                     break;
                }
                catch(ArrayIndexOutOfBoundsException e){
                     System.out.println("Invalid, please enter Array Indes again: ");
                   //  e.printStackTrace();
                }
                catch(Exception e){
                     System.out.println("Generic error");
                }
                sc.nextLine();
           }

        }
       
       
       
    public static void main (String[] args){
        Class15 Test = new Class15();
        Test.perform();
    }
        
    }