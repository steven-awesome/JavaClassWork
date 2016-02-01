/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import TheDie.TheDie;
import java.util.Arrays;

/**
 *
 * @author st_morr
 */
public class DieTester {
    
    TheDie die1;
    
    
    public void perform(){
        die1 = new TheDie();
        String s = "";
        int[] arr = new int[6];
       
        for(int i = 0; i < 100; i++){
            die1.rollTheDie();
            s += die1.toString() + " ";
            
            arr[die1.getOneDie()-1]++;
        }
        
        System.out.println(s);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void main(String[] args) {
        DieTester dieTester = new DieTester();
        dieTester.perform();
        System.exit(0);
}

}
