/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class15;

import java.math.BigInteger;
import static java.math.RoundingMode.HALF_EVEN;

/**
 *
 * @author st_morr
 */
public class BigDecimalTest {
    
    public void perform(){
        BigInteger big1 = new BigInteger("1");
        big1 = big1.setScale(50, HALF_EVEN);
        BigInteger big2 = new BigInteger("2");
        BigInteger big3 = new BigInteger("3");
        
        for(int i = 0; i < 10;){
            if(big1.remainder)
            big1.add(big2);
        }
        
    }
    
    
    
    public static void main (String[] args){
        
    }
    
}
