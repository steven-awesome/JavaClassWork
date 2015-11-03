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
public class Checking extends Account {
    
    public Checking(double curBalance, double annuIntRate){
        super(curBalance, annuIntRate);
    }
    
    @Override
    public void makeWithdraw(double wtdAmt){
        if (currentBalance - wtdAmt <0){
            currentBalance -= 15;
            System.out.println("Your balance fell below $0 and service charge applied. New balance: " + currentBalance);
        }
        else{
            super.makeWithdraw(wtdAmt);
            
        }
    }
    
    
        //This is to check is a withdrawal will bring balance below $0, and if it does, charge a $15 fee
    @Override
    public void balanceUnderZero(double wtdAmt){
        if (currentBalance - wtdAmt <0){
            currentBalance -= 15.0;
            System.out.println("Insufficient funds, service fee charged. New balance: " + currentBalance);
        }
        else super.makeWithdraw(wtdAmt);
    }
    
    public void doMonthlyReport(){
        mmServiceCharge = 5 + (numberWithdrawals * 0.1);
        super.doMonthyReport();
    }
    
}
