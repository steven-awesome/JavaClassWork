/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasswork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author st_morr
 */
public class JavaClassWork {
    Scanner sc;
    ArrayList<Integer> intx;
    
    
    
    
    public void perform(){
        int ee=0;
        intx = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++ ){
            intx.add(getInput());
            ee = Collections.max(intx);
            System.out.println(intx.get(i));
        }
        
        System.out.println(ee);
    }
    
    
    
    
    
    
    public int getInput(){
        System.out.println("Please enter a String");
        sc = new Scanner(System.in);
        int usrInput = 0;
        
        if (sc.hasNextInt()){
            usrInput = sc.nextInt();
        }
        else while(true){
            System.out.println("Please enter a valid Int");
            if (sc.hasNextInt()){
                usrInput = sc.nextInt();
                break;
            }
            sc.nextLine();
        }
        sc.nextLine();
        
        return usrInput;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JavaClassWork jcw = new JavaClassWork();
        jcw.perform();
    }
    
}
