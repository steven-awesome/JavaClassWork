/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labassignment3;

import static java.util.Calendar.DAY_OF_MONTH;
import java.util.GregorianCalendar;

/**
 *
 * @author Steven
 */
public class DateTest2 {
    public void perform(){
        GregorianCalendar GC;
        GC = new GregorianCalendar(1999, 1, 1);
        StringBuilder sb = new StringBuilder();
        
        
        String s = GC.getTime().toString();
        
        System.out.println(s);
        
        /*for (int i = 0; i < 100; i++){
            for (int i2 = 0; i < 8; i++){
                String s = 
            }
        }*/
        
    }
    
    public static void main(String[] args){
        DateTest2 dt = new DateTest2();
        dt.perform();
    }
    
}
