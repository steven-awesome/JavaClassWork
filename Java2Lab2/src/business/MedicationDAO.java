/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.MedicationBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fista
 */
public class MedicationDAO {
    
    String url = "jdbc:derby://localhost:1527/Hospital";
    String user = "hospital";
    String password = "hospital";
    
    
    
    /////////////////////////////////////////////CREATE RECORD////////////////////////////////////////
    
    public int createMedicationlRecord(MedicationBean mb) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO MEDICATION (PATIENTID, DATEOFMED, MED, UNITCOST, "
                            + "UNITS) "
                                + "VALUES (?, ?, ?, ?, ?)";
        
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(preparedSQL);
            ){
            ps.setInt(1, mb.getPatientID());
            ps.setDate(2, mb.getDateOfMed());
            ps.setString(3, mb.getMed());
            ps.setDouble(4, mb.getUnitCost());
            ps.setDouble(5, mb.getUnits());
            
            result = ps.executeUpdate();
        }
        
        return result;
        
    }
    
    /////////////////////////////////////////////////////QUERY//////////////////////////////////////////////
    
    public MedicationBean findByID(int id) throws SQLException {
        
        MedicationBean mb = new MedicationBean();

        String selectQuery = "SELECT * "
                            + "FROM MEDICATION "
                            + "WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = 
                        connection.prepareStatement(selectQuery)) 
                {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    
                    while(rs.next()){

                        mb.setPatientID(rs.getInt("PATIENTID"));
                        mb.setDateOfMed(rs.getDate("DATEOFMED"));
                        mb.setMed(rs.getString("MED"));
                        mb.setUnitCost(rs.getDouble("UNITCOST"));
                        mb.setUnits(rs.getDouble("UNITS"));
                    }

                }
        
        return mb;
    }
    
    //////////////////////////////////////UPDATE RECORDS/////////////////////////////////////
    
     public int update(MedicationBean mb, int id) throws SQLException{
         int result = -1;
         
         String prepareStatement = "UPDATE MEDICATION "
                 + "SET "
                 + "PATIENTID = ?, "
                 + "DATEOFMED = ?, "
                 + "MED = ?, "
                 + "UNITCOST = ?, "
                 + "UNITS = ? "
                 + "WHERE ID = ?";
         
         try(
                 Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement ps = connection.prepareStatement(prepareStatement)
                 ){
                    ps.setInt(1, mb.getPatientID());
                    ps.setDate(2, mb.getDateOfMed());
                    ps.setString(3, mb.getMed());
                    ps.setDouble(4, mb.getUnitCost());
                    ps.setDouble(5, mb.getUnits());
                    ps.setInt(7, id);
                    result = ps.executeUpdate();
                    }
         
         return result;
     }
     
     ///////////////////////////////////////DELETE RECORD///////////////////////////////////////////
     
     public int delete(int id) throws SQLException{
         int result = -1;
         
         String prepareStatement = "DELETE FROM MEDICATION "+
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
