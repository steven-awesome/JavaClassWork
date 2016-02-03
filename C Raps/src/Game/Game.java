/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import DataBean.Bankroll;
import PassLine.PassLine;
import PassLine.PassLineBean;
import TheDie.TheDie;
import java.util.Scanner;
        

/**
 *
 * @author fista
 */
public class Game {
    PassLine pl;
    PassLineBean plb;
    TheDie die;
    Bankroll bRoll;
    
    Scanner sc;
    
    public void pefform(){
        
    }
    
    public int getInput(){
        sc = new Scanner(System.in);
        
        int ans = sc.next().charAt(0);
        return ans;
    }
    
    public void menu(){
         while (true) {
            System.out.println("Craps Game.\nA: Passline Bet\nB: Field Bet\nC: Any 7");
            
            try{
                switch (getInput()) {
                    case 1: {
                        pl.PassLineBet();
                        break;
                    }
                    case 2: {
                        break;
                    }
                    case 3: {
                        int c = 0;
                        System.exit(c);
                    }
                    case 4: {
                        System.out.println("Please enter a valid Choice: ");
                        break;
                    }

                }
            }
            catch (NullPointerException npe){
                System.out.println("Please enter a valid choice");
        }
    }
    }
    
}
