/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import business.PatientDAO;
import data.PatientBean;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Steven
 */
class Application {
    
    

    public Application() {
        
    }
    
    public void perform(){
        PatientDAO dbsql = new PatientDAO();
        ArrayList<PatientBean> ptb = null;
        try{
            ptb = dbsql.findByID(2);
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
            
        for(PatientBean pb : ptb){
            System.out.println(pb.toString());
        }
        
    }
    
    /*public void perform(){
        DBSQLScripts dbsql = new DBSQLScripts();
        ArrayList<Object> ptb = null;
        String s = "Wayne";
        try{
            ptb = dbsql.findByLastName(s);
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        System.out.println(ptb.get(0).toString());
        System.out.println(ptb.get(1).toString());
        System.out.println(ptb.get(2).toString());
        System.out.println(ptb.get(3).toString());
    }*/
    
    public static void main(String[] args){
        Application pt = new Application();
        pt.perform();
        
    }
    
}
