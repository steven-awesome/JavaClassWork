/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labassignment3;

import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class DateTest2 {
    ArrayList<String> ts;
    GregorianCalendar gc; 
    StringBuilder st;
    Scanner sc;
    
    public void Perform(){
        System.out.println("Please enter the Year: ");
        int Year = getInput();
        System.out.println("Please enter the Month: ");
        int Month = getInput();
        
        gc = new GregorianCalendar(Year, Month, 1);
        
        createCalendar();
        
        for (String s : ts){
            System.out.println(s);
        }
        
        System.out.println();
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
    
    public void createCalendar(){
        ts = new ArrayList(48);
        int daysMax = gc.getActualMaximum(DAY_OF_MONTH);
        
        if (gc.get(DAY_OF_WEEK) > 1){
            
            for (int emptyDays = gc.get(DAY_OF_WEEK) - 1; emptyDays > 0; emptyDays--){
                ts.add("");
            }
        }
        
        for (int i = 1; i <= daysMax; i++){
            gc.set(DAY_OF_MONTH, i);
            ts.add(String.valueOf(gc.get(DAY_OF_MONTH)));
        }
        
    }
    
    public String printCalendar(){
        for (int i = 0; i < st.length(); i++){
            
        }
        
       return "";
    }
    
    
    
    
    
    public static void main(String[] args){
        DateTest2 dt = new DateTest2();
        dt.Perform();
    }
    
}
