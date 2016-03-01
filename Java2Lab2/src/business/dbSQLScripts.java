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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    //////////////////////////////////CREATE RECORDS///////////////////////////////////////
    
    public int createPatient(PatientBean patient) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO Patient (PATIENTID, LASTNAME, FIRSNAME,  DIAGNOSIS, "
                            + "ADMISSIONDATE, RELEASEDATE) "
                                + "VALUES (?, ?, ?, ?, ?, ?";
        
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(preparedSQL);
            ){
            ps.setInt(1, patient.getPatientID());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getLastName());
            ps.setString(4, patient.getDiagnosis());
            ps.setDate(5, patient.getAdmissionDate());
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
            ps.setInt(1, ipb.getPatientID());
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
    
    public int createSurgicalRecord(SurgicalBean surgical) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO Patient (PATIENTID, DATEOFSTAY, ROOMNUMBER,  DAILYRATE, "
                            + "SUPPLIES, SERVICES) "
                                + "VALUES (?, ?, ?, ?, ?, ?";
        
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(preparedSQL);
            ){
            ps.setInt(1, surgical.getPatientID());
            ps.setDate(2, surgical.getDateOfSurgery());
            ps.setString(3, surgical.getSurgery());
            ps.setDouble(4, surgical.getRoomFee());
            ps.setDouble(5, surgical.getSurgeonFee());
            ps.setDouble(6, surgical.getSupplies());
            
            result = ps.executeUpdate();
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        
        return result;
        
    }
    
    public int createMedicationRecord(MedicationBean medication) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO Patient (PATIENTID, DATEOFSTAY, ROOMNUMBER,  DAILYRATE, "
                            + "SUPPLIES, SERVICES) "
                                + "VALUES (?, ?, ?, ?, ?, ?";
        
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(preparedSQL);
            ){
            ps.setInt(1, medication.getPatientID());
            ps.setDate(2, medication.getDateOfMed());
            ps.setString(3, medication.getMed());
            ps.setDouble(4, medication.getUnitCost());
            ps.setDouble(5, medication.getUnits());
            
            result = ps.executeUpdate();
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        
        return result;
        
    }
    
    
    //////////////////////////////////////QUERIES////////////////////////////////////////////////
    
    public ArrayList<PatientBean> findAll() throws SQLException {

        ArrayList<PatientBean> pt = new ArrayList<>();

        String selectQuery = "SELECT PATIENTID, LASTNAME, FIRSNAME,  DIAGNOSIS, "
                            + "ADMISSIONDATE, RELEASEDATE "
                            + "FROM PATIENT";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = connection
                .prepareStatement(selectQuery);
                ResultSet resultSet = ps.executeQuery()
                ) {
            while (resultSet.next()) {
                PatientBean pt1 = new PatientBean();
                pt1.setPatientID(resultSet.getInt("PATIENTID"));
                pt1.setLastName(resultSet.getString("LASTNAME"));
                pt1.setFirstName(resultSet.getString("FIRSNAME"));
                pt1.setDiagnosis(resultSet.getString("DIAGNOSIS"));
                pt1.setAdmissionDate(resultSet.getDate("ADMISSIONDATE"));
                pt1.setReleaseDate(resultSet.getDate("RELEASEDATE"));

                pt.add(pt1);
            }
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        return pt;
    }
    
    public PatientBean findByID(int id) throws SQLException {
        
        PatientBean pt = new PatientBean();

        String selectQuery = "SELECT * "
                            + "FROM PATIENT "
                            + "WHERE ID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = 
                        connection.prepareStatement(selectQuery)) 
                {
                    ps.setInt(1, id);
                    ResultSet resultSet = ps.executeQuery();

                    pt.setPatientID(resultSet.getInt("PATIENTID"));
                    pt.setLastName(resultSet.getString("LASTNAME"));
                    pt.setFirstName(resultSet.getString("FIRSNAME"));
                    pt.setDiagnosis(resultSet.getString("DIAGNOSIS"));
                    pt.setAdmissionDate(resultSet.getDate("ADMISSIONDATE"));
                    pt.setReleaseDate(resultSet.getDate("RELEASEDATE"));
                }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        
        return pt;
    }
    
     public PatientBean findByLastName(String lName) throws SQLException {

        int result = -1;
        PatientBean pt = new PatientBean();

        String selectQuery = "SELECT * "
                            + "FROM PATIENT "
                            + "WHERE LASTNAME = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = 
                        connection.prepareStatement(selectQuery)) 
                {
                    ps.setString(1, lName);
                    ResultSet resultSet = ps.executeQuery();

                    pt.setPatientID(resultSet.getInt("PATIENTID"));
                    pt.setLastName(resultSet.getString("LASTNAME"));
                    pt.setFirstName(resultSet.getString("FIRSNAME"));
                    pt.setDiagnosis(resultSet.getString("DIAGNOSIS"));
                    pt.setAdmissionDate(resultSet.getDate("ADMISSIONDATE"));
                    pt.setReleaseDate(resultSet.getDate("RELEASEDATE"));
                }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        
        return pt;
    }
     
     //////////////////////////////////////UPDATE RECORDS/////////////////////////////////////
    
     public int update(PatientBean ptb, int id) throws SQLException{
         int result = -1;
         
         String prepareStatement = "UPDATE PATIENT "
                 + "SET "
                 + "PATIENTID = ?, "
                 + "LASTNAME = ?, "
                 + "FIRSNAME = ?, "
                 + "DIAGNOSIS = ?, "
                 + "ADMISSIONDATE = ?, "
                 + "RELEASEDATE = ? "
                 + "WHERE ID = ?";
         
         try(
                 Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement ps = connection.prepareStatement(prepareStatement)
                 ){
                    ps.setInt(1, ptb.getPatientID());
                    ps.setString(2, ptb.getLastName());
                    ps.setString(3, ptb.getFirstName());
                    ps.setString(4, ptb.getDiagnosis());
                    ps.setDate(5, ptb.getAdmissionDate());
                    ps.setDate(6, ptb.getReleaseDate());
                    ps.setInt(7, id);
                    result = ps.executeUpdate();
                    }
         catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
         
         return result;
     }
     
     ///////////////////////////////////////DELETE RECORD///////////////////////////////////////////
     
     public int delete(int id) throws SQLException{
         int result = -1;
         
         String prepareStatement = "DELETE FROM PATIENT "+
                            "WHERE ID = ?";
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(prepareStatement)
                ){
            ps.setInt(1, id);
            result = ps.executeUpdate();
            
        }
        catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
        
        return result;
         
         
     }
     
     
     
     
     
     
}
