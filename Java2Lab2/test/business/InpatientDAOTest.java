/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.InpatientBean;
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
public class InpatientDAOTest {
    
    public InpatientDAOTest() {
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
     * Test of createInpatientRecord method, of class InpatientDAO.
     */
    @Test
    public void testCreateInpatientRecord() throws Exception {
        System.out.println("createInpatientRecord");
        InpatientBean ipb = null;
        InpatientDAO instance = new InpatientDAO();
        int expResult = 0;
        int result = instance.createInpatientRecord(ipb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByID method, of class InpatientDAO.
     */
    @Test
    public void testFindByID() throws Exception {
        System.out.println("findByID");
        int id = 0;
        InpatientDAO instance = new InpatientDAO();
        ArrayList<InpatientBean> expResult = null;
        ArrayList<InpatientBean> result = instance.findByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class InpatientDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        InpatientBean ipb = null;
        int id = 0;
        InpatientDAO instance = new InpatientDAO();
        int expResult = 0;
        int result = instance.update(ipb, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
