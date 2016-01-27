/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2Class3;

/**
 *
 * @author st_morr
 */
public class AccountTest {
    Account ac1 = new Account();
    Account ac2 = new Account();
    
    public void perform(){
        
        
        System.out.println(ac1.getDateCreated().toString());
    }
    
    public static void main(String[] args){
        AccountTest at = new AccountTest();
        at.perform();
        System.exit(0);
    }
}
