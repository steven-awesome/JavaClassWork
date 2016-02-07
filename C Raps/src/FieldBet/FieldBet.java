/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FieldBet;

import Bankroll.Bankroll;
import Game.Game;
import PassLine.PassLineBean;
import TheDie.TheDie;

/**
 *
 * @author fista
 */
public class FieldBet {
    
    PassLineBean plb;
    TheDie die1;
    TheDie die2;
    Bankroll br;
    Game gm;
    
        
    
    public void fieldBetGame(Bankroll br){
        plb = new PassLineBean();
        die1 = new TheDie();
        die2 = new TheDie();
        gm = new Game();
        double amt = 0;
        int temp;
        
        System.out.println("This is the Field Bet game. Enter an amount to roll the dice");
        amt = gm.getAmountInput(br);
        
        die1.rollTheDie();
        die2.rollTheDie();
        temp = die1.getOneDie() + die2.getOneDie();
        System.out.println("Roll: " + temp);
        
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
