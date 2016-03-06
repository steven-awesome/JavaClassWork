/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.InpatientBean;
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
import org.junit.Ignore;

/**
 *
 * @author fista
 */
public class MasterDAOScriptsTest {
    
    public MasterDAOScriptsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException {
        PatientDAO pdao = new PatientDAO();
        Date dateAdmit = Date.valueOf("2015-01-23");
        Date dateRelease = Date.valueOf("2015-01-25");
        PatientBean patient = new PatientBean();
        patient.setLastName("TestLastName");
        patient.setFirstName("TestFirstName");
        patient.setDiagnosis("TestDiagnosis");
        patient.setAdmissionDate(dateAdmit);
        patient.setReleaseDate(dateAdmit);
        pdao.createPatient(patient);
    }
    
    @AfterClass
    public static void tearDownClass() throws SQLException {
        System.out.println("test tear down");
        MasterDAOScripts masterDAO = new MasterDAOScripts();
        PatientDAO pdao = new PatientDAO();
        
        masterDAO.deleteRecordsByID(pdao.findByLastName("TestLastName").getPatientID());
    }
    
    @Before
    public void setUp() throws SQLException {
        System.out.println("test set up");
        PatientDAO pdao = new PatientDAO();
        
        
        InpatientBean ipb = new InpatientBean();
        InpatientDAO indao = new InpatientDAO();
        Date dateStay = Date.valueOf("2016-01-04");
        ipb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        ipb.setDateOfStay(dateStay);
        ipb.setRoomNumber("Test2");
        ipb.setDailyRate(123);
        ipb.setSupplies(456);
        ipb.setServices(789);
        
        
        Date dateMed = Date.valueOf("2012-01-25");
        MedicationBean mb = new MedicationBean();
        mb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        mb.setDateOfMed(dateMed);
        mb.setMed("TestCreateMed");
        mb.setUnitCost(111);
        mb.setUnits(222);
        MedicationDAO mdao = new MedicationDAO();
        
        
        Date dateSurgery = Date.valueOf("2000-01-25");
        SurgicalBean sb = new SurgicalBean();
        sb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        sb.setDateOfSurgery(dateSurgery);
        sb.setSurgery("TestSurgery");
        sb.setRoomFee(123);
        sb.setSurgeonFee(456);
        sb.setSupplies(111);
        SurgicalDAO sdao = new SurgicalDAO();
        
        
        indao.createInpatientRecord(ipb);
        mdao.createMedicationRecord(mb);
        sdao.createSurgicalRecord(sb);
        
    }
    
    @After
    public void tearDown() throws SQLException {
        
    }

    /**
     * Test of findRecordsByID method, of class MasterDAOScripts.
     */
    @Test
    public void testFindRecordsByID() throws Exception {
        System.out.println("findRecordsByID");
        
        //CREATING BEANS TO COMPARE RESULT AGAINST
        
        PatientDAO pdao = new PatientDAO();
        Date dateAdmit = Date.valueOf("2015-01-23");
        Date dateRelease = Date.valueOf("2015-01-25");
        PatientBean patient = new PatientBean();
        patient = pdao.findByLastName("TestLastName");
        ArrayList<PatientBean> arPB = new ArrayList();
        arPB.add(patient);
        
        
        
        InpatientBean ipb = new InpatientBean();
        ArrayList<InpatientBean> arIPB = new ArrayList();
        InpatientDAO indao = new InpatientDAO();
        Date dateStay = Date.valueOf("2016-01-04");
        ipb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        ipb.setDateOfStay(dateStay);
        ipb.setRoomNumber("Test2");
        ipb.setDailyRate(123);
        ipb.setSupplies(456);
        ipb.setServices(789);
        arIPB.add(ipb);
        
        
        Date dateMed = Date.valueOf("2012-01-25");
        MedicationBean mb = new MedicationBean();
        ArrayList<MedicationBean> arMB = new ArrayList();
        mb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        mb.setDateOfMed(dateMed);
        mb.setMed("TestCreateMed");
        mb.setUnitCost(111);
        mb.setUnits(222);
        arMB.add(mb);
        MedicationDAO mdao = new MedicationDAO();
        
        
        Date dateSurgery = Date.valueOf("2000-01-25");
        SurgicalBean sb = new SurgicalBean();
        ArrayList<SurgicalBean> arSB = new ArrayList();
        sb.setPatientID(pdao.findByLastName("TestLastName").getPatientID());
        sb.setDateOfSurgery(dateSurgery);
        sb.setSurgery("TestSurgery");
        sb.setRoomFee(123);
        sb.setSurgeonFee(456);
        sb.setSupplies(111);
        arSB.add(sb);
        SurgicalDAO sdao = new SurgicalDAO();
        
        
        
        int id = pdao.findByLastName("TestLastName").getPatientID();
        MasterDAOScripts masterDAO = new MasterDAOScripts();
        //Creating an ArrayList and adding all the mocked records
        ArrayList<Object> expResult = new ArrayList();
        expResult.add(arPB);
        expResult.add(arIPB);
        expResult.add(arSB);
        expResult.add(arMB);
        
        //Saving records into Object ArrayList
        ArrayList<Object> result = masterDAO.findRecordsByID(id);
        //Technically, these two Object ArrayLists should be equal...
        assertEquals(expResult, result);
    }

    /**
     * Test of findRecordsByLName method, of class MasterDAOScripts.
     */
    @Ignore
    @Test
    public void testFindRecordsByLName() throws Exception {
        
        //DID NOT FINISH THIS TEST AS I COULDNT GET FINDBYID TO WORK FIRST
        System.out.println("findRecordsByLName");
        String lastName = "TestLastName";
        MasterDAOScripts instance = new MasterDAOScripts();
        ArrayList<Object> expResult = new ArrayList();
        ArrayList<Object> result = instance.findRecordsByLName(lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteRecordsByID method, of class MasterDAOScripts.
     */
    @Test
    public void testDeleteRecordsByID() throws Exception {
        //This test works, it uses the data set up in the @Before setUp method and 
        //compares how many records were deleted
        System.out.println("deleteRecordsByID");
        PatientDAO pdao = new PatientDAO();
        int id = pdao.findByLastName("TestLastName").getPatientID();
        MasterDAOScripts instance = new MasterDAOScripts();
        int expResult = 1;
        int result = instance.deleteRecordsByID(id);
        assertEquals(expResult, result);
    }
    
}
