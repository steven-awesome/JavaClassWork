/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labassignment3;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
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
        
        //for (String s : ts){
        //    System.out.println(s);
        //}
        
        System.out.println(st.toString());
    }
    
    
    //Method for getting input
    public int getInput(){
        sc = new Scanner(System.in);
        int usrInput = 0;
        
        if (sc.hasNext()){
            usrInput = sc.nextInt();
        }
        else while(true){
            System.out.println("Please enter a valid Int");
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
        st = new StringBuilder();
        int daysMax = gc.getActualMaximum(DAY_OF_MONTH);
        
        //Sets the first few elements of the array to empty string
        if (gc.get(DAY_OF_WEEK) > 1){
            for (int emptyDays = gc.get(DAY_OF_WEEK) - 1; emptyDays >= 0; emptyDays--){
                ts.add("  ");
            }
        }
        
        //Adds each DAY_OF_MONTH at the end of the Array, until 
        //gc.getActualMaximum(DAY_OF_MONTH) is reached
        for (int i = 1; i <= daysMax; i++){
            gc.set(DAY_OF_MONTH, i);
            if(gc.get(DAY_OF_MONTH) < 10){
                if (gc.get(DAY_OF_WEEK) == 1){
                    ts.add("\n "+String.valueOf(gc.get(DAY_OF_MONTH))+"  ");
                }
                else if (gc.get(DAY_OF_MONTH) == 9){
                    ts.add(String.valueOf(gc.get(DAY_OF_MONTH))+" ");
                }
                else {
                    ts.add(String.valueOf(gc.get(DAY_OF_MONTH))+"  ");
                }
            }
            else{
                if (gc.get(DAY_OF_WEEK) == 1){
                    ts.add("\n"+String.valueOf(gc.get(DAY_OF_MONTH))+" ");
                }
                else {
                    ts.add(String.valueOf(gc.get(DAY_OF_MONTH))+" ");
                }   
            }

            
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM");

        st.append("\n"+sdf.format(gc.getTime()) + "\n S  M  T  W  T  F  S\n================\n");
        
        //This will add each arraylist element to a string with a space after.
        //IF DAY_OF_WEEK = Sunday, add new line
        for (int i = 1; i <= daysMax; i++ ){
            st.append(ts.get(i));
        }
        
    }
    
    
    
    
    
    
    public static void main(String[] args){
        DateTest2 dt = new DateTest2();
        dt.Perform();
    }
    
}
