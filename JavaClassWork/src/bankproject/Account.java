/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankproject;

/**
 *
 * @author Steven
 */
public abstract class Account {
    
    protected double zeroBalance;
    protected double currentBalance;
    protected double totalDeposits;
    protected int numberDeposits;
    protected double totalWithdrawals;
    protected int numberWithdrawals;
    protected double annualInterestRate;
    protected double mmServiceCharge;
    protected char accountStatus;
    
    
    public Account(double curBalance, double annuIntRate){
        currentBalance = curBalance;
        annualInterestRate = annuIntRate;
    }
    
    public void makeDeposit(double depAmt){
        currentBalance+=depAmt;
        totalDeposits++;
        System.out.println("Deposit success. New balance: " + currentBalance);
    }
    
    public void makeWithdraw(double wdAmt){
        currentBalance-=wdAmt;
        totalWithdrawals++;
        System.out.println("Withdrawal success. New balance: " + currentBalance);
    }
    
    public void calculateInterest(){
        double mIntRate = annualInterestRate / 12;
        double mmInt = currentBalance * mIntRate;
        currentBalance += mmInt;
    }
    
    public void doMonthlyReport(){
        currentBalance -= mmServiceCharge;
        calculateInterest();
        numberDeposits = numberWithdrawals = 0;
        mmServiceCharge = 0;
    }
    
    //Using this method to do checks on whether a transation brings an account below $25 or not
    public char isActiveWD(double chkAmt){
        if (currentBalance - chkAmt > 25 ){
            accountStatus = 'A';
        }
        else{ 
            accountStatus = 'I';
        } 
        return accountStatus;
    }
    
    public char isActiveDep(double chkAmt){
        if (currentBalance + chkAmt >= 25 ){
            accountStatus = 'A';
            System.out.println("Your account is active again");
        }
        return accountStatus;
    }
    
    public abstract void balanceUnderZero(double wtdAmt);
    
    
    
    
}
