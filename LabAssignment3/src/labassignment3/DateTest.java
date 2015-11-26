/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labassignment3;

import java.text.DateFormat;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import java.util.GregorianCalendar;

/**
 *
 * @author Steven
 */
public class DateTest {
    StringBuilder s;
    
    public void perform(){
        GregorianCalendar GC = new GregorianCalendar(2013, 2, 0);
        s = new StringBuilder();
        DateFormat fullDate =
               DateFormat.getDateInstance(DateFormat.FULL);
        //fullDate.
        
        /*s.setLength(GC.getTime().toString().length());
        s.append(fullDate.format(GC.getTime()));
        
        for (int i = 0; i < s.length(); i++){
            
            if (s.charAt(i) == ','){
                s.delete(i, s.length());
            }
        }
        
        String s2 = s.toString().trim();*/
        int mm = GC.get(Calendar.MONTH);
        int gg = GC.getActualMaximum(DAY_OF_MONTH);
        
        System.out.println(mm+"   "+gg);
    }
    
    public static void main(String[] args){
        DateTest dt = new DateTest();
        dt.perform();
    }
    
}
