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
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Steven
 */
class Application {
    
    //THIS IS A MANUAL TEST FILE. As I understood,
    //we were not supposed to do a user interface so I wasn't sure
    //what the Application package was for since we are testing everthing works
    //in our jUnit Tests

    public Application() {
        
    }
    //THIS METHOD PROVES THAT THE FIND ALL WORKS. FOR SOME REASON IT WONT
    //WORK DURING UNIT TESTING?
    public void findMaster(){
        MasterDAOScripts mScripts = new MasterDAOScripts();
        ArrayList<Object> arList = new ArrayList();
        
        try{
            arList = mScripts.findRecordsByID(1);
            
            for (int i = 0; i < arList.size(); i++){
                System.out.println(arList.get(i).toString());
                System.out.println("====================");
            }
            
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
    }
    
    public void perform() throws SQLException{
        System.out.println("update");
        InpatientBean ipb = new InpatientBean();
        InpatientDAO indao = new InpatientDAO();
        Date dateStay = Date.valueOf("2009-01-03");
        ArrayList<InpatientBean> findResult = new ArrayList();
        
        ipb.setID(1);
        ipb.setDateOfStay(dateStay);
        ipb.setRoomNumber("Test2");
        ipb.setDailyRate(333);
        ipb.setSupplies(444);
        ipb.setServices(555);
        indao.update(ipb, 8);
        
        System.out.println(ipb.toString());
        
    }
    
    public void testFindMedication() throws SQLException{
        System.out.println("findByID");
        int id = 1;
        Date date = Date.valueOf("2014-01-24");
        MedicationBean mb = new MedicationBean();
        mb.setID(1);
        mb.setPatientID(1);
        mb.setDateOfMed(date);
        mb.setMed("Snickers");
        mb.setUnitCost(1.25);
        mb.setUnits(5);
        
        MedicationDAO instance = new MedicationDAO();
        
        ArrayList<MedicationBean> result = instance.findMedicationByID(id);
        
        System.out.println(result.get(0).toString());
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
    
    public static void main(String[] args) throws SQLException{
        Application pt = new Application();
        pt.testInpatient();
}
    
}
