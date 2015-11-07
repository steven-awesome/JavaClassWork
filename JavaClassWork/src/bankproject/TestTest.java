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
public class TestTest {
    private String usr1;
    private String usr2;
    private String usr3;
    Scanner sc = new Scanner(System.in);
    Savings sav = new Savings(0, 0);
    double testest;

    public void Menu(){
        System.out.println("Welcome to the banking system. Please make your selection:\n A: Savings\n B:Checking\n C: Exit");
        usr1 = this.getInput();

        switch (usr1){
            case "A":
            {
                menuSavings();
                break;
            }
            case "B":
            {
                menuChecking();
                break;
            }
            case "C":
            {
                int c = 0;
                System.exit(c);
            }

        }

    }


    public void menuSavings(){

        while(true){


            System.out.println("Savings Account. Please make your selection:\n A: Deposit\n B: Withdrawal\n C: Report\n D: Return to Bank Menu");
            usr2 = getInput();

            switch (usr2){
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
                    Menu();
                    break;
                }

            }
        }
    }

    public void menuChecking(){
        System.out.println("Checking Account. Please make your selection:\n A: Deposit\n B: Withdrawal\n C: Report\n D: Return to Bank Menu");
    }


    public String getInput() {
        String usrInput;
        String menuText = "menu Savings";
        Object obj = new Object();
        if (sc.hasNext("[ABC]")){
            usrInput = sc.next();
        }
        else if (Thread.currentThread().getStackTrace().getEnc.equals(menuText) && sc.hasNext("[ABCD]")){
            usrInput = sc.next();
        }
        else usrInput = "ZXC";
        sc.nextLine();

        while(usrInput.equals("ZXC")){
            System.out.println("Please enter a valid Choice");
            if (sc.hasNext("[ABC]")){
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
        TestTest testObj = new TestTest();
        testObj.Menu();
    }


}
