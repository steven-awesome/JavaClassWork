/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PassLine;
import TheDie.TheDie


public class PassLine {
    
    PassLineBean plb;
    TheDie die;
    
    public PassLine(){}
    
    
    public void ComeOutRoll(){
        plb = new PassLineBean();
        die = new TheDie();
        int temp;
        
        die.rollTheDie();
        temp = die.getOneDie();
        die.rollTheDie();
        temp+=die.getOneDie();
    }
    
    public void point(){
        die = new TheDie();
        int temp;
        
        die.rollTheDie();
        temp = die.getOneDie()
    }
    
    
}
