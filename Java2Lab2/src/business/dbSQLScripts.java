/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;
import data.PatientBean;
import data.InpatientBean;
import data.MedicationBean;
import data.SurgicalBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Steven
 */
public class dbSQLScripts {

    public PatientBean patient;
    public InpatientBean inpatient;
    public MedicationBean meds;
    public SurgicalBean surgical;
    
    String url = "jdbc:derby://localhost:1527/Hospital";
    String user = "hospital";
    String password = "hospital";

    public dbSQLScripts() {
        patient = new PatientBean();
        inpatient = new InpatientBean();
        meds = new MedicationBean();
        surgical = new SurgicalBean();
    }
    
    
    
    public int createPatient(PatientBean patient) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO Patient (PATIENTID, LASTNAME, FIRSNAME,  DIAGNOSIS, "
                            + "ADMISSIONDATE, RELEASEDATE) "
                                + "VALUES (?, ?, ?, ?, ?, ?";
        
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(preparedSQL);
            ){
            ps.setInt(1, patient.getPatiendID());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getLastName());
            ps.setString(4, patient.getDiagnosis());
            ps.setDate(5, patient.getAdmissonDate());
            ps.setDate(6, patient.getReleaseDate());
            
            result = ps.executeUpdate();
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        
        return result;
        
    }
    
    public int createInpatientRecord(InpatientBean ipb) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO Patient (PATIENTID, DATEOFSTAY, ROOMNUMBER,  DAILYRATE, "
                            + "SUPPLIES, SERVICES) "
                                + "VALUES (?, ?, ?, ?, ?, ?";
        
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(preparedSQL);
            ){
            ps.setInt(1, ipb.getPatiendID());
            ps.setDate(2, ipb.getDateOfStay());
            ps.setString(3, ipb.getRoomNumber());
            ps.setDouble(4, ipb.getDailyRate());
            ps.setDouble(5, ipb.getSupplies());
            ps.setDouble(6, ipb.getServices());
            
            result = ps.executeUpdate();
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        
        return result;
        
    }
    
}
