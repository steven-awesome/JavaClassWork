/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fista
 */
public interface MasterDAOScriptsInterface {
    
    public ArrayList<Object> findRecordsByID(int id) throws SQLException;
    public ArrayList<Object> findRecordsByLName(String lastName) throws SQLException;
    public int deleteRecordsByID(int id) throws SQLException;
    
}
