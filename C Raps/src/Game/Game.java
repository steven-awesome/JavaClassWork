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
public class Game implements GameInterface {
    PassLine pl;
    Any7 a7;
    FieldBet fb;
    Scanner sc;
    Bankroll br = new Bankroll(100);
    
    //This method just gets a number, catches any exception and asks for another number
    @Override
    public int getInput(){
        int ans = 0;
        sc = new Scanner(System.in);
        innerloop:
        while(true){
            try{
                ans = sc.nextInt();
                break;
            }
            catch(Exception e){
                System.out.println("Please enter a valid number");
                sc.nextLine();
            }
        }
        return ans;
    }
    
    //This method gets a double to be used for bankroll transactions
    @Override
    public double getAmountInput(Bankroll br){
        double amt = 0;
        sc = new Scanner(System.in);
        while (true) {
            try{
                amt = sc.nextDouble();
                if ((br.getMoney() - amt) < 0) {
                    System.out.println("Your bankroll is: " + br.getFormattedMoney() + " "
                                + "\nPlease do not go below your bankroll amount");
                 }
                else if (amt < 1){
                    System.out.println("Please enter a positive amount: ");
                }
                else{
                    break;
                }
                    
            }
            catch(Exception e){
                    System.out.println("Please enter a valid amount");
                    sc.nextLine();
            }
            
        }
        return amt;
    }
    
    //Menu method which displays to user
    public void menu(){
        pl = new PassLine();
        a7 = new Any7();
        fb = new FieldBet();
        int choice;
         while (true) {
             
             if(br.getMoney() == 0){
                 System.out.println("Game Over");
                 System.exit(0);
             }
            System.out.println("Craps Game.\n1: Passline Bet\n2: Field Bet\n3: Any 7\n4: Bankroll balance\n5: Exit");
            choice = getInput();
            
            try{
                switch (choice) {
                    case 1: {
                        pl.PassLineBet(br);
                        System.out.println(br.toString());
                        break;
                    }
                    case 2: {
                        fb.fieldBetGame(br);
                        System.out.println(br.toString());
                        break;
                    }
                    case 3: {
                        a7.any7Game(br);
                        System.out.println(br.toString());
                        break;
                    }
                    case 4: {
                        System.out.println(br.toString());
                        break;
                    }
                    case 5: {
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Please enter a valid choice");
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
