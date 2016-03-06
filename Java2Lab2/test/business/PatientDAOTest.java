/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.PatientBean;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
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
        PatientDAO instance = new PatientDAO();
        PatientBean result = new PatientBean();
        
        result = instance.findByLastName("TestLastName");

        instance.delete(result.getPatientID());
    }


    /**
     * Test of createPatient method, of class PatientDAO.
     */
    @After
    @Test
    public void testCreatePatient() throws Exception {
        System.out.println("createPatient");
        PatientDAO instance = new PatientDAO();
        Date dateAdmit = Date.valueOf("2015-01-23");
        Date dateRelease = Date.valueOf("2015-01-25");
        PatientBean patient = new PatientBean();
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");
        patient.setDiagnosis("TestDiagnosis");
        patient.setAdmissionDate(dateAdmit);
        patient.setReleaseDate(dateRelease);
        
        int result = instance.createPatient(patient);
        int expResult = 1;
        assertEquals(expResult, result);
        
        instance.delete(instance.findByLastName("TestLastName").getPatientID());
    }

    /**
     * Test of findAll method, of class PatientDAO.
     */
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        PatientDAO instance = new PatientDAO();
        instance.delete(instance.findByLastName("TestLastName").getPatientID());
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
        //Creating patient bean to be compared. We know the data of PATIENTID 1 
        //by looking it up in the database beforehand
        Date dateAdmit = Date.valueOf("2014-01-23");
        Date dateRelease = Date.valueOf("2014-01-25");
        PatientBean pb = new PatientBean();
        pb.setPatientID(1);
        pb.setLastName("Wayne");
        pb.setFirstName("Bruce");
        pb.setDiagnosis("Asthma");
        pb.setAdmissionDate(dateAdmit);
        pb.setReleaseDate(dateRelease);
        
        PatientDAO instance = new PatientDAO();
        
        PatientBean result = instance.findByID(id);
        assertEquals(pb, result);
    }

    /**
     * Test of findByLastName method, of class PatientDAO.
     */
    @Test
    public void testFindByLastName() throws Exception {
        System.out.println("findByLastName");
        String lName = "Wayne";
        Date dateAdmit = Date.valueOf("2014-01-23");
        Date dateRelease = Date.valueOf("2014-01-25");
        PatientBean pb = new PatientBean();
        pb.setPatientID(1);
        pb.setLastName("Wayne");
        pb.setFirstName("Bruce");
        pb.setDiagnosis("Asthma");
        pb.setAdmissionDate(dateAdmit);
        pb.setReleaseDate(dateRelease);
        PatientDAO instance = new PatientDAO();
        ArrayList<PatientBean> expResult = null;
        PatientBean result = instance.findByLastName(lName);
        assertEquals(pb, result);

    }

    /**
     * Test of update method, of class PatientDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        int id = 1;
        PatientDAO instance = new PatientDAO();
        PatientBean pbOriginal = new PatientBean();
        PatientBean pb = new PatientBean();
        pbOriginal = instance.findByID(1);
        Date dateAdmit = Date.valueOf("2013-01-01");
        Date dateRelease = Date.valueOf("2013-02-01");
        pb.setPatientID(id);
        pb.setLastName("Wayne");
        pb.setFirstName("Bruce");
        pb.setDiagnosis("Asthma");
        pb.setAdmissionDate(dateAdmit);
        pb.setReleaseDate(dateRelease);
        
        
        int result = instance.update(pb, id);
        assertEquals(pb, instance.findByID(id));
        
        result = instance.update(pbOriginal, id);
    }

    /**
     * Test of delete method, of class PatientDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        String lName = "TestLastName";
        PatientDAO instance = new PatientDAO();
        int pID = instance.findByLastName(lName).getPatientID();
        int expResult = 5;
        instance.delete(pID);
        int result = instance.findAll().size();
        assertEquals(expResult, result);
    }
    
}
