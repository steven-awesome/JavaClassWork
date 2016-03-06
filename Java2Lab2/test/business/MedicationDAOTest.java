/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.MedicationBean;
import data.PatientBean;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author fista
 */
public class MedicationDAOTest {
    
    public MedicationDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
    }
    
    @Before
    public void setUp() throws SQLException {
        System.out.println("Test set up");
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
        Date date = Date.valueOf("2011-01-25");
        MedicationBean mb = new MedicationBean();
        mb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        mb.setDateOfMed(date);
        mb.setMed("TestCandy");
        mb.setUnitCost(123);
        mb.setUnits(456);
        MedicationDAO instance = new MedicationDAO();
        instance.createMedicationRecord(mb);
    }
    
    @After
    public void tearDown() throws SQLException {
        System.out.println("Test tear down");
        PatientDAO pdao = new PatientDAO();
        MedicationDAO instance = new MedicationDAO();
        instance.delete(pdao.findByLastName("TestLastName").getPatientID());
        pdao.delete(pdao.findByLastName("TestLastName").getPatientID());
    }

    /**
     * Test of createMedicationlRecord method, of class MedicationDAO.
     */
    @Test
    public void testCreateMedicationlRecord() throws Exception {
        System.out.println("createMedicationlRecord");
        Date date = Date.valueOf("2011-01-25");
        MedicationBean mb = new MedicationBean();
        PatientDAO pdao = new PatientDAO();
        mb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        mb.setDateOfMed(date);
        mb.setMed("TestCreateMed");
        mb.setUnitCost(111);
        mb.setUnits(222);
        MedicationDAO instance = new MedicationDAO();
        instance.createMedicationRecord(mb);
        ArrayList<MedicationBean> result = instance.findMedicationByID(pdao.findByLastName("TestLastName").getPatientID());
        assertEquals(mb, result.get(result.size()-1));
    }

    /**
     * Test of findByID method, of class MedicationDAO.
     */
    @Test
    public void testFindByMedicationID() throws Exception {
        System.out.println("findByID");
        int id = 1;
        Date date = Date.valueOf("2014-01-24");
        MedicationBean mb = new MedicationBean();
        mb.setID(1);
        mb.setPatientID(1);
        mb.setDateOfMed(date);
        mb.setMed("Snickers");
        mb.setUnitCost(1.25);
        mb.setUnits(5);
        
        MedicationDAO instance = new MedicationDAO();
        
        ArrayList<MedicationBean> result = instance.findMedicationByID(id);
        assertEquals(mb, result.get(0));
    }

    /**
     * Test of update method, of class MedicationDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        MedicationDAO instance = new MedicationDAO();
        MedicationBean mb = new MedicationBean();
        
        Date date = Date.valueOf("2011-01-25");
        ArrayList<MedicationBean> findMedsWithLastName = new ArrayList();
        PatientDAO pdao = new PatientDAO();
        findMedsWithLastName = instance.findMedicationByID(pdao.findByLastName("TestLastName").getPatientID());
        
        mb.setDateOfMed(date);
        mb.setMed("TestCreateMed2");
        mb.setUnitCost(321);
        mb.setUnits(555);
        
        MedicationBean mb1 = new MedicationBean();
        mb1 = findMedsWithLastName.get(0);
        int id = mb1.getID();
        int result = instance.update(mb, id);
        int expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class MedicationDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        PatientDAO pdao = new PatientDAO();
        int id = pdao.findByLastName("TestLastName").getPatientID();
        MedicationDAO instance = new MedicationDAO();
        int expResult = 1;
        int result = instance.delete(id);
        assertEquals(expResult, result);
    }
    
}
