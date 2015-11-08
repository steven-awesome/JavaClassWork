package bankproject;

import java.util.Scanner;

/**
 * Created by steven on 11/7/2015.
 */
public class TestMain {
    private String usr1;
    private String usr2;
    private String usr3;
    Scanner sc = new Scanner(System.in);


    public void mainPerform(){

        Savings sav = new Savings(0,2);
        Checking chk = new Checking(0,0);

        System.out.println("Welcome to the banking system. Please make your selection:\n A: Savings\n B: Checking\n C: Exit");

        while (true){
            outerloop:
            if (getInput().equals("A")){
                while (true){
                    System.out.println("Savings Account. Please make your selection:\n A: Deposit\n B: Withdrawal\n C: Report\n D: Return to Bank Menu");
                    if (getInput().equals("A")){
                        System.out.println("Please enter an amount to Deposit:");
                        sav.makeDeposit(getAmount());
                    }
                    else if (getInput().equals("B")){
                        System.out.println("Please enter an amount to Withdraw:");
                        sav.makeWithdraw(getAmount());
                    }
                    else if (getInput().equals("C")){
                        sav.doMonthlyReport();
                    }
                    else if (getInput().equals("D")){
                        break outerloop;
                    }
                }
            }
            else if (getInput().equals("B")) {
                while (true) {
                    System.out.println("Checking Account. Please make your selection:\n A: Deposit\n B: Withdrawal\n C: Report\n D: Return to Bank Menu");
                    if (getInput().equals("A")) {
                        System.out.println("Please enter an amount to Deposit:");
                        chk.makeDeposit(getAmount());
                    }
                    else if (getInput().equals("B")) {
                        System.out.println("Please enter an amount to Withdraw:");
                        chk.makeWithdraw(getAmount());
                    }
                    else if (getInput().equals("C")) {
                        chk.doMonthlyReport();
                    }
                    else if (getInput().equals("D")) {
                        break outerloop;
                    }
                }
            }
            else if (getInput().equals("C")) {
                int exit = 0;
                System.exit(exit);
            }
        }
    }










    public String getInput() {
        String usrInput;
        if (sc.hasNext("[ABCD]")){
            usrInput = sc.next();
        }
        else usrInput = "ZXC";
        sc.nextLine();

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
        TestMain testObj = new TestMain();
        testObj.mainPerform();
    }
}
