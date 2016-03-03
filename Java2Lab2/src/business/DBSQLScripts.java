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
public class DBSQLScripts {

    public PatientBean patient;
    public InpatientBean inpatient;
    public MedicationBean meds;
    public SurgicalBean surgical;
    
    String url = "jdbc:derby://localhost:1527/Hospital";
    String user = "hospital";
    String password = "hospital";

    public DBSQLScripts() {
        patient = new PatientBean();
        inpatient = new InpatientBean();
        meds = new MedicationBean();
        surgical = new SurgicalBean();
    }
    
    //////////////////////////////////CREATE RECORDS///////////////////////////////////////
    
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
    
    public int createInpatientRecord(InpatientBean ipb) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO Patient (PATIENTID, DATEOFSTAY, ROOMNUMBER, DAILYRATE, "
                            + "SUPPLIES, SERVICES) "
                                + "VALUES (?, ?, ?, ?, ?, ?)";
        
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
        
        return result;
        
    }
    
    public int createSurgicalRecord(SurgicalBean surgical) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO SURGICAL (PATIENTID, DATEOFSURGERY, SURGERY, ROOMFEE, "
                            + "SURGEONFEE, SUPPLIES) "
                                + "VALUES (?, ?, ?, ?, ?, ?)";
        
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
        
        return result;
        
    }
    
    public int createMedicationRecord(MedicationBean medication) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO MEDICATION (PATIENTID, DATEOFMED, MED, UNITCOST, "
                            + "UNITS) "
                                + "VALUES (?, ?, ?, ?, ?, ?)";
        
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
        
        return result;
        
    }
    
    
    //////////////////////////////////////QUERIES////////////////////////////////////////////////
    
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
    
    public ArrayList<Object> findByID(int id) throws SQLException {
        
        ArrayList<Object> pats = new ArrayList();

        String selectQuery = "SELECT PATIENT.PATIENTID AS PID, PATIENT.LASTNAME, PATIENT.FIRSTNAME, PATIENT.DIAGNOSIS, PATIENT.ADMISSIONDATE, PATIENT.RELEASEDATE, "
                                        + "INPATIENT.DATEOFSTAY, INPATIENT.ROOMNUMBER, INPATIENT.DAILYRATE, INPATIENT.SUPPLIES, INPATIENT.SERVICES, "
                                        + "SURGICAL.DATEOFSURGERY, SURGICAL.SURGERY,  SURGICAL.ROOMFEE, SURGICAL.SURGEONFEE, SURGICAL.SUPPLIES, "
                                        + "MEDICATION.DATEOFMED, MEDICATION.MED, MEDICATION.UNITCOST, MEDICATION.UNITS "
                            + "FROM PATIENT "
                            + "LEFT JOIN INPATIENT ON PATIENT.PATIENTID = INPATIENT.PATIENTID "
                            + "INNER JOIN SURGICAL ON INPATIENT.PATIENTID = SURGICAL.PATIENTID "
                            + "INNER JOIN MEDICATION ON SURGICAL.PATIENTID = MEDICATION.PATIENTID "
                            + "WHERE PATIENT.PATIENTID = ?";

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

                        pt.setPatientID(rs.getInt("PID"));
                        pt.setLastName(rs.getString("LASTNAME"));
                        pt.setFirstName(rs.getString("FIRSTNAME"));
                        pt.setDiagnosis(rs.getString("DIAGNOSIS"));
                        pt.setAdmissionDate(rs.getDate("ADMISSIONDATE"));
                        pt.setReleaseDate(rs.getDate("RELEASEDATE"));
                        ipb.setDateOfStay(rs.getDate("DATEOFSTAY"));
                        ipb.setRoomNumber(rs.getString("ROOMNUMBER"));
                        ipb.setDailyRate(rs.getDouble("DAILYRATE"));
                        ipb.setSupplies(rs.getDouble("SUPPLIES"));
                        ipb.setServices(rs.getDouble("SERVICES"));
                        sb.setDateOfSurgery(rs.getDate("DATEOFSURGERY"));
                        sb.setSurgery(rs.getString("SURGERY"));
                        sb.setRoomFee(rs.getDouble("ROOMFEE"));
                        sb.setSurgeonFee(rs.getDouble("SURGEONFEE"));
                        sb.setSupplies(rs.getDouble("SUPPLIES"));
                        mb.setDateOfMed(rs.getDate("DATEOFMED"));
                        mb.setMed(rs.getString("MED"));
                        mb.setUnitCost(rs.getDouble("UNITCOST"));
                        mb.setUnits(rs.getDouble("UNITS"));
                    
                    }
                    
                    pats.add(pt);
                    pats.add(ipb);
                    pats.add(sb);
                    pats.add(mb);
                }
        
        return pats;
    }
    
     public ArrayList<Object> findByLastName(String lName) throws SQLException {

        int result = -1;
        ArrayList<Object> pats = new ArrayList();

        String selectQuery = "SELECT PATIENT.PATIENTID AS PID, PATIENT.LASTNAME, PATIENT.FIRSTNAME, PATIENT.DIAGNOSIS, PATIENT.ADMISSIONDATE, PATIENT.RELEASEDATE, "
                                        + "INPATIENT.DATEOFSTAY, INPATIENT.ROOMNUMBER, INPATIENT.DAILYRATE, INPATIENT.SUPPLIES, INPATIENT.SERVICES, "
                                        + "SURGICAL.DATEOFSURGERY, SURGICAL.SURGERY,  SURGICAL.ROOMFEE, SURGICAL.SURGEONFEE, SURGICAL.SUPPLIES, "
                                        + "MEDICATION.DATEOFMED, MEDICATION.MED, MEDICATION.UNITCOST, MEDICATION.UNITS "
                            + "FROM PATIENT "
                            + "LEFT JOIN INPATIENT ON PATIENT.PATIENTID = INPATIENT.PATIENTID "
                            + "INNER JOIN SURGICAL ON INPATIENT.PATIENTID = SURGICAL.PATIENTID "
                            + "INNER JOIN MEDICATION ON SURGICAL.PATIENTID = MEDICATION.PATIENTID "
                            + "AND PATIENT.LASTNAME = ?";

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
                        ipb.setPatientID(rs.getInt("PATIENTID"));
                        ipb.setDateOfStay(rs.getDate("DATEOFSTAY"));
                        ipb.setRoomNumber(rs.getString("ROOMNUMBER"));
                        ipb.setDailyRate(rs.getDouble("DAILYRATE"));
                        ipb.setSupplies(rs.getDouble("SUPPLIES"));
                        ipb.setServices(rs.getDouble("SERVICES"));
                        sb.setPatientID(rs.getInt("PATIENTID"));
                        sb.setDateOfSurgery(rs.getDate("DATEOFSURGERY"));
                        sb.setSurgery(rs.getString("SURGERY"));
                        sb.setRoomFee(rs.getDouble("ROOMFEE"));
                        sb.setSurgeonFee(rs.getDouble("SURGEONFEE"));
                        sb.setSupplies(rs.getDouble("SUPPLIES"));
                        mb.setPatientID(rs.getInt("PATIENTID"));
                        mb.setDateOfMed(rs.getDate("DATEOFMED"));
                        mb.setMed(rs.getString("MED"));
                        mb.setUnitCost(rs.getDouble("UNITCOST"));
                        mb.setUnits(rs.getDouble("UNITS"));
                    }
                    
                    pats.add(pt);
                    pats.add(ipb);
                    pats.add(sb);
                    pats.add(mb);
                }
        
        return pats;
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
        
        return result;
         
         
     }
     
     
     
     
     
     
}
