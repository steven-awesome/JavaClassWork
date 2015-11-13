/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankproject;

import java.text.NumberFormat;

/**
 *
 * @author Steven
 */
public abstract class Account {
    
    protected double startingBalance;
    protected double currentBalance;
    protected int totalDeposits;
    protected int numberDeposits;
    protected int totalWithdrawals;
    protected int numberWithdrawals;
    protected double annualInterestRate;
    protected double mmServiceCharge;
    protected char accountStatus;
    NumberFormat nF;
        
    

    
    //Constructor
    public Account(double startBal, double annuIntRate){
        startingBalance = startBal;
        annualInterestRate = annuIntRate;
        nF = NumberFormat.getNumberInstance();
        nF.setMaximumFractionDigits(2);
    }

    //Setters
    public void setStartingBalance(double startBal){
        startingBalance = startBal;
    }
    public void setCurrentBalance(double currentBal){
        currentBalance = currentBal;
    }
    public void setNumberDeposits(int numDep){
        numberDeposits = numDep;
    }
    public void setNumberWithdrawals(int numWtd){
        numberDeposits = numWtd;
    }
    public void setServiceCharge(double servChg){
        mmServiceCharge = servChg;
    }
    public void setAccountStatus(char accStatus){
        accountStatus = accStatus;
    }

    //Getters
    public double getStartingBalance(){
        return startingBalance;
    }
    public double getCurrentBalance(){
        return currentBalance;
    }
    public int getNumberDeposits(){
        return numberDeposits;
    }
    public int getTotalDeposits(){
        return totalDeposits;
    }
    public int getNumberWithdrawals(){
        return numberWithdrawals;
    }
    public int getTotalWithdrawals(){
        return totalWithdrawals;
    }
    public double getServiceCharge(){
        return mmServiceCharge;
    }
    public char getAccountStatus(){
        return accountStatus;
    }

    
    public void makeDeposit(double depAmt){
        currentBalance+=depAmt;
        ++numberDeposits;
        totalDeposits+=depAmt;
        System.out.println("Deposit success. New balance: " + currentBalance);
    }
    
    public void makeWithdraw(double wdAmt){
        currentBalance-=wdAmt;
        ++numberWithdrawals;
        totalWithdrawals+=wdAmt;
        System.out.println("Withdrawal success. New balance: " + currentBalance);
    }
    //if mmInt LESS THAN 0, show 0. (can happen if currbal is $3, and monthly report is run and charges $5, balance is negativer
    public void calculateInterest(){
        double mIntRate = (annualInterestRate / 100) / 12.0;
        double mmInt = currentBalance * mIntRate;
        currentBalance += mmInt;
        System.out.println("Total interest: " + mmInt);
    }
    
    public void doMonthlyReport(){
        currentBalance -= mmServiceCharge;
        calculateInterest();
        System.out.println("Starting Balance: " + nF.format(startingBalance) + " Total Deposits: " + totalDeposits + " Total Withdrawals: " + totalWithdrawals + " Service Charge: " + nF.format(mmServiceCharge) + " Number of deposits: " + numberDeposits + " Number Withdrawals: " + numberWithdrawals + " Current Balance: " + nF.format(currentBalance) + " Account Status: " + accountStatus);
        numberDeposits = numberWithdrawals = 0;
        mmServiceCharge = 0;
        totalDeposits = 0;
        totalWithdrawals = 0;
        startingBalance = currentBalance;
    }
    
    //Using this method to do checks on whether a transaction brings an account below $25 or not
    public char isActiveWD(double chkAmt){
        if (currentBalance - chkAmt > 25 ){
            accountStatus = 'A';
        }
        else{ 
            accountStatus = 'I';
        } 
        return accountStatus;
    }
    //Parent deposit class that checks if the amount the user wants to deposit bring the balance
    public char isActiveDep(double chkAmt){
        if (currentBalance + chkAmt >= 25 ){
            accountStatus = 'A';
            System.out.println("Your account is active again");
        }
        return accountStatus;
    }
    
    
    
    
}
