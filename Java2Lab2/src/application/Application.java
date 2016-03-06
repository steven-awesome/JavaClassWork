/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import business.InpatientDAO;
import business.MasterDAOScripts;
import business.MedicationDAO;
import business.PatientDAO;
import data.InpatientBean;
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
    
    public void findMaster(){
        MasterDAOScripts mScripts = new MasterDAOScripts();
        ArrayList<Object> arList = new ArrayList();
        
        try{
            arList = mScripts.findRecordsByID(1);
            
            for (int i = 0; i < arList.size()-1; i++){
                System.out.println(arList.get(i).toString());
                System.out.println("====================");
            }
            
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
    }
    
    public void perform() throws SQLException{
        MedicationDAO dbsql = new MedicationDAO();
        PatientBean ptb = new PatientBean();
            
        Timestamp ts = Timestamp.valueOf("2014-01-24 11:00:00.00");
        Date date = new Date(ts.getTime());

        
         MedicationBean mb = new MedicationBean();
        mb.setID(1);
        mb.setPatientID(1);
        mb.setDateOfMed(date);
        mb.setMed("Snickers");
        mb.setUnitCost(1.25);
        mb.setUnits(5);
        
        dbsql.createMedicationRecord(mb);
        
         MedicationBean mb1 = new MedicationBean();
        mb1.setID(1);
        mb1.setPatientID(1);
        mb1.setDateOfMed(date);
        mb1.setMed("Snickers");
        mb1.setUnitCost(1.25);
        mb1.setUnits(5);
        
       
        
    }
    
    public void testInpatient() {
        InpatientDAO indao = new InpatientDAO();
        ArrayList<InpatientBean> arIPB = new ArrayList();
        InpatientBean ipb = new InpatientBean();
        Date dateStay = Date.valueOf("2016-01-03");
        ipb.setPatientID(1);
        ipb.setDateOfStay(dateStay);
        ipb.setRoomNumber("Test1");
        ipb.setDailyRate(123);
        ipb.setSupplies(456);
        ipb.setServices(789);
        
        try{
            int result = indao.createInpatientRecord(ipb);
            System.out.println(result);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
    }
    
    public void delete(){
        PatientDAO dbsql = new PatientDAO();
        
        try{
        int temp = dbsql.delete(1);
            System.out.println(temp);
        }
        catch(SQLException ex){
            ex.printStackTrace();
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
    
    public static void main(String[] args) throws SQLException{
        Application pt = new Application();
        pt.delete();
        
    }
    
}
