/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FieldBet;

import DataBean.Bankroll;
import Game.Game;
import PassLine.PassLineBean;
import TheDie.TheDie;

/**
 *
 * @author fista
 */
public class FieldBet {
    
    PassLineBean plb;
    TheDie die;
    Bankroll br;
    Game gm;
    
        
    
    public void fieldBetGame(){
        plb = new PassLineBean();
        die = new TheDie();
        br = new Bankroll();
        gm = new Game();
        int amt = 0;
        int temp;
        
        System.out.println("This is the Field Bet game. Enter an amount to roll the dice");
        amt = gm.getInput();
        
        die.rollTheDie();
        temp=die.getOneDie();
        die.rollTheDie();
        temp+=die.getOneDie();
        
        
        switch(temp){
            case 3:
            case 4:
            case 9:
            case 10:
            case 11:
                System.out.println("You win!");
                br.add(amt);
                break;
            case 2:
                System.out.println("You win double!");
                br.add(amt*2);
                break;
            case 12:
                System.out.println("You win triple!");
                br.add(amt*3);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                System.out.println("You lose");
                br.subtract(amt);
                break;
        }
    }
    
}
