/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PassLine;
import TheDie.TheDie;
import DataBean.Bankroll;
import Game.Game;


public class PassLine {
    
    PassLineBean plb;
    TheDie die;
    Bankroll br;
    Game gm;
    
    public PassLine(){}
    
    
    public void PassLineBet(){
        plb = new PassLineBean();
        die = new TheDie();
        br = new Bankroll();
        gm = new Game();
        int amt;
        boolean pt;
        
        
        System.out.println("This is the Come Out Roll. Enter an amount to roll the dice");
        amt = gm.getInput();
        die.rollTheDie();
        plb.setComeOutRoll(die.getOneDie());
        die.rollTheDie();
        plb.setComeOutRoll(plb.getComeOutRoll()+die.getOneDie());
        
        System.out.println("Roll: " + plb.getComeOutRoll());
        
        
        if (plb.getComeOutRoll() == 7 || plb.getComeOutRoll() == 11){
            System.out.println("You win!");
            br.add(amt);
        }
        else if (plb.getComeOutRoll() == 2 || plb.getComeOutRoll() == 3 || plb.getComeOutRoll() == 12){
            System.out.println("You lost");
            br.subtract(amt);
        }
        else{
            plb.setPoint(plb.getComeOutRoll());
            System.out.println("The Point is now: " + plb.getPoint());
            pt = true;
        }
        
        while (pt = true){
            
            System.out.println("Point roll: ");
            die.rollTheDie();
            tempPT = die.getOneDie();
            
        }
        
        System.out.println("Result: " + temp);
        
    }
    
    public int point(){
        die = new TheDie();
        int temp;
        
        die.rollTheDie();
        temp = die.getOneDie()
    }
    
    
}
