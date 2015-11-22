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
        BigInteger big1 = new BigInteger("10000000000000000000000000000000000000000000000000");
        BigInteger big2 = new BigInteger("2");
        BigInteger big3 = new BigInteger("3");
        
        for(int i = 0; i < 10;){
            if(big1.remainder(big2).toString().equals("0") || (big1.remainder(big3).toString().equals("0")))
            big1.add(big2);
        }
        
    }
    
    
    
    public static void main (String[] args){
        
    }
    
}
