/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Any7;

import DataBean.Bankroll;
import Game.Game;
import PassLine.PassLineBean;
import TheDie.TheDie;

/**
 *
 * @author fista
 */
public class Any7 {
    PassLineBean plb;
    TheDie die;
    Bankroll br;
    Game gm;
    
        
    
    public void any7Game(){
        plb = new PassLineBean();
        die = new TheDie();
        br = new Bankroll();
        gm = new Game();
        int amt;
        int temp;
        
        System.out.println("This is the Any 7 game. Enter an amount to roll the dice");
        amt = gm.getInput();
        
        die.rollTheDie();
        temp=die.getOneDie();
        die.rollTheDie();
        temp+=die.getOneDie();
        
        if (die.getOneDie() == 7){
            System.out.println("You win!");
            br.add(amt*4);
        }
        
    }
}
