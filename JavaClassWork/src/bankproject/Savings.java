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
            super.makeWithdraw(wdAmt);
        }
        else{
            System.out.println("This account is not active,");
            
        }
    }
    
}
