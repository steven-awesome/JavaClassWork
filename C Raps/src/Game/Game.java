/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import PassLine.PassLine;
import java.util.Scanner;
import Any7.Any7;
import DataBean.Bankroll;
import FieldBet.FieldBet;
        

/**
 *
 * @author fista
 */
public class Game {
    PassLine pl;
    Any7 a7;
    FieldBet fb;
    Scanner sc;
    
    public int getInput(){
        sc = new Scanner(System.in);
        int ans = sc.nextInt();
        return ans;
    }
    
    public int getAmountInput(Bankroll br){
        int amt=0;
        
        while (true) {
                System.out.println("Your bankroll is: " + br.getFormattedMoney() + " "
                        + "\nPlease do not go below your bankroll amount");
                if (amt - br.getMoney() < 0) {
                        amt = sc.nextInt();
                }
        }
        
        return amt;
    }
    
    public void menu(){
        pl = new PassLine();
        a7 = new Any7();
        fb = new FieldBet();
        int choice;
         while (true) {
            System.out.println("Craps Game.\n1: Passline Bet\n2: Field Bet\n3: Any 7\n4: Exit");
            choice = getInput();
            
            try{

                switch (choice) {
                    case 1: {
                        pl.PassLineBet();
                        break;
                    }
                    case 2: {
                        fb.fieldBetGame();
                        break;
                    }
                    case 3: {
                        a7.any7Game();
                        break;
                    }
                    case 4: {
                        System.exit(0);
                    }

                }
            }
            catch (NullPointerException npe){
                npe.printStackTrace();
        }
    }
    }
    
    public static void main (String[] args){
        Game g = new Game();
        g.menu();
        System.exit(0);
    }
    
}
