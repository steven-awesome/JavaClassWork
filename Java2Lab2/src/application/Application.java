/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import business.PatientDAO;
import data.MedicationBean;
import data.PatientBean;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
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
                Timestamp ts = Timestamp.valueOf("2014-01-24 11:00:00.00");
                Date date = new Date(ts.getTime());

        
         MedicationBean mb = new MedicationBean();
        mb.setID(1);
        mb.setPatientID(1);
        mb.setDateOfMed(date);
        mb.setMed("Snickers");
        mb.setUnitCost(1.25);
        mb.setUnits(5);
        
         MedicationBean mb1 = new MedicationBean();
        mb1.setID(1);
        mb1.setPatientID(1);
        mb1.setDateOfMed(date);
        mb1.setMed("Snickers");
        mb1.setUnitCost(1.25);
        mb1.setUnits(5);
        
        System.out.println(mb.equals(mb1));
        
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
