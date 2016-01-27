/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBean;

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
    
    public String getFormattedMoney(){
        
        return String.format("$%s", money);
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
        return super.equals(obj); 
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

    
    
    
    
    
    
    
    
    
}
