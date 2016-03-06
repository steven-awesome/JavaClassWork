/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import data.InpatientBean;
import data.MedicationBean;
import data.PatientBean;
import data.SurgicalBean;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Steven
 */
public interface PatientInterface {
    
    public int createPatient(PatientBean patient) throws SQLException;
    
    public ArrayList<PatientBean> findAll() throws SQLException;
    public PatientBean findByID(int id) throws SQLException;
    public PatientBean findByLastName(String lName) throws SQLException;
    
    public int update(PatientBean ptb, int id) throws SQLException;
    
    public int delete(int id) throws SQLException;
    
    
}
