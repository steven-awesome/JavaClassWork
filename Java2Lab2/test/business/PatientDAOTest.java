/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

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
public class PatientDAOTest {
    
    public PatientDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
    }
    
    @After
    public void tearDown() throws SQLException {
    }

    /**
     * Test of createPatient method, of class PatientDAO.
     */
    /*
    @Ignore
    @After
    @Test
    public void testCreatePatient() throws Exception {
        System.out.println("createPatient");
        Date dateAdmit = Date.valueOf("2016-01-01");
        Date dateRelease = Date.valueOf("2016-02-01");
        PatientBean patient = new PatientBean();
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFistName");
        patient.setDiagnosis("TestDiagnosis");
        patient.setAdmissionDate(dateAdmit);
        patient.setReleaseDate(dateRelease);
        
        PatientDAO instance = new PatientDAO();
        ArrayList<PatientBean> expResult = instance.findByID(instance.findAll().size()-1);
        int result = instance.createPatient(patient);
        assertEquals(expResult.get(0), patient);
    }

    /**
     * Test of findAll method, of class PatientDAO.
     */
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        PatientDAO instance = new PatientDAO();
        int expResult = 5;
        ArrayList<PatientBean> result = new ArrayList();
        result = instance.findAll();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of findByID method, of class PatientDAO.
     */
    @Test
    public void testFindByID() throws Exception {
        System.out.println("findByID");
        int id = 1;
        Date dateAdmit = Date.valueOf("2014-01-23");
        Date dateRelease = Date.valueOf("2016-01-25");
        PatientBean pb = new PatientBean();
        pb.setPatientID(1);
        pb.setLastName("Wayne");
        pb.setFirstName("Bruce");
        pb.setDiagnosis("Asthma");
        pb.setAdmissionDate(dateAdmit);
        pb.setReleaseDate(dateRelease);
        
        PatientDAO instance = new PatientDAO();
        
        ArrayList<PatientBean> expResult = null;
        
        
        ArrayList<PatientBean> result = instance.findByID(id);
        assertEquals(pb, result.get(0));
    }

    /**
     * Test of findByLastName method, of class PatientDAO.
     */
    @Test
    public void testFindByLastName() throws Exception {
        System.out.println("findByLastName");
        String lName = "Wayne";
        Date dateAdmit = Date.valueOf("2016-01-01");
        Date dateRelease = Date.valueOf("2016-02-01");
        PatientBean pb = new PatientBean();
        pb.setPatientID(1);
        pb.setLastName("Wayne");
        pb.setFirstName("Bruce");
        pb.setDiagnosis("Asthma");
        pb.setAdmissionDate(dateAdmit);
        pb.setReleaseDate(dateRelease);
        PatientDAO instance = new PatientDAO();
        ArrayList<PatientBean> expResult = null;
        ArrayList<PatientBean> result = instance.findByLastName(lName);
        assertEquals(pb, result.get(0));

    }

    /**
     * Test of update method, of class PatientDAO.
     */
    @Ignore
    @Before
    @After
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        Date dateAdmit = Date.valueOf("2013-01-01");
        Date dateRelease = Date.valueOf("2013-02-01");
        PatientBean pb = new PatientBean();
        pb.setPatientID(6);
        pb.setLastName("Wayne");
        pb.setFirstName("Bruce");
        pb.setDiagnosis("Asthma");
        pb.setAdmissionDate(dateAdmit);
        pb.setReleaseDate(dateRelease);
        int id = 0;
        PatientDAO instance = new PatientDAO();
        int expResult = 0;
        int result = instance.update(pb, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class PatientDAO.
     */
    @Ignore
    @Before
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 6;
        PatientDAO instance = new PatientDAO();
        int expResult = 5;
        instance.delete(id);
        int result = instance.findAll().size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
