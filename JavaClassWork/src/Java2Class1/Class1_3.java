/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ST_MORR
 */
public class Class1_3 {
    private int usrInput;
    private Scanner sc;
    private static String s;
    public int temp;
    public int[] arList;
    
    
    public Class1_3(){
        super();
    }
    
    public void perform(){
        sc = new Scanner(System.in);
        System.out.println("Please enter 10 Integers between 0 and 9: ");
        arList = new int[10];
        
        for (int i = 0; i < 10; i++){
            usrInput = sc.nextInt();
            arList[i-1] = usrInput;
        }
        
        eliminateDuplicates(arList);
    }

    public static int[] eliminateDuplicates(int[] list){
        int[] tempArray = new int[10];
        
        for (int i = 0; i < list.length-1; i++){
            tempArray[i] = 
            
            for (int j : list){
               
                if (list[i] == list[j] && i != j){
                    tempArray
                }
            }
        }
    }
    
    
    public static void main(String[] args){
        Class1_3 Test = new Class1_3();
        Test.perform();
        System.exit(0);
    }
}
