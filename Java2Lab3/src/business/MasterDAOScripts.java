/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.InpatientBean;
import data.MedicationBean;
import data.PatientBean;
import data.SurgicalBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fista
 */
public class MasterDAOScripts {
    
    PatientDAO pdao;
    InpatientDAO indao;
    SurgicalDAO sdao;
    MedicationDAO mdao;
    String url = "jdbc:derby://localhost:1527/HospitalDB";
    String user = "hospital";
    String password = "hospital";
    
    public ArrayList findRecordsByID(int id) throws SQLException{
        
        pdao = new PatientDAO();
        indao = new InpatientDAO();
        sdao = new SurgicalDAO();
        mdao = new MedicationDAO();
        ArrayList<Object> patient = new ArrayList();
        
        PatientBean pList = pdao.findByID(id);
        ArrayList<InpatientBean> inList = indao.findByID(id);
        ArrayList<SurgicalBean> sList = sdao.findSurgicalByID(id);
        ArrayList<MedicationBean> mList= mdao.findMedicationByID(id);
        
        patient.add(pList);
        patient.add(inList);
        patient.add(sList);
        patient.add(mList);
        
        return patient;
        }    
    
    public ArrayList<Object> findRecordsByLName(String lastName) throws SQLException{
        
        pdao = new PatientDAO();
        indao = new InpatientDAO();
        sdao = new SurgicalDAO();
        mdao = new MedicationDAO();
        ArrayList<Object> patient = new ArrayList();
        
        PatientBean pList = pdao.findByLastName(lastName);
        int pID = pList.getPatientID();
        ArrayList<InpatientBean> inList = indao.findByID(pID);
        ArrayList<SurgicalBean> sList = sdao.findSurgicalByID(pID);
        ArrayList<MedicationBean> mList= mdao.findMedicationByID(pID);
        
        patient.add(pList);
        patient.add(inList);
        patient.add(sList);
        patient.add(mList);
        
        return patient;
        
    }
    
    public int deleteRecordsByID(int id) throws SQLException{
        int count = 0;
        
        mdao = new MedicationDAO();
        sdao = new SurgicalDAO();
        indao = new InpatientDAO();
        pdao = new PatientDAO();
        try{
        if (mdao.delete(id) == 1){
            count++;
            Thread.sleep(100);
        }
        if (sdao.delete(id) == 1){
            count++;
            Thread.sleep(100);
        }
        if (indao.delete(id) == 1){
            count++;
            Thread.sleep(100);
        }
        if (pdao.delete(id) == 1){
            count++;
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
            System.out.println("Records deleted: "+count);
        
        return count;
    }
    
}
