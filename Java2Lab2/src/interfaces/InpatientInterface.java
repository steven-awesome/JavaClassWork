/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import data.InpatientBean;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fista
 */
public interface InpatientInterface {
    
    public int createInpatientRecord(InpatientBean ipb) throws SQLException;
    
    public ArrayList<InpatientBean> findByID(int id) throws SQLException;
    
    public int update(InpatientBean ipb, int id) throws SQLException;
    
    public int delete(int id) throws SQLException;
    
}
