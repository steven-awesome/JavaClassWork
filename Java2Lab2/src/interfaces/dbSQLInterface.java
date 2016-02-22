/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import data.PatientBean;

/**
 *
 * @author Steven
 */
public interface dbSQLInterface {
    
    public int createPatient(PatientBean patient);
    
    
    
}
