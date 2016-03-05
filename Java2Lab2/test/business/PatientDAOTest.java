/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.PatientBean;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPatient method, of class PatientDAO.
     */
    @Test
    public void testCreatePatient() throws Exception {
        System.out.println("createPatient");
        PatientBean patient = null;
        PatientDAO instance = new PatientDAO();
        int expResult = 0;
        int result = instance.createPatient(patient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class PatientDAO.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        PatientDAO instance = new PatientDAO();
        ArrayList<PatientBean> expResult = null;
        ArrayList<PatientBean> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByID method, of class PatientDAO.
     */
    @Test
    public void testFindByID() throws Exception {
        System.out.println("findByID");
        int id = 0;
        PatientDAO instance = new PatientDAO();
        ArrayList<PatientBean> expResult = null;
        ArrayList<PatientBean> result = instance.findByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByLastName method, of class PatientDAO.
     */
    @Test
    public void testFindByLastName() throws Exception {
        System.out.println("findByLastName");
        String lName = "";
        PatientDAO instance = new PatientDAO();
        ArrayList<PatientBean> expResult = null;
        ArrayList<PatientBean> result = instance.findByLastName(lName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class PatientDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        PatientBean ptb = null;
        int id = 0;
        PatientDAO instance = new PatientDAO();
        int expResult = 0;
        int result = instance.update(ptb, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PatientDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        PatientDAO instance = new PatientDAO();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
