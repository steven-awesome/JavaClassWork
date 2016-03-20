/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import business.*;
import data.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author fista
 */
public class FXMLDocumentController implements Initializable {
    
    Scanner sc;
    MasterDAOScripts madao;
    PatientDAO pdao;
    InpatientDAO indao;
    SurgicalDAO sdao;
    MedicationDAO mdao;
    PatientBean ptb;
    ArrayList<InpatientBean> arIPB;
    ArrayList<SurgicalBean> arSB;
    ArrayList<MedicationBean> arMB;
    int[][] pageIndex = new int[3][2];
    
    private int getIPBPageIndex(){
        return pageIndex[0][0];
    }
    
    private int getIPBPageNum(){
        return pageIndex[0][1];
    }
    
    private int getSurgPageIndex(){
        return pageIndex[1][0];
    }
    
    private int getSurgPageNum(){
        return pageIndex[1][1];
    }
    
    private int getMedPageIndex(){
        return pageIndex[2][0];
    }
    
    private int getMedPageNum(){
        return pageIndex[2][1];
    }
    
    private void setIPBPageIndex(int pgIndx){
        pageIndex[0][0] = pgIndx;
    }
    
    private void setIPBPageNum(int pgNum){
        pageIndex[0][1] = pgNum;
    }
    
    private void setSurgPageIndex(int pgIndx){
        pageIndex[1][0] = pgIndx;
    }
    
    private void setSurgPageNum(int pgNum){
        pageIndex[1][1] = pgNum;
    }
    
    private void setMedPageIndex(int pgIndx){
        pageIndex[2][0] = pgIndx;
    }
    
    private void setMedPageNum(int pgNum){
        pageIndex[2][1] = pgNum;
    }
    
    @FXML
    private Pane patientPane, inpatientPane, surgicalPane, medicationPane;
    
    @FXML
    private AnchorPane centerPane;
    
    @FXML
    private Hyperlink rep, exit;
    
    @FXML
    private GridPane patientGrid, inpatientGrid, surgicalGrid, medicationGrid, bottomMenu;
    
    @FXML
    private TextField pidFind, lNameFind;
    
    @FXML
    private TextField pID, fName, lName, diag, dAdmit, dRelease;
    
    @FXML
    private TextField inpID, inpPid, inpDRate, dateOfStay, inpSupp, inpRNum, inpServ;
    
    @FXML
    private TextField surgID, pidSurg, surgRFee, dateSurg, surgFee, surg, surgSupp;
    
    @FXML
    private TextField medID, pidMed, medUCost, dateMed, medUnits, med;
    
    @FXML
    private Alert error, info;
    
    
    
    ////////////////////////////////////////////////////ALERTS////////////////////////////////////////////////////////
    
    
    public void showErrorMsg(String msg, String header){
        error = new Alert(AlertType.ERROR);
        error.setResizable(false);
        error.setHeaderText(header);
        error.setContentText(msg);
        error.showAndWait();
    }
    
    public void showInfoMsg(String msg, String header){
        info = new Alert(AlertType.INFORMATION);
        info.setResizable(true);
        info.setHeaderText(header);
        info.setContentText(msg);
        info.showAndWait();
    }
    
    
    /////////////////////////////////////////////////BOTTOM MENU//////////////////////////////////////////////////////
    
    //clears all node children of each pane, if they happen to be text fields
    @FXML
    public void clearClick() throws SQLException{  /////////////////////////////////////CLEAR/////////////////////////////////
        for (Node node : patientGrid.getChildren()) {
            if (node instanceof TextField) {
                // clear
                ((TextField)node).setText("");
            }
        }
        for (Node node : inpatientGrid.getChildren()) {
            if (node instanceof TextField) {
                // clear
                ((TextField)node).setText("");
            }
        }
        for (Node node : surgicalGrid.getChildren()) {
            if (node instanceof TextField) {
                // clear
                ((TextField)node).setText("");
            }
        }
        for (Node node : medicationGrid.getChildren()) {
            if (node instanceof TextField) {
                // clear
                ((TextField)node).setText("");
            }
        }
        
        ptb = new PatientBean();
        arIPB = new ArrayList();
        arSB = new ArrayList();
        arMB = new ArrayList();
    }
    
    @FXML
    public void saveClick() throws SQLException{ ///////////////////////////SAVE/////////////////////////
        pdao = new PatientDAO();
        indao = new InpatientDAO();
        sdao = new SurgicalDAO();
        mdao = new MedicationDAO();
        PatientBean pb;
        InpatientBean ipb;
        SurgicalBean sb;
        MedicationBean mb;
        int errors = 0;
        
        //depending on which pane is currently visible, records are either update
        //if PatientID/ID is filled in, or create new record if PatientID/ID is empty
        switch(whichPaneVisible()){
            case 1:
                pb = new PatientBean();
                
                /////////VALIDATION FOR PATIENT FORMS
                    if(!validateInt(pID.getText().trim()) && !pID.getText().trim().isEmpty()){
                        showErrorMsg("Invalid Patient ID", "Invalid Int");
                        errors++;
                    }
                    if(!validateStringWithLength(fName.getText(), 31)){
                        showErrorMsg("Invalid First Name", "Invalid String");
                        errors++;
                    }
                    if(!validateStringWithLength(lName.getText(), 31)){
                        showErrorMsg("Invalid Last Name", "Invalid String");
                        errors++;
                    }
                    if(!validateStringWithLength(diag.getText(), 61)){
                        showErrorMsg("Invalid Diagnosis", "Invalid String");
                        errors++;
                    }
                    
                if(!pID.getText().isEmpty()){
                    pb.setPatientID(Integer.valueOf(pID.getText().trim()));
                    pb.setFirstName(fName.getText());
                    pb.setLastName(lName.getText());
                    pb.setDiagnosis(diag.getText());
                    if(errors < 1){
                        pdao.update(pb, pb.getPatientID());
                    }
                } else{
                    pb.setFirstName(fName.getText());
                    pb.setLastName(lName.getText());
                    pb.setDiagnosis(diag.getText());
                    if(errors < 1){
                        pdao.createPatient(pb);
                    }
                }
                break;

            case 2:
                ipb = new InpatientBean();
                //////////VALIDATION FOR INPATIENT FORM
                    if(!validateInt(inpID.getText().trim()) && !inpID.getText().trim().isEmpty()){
                            showErrorMsg("Invalid ID", "Invalid Int");
                            errors++;
                        }
                    if(!validateNonSpecial(inpRNum.getText().trim(), 6)){
                            showErrorMsg("Invalid Room Number", "Invalid String");
                            errors++;
                        }
                    if(!validateDouble(inpDRate.getText().trim())){
                            showErrorMsg("Invalid Daily Rate", "Invalid Double");
                            errors++;
                        }
                    if(!validateDouble(inpSupp.getText().trim())){
                            showErrorMsg("Invalid Supplies", "Invalid Double");
                            errors++;
                        }
                    if(!validateDouble(inpServ.getText().trim())){
                            showErrorMsg("Invalid Services", "Invalid Double");
                            errors++;
                        }
                
                if(!inpID.getText().isEmpty()){
                    ipb.setID(Integer.valueOf(inpID.getText().trim()));
                    ipb.setPatientID(Integer.valueOf(inpPid.getText().trim()));
                    ipb.setDateOfStay(Date.valueOf(dateOfStay.getText()));
                    ipb.setRoomNumber(inpRNum.getText());
                    ipb.setDailyRate(Double.valueOf(inpDRate.getText().trim()));
                    ipb.setSupplies(Double.valueOf(inpSupp.getText().trim()));
                    ipb.setServices(Double.valueOf(inpServ.getText().trim()));
                    if(errors < 1){
                        indao.update(ipb, Integer.valueOf(inpID.getText().trim()));
                    }
                } else{
                    ipb.setPatientID(Integer.valueOf(inpPid.getText().trim()));
                    ipb.setDateOfStay(Date.valueOf(dateOfStay.getText()));
                    ipb.setRoomNumber(inpRNum.getText());
                    ipb.setDailyRate(Double.valueOf(inpDRate.getText().trim()));
                    ipb.setSupplies(Double.valueOf(inpSupp.getText().trim()));
                    ipb.setServices(Double.valueOf(inpServ.getText().trim()));
                    if(errors < 1){
                        indao.createInpatientRecord(ipb);
                    }
                }
                break;
                
            case 3:
                sb = new SurgicalBean();
                //////////VALIDATION FOR SURGERY FORM
                    if(!validateInt(surgID.getText().trim()) && !surgID.getText().trim().isEmpty()){
                            showErrorMsg("Invalid ID", "Invalid Int");
                            errors++;
                        }
                    if(!validateStringWithLength(surg.getText().trim(), 26)){
                            showErrorMsg("Invalid Surgeryr", "Invalid String");
                            errors++;
                        }
                    if(!validateDouble(surgRFee.getText().trim())){
                            showErrorMsg("Invalid Room Fee", "Invalid Double");
                            errors++;
                        }
                    if(!validateDouble(surgFee.getText().trim())){
                            showErrorMsg("Invalid Surgeon Fee", "Invalid Double");
                            errors++;
                        }
                    if(!validateDouble(surgSupp.getText().trim())){
                            showErrorMsg("Invalid Supplies", "Invalid Double");
                            errors++;
                        }
                if(!surgID.getText().isEmpty()){
                    sb.setID(Integer.valueOf(surgID.getText().trim()));
                    sb.setPatientID(Integer.valueOf(pidSurg.getText().trim()));
                    sb.setDateOfSurgery(Date.valueOf(dateSurg.getText()));
                    sb.setSurgery(surg.getText());
                    sb.setRoomFee(Double.valueOf(surgRFee.getText().trim()));
                    sb.setSurgeonFee(Double.valueOf(surgFee.getText().trim()));
                    sb.setSupplies(Double.valueOf(surgSupp.getText().trim()));
                    if(errors < 1){
                        sdao.update(sb, Integer.valueOf(medID.getText().trim()));
                    }
                } else{
                    sb.setPatientID(Integer.valueOf(pidSurg.getText().trim()));
                    sb.setDateOfSurgery(Date.valueOf(dateSurg.getText()));
                    sb.setSurgery(surg.getText());
                    sb.setRoomFee(Double.valueOf(surgRFee.getText().trim()));
                    sb.setSurgeonFee(Double.valueOf(surgFee.getText().trim()));
                    sb.setSupplies(Double.valueOf(surgSupp.getText().trim()));
                    if(errors <1 ){
                        sdao.createSurgicalRecord(sb);
                    }
                }
                break;
                
            case 4:
                mb = new MedicationBean();
                //////////VALIDATION FOR MEDICATION FORM
                    if(!validateInt(medID.getText().trim()) && !medID.getText().trim().isEmpty()){
                            showErrorMsg("Invalid ID", "Invalid Int");
                            errors++;
                        }
                    if(!validateStringWithLength(med.getText().trim(), 26)){
                            showErrorMsg("Invalid Surgery", "Invalid String");
                            errors++;
                        }
                    if(!validateDouble(medUCost.getText().trim())){
                            showErrorMsg("Invalid Room Fee", "Invalid Double");
                            errors++;
                        }
                    if(!validateDouble(medUnits.getText().trim())){
                            showErrorMsg("Invalid Surgeon Fee", "Invalid Double");
                            errors++;
                        }
                if(!medID.getText().isEmpty()){
                    mb.setID(Integer.valueOf(medID.getText().trim()));
                    mb.setPatientID(Integer.valueOf(pidMed.getText().trim()));
                    mb.setDateOfMed(Date.valueOf(dateMed.getText()));
                    mb.setMed(med.getText());
                    mb.setUnitCost(Double.valueOf(medUCost.getText().trim()));
                    mb.setUnits(Double.valueOf(medUnits.getText().trim()));
                    if(errors < 1){
                        mdao.update(mb, Integer.valueOf(medID.getText().trim()));
                    }
                } else{
                    mb.setPatientID(Integer.valueOf(pidMed.getText().trim()));
                    mb.setDateOfMed(Date.valueOf(dateMed.getText()));
                    mb.setMed(med.getText());
                    mb.setUnitCost(Double.valueOf(medUCost.getText().trim()));
                    mb.setUnits(Double.valueOf(medUnits.getText().trim()));
                    if(errors < 1){
                        mdao.createMedicationRecord(mb);
                    }
                }
                break;
        }
    }
    
    @FXML
    public void delClick() throws SQLException{  /////////////////////////////////////DELETE////////////////////////////
        madao = new MasterDAOScripts();
        pdao = new PatientDAO();
        indao = new InpatientDAO();
        sdao = new SurgicalDAO();
        mdao = new MedicationDAO();
        int result;
        int id;
        String msg = "Records deleted";
        String header = "Deleted";
        
        
        //depending on which pane is currently visible, deletes either all records for a patient
        //or a single detail record. Then, disables bottom menu as you cannot clear, save, delete
        //or report after you delete the record you are currently viewing
        switch(whichPaneVisible()){
            case 1:
                id = Integer.valueOf(pID.getText().trim());
                madao.deleteRecordsByID(id);
                bottomMenu.setDisable(true);
                patientPane.setVisible(true);
                showInfoMsg(msg, header);
                break;
                
            case 2:
                id = Integer.valueOf(inpID.getText().trim());
                result = indao.delete(id);
                bottomMenu.setDisable(true);
                inpatientPane.setVisible(false);
                patientPane.setVisible(true);
                showInfoMsg(msg, header);
                break;
                
            case 3:
                id = Integer.valueOf(surgID.getText().trim());
                result = sdao.delete(id);
                bottomMenu.setDisable(true);
                surgicalPane.setVisible(false);
                patientPane.setVisible(true);
                showInfoMsg(msg, header);
                break;
                
            case 4:
                id = Integer.valueOf(medID.getText().trim());
                result = mdao.delete(id);
                bottomMenu.setDisable(true);
                medicationPane.setVisible(false);
                patientPane.setVisible(true);
                showInfoMsg(msg, header);
                break;
                
            default:
                break;
        }
        clearClick();
    }
    
    @FXML
    public void repClick(){                  ///////////////////////////////////REPORT//////////////////////////////////////
        double total = 0;
        int numOfDaysStay = 0;
        String msg;
        String header = "Total Patient Cost";
        
        //these for loops total all the costs of inpatient: services, supplies, room rates
        //surgical: room fee, supplies, surgeon fee
        //medication: total cost of units
        for(InpatientBean ib : arIPB){
            total+=ib.getServices();
            total+=ib.getSupplies();
            total+=ib.getDailyRate();
        }
        for(SurgicalBean sb : arSB){
            total+=sb.getRoomFee();
            total+=sb.getSupplies();
            total+=sb.getSurgeonFee();
        }
        for(MedicationBean mb : arMB){
            total+=(mb.getUnits()*mb.getUnitCost());
        }
        
        msg = "Patient Cost = "+total;
        
        showInfoMsg(msg, header);
    }
    
    @FXML
    public void exitClick(){                       ///////////////////////////////////////////EXIT///////////////////////////////////
        System.exit(0);
    }
    
    //////////////////////////////////////////////////////FIND FUNCTION////////////////////////////////////////////////////
    
    @FXML
    private void clickFindBtn() throws SQLException{
       
        //Setting bottom menu accessible, and detail records hidden
        bottomMenu.setDisable(false);
        inpatientPane.setVisible(false);
        surgicalPane.setVisible(false);
        medicationPane.setVisible(false);
        rep.setDisable(false);
        exit.setDisable(false);
        //resets page index for next/prev detail record buttons
        setIPBPageIndex(1);
        setSurgPageIndex(1);
        setMedPageIndex(1);
        
        pdao = new PatientDAO();
        madao = new MasterDAOScripts();
        ArrayList master = new ArrayList();
        ptb = new PatientBean();
        arIPB = new ArrayList();
        arSB = new ArrayList();
        arMB = new ArrayList();
        
        String badID = "Please enter a valid ID";
        String badLN = "Please enter a valid name";
        String header = "Invalid characters";
        int pid = 0;
        String lastName;
       
        
        
        if (!pID.getText().isEmpty()){
             try{
                pid = Integer.parseInt(pidFind.getText().trim());
            
            }catch(Exception e){
                showErrorMsg(badID, header);
            }
            master  = madao.findRecordsByID(pid);
        } else {
            try{
                lastName = lNameFind.getText().trim();
                master =  madao.findRecordsByLName(lastName);
            }
            catch(Exception e){
                showErrorMsg(badLN, header);
            }
            
        }
        
        //getting objects from master ArrayList and casting them as individual Bean Types
        ptb = (PatientBean) master.get(0);
        arIPB = (ArrayList<InpatientBean>) master.get(1);
        arSB = (ArrayList<SurgicalBean>) master.get(2);
        arMB = (ArrayList<MedicationBean>) master.get(3);
        
        
        setPatientView(ptb);
    }
    
    ///////////////////////////////////////////SETTING VIEWS/////////////////////////////////////////////////
    
            //these methods are implemented to separate the setting of individual views
            //from the rest of the functionality
    
    @FXML
    public void setPatientView(PatientBean pb){
        pID.setText(String.valueOf(pb.getPatientID()));
        fName.setText(pb.getFirstName());
        lName.setText(pb.getLastName());
        diag.setText(pb.getDiagnosis());
        dAdmit.setText(pb.getAdmissionDate().toString());
        dRelease.setText(pb.getReleaseDate().toString());
        patientPane.setVisible(true);
    }
    
    public void setInpatientView(ArrayList<InpatientBean> ipb, int index){
        inpID.setText(String.valueOf(ipb.get(index).getID()));
        inpPid.setText(String.valueOf(ipb.get(index).getPatientID()));
        inpDRate.setText(String.valueOf(ipb.get(index).getDailyRate()));
        dateOfStay.setText(ipb.get(index).getDateOfStay().toString());
        inpSupp.setText(String.valueOf(ipb.get(index).getSupplies()));
        inpRNum.setText(ipb.get(index).getRoomNumber());
        inpServ.setText(String.valueOf(ipb.get(index).getServices()));
    }
    
    public void setSurgicalView(ArrayList<SurgicalBean> sb, int index){
        surgID.setText(String.valueOf(sb.get(index).getID()));
        pidSurg.setText(String.valueOf(sb.get(index).getPatientID()));
        surgRFee.setText(String.valueOf(sb.get(index).getRoomFee()));
        dateSurg.setText(sb.get(index).getDateOfSurgery().toString());
        surgSupp.setText(String.valueOf(sb.get(index).getSupplies()));
        surg.setText(sb.get(index).getSurgery());
        surgFee.setText(String.valueOf(sb.get(index).getSurgeonFee()));
    }
    
    public void setMedicationView(ArrayList<MedicationBean> mb, int index){
        medID.setText(String.valueOf(mb.get(index).getID()));
        pidMed.setText(String.valueOf(mb.get(index).getPatientID()));
        medUCost.setText(String.valueOf(mb.get(index).getUnitCost()));
        dateMed.setText(mb.get(index).getDateOfMed().toString());
        medUnits.setText(String.valueOf(mb.get(index).getUnits()));
        med.setText(mb.get(index).getMed());
    }
    
    public void allNotVisible(){
        for (Node node : centerPane.getChildren()) {
            if (node instanceof Pane) {
                ((Pane)node).setVisible(false);
            }
        }
    }
    
    
    
    
    //////////////////////////////////////////////////////DETAIL RECORD BUTTONS///////////////////////////////////////////////////////////
    
            //detail record buttons reset page index, get first saved record, 
            //and set the detail record form to visible
    @FXML
    public void inpBtnClick(){
        if (!arIPB.isEmpty()){
            rep.setDisable(true);
            exit.setDisable(true);
            setIPBPageIndex(1);
            setInpatientView(arIPB, 0);
            patientPane.setVisible(false);
            inpatientPane.setVisible(true);
        }
    }
    
    @FXML
    public void surgBtnClick(){
        if(!arSB.isEmpty()){
            rep.setDisable(true);
            exit.setDisable(true);
            setSurgPageIndex(1);
            setSurgicalView(arSB, 0);
            patientPane.setVisible(false);
            surgicalPane.setVisible(true);
        }
    }
    
    @FXML
    public void medBtnClick(){
        if(!arMB.isEmpty()){
            rep.setDisable(true);
            exit.setDisable(true);
            setMedPageIndex(1);
            setMedicationView(arMB, 0);
            patientPane.setVisible(false);
            medicationPane.setVisible(true);
        }
    }
    
            //back buttons on each detail record page.
    @FXML
    public void inpBackBtnClick(){
       inpatientPane.setVisible(false);
       rep.setDisable(false);
       exit.setDisable(false);
       patientPane.setVisible(true);
    }
    
    @FXML
    public void surgBackBtnClick(){
        surgicalPane.setVisible(false);
        rep.setDisable(false);
        exit.setDisable(false);
        patientPane.setVisible(true);
    }
    
    @FXML
    public void medBackBtnClick(){
        medicationPane.setVisible(false);
        rep.setDisable(false);
        exit.setDisable(false);
        patientPane.setVisible(true);
    }
    
            //next button checks which pane is currently visible, and
            //if the detail record arraylist is bigger than size=1, sets the
            //view to the next record
    @FXML
    public void nextBtnPress(){
        switch(whichPaneVisible()){
            case 2:
                if (arIPB.size() > 1 && getIPBPageIndex() < arIPB.size()){
                    setIPBPageIndex(getIPBPageIndex()+1);
                    setInpatientView(arIPB, (getIPBPageIndex()-1));
                }
                break;
                
            case 3:
                if (arSB.size() > 1 && getSurgPageIndex() < arSB.size()){
                    setSurgPageIndex(getSurgPageIndex()+1);
                    setSurgicalView(arSB, (getSurgPageIndex()-1));
                }
                break;
                
            case 4:
                if (arMB.size() > 1 && getMedPageIndex() < arMB.size()){
                    setMedPageIndex(getMedPageIndex()+1);
                    setMedicationView(arMB, (getMedPageIndex()-1));
                }
                break;
                
            default:
                return;
        }
    }
    
            //previous buttons works just like next btn, but in reverse
    @FXML
    public void prevBtnPress(){
        switch(whichPaneVisible()){
            case 2:
                if (arIPB.size() > 1 && getIPBPageIndex() > 1){
                    setIPBPageIndex(getIPBPageIndex()-1);
                    setInpatientView(arIPB, (getIPBPageIndex()-1));
                }
                break;
                
            case 3:
                if (arSB.size() > 1 && getSurgPageIndex() > 1){
                    setSurgPageIndex(getSurgPageIndex()-1);
                    setSurgicalView(arSB, (getSurgPageIndex()-1));
                }
                break;
                
            case 4:
                if (arMB.size() > 1 && getMedPageIndex() > 1){
                    setMedPageIndex(getMedPageIndex()-1);
                    setMedicationView(arMB, (getMedPageIndex()-1));
                }
                break;
                        
            default:
                break;
        }
    }
    
            //this method is core to the whole program. checks which pane is currently visible
            //and returns an index #.
            // 1 = patient, 2 = inpatient, 3 = surgical, 4 = medication
    @FXML
    public int whichPaneVisible(){
        if (patientPane.isVisible()){
            return 1;
        }
        else if (inpatientPane.isVisible()){
            return 2;
        }
        else if (surgicalPane.isVisible()){
            return 3;
        }
        else if (medicationPane.isVisible()){
            return 4;
        }
        else {
            return 0;
        }
    }
    
    ///////////////////////////////////////////////////VALIDATION///////////////////////////////////////////////////
    
    
    public boolean validateString(String s){
        sc = new Scanner(s);
        if (sc.hasNext("[a-zA-Z]")){
            return true;
        } else{
            return false;
        }
    }
    
    public boolean validateStringWithLength(String s, int n){
        sc = new Scanner(s);
        
        if (s.matches("^[-\\w.]+$") && s.length() < n){
            return true;
        } else{
            return false;
        }
    }
    
    public boolean validateDouble(String s){
        try{
            Double.parseDouble(s);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean validateInt(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean validateNonSpecial(String s, int n){
        if(s.matches("[^A-Za-z0-9_.]") && s.length() < n){
            return true;
        } else{
            return false;
        }
    }
    
    public boolean validateDate(String s){
        if(s.matches(  "([0-9]{4})-([0-9]{2})-([0-9]{2})"  )){
                return true;
        } else{
            return false;
        }
    }
    
    //this keeps track of how many pages there are correlating to size of detail record
    //arraylist size
    public void setPageNums(ArrayList ar1, ArrayList ar2, ArrayList ar3){
        setIPBPageNum(ar1.size());
        setSurgPageNum(ar2.size());
        setMedPageNum(ar3.size());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
