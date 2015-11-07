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
public class Savings extends Account {

    public Savings(double curBalance, double annuIntRate) {
        super(curBalance, annuIntRate);
    }
    
    @Override
    public void makeWithdraw(double wdAmt){
        if (accountStatus == 'A'){
            balanceUnderZero(wdAmt);
        }
        else System.out.println("Account is inactive, please bring balance abover $25");
    }
    
    
    @Override
    public void makeDeposit(double depAmt){
        isActiveDep(depAmt);
        super.makeDeposit(depAmt);
    }
    
    
    //This is to check is a withdrawal will bring balance below $0, and if it does, charge a $15 fee
    @Override
    public void balanceUnderZero(double wtdAmt){
        if (currentBalance - wtdAmt <25){
            accountStatus = 'I';
            System.out.println("Your account is now Inactive. Please make a deposit to bring balance over $25 to use this account again");
            
        }
        else{
            super.makeWithdraw(wtdAmt);
            
        }
    }

    @Override
    public void doMonthlyReport(){
        if (numberWithdrawals > 4){
            mmServiceCharge += (numberWithdrawals - 4);
        }
        super.doMonthyReport();
    }
    
}
