/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class15;

import java.math.BigDecimal;
import java.math.BigInteger;
import static java.math.RoundingMode.HALF_EVEN;

/**
 *
 * @author st_morr
 */
public class BigDecimalTest {

    /*(Divisible by 2 or 3 by using BigInteger) Find the first ten numbers
with 50 decimal digits that are divisible by 2 or 3. The output of
your program should be:*/
    
    public void perform(){
        BigDecimal big1 = new BigDecimal("10000000000000000000000000000000000000000000000000");
        big1 = big1.setScale(0, HALF_EVEN);
        BigInteger big2 = new BigInteger("2");
        BigInteger big3 = new BigInteger("3");
        
        for(int i = 0; i < 10;){
            if(big1.remainder(big2) == 0 || (big1.remainder(big3) == 0))
            big1.add(big2);
        }
        
    }
    
    
    
    public static void main (String[] args){
        
    }
    
}
