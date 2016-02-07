/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Any7;

import Bankroll.Bankroll;
import Game.Game;
import PassLine.PassLineBean;
import TheDie.TheDie;

/**
 *
 * @author fista
 */
public class Any7 implements Any7Interface {
    PassLineBean plb;
    TheDie die1;
    TheDie die2;
    Bankroll br;
    Game gm;
    
        
    
    @Override
    public void any7Game(Bankroll br){
        plb = new PassLineBean();
        die1 = new TheDie();
        die2 = new TheDie();
        gm = new Game();
        double amt;
        int temp;
        
        System.out.println("This is the Any 7 game. Enter an amount to roll the dice");
        amt = gm.getAmountInput(br);
        
        die1.rollTheDie();
        die2.rollTheDie();
        temp = die1.getOneDie() + die2.getOneDie();
        
        System.out.println("Roll: " + temp);
        if (temp == 7){
            System.out.println("You win!");
            br.add(amt*4);
        }
        else{
            System.out.println("You lose");
            br.subtract(amt);
        }
        
    }
}
