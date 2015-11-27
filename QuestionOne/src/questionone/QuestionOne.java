/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionone;

import java.util.Scanner;

/**
 *
 * @author st_morr
 */
public class QuestionOne {
    Scanner sc;
    
    public QuestionOne(){
        
    }
    
    
    
    
    public void perform(){
        int num;
        
        System.out.println("Please enter a String: ");
        
        String s1 = getInput();
        System.out.println("Please enter a character: ");
        char c1 = getInput().charAt(0);
        num = count(s1, c1);
        
        System.out.println("Character was entered "+num+" times");
    }
    
    
    
    
    public int count (String str, char a){
        int numOfOccur = 0;
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) == a){
                numOfOccur++;
            }
        }
        return numOfOccur;
    }
    
    public String getInput() {
        sc = new Scanner(System.in);
        String usrInput;
        if (sc.hasNext()){
            usrInput = sc.next();
        }
        else usrInput = "ZXC";
        sc.nextLine();

        //ZXC is just garbage input for the loop
        while(usrInput.equals("ZXC")){
            System.out.println("Please enter a valid Choice");
            if (sc.hasNext()){
                usrInput = sc.next();
            }
            else usrInput = "ZXC";
            sc.nextLine();
        }
        return usrInput;
    }
    
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QuestionOne q1 = new QuestionOne();
        q1.perform( );
    }
    
}
