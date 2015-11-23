/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labassignment3;

import java.text.DateFormat;
import static java.util.Calendar.DAY_OF_WEEK;
import java.util.GregorianCalendar;

/**
 *
 * @author Steven
 */
public class DateTest {
    StringBuilder s;
    
    public void perform(){
        GregorianCalendar GC = new GregorianCalendar(1999, 1, 1);
        s = new StringBuilder();
        DateFormat fullDate =
               DateFormat.getDateInstance(DateFormat.FULL);
        //fullDate.
        
        s.setLength(GC.getTime().toString().length());
        s.append(fullDate.format(GC.getTime()));
        
        for (int i = 0; i < s.length(); i++){
            
            if (s.charAt(i) == ','){
                s.delete(i, s.length());
            }
        }
        
        String s2 = s.toString().trim();
        int ii = GC.get(DAY_OF_WEEK);
        
        System.out.println(ii);
    }
    
    public static void main(String[] args){
        DateTest dt = new DateTest();
        dt.perform();
    }
    
}
