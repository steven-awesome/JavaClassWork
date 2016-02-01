/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheDie;

import java.util.Random;

/**
 *
 * @author st_morr
 */
public class TheDie implements DieInterface {
    
    private int oneDie;
    
    public TheDie(){};
    
    @Override
    public void rollTheDie(){
        Random rand = new Random();
        oneDie = rand.nextInt(6) + 1;

    }

    public int getOneDie() {
        return oneDie;
    }

    public void setOneDie(int oneDie) {
        this.oneDie = oneDie;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

    @Override
    public String toString() {
        return "" + Integer.toString(oneDie);
    }
    
    
    
}
