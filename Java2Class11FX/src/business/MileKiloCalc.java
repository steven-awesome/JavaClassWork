/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author st_morr
 */
public class MileKiloCalc {
    
    public String mileToKilo(String s) throws Exception{
        double temp = 0;
        if ( !s.isEmpty()){
            temp = Double.valueOf(s) * 1.6;
            return String.valueOf(temp);
        }
        return " ";
    }
    
    public String kiloToMile(String s) throws Exception{
        double temp = 0;
        if ( !s.isEmpty()){
            temp = Double.valueOf(s) / 1.6;
            return String.valueOf(temp);
        }
        return " ";
    }
}
