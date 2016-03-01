/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import business.DBSQLScripts;
import data.PatientBean;
import java.sql.SQLException;


/**
 *
 * @author Steven
 */
class Application {
    
    

    public Application() {
        
    }
    
    public void perform(){
        DBSQLScripts dbsql = new DBSQLScripts();
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
        Application pt = new Application();
        pt.perform();
        
    }
    
}
