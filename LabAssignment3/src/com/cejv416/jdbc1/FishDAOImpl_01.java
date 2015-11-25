package com.cejv416.jdbc1;

import java.sql.*;

/**
 * @author Ken Fogel
 *
 */
public class FishDAOImpl_01 implements FishDAO_01 {


    String url = "jdbc:derby://localhost:1527/fishDB";
    String user = "fish";
    String password = "fish";

    /**
     * Constructor
     */
    public FishDAOImpl_01() {
        super();
    }

    /**
     * Retrieve all the records and display them on the console Uses
     * try-with-resources so that the Connection, PreparedStatement and
     * ResultSet are closed no matter what happens
     *
     * @return A string with the records in it
     */
    @Override
    public String retrieveData(String usr) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT * FROM FISH "+
                "WHERE SPECIESORIGIN = ?";
        try (
                Connection connection = 
                        DriverManager.getConnection(url, user, password);
                PreparedStatement pStatement = 
                        connection.prepareStatement(query))
        {
            pStatement.setString(1, usr);
        
            ResultSet resultSet = pStatement.executeQuery(); 
            ResultSetMetaData rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                    sb.append(resultSet.getString(i)).append("\n");
                }
                sb.append("====================\n");
            }
        }
        
        return sb.toString();
    }
    
    // add your other methods
}
