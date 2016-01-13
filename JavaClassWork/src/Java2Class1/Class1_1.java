/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ST_MORR
 */
public class Class1_1 {
    
    private int usrInput;
    private Scanner sc;
    public int temp;
    private int pCount;
    private int nCount;
    private int total;
    private int count;
    public Class1_1(){
        super();
    }
    
    public void perform(){
        //ArrayList<Integer> nums = new ArrayList();
        sc = new Scanner(System.in);
        
        System.out.println("Please enter Integers: ");
        usrInput = sc.nextInt();
        while (usrInput != 0){
            
            if (usrInput > 0){
                pCount++;
            }
            else if (usrInput < 0){
                nCount++;
            }
            
            total+=usrInput;
            count++;
            usrInput = sc.nextInt();
        }
        if (count == 0){
            System.out.println("only 0 entered");
        }
        else{
        System.out.println("Number of Positives: " + pCount + "\n"+
                            "Number of Negatives: " + nCount + "\n"+
                            "Total: " + total +"\n"+
                            "Average: " + total * 1.0 / (pCount+nCount));
        
        
         //for (int i = 0; i < nums.size()-1; i++){
        }
        
    }
    
    
    
public static void main(String[] args){
    Class1_1 classPerform = new Class1_1();
    classPerform.perform();
    System.exit(0);
}
    
}
