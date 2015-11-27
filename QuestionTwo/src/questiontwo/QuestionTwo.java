/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questiontwo;

import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author st_morr
 */
public class QuestionTwo {
    Scanner sc;
    int[] in;
    
    
    public QuestionTwo(){
        
    }
    
    
    
    public void perform(){
        
        in = new int[5];
        
        for (int i = 0; i < 5; i++){
            in[i] = getNumber();
        }
        
        System.out.println("List is in order?" + " | " + isSorted(in));
        
    }
    
    public boolean isSorted(int[] list){
        
      int maxValue = list[0];
      int minValue = list[0];
      
      for(int i=0;i < list.length;i++){  
            if(list[i] > maxValue){  
                maxValue = list[i];  
            }
            if(list[i] < minValue){
                minValue = list[i];
            }
      }
      
      if (maxValue == list[0] && minValue == list[list.length-1]){
          return true;
      } else{
          return false;
      }
    }
    
    
    public int getNumber(){
        int num1;
        sc = new Scanner(System.in);
        System.out.println("Please enter an Integer: ");
        if (sc.hasNextInt()){
            num1 = sc.nextInt();
        } else num1 = -1;
        sc.nextLine();
        
        while(num1 < 0){
            System.out.println("Please enter a valid Int: ");
            if (sc.hasNextInt()){
                num1 = sc.nextInt();
            }
        }
        
        return num1;
        
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QuestionTwo q2 = new QuestionTwo();
        q2.perform();
    }
    
}
