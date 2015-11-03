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
    }
    
    public void makeWithdraw(double wdAmt){
        currentBalance-=wdAmt;
        totalWithdrawals--;
    }
    
    public void calculateInterest(){
        double mIntRate = annualInterestRate / 12;
        double mmInt = currentBalance * mIntRate;
        currentBalance += mmInt;
    }
    
    public void doMonthyReport(){
        currentBalance -= mmServiceCharge;
        calculateInterest();
        numberDeposits = numberWithdrawals = 0;
        mmServiceCharge = 0;
    }
    
    //Using this method to do checks on whether a transation brings an account below $25 or not
    public boolean isActiveWD(double chkAmt){
        if (currentBalance - chkAmt < 25 ){
            accountStatus = 'I';
            return true;
        }
        else return false;
    }
    
    public boolean isActiveDep(double chkAmt){
        if (currentBalance + chkAmt >= 25 ){
            accountStatus = 'A';
            return true;
        }
        else return false;
    }
    
    
    
    
    
    
}
