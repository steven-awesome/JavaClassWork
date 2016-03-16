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
import interfaces.InpatientInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fista
 */
public class InpatientDAO implements InpatientInterface {
    
    String url = "jdbc:derby://localhost:1527/HospitalDB";
    String user = "hospital";
    String password = "hospital";
    
    
    
    /////////////////////////////////////////////CREATE RECORD////////////////////////////////////////
    
    @Override
    public int createInpatientRecord(InpatientBean ipb) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO INPATIENT (PATIENTID, DATEOFSTAY, ROOMNUMBER, DAILYRATE, "
                            + "SUPPLIES, SERVICES) "
                                + "VALUES ((SELECT PATIENTID FROM PATIENT WHERE PATIENTID = ?), ?, ?, ?, ?, ?)";
        
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
    
    /////////////////////////////////////////////////////QUERIES//////////////////////////////////////////////
    
    // I made a find all method for troubleshooting
    public ArrayList<InpatientBean> findAll() throws SQLException {

        ArrayList<InpatientBean> arIPB = new ArrayList<>();

        String selectQuery = "SELECT PATIENTID, DATEOFSTAY, ROOMNUMBER, DAILYRATE, "
                            + "SUPPLIES, SERVICES "
                            + "FROM INPATIENT";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = connection
                .prepareStatement(selectQuery);
                ResultSet rs = ps.executeQuery()
                ) {
            while (rs.next()) {
                InpatientBean ipb = new InpatientBean();
                ipb.setPatientID(rs.getInt("PATIENTID"));
                ipb.setDateOfStay(rs.getDate("DATEOFSTAY"));
                ipb.setRoomNumber(rs.getString("ROOMNUMBER"));
                ipb.setDailyRate(rs.getDouble("DAILYRATE"));
                ipb.setSupplies(rs.getDouble("SUPPLIES"));
                ipb.setServices(rs.getDouble("SERVICES"));

                arIPB.add(ipb);
            }
        }
        return arIPB;
    }
    
    @Override
    public ArrayList<InpatientBean> findByID(int id) throws SQLException {
        
        ArrayList<InpatientBean> arIPB = new ArrayList();
        

        String selectQuery = "SELECT * "
                            + "FROM INPATIENT "
                            + "WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = 
                        connection.prepareStatement(selectQuery)) 
                {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    
                    while(rs.next()){
                        InpatientBean ipb = new InpatientBean();
                        ipb.setPatientID(rs.getInt("PATIENTID"));
                        ipb.setDateOfStay(rs.getDate("DATEOFSTAY"));
                        ipb.setRoomNumber(rs.getString("ROOMNUMBER"));
                        ipb.setDailyRate(rs.getDouble("DAILYRATE"));
                        ipb.setSupplies(rs.getDouble("SUPPLIES"));
                        ipb.setServices(rs.getDouble("SERVICES"));
                        
                        arIPB.add(ipb);
                    }

                }
        
        return arIPB;
    }
    
    //////////////////////////////////////UPDATE RECORDS/////////////////////////////////////
    
    @Override
     public int update(InpatientBean ipb, int id) throws SQLException{
         int result = -1;
         
         String prepareStatement = "UPDATE INPATIENT "
                 + "SET "
                 + "DATEOFSTAY = ?, "
                 + "ROOMNUMBER = ?, "
                 + "DAILYRATE = ?, "
                 + "SUPPLIES = ?, "
                 + "SERVICES = ? "
                 + "WHERE ID = ?";
         
         try(
                 Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement ps = connection.prepareStatement(prepareStatement)
                 ){
                    ps.setDate(1, ipb.getDateOfStay());
                    ps.setString(2, ipb.getRoomNumber());
                    ps.setDouble(3, ipb.getDailyRate());
                    ps.setDouble(4, ipb.getSupplies());
                    ps.setDouble(5, ipb.getServices());
                    ps.setInt(6, id);
                    result = ps.executeUpdate();
                    }
         
         return result;
     }
     
     ///////////////////////////////////////DELETE RECORD///////////////////////////////////////////
     
    @Override
     public int delete(int id) throws SQLException{
         int result = -1;
         //This statement deletes all records matching to a patient
         String prepareStatement = "DELETE FROM INPATIENT "+
                            "WHERE INPATIENT.ID IN (SELECT ID FROM INPATIENT WHERE PATIENTID = ?)";
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
