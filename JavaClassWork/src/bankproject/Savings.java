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
        //Check if account is 'A', and wdAmt doesnt bring balance below $0
        if ((accountStatus == 'A') && (currentBalance - wdAmt > 0)){
            //If account is 'A' but wdAmt bring balance under $25, make withdraw but set account to 'I'
            if (currentBalance - wdAmt <25){
                super.makeWithdraw(wdAmt);
                accountStatus = 'I';
                System.out.println("Your account is now Inactive. Please make a deposit to bring balance over $25 to use this account again");

            }
            else{
                super.makeWithdraw(wdAmt);

            }
        }
        else System.out.println("Account is inactive, please bring balance above $25");
    }
    
    
    @Override
    public void makeDeposit(double depAmt){
        isActiveDep(depAmt);
        super.makeDeposit(depAmt);
    }


    @Override
    public void doMonthlyReport(){
        if (numberWithdrawals > 4){
            mmServiceCharge += (numberWithdrawals - 4);
            System.out.println("Total service charges: " + mmServiceCharge);
        }
        super.doMonthlyReport();
    }
    
}
