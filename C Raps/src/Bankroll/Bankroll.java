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
public class Bankroll implements BankrollInterface {
    private double money;
    
    public Bankroll(){
        money = 0;
    }
    
    public Bankroll(double money){
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
    
    @Override
    public String getFormattedMoney(){
        
        return String.format("$%.2f", money);
    }
    
    @Override
    public void add(double amt) {
        money+=amt;
    }

    @Override
    public void subtract(double amt) {
        money-=amt;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Bankroll){
            Bankroll b = (Bankroll) obj;
            if(this.getMoney() == b.getMoney()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bankroll balance: " + this.getFormattedMoney(); 
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }
   
}
