/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import data.SurgicalBean;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fista
 */
public interface SurgicalInterface {
    
    public int createSurgicalRecord(SurgicalBean sb) throws SQLException;
    
    public ArrayList<SurgicalBean> findSurgicalByID(int id) throws SQLException;
    
    public int update(SurgicalBean sb, int id) throws SQLException;
    
    public int delete(int id) throws SQLException;
    
}
