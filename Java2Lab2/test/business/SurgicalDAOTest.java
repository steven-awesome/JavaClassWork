/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.MedicationBean;
import data.SurgicalBean;
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
public class SurgicalDAOTest {
    
    public SurgicalDAOTest() {
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
     * Test of createSurgicalRecord method, of class SurgicalDAO.
     */
    @Test
    public void testCreateSurgicalRecord() throws Exception {
        System.out.println("createSurgicalRecord");
        Date date = Date.valueOf("2000-01-25");
        SurgicalBean sb = new SurgicalBean();
        sb.setPatientID(1);
        sb.setDateOfSurgery(date);
        sb.setSurgery("TestSurgery");
        sb.setRoomFee(123);
        sb.setSurgeonFee(456);
        sb.setSupplies(111);
        SurgicalDAO instance = new SurgicalDAO();
        instance.createSurgicalRecord(sb);
        ArrayList<SurgicalBean> result = instance.findSurgicalByID(1);
        assertEquals(sb, result.get(result.size()-1));
    }

    /**
     * Test of findSurgicalByID method, of class SurgicalDAO.
     */
    @Test
    public void testFindSurgicalByID() throws Exception {
        System.out.println("findSurgicalByID");
        int id = 1;
        Date date = Date.valueOf("2000-01-24");
        SurgicalBean sb = new SurgicalBean();
        sb.setPatientID(1);
        sb.setDateOfSurgery(date);
        sb.setSurgery("TestSurgery");
        sb.setRoomFee(123);
        sb.setSurgeonFee(456);
        sb.setSupplies(111);
        
        SurgicalDAO instance = new SurgicalDAO();
        
        ArrayList<SurgicalBean> result = instance.findSurgicalByID(id);
        assertEquals(sb, result.get(result.size()-1));
    }

    /**
     * Test of update method, of class SurgicalDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        SurgicalBean sb = null;
        int id = 0;
        SurgicalDAO instance = new SurgicalDAO();
        int expResult = 0;
        int result = instance.update(sb, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SurgicalDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        SurgicalDAO instance = new SurgicalDAO();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
