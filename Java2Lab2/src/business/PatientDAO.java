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
import interfaces.PatientInterface;
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
public class PatientDAO implements PatientInterface {

    public PatientBean patient;
    public InpatientBean inpatient;
    public MedicationBean meds;
    public SurgicalBean surgical;
    
    String url = "jdbc:derby://localhost:1527/HospitalDB";
    String user = "hospital";
    String password = "hospital";

    public PatientDAO() {
        patient = new PatientBean();
        inpatient = new InpatientBean();
        meds = new MedicationBean();
        surgical = new SurgicalBean();
    }
    
    //////////////////////////////////CREATE RECORDS///////////////////////////////////////
    
    @Override
    public int createPatient(PatientBean patient) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO Patient (LASTNAME, FIRSTNAME, DIAGNOSIS, "
                            + "ADMISSIONDATE, RELEASEDATE) "
                                + "VALUES (?, ?, ?, ?, ?)";
        
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(preparedSQL);
            ){
            ps.setString(1, patient.getLastName());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getDiagnosis());
            ps.setDate(4, patient.getAdmissionDate());
            ps.setDate(5, patient.getReleaseDate());
            
            result = ps.executeUpdate();
        }
        
        return result;
        
    }
    
    //////////////////////////////////////QUERIES////////////////////////////////////////////////
    
    @Override
    public ArrayList<PatientBean> findAll() throws SQLException {

        ArrayList<PatientBean> pt = new ArrayList<>();

        String selectQuery = "SELECT PATIENTID, LASTNAME, FIRSTNAME, DIAGNOSIS, "
                            + "ADMISSIONDATE, RELEASEDATE "
                            + "FROM PATIENT";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = connection
                .prepareStatement(selectQuery);
                ResultSet rs = ps.executeQuery()
                ) {
            while (rs.next()) {
                PatientBean pt1 = new PatientBean();
                pt1.setPatientID(rs.getInt("PATIENTID"));
                pt1.setLastName(rs.getString("LASTNAME"));
                pt1.setFirstName(rs.getString("FIRSTNAME"));
                pt1.setDiagnosis(rs.getString("DIAGNOSIS"));
                pt1.setAdmissionDate(rs.getDate("ADMISSIONDATE"));
                pt1.setReleaseDate(rs.getDate("RELEASEDATE"));

                pt.add(pt1);
            }
        }
        return pt;
    }
    
    @Override
    public PatientBean findByID(int id) throws SQLException {
        
        PatientBean pt = new PatientBean();

        String selectQuery = "SELECT * FROM PATIENT "
                            + "WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = 
                        connection.prepareStatement(selectQuery)) 
                {
                    
                    
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()){

                        pt.setPatientID(rs.getInt("PATIENTID"));
                        pt.setLastName(rs.getString("LASTNAME"));
                        pt.setFirstName(rs.getString("FIRSTNAME"));
                        pt.setDiagnosis(rs.getString("DIAGNOSIS"));
                        pt.setAdmissionDate(rs.getDate("ADMISSIONDATE"));
                        pt.setReleaseDate(rs.getDate("RELEASEDATE"));
                    
                    }
                }
        
        return pt;
    }
    
    @Override
     public PatientBean findByLastName(String lName) throws SQLException {

        int result = -1;
        PatientBean pt = new PatientBean();

        String selectQuery = "SELECT * FROM PATIENT "
                            + "WHERE LASTNAME = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = 
                        connection.prepareStatement(selectQuery)) 
                {
                    
                    
                    ps.setString(1, lName);
                    ResultSet rs = ps.executeQuery();
                    
                    while(rs.next()){

                        pt.setPatientID(rs.getInt("PATIENTID"));
                        pt.setLastName(rs.getString("LASTNAME"));
                        pt.setFirstName(rs.getString("FIRSTNAME"));
                        pt.setDiagnosis(rs.getString("DIAGNOSIS"));
                        pt.setAdmissionDate(rs.getDate("ADMISSIONDATE"));
                        pt.setReleaseDate(rs.getDate("RELEASEDATE"));

                    }
                }
        
        return pt;
    }
     
     //////////////////////////////////////UPDATE RECORDS/////////////////////////////////////
    
    @Override
     public int update(PatientBean ptb, int id) throws SQLException{
         int result = -1;
         
         String prepareStatement = "UPDATE PATIENT "
                 + "SET "
                 + "LASTNAME = ?, "
                 + "FIRSTNAME = ?, "
                 + "DIAGNOSIS = ?, "
                 + "ADMISSIONDATE = ?, "
                 + "RELEASEDATE = ? "
                 + "WHERE PATIENTID = ?";
         
         try(
                 Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement ps = connection.prepareStatement(prepareStatement)
                 ){
                    ps.setString(1, ptb.getLastName());
                    ps.setString(2, ptb.getFirstName());
                    ps.setString(3, ptb.getDiagnosis());
                    ps.setDate(4, ptb.getAdmissionDate());
                    ps.setDate(5, ptb.getReleaseDate());
                    ps.setInt(6, id);
                    result = ps.executeUpdate();
                    }
         
         return result;
     }
     
     ///////////////////////////////////////DELETE RECORD///////////////////////////////////////////
     
    @Override
     public int delete(int id) throws SQLException{
         int result = -1;
         
         String prepareStatement = "DELETE FROM PATIENT "+
                            "WHERE PATIENTID = ?";
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(prepareStatement)
                ){
            ps.setInt(1, id);
            result = ps.executeUpdate();
            
        }
        
        return result;
         
         
     }    
}