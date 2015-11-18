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
    

    
    @Override
    public void doMonthlyReport(){
        mmServiceCharge = 5 + (numberWithdrawals * 0.1);
        super.doMonthlyReport();
        
    }
    
}