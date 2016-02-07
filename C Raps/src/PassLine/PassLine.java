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
    TheDie die1;
    TheDie die2;
    Bankroll br;
    Game gm;
    
    public PassLine(){}
    
    
    public void PassLineBet(Bankroll br){
        plb = new PassLineBean();
        die1 = new TheDie();
        die2 = new TheDie();
        gm = new Game();
        double amt = 0;
        boolean pt;
        
        System.out.println("This is the PassLine Bet game. Enter an amount to roll the dice");
        amt = gm.getAmountInput(br);
        
        die1.rollTheDie();
        die2.rollTheDie();
        plb.setComeOutRoll(die1.getOneDie()+die2.getOneDie());
        
        System.out.println("Come Out Roll: " + plb.getComeOutRoll());
        
        
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
            
            //================POINT GAME=====================
            /*Changed method to just auto reroll since you have no choice but to keep rolling anyway*/
            while (pt = true){
            int tempPT;
            
            die1.rollTheDie();
            die2.rollTheDie();
            tempPT = die1.getOneDie()+die2.getOneDie();
            System.out.println("Point roll: " + tempPT);
            
            //If dice roll equals Point, you win, else if dice roll equals 7, you lose
            if (tempPT == plb.getPoint()){
                System.out.println("You win!");
                br.add(amt);
                break;
            }
            else if (tempPT == 7){
                System.out.println("You lose");
                br.subtract(amt);
                break;
            }
            
        }
        }
        
        
        
        
        
    }    
    
}
