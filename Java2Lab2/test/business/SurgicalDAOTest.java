/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.MedicationBean;
import data.PatientBean;
import data.SurgicalBean;
import java.sql.Date;
import java.sql.SQLException;
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
        System.out.println("testteardownclass");
        SurgicalDAO sdao = new SurgicalDAO();
        PatientDAO pdao = new PatientDAO();
        
        sdao.delete(pdao.findByLastName("TestLastName").getPatientID());
        pdao.delete(pdao.findByLastName("TestLastName").getPatientID());
    }
    
    @Before
    public void setUp() throws SQLException {
        System.out.println("testsetup");
        
        PatientDAO pdao = new PatientDAO();
        
        Date date = Date.valueOf("2000-01-24");
        SurgicalBean sb = new SurgicalBean();
        sb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        sb.setDateOfSurgery(date);
        sb.setSurgery("TestSurgery");
        sb.setRoomFee(123);
        sb.setSurgeonFee(456);
        sb.setSupplies(111);
        SurgicalDAO instance = new SurgicalDAO();
        instance.createSurgicalRecord(sb);
    }
    
    @After
    public void tearDown() throws SQLException {
        System.out.println("Test tear down");
        PatientDAO pdao = new PatientDAO();
        MedicationDAO instance = new MedicationDAO();
        instance.delete(pdao.findByLastName("TestLastName").getPatientID());
    }

    /**
     * Test of createSurgicalRecord method, of class SurgicalDAO.
     */
    @Test
    public void testCreateSurgicalRecord() throws Exception {
        System.out.println("createSurgicalRecord");
        
        PatientDAO pdao = new PatientDAO();
        Date date = Date.valueOf("2000-01-24");
        SurgicalBean sb = new SurgicalBean();
        sb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        sb.setDateOfSurgery(date);
        sb.setSurgery("TestSurgery");
        sb.setRoomFee(123);
        sb.setSurgeonFee(456);
        sb.setSupplies(111);
        SurgicalDAO instance = new SurgicalDAO();
        instance.createSurgicalRecord(sb);
        ArrayList<SurgicalBean> result = instance.findSurgicalByID(pdao.findByLastName("TestLastName").getPatientID());
        assertEquals(sb, result.get(result.size()-1));
    }

    /**
     * Test of findSurgicalByID method, of class SurgicalDAO.
     */
    @Test
    public void testFindSurgicalByID() throws Exception {
        System.out.println("findSurgicalByID");
        PatientDAO pdao = new PatientDAO();
        int id = pdao.findByLastName("TestLastName").getPatientID();
        Date date = Date.valueOf("2000-01-24");
        SurgicalBean sb = new SurgicalBean();
        sb.setPatientID(id);
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
        
        System.out.println("update");
        PatientDAO pdao = new PatientDAO();
        SurgicalBean sb = new SurgicalBean();
        SurgicalDAO sdao = new SurgicalDAO();
        Date dateStay = Date.valueOf("2009-01-03");
        ArrayList<SurgicalBean> findResult = new ArrayList();
        int pID = pdao.findByLastName("TestLastName").getPatientID();
        sb.setDateOfSurgery(dateStay);
        sb.setSurgery("TestSurgery");
        sb.setRoomFee(123);
        sb.setSurgeonFee(456);
        sb.setSupplies(111);
        int result = sdao.update(sb, 1);
        int expResult = 1;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class SurgicalDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        SurgicalDAO instance = new SurgicalDAO();
        PatientDAO pdao = new PatientDAO();
        int expResult = 3;
        int result = instance.delete(pdao.findByLastName("TestLastName").getPatientID());
        assertEquals(expResult, result);
    }
    
}
