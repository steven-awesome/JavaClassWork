/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.InpatientBean;
import data.PatientBean;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author fista
 */
public class InpatientDAOTest {
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        System.out.println("testsetup");
        PatientBean pb = new PatientBean();
        PatientDAO pdao = new PatientDAO();
        Date dateAdmit = Date.valueOf("2015-01-23");
        Date dateRelease = Date.valueOf("2015-01-25");
        PatientBean patient = new PatientBean();
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");
        patient.setDiagnosis("TestDiagnosis");
        patient.setAdmissionDate(dateAdmit);
        patient.setReleaseDate(dateRelease);
        pdao.createPatient(patient);
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        System.out.println("testteardown");
        InpatientDAO indao = new InpatientDAO();
        PatientDAO pdao = new PatientDAO();
        
        indao.delete(pdao.findByLastName("TestLastName").getPatientID());
        pdao.delete(pdao.findByLastName("TestLastName").getPatientID());
    }
    
    @Before
    public void setUp() throws SQLException {
       
    }
    
    @After
    public void tearDown() throws SQLException {
        
    }
    
    /**
     * Test of createInpatientRecord method, of class InpatientDAO.
     */
    
    @Test
    public void testCreateInpatientRecord() throws Exception {
        System.out.println("createInpatientRecord");
        InpatientBean ipb = new InpatientBean();
        InpatientDAO instance = new InpatientDAO();
        PatientDAO pdao = new PatientDAO();
        
        Date dateStay = Date.valueOf("2016-01-04");
        //Finding ID of patient created in the SetUp
        ipb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        ipb.setDateOfStay(dateStay);
        ipb.setRoomNumber("Test2");
        ipb.setDailyRate(123);
        ipb.setSupplies(456);
        ipb.setServices(789);
        int expResult = 1;
        int result = instance.createInpatientRecord(ipb);
        //Verfying the update was done
        assertEquals(expResult, result);
    }

    /**
     * Test of findByID method, of class InpatientDAO.
     */
    @Test
    public void testFindByID() throws Exception {
        System.out.println("findByID");
        int id = 1;
        InpatientBean ipb = new InpatientBean();
        InpatientDAO instance = new InpatientDAO();
         ArrayList<InpatientBean> findResult = new ArrayList();
        
        Date dateStay = Date.valueOf("2014-01-23");
        
        ipb.setDateOfStay(dateStay);
        ipb.setRoomNumber("A1");
        ipb.setDailyRate(250.00);
        ipb.setSupplies(75.24);
        ipb.setServices(12.95);
        findResult = instance.findByID(id);
        InpatientBean result = new InpatientBean();
        //Finding ID '1' in list of inpatient records
                for (InpatientBean in : findResult){
                    if (in.getID() == 1){
                        result = in;
                    }
                }
        //Verifying the correct record was found by ID
        assertEquals(ipb.getID(), result.getID());
    }

    /**
     * Test of update method, of class InpatientDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        PatientDAO pdao = new PatientDAO();
        InpatientBean ipb = new InpatientBean();
        InpatientDAO indao = new InpatientDAO();
        Date dateStay = Date.valueOf("2009-01-03");
        ArrayList<InpatientBean> findResult = new ArrayList();
        int pID = pdao.findByLastName("TestLastName").getPatientID();
        ipb.setDateOfStay(dateStay);
        ipb.setRoomNumber("Test2");
        ipb.setDailyRate(333);
        ipb.setSupplies(444);
        ipb.setServices(555);
        int result = indao.update(ipb, pID);
        int expResult = 1;
        //Verifies the update was done
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class InpatientDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        InpatientDAO instance = new InpatientDAO();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
    
}
