/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankrollApp;

import DataBean.Bankroll;

/**
 *
 * @author st_morr
 */
public class MoneyTester {
    
    
    
    Bankroll br1;
    Bankroll br2;
    
    public void perform(){
        br1 = new Bankroll();
        br2 = new Bankroll(100);
        
        System.out.println(br1.getFormattedMoney());
        System.out.println(br2.getFormattedMoney());
        
        for (int i = 0; i < 10; i++){
            int temp = (int) (Math.random()*10);
            int temp2 = (int) (Math.random()*10);
            
            br1.add(temp);
            System.out.println(br1.getFormattedMoney());
            br1.subtract(temp2);
            System.out.println(br1.getFormattedMoney());
            br2.add(temp2);
            System.out.println(br2.getFormattedMoney());
            br2.subtract(temp);
            System.out.println(br2.getFormattedMoney());
        }
    }
    
    
    
    public static void main(String[] args) {
        MoneyTester mt = new MoneyTester();
        mt.perform();
        System.exit(0);
}


    
}
