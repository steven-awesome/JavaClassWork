/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.MedicationBean;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import java.sql.Date;

/**
 *
 * @author fista
 */
public class MedicationDAOTest {
    
    public MedicationDAOTest() {
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
     * Test of createMedicationlRecord method, of class MedicationDAO.
     */
    @Test
    public void testCreateMedicationlRecord() throws Exception {
        System.out.println("createMedicationlRecord");
        Date date = Date.valueOf("2011-01-25");
        MedicationBean mb = new MedicationBean();
        mb.setPatientID(1);
        mb.setDateOfMed(date);
        mb.setMed("TestCandy");
        mb.setUnitCost(123);
        mb.setUnits(456);
        MedicationDAO instance = new MedicationDAO();
        instance.createMedicationRecord(mb);
        ArrayList<MedicationBean> result = instance.findMedicationByID(1);
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
        assertEquals(mb, result.get(result.size()-1));
    }

    /**
     * Test of update method, of class MedicationDAO.
     */
    @Ignore
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Date dateMed = Date.valueOf("2013-01-01");
        MedicationBean mb = new MedicationBean();
        mb.setPatientID(1);
        mb.setDateOfMed(dateMed);
        mb.setMed("Snickers");
        mb.setUnitCost(1.25);
        mb.setUnits(5);
        
        int id = 1;
        MedicationDAO instance = new MedicationDAO();
        int expResult = 1;
        int result = instance.update(mb, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class MedicationDAO.
     */
    @Ignore
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id = 0;
        MedicationDAO instance = new MedicationDAO();
        int expResult = 0;
        int result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
