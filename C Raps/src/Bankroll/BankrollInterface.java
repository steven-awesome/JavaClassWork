/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bankroll;

/**
 *
 * @author st_morr
 */
public interface BankrollInterface {
    
    
    
    public void add(double amt);
    public void subtract(double amt);
    
    public String getFormattedMoney();
    
}
