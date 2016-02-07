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
        if(obj instanceof TheDie){
            TheDie td = (TheDie) obj;
            if(oneDie == td.getOneDie()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }

    @Override
    public String toString() {
        return "Die Roll: " + oneDie;
    }
    
    
    
}
