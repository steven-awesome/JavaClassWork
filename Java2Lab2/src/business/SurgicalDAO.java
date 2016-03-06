/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.SurgicalBean;
import interfaces.SurgicalInterface;
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
public class SurgicalDAO implements SurgicalInterface {
    
    String url = "jdbc:derby://localhost:1527/Hospital";
    String user = "hospital";
    String password = "hospital";
    
    
    
    /////////////////////////////////////////////CREATE RECORD////////////////////////////////////////
    
    @Override
    public int createSurgicalRecord(SurgicalBean sb) throws SQLException{
        
        int result = -1;
        
         String preparedSQL = "INSERT INTO SURGICAL (PATIENTID, DATEOFSURGERY, SURGERY,  ROOMFEE, "
                            + "SURGEONFEE, SUPPLIES) "
                                + "VALUES ((SELECT PATIENTID FROM PATIENT WHERE PATIENTID = ?), ?, ?, ?, ?, ?)";
        
        try(
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = connection.prepareStatement(preparedSQL);
            ){
            ps.setInt(1, sb.getPatientID());
            ps.setDate(2, sb.getDateOfSurgery());
            ps.setString(3, sb.getSurgery());
            ps.setDouble(4, sb.getRoomFee());
            ps.setDouble(5, sb.getSurgeonFee());
            ps.setDouble(6, sb.getSupplies());
            
            result = ps.executeUpdate();
        }
        
        return result;
        
    }
    
    /////////////////////////////////////////////////////QUERY//////////////////////////////////////////////
    
    @Override
    public ArrayList<SurgicalBean> findSurgicalByID(int id) throws SQLException {
        
        ArrayList<SurgicalBean> arSB = new ArrayList();
        

        String selectQuery = "SELECT * "
                            + "FROM SURGICAL "
                            + "WHERE PATIENTID = ?";

        try (Connection connection = DriverManager.getConnection(url, user,
                password);
                PreparedStatement ps = 
                        connection.prepareStatement(selectQuery)) 
                {
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();
                    
                    while(rs.next()){
                        SurgicalBean sb = new SurgicalBean();
                        sb.setPatientID(rs.getInt("PATIENTID"));
                        sb.setDateOfSurgery(rs.getDate("DATEOFSURGERY"));
                        sb.setSurgery(rs.getString("SURGERY"));
                        sb.setRoomFee(rs.getDouble("ROOMFEE"));
                        sb.setSurgeonFee(rs.getDouble("SURGEONFEE"));
                        sb.setSupplies(rs.getDouble("SUPPLIES"));
                        
                        arSB.add(sb);
                    }
                }
        
        return arSB;
    }
    
    //////////////////////////////////////UPDATE RECORDS/////////////////////////////////////
    
    @Override
     public int update(SurgicalBean sb, int id) throws SQLException{
         int result = -1;
         
         String prepareStatement = "UPDATE SURGICAL "
                 + "SET "
                 + "DATEOFSURGERY = ?, "
                 + "SURGERY = ?, "
                 + "ROOMFEE = ?, "
                 + "SURGEONFEE = ?, "
                 + "SUPPLIES = ? "
                 + "WHERE ID = ?";
         
         try(
                 Connection connection = DriverManager.getConnection(url, user, password);
                 PreparedStatement ps = connection.prepareStatement(prepareStatement)
                 ){
                    ps.setDate(1, sb.getDateOfSurgery());
                    ps.setString(2, sb.getSurgery());
                    ps.setDouble(3, sb.getRoomFee());
                    ps.setDouble(4, sb.getSurgeonFee());
                    ps.setDouble(5, sb.getSupplies());
                    ps.setInt(6, id);
                    result = ps.executeUpdate();
                    }
         
         return result;
     }
     
     ///////////////////////////////////////DELETE RECORD///////////////////////////////////////////
     
    @Override
     public int delete(int id) throws SQLException{
         int result = -1;
         
         String prepareStatement = "DELETE FROM SURGICAL "+
                            "WHERE SURGICAL.ID IN (SELECT ID FROM SURGICAL WHERE PATIENTID = ?)";
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
