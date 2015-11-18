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
    Scanner sc = new Scanner(System.in);
    //Set starting balance to 0 for both Savings an Checking, and interest rates are 2 and 3 respectively.
    Savings sav = new Savings(0,2);
    Checking chk = new Checking(0,3);
    //All the options call their own menuMethods, and switch cases are used to try to make things easier to read. 
    //Left out default constructor as a default one will be automatically created.
    
    public void systemMenu(){

        //Case "D" was included because the getInput validation includes "D", and its easier to include an extra case than write a new if statement
        //to deal with each method separately with their own getInput.
        while (true) {
            System.out.println("Welcome to the banking system. Please make your selection:\n A: Savings\n B: Checking\n C: Exit");
            switch (getInput()) {
                case "A": {
                    menuSavings();
                    break;
                }
                case "B": {
                    menuChecking();
                    break;
                }
                case "C": {
                    int c = 0;
                    System.exit(c);
                }
                case "D": {
                    System.out.println("Please enter a valid Choice: ");
                    break;
                }

            }
        }
    }


    public void menuSavings(){

        while(true){
            System.out.println("Savings Account. Please make your selection:\n A: Deposit\n B: Withdrawal\n C: Report\n D: Return to Bank Menu");
            switch (getInput()){
                case "A":
                {
                    System.out.println("Please enter an amount to Deposit:");
                    sav.makeDeposit(getAmount());
                    break;
                }
                case "B":
                {
                    System.out.println("Please enter an amount to Withdraw:");
                    sav.makeWithdraw(getAmount());
                    break;
                }
                case "C":
                {
                    sav.doMonthlyReport();
                    break;
                }
                case "D":
                {
                    return;
                }
            }
        }
    }

    public void menuChecking(){


        while(true) {
            System.out.println("Checking Account. Please make your selection:\n A: Deposit\n B: Withdrawal\n C: Report\n D: Return to Bank Menu");
            switch (getInput()) {
                case "A": {
                    System.out.println("Please enter an amount to Deposit:");
                    chk.makeDeposit(getAmount());
                    break;
                }
                case "B": {
                    System.out.println("Please enter an amount to Withdraw:");
                    chk.makeWithdraw(getAmount());
                    break;
                }
                case "C": {
                    chk.doMonthlyReport();
                    break;
                }
                case "D": {
                    return;
                }

            }
        }
    }


    public String getInput() {
        String usrInput;
        Object obj = new Object();
        if (sc.hasNext("[ABCD]")){
            usrInput = sc.next();
        }
        else usrInput = "ZXC";
        sc.nextLine();

        //ZXC is just garbage input for the loop
        while(usrInput.equals("ZXC")){
            System.out.println("Please enter a valid Choice");
            if (sc.hasNext("[ABCD]")){
                usrInput = sc.next();
            }
            else usrInput = "ZXC";
            sc.nextLine();
        }
        return usrInput;
    }

    public double getAmount() {
        double usrAmt;
        if (sc.hasNextDouble()){
            usrAmt = sc.nextDouble();
        }
        else usrAmt = -1;
        sc.nextLine();

        while(usrAmt < 0){
            System.out.println("Please enter a valid amount: ");
            if (sc.hasNextDouble()){
                usrAmt = sc.nextDouble();
                sc.nextLine();
            }

            else usrAmt = -1;
        }
        return usrAmt;
    }




    public static void main(String [] args){
        Menu testObj = new Menu();
        testObj.systemMenu();
    }





}
