/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class13;

/**
 *
 * @author st_morr
 */
public class Class13 {
    int sum = 0;
    int max = 0;
    int maxElement = 0;
    
    public void perform(){
        int[] myList = new int[10];
        
        for (int i = 0; i < myList.length; i++){
            
            myList[i] = (int)(Math.random() * 10);
            sum += myList[i];
            System.out.println(myList[i] + "");
            if (myList[i] > max){
                max = myList[i];
                maxElement = i;
            }
        }
        System.out.println("Sum is: " + sum);
        System.out.println("Max is: " + max);
        System.out.println("Largest element is: " + maxElement);
        
        
        int temp = 0;
        temp = myList[0];
        for (int i = 0; i < 9; i++){
            if (myList[i] == myList.length){
                    myList[i] = temp;
                }
            myList[i] = myList[i + 1];
                
            
        }
        myList[myList.length-1]=temp;
        
        
    }


public static void main(String[] args){
Class13 classPerform = new Class13();
classPerform.perform();
}
}