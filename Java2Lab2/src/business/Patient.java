/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.PatientBean;
import java.sql.SQLException;


/**
 *
 * @author Steven
 */
class Patient {
    
    

    public Patient() {
        
    }
    
    public void perform(){
        dbSQLScripts dbsql = new dbSQLScripts();
        PatientBean ptb = null;
        try{
            ptb = dbsql.findByID(1);
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        System.out.println(ptb.toString());
    }
    
    
    
    public static void main(String[] args){
        Patient pt = new Patient();
        pt.perform();
        
    }
    
}
