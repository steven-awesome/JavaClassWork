/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.InpatientBean;
import java.sql.Date;
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
public class MasterDAOScriptsTest {
    
    public MasterDAOScriptsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        InpatientBean ipb = new InpatientBean();
        InpatientDAO instance = new InpatientDAO();
        
        Date dateStay = Date.valueOf("2016-01-04");
        
        ipb.setPatientID(1);
        ipb.setDateOfStay(dateStay);
        ipb.setRoomNumber("Test2");
        ipb.setDailyRate(123);
        ipb.setSupplies(456);
        ipb.setServices(789);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findRecordsByID method, of class MasterDAOScripts.
     */
    @Test
    public void testFindRecordsByID() throws Exception {
        System.out.println("findRecordsByID");
        int id = 0;
        MasterDAOScripts instance = new MasterDAOScripts();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.findRecordsByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRecordsByLName method, of class MasterDAOScripts.
     */
    @Test
    public void testFindRecordsByLName() throws Exception {
        System.out.println("findRecordsByLName");
        String lastName = "";
        MasterDAOScripts instance = new MasterDAOScripts();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.findRecordsByLName(lastName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRecordsByID method, of class MasterDAOScripts.
     */
    @Test
    public void testDeleteRecordsByID() throws Exception {
        System.out.println("deleteRecordsByID");
        int id = 1;
        MasterDAOScripts instance = new MasterDAOScripts();
        int expResult = 1;
        int result = instance.deleteRecordsByID(id);
        assertEquals(expResult, result);
    }
    
}
