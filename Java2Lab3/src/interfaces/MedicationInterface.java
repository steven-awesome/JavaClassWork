/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import data.MedicationBean;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fista
 */
public interface MedicationInterface {
    
    public int createMedicationRecord(MedicationBean mb) throws SQLException;
    
    public ArrayList<MedicationBean> findMedicationByID(int id) throws SQLException;
    
    public int update(MedicationBean mb, int id) throws SQLException;
    
    public int delete(int id) throws SQLException;
    
}
