/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankproject;

import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class Menu {
    String choice1;
    String choice2;
    String choice3;
    Scanner sc = new Scanner(System.in);
    
    
    //Get User Input
    
    public String getInputMain(){
        System.out.println("Wecome to the banking system. Please make your selection:\n A: Savings\n B:Checking\n C: Exit");
        
        if (sc.hasNext("[ABC]")){
            choice1 = sc.next();
        }
        else choice1 = "ZXC";
        
        while(choice1.equals("ZXC")){
            System.out.println("Please enter a valid Choice");
            if (sc.hasNext("[ABC]")){
                choice1 = sc.next();
            }
            else choice1 = "ZXC";
        }
        return "";
    }
    
    public String getInputSavings(){
        System.out.println("Savings Menu. Please make your selection:\n A: Deposit\n B: Withdrawal\n C: Report\n D: Return to Bank Menu");
        
        if (sc.hasNext("[ABC]")){
            choice2 = sc.next();
        }
        else choice2 = "ZXC";
        
        while(choice2.equals("ZXC")){
            System.out.println("Please enter a valid Choice");
            if (sc.hasNext("[ABC]")){
                choice2 = sc.next();
            }
            else choice2 = "ZXC";
        }
        return "";
    }
    
    public String getInputChecking(){
        System.out.println("Checking Menu. Please make your selection:\n A: Deposit\n B: Withdrawal\n C: Report\n D: Return to Bank Menu");
        
        if (sc.hasNext("[ABC]")){
            choice3 = sc.next();
        }
        else choice3 = "ZXC";
        
        while(choice3.equals("ZXC")){
            System.out.println("Please enter a valid Choice");
            if (sc.hasNext("[ABC]")){
                choice3 = sc.next();
            }
            else choice3 = "ZXC";
        }
        
        switch (choice3){
            case "A":
                System.out.println("Please enter an amount to Deposit: ");
                double caseA = sc.nextDouble();
                break;
            case "B":
                System.out.println("Please enter an amount to Withdraw: ");
                double caseB = sc.nextDouble();
                break;
            case "C":
                System.out.println("");
                
        }
        
    }
    
    
    
    
    
    
}
