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
    
    String url = "jdbc:derby://localhost:1527/Hospital";
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
        
         String preparedSQL = "INSERT INTO Patient (PATIENTID, LASTNAME, FIRSNAME, DIAGNOSIS, "
                            + "ADMISSIONDATE, RELEASEDATE) "
                                + "VALUES (?, ?, ?, ?, ?, ?)";
        
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
        
        return result;
        
    }
    
    //////////////////////////////////////QUERIES////////////////////////////////////////////////
    
    @Override
    public ArrayList<PatientBean> findAll() throws SQLException {

        ArrayList<PatientBean> pt = new ArrayList<>();

        String selectQuery = "SELECT PATIENTID, LASTNAME, FIRSNAME, DIAGNOSIS, "
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
                pt1.setFirstName(rs.getString("FIRSNAME"));
                pt1.setDiagnosis(rs.getString("DIAGNOSIS"));
                pt1.setAdmissionDate(rs.getDate("ADMISSIONDATE"));
                pt1.setReleaseDate(rs.getDate("RELEASEDATE"));

                pt.add(pt1);
            }
        }
        return pt;
    }
    
    @Override
    public ArrayList<PatientBean> findByID(int id) throws SQLException {
        
        ArrayList<PatientBean> pats = new ArrayList();

        String selectQuery = "SELECT * FROM PATIENT "
                            + "WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = 
                        connection.prepareStatement(selectQuery)) 
                {
                    PatientBean pt = new PatientBean();
                    InpatientBean ipb = new InpatientBean();
                    SurgicalBean sb = new SurgicalBean();
                    MedicationBean mb = new MedicationBean();
                    
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()){

                        pt.setPatientID(rs.getInt("PATIENTID"));
                        pt.setLastName(rs.getString("LASTNAME"));
                        pt.setFirstName(rs.getString("FIRSTNAME"));
                        pt.setDiagnosis(rs.getString("DIAGNOSIS"));
                        pt.setAdmissionDate(rs.getDate("ADMISSIONDATE"));
                        pt.setReleaseDate(rs.getDate("RELEASEDATE"));
                        pats.add(pt);
                    
                    }
                }
        
        return pats;
    }
    
    @Override
     public ArrayList<PatientBean> findByLastName(String lName) throws SQLException {

        int result = -1;
        ArrayList<PatientBean> pats = new ArrayList();

        String selectQuery = "SELECT * FROM PATIENT "
                            + "WHERE LASTNAME = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = 
                        connection.prepareStatement(selectQuery)) 
                {
                    PatientBean pt = new PatientBean();
                    InpatientBean ipb = new InpatientBean();
                    SurgicalBean sb = new SurgicalBean();
                    MedicationBean mb = new MedicationBean();
                    
                    ps.setString(1, lName);
                    ResultSet rs = ps.executeQuery();
                    
                    while(rs.next()){

                        pt.setPatientID(rs.getInt("PATIENTID"));
                        pt.setLastName(rs.getString("LASTNAME"));
                        pt.setFirstName(rs.getString("FIRSNAME"));
                        pt.setDiagnosis(rs.getString("DIAGNOSIS"));
                        pt.setAdmissionDate(rs.getDate("ADMISSIONDATE"));
                        pt.setReleaseDate(rs.getDate("RELEASEDATE"));
                        pats.add(pt);

                    }
                }
        
        return pats;
    }
     
     //////////////////////////////////////UPDATE RECORDS/////////////////////////////////////
    
    @Override
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
         
         return result;
     }
     
     ///////////////////////////////////////DELETE RECORD///////////////////////////////////////////
     
    @Override
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
        
        return result;
         
         
     }
     
     
     
     
     
     
}


/*String selectQuery = "SELECT PATIENT.PATIENTID AS PID, PATIENT.LASTNAME, PATIENT.FIRSTNAME, PATIENT.DIAGNOSIS, PATIENT.ADMISSIONDATE, PATIENT.RELEASEDATE, "
                                        + "INPATIENT.DATEOFSTAY, INPATIENT.ROOMNUMBER, INPATIENT.DAILYRATE, INPATIENT.SUPPLIES, INPATIENT.SERVICES, "
                                        + "SURGICAL.DATEOFSURGERY, SURGICAL.SURGERY,  SURGICAL.ROOMFEE, SURGICAL.SURGEONFEE, SURGICAL.SUPPLIES, "
                                        + "MEDICATION.DATEOFMED, MEDICATION.MED, MEDICATION.UNITCOST, MEDICATION.UNITS "
                            + "FROM PATIENT "
                            + "LEFT JOIN INPATIENT ON PATIENT.PATIENTID = INPATIENT.PATIENTID "
                            + "INNER JOIN SURGICAL ON INPATIENT.PATIENTID = SURGICAL.PATIENTID "
                            + "INNER JOIN MEDICATION ON SURGICAL.PATIENTID = MEDICATION.PATIENTID "
                            + "WHERE PATIENT.PATIENTID = ?";*/