/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labassignment3;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class LabTest {

    ArrayList<String> TS;
    GregorianCalendar GC = new GregorianCalendar(); 
    StringBuilder ST;
    Scanner sc;
    
    
    
    public LabTest(){
        
    }
    
    public void Perform(){
        System.out.println("Please enter the Year: ");
        int Year = getInput();
        System.out.println("Please enter the Month: ");
        int Month = getInput();
        
        
        GC.set(Year, Month);
        
        String calendar = createCalendar();
       
        
        
    }
    
    public int getInput(){
        sc = new Scanner(System.in);
        int usrInput = 0;
        
        if (sc.hasNext()){
            usrInput = sc.nextInt();
        }
        else while(true){
            System.out.println("Please enter a valid String");
            if (sc.hasNextInt()){
                usrInput = sc.nextInt();
                break;
            }
            sc.nextLine();
        }
        sc.nextLine();
        
        return usrInput;
    }
    
    public String createCalendar(){
        
        StringBuilder calString = new StringBuilder();
        TS = new ArrayList(48);
        int daysMax;
        ArrayList<String> dayNames = new ArrayList();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        
        daysMax = GC.getActualMaximum(DAY_OF_MONTH);
        
        
        
      
      
        for (int i = 0; i == daysMax; i++){
            GC.set(DAY_OF_MONTH, i);
            TS.add(i, ));
            if ()
            
    }
        
    }
    
    public String dayName(Date dt){
        ST = new StringBuilder();
        DateFormat fullDate =
        DateFormat.getDateInstance(DateFormat.MONTH_FIELD);
        ST.setLength(GC.getTime().toString().length());
        ST.append(fullDate.format(GC.getTime()));
        
        
        /*for (int i = 0; i < ST.length(); i++){
            
            if (ST.charAt(i) == ','){
                ST.delete(i, ST.length());
            }
        }*/
        
        String s2 = ST.toString().trim();
        
        
        return s2;
    }
    
    
    
    
    
    public static void main(String[] args) {
        LabTest lt = new LabTest();
        lt.Perform();
        
    }
    
}
