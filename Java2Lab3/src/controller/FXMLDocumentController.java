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
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author fista
 */
public class FXMLDocumentController implements Initializable {
    
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
    private GridPane patientGrid, inpatientGrid, surgicalGrid, medicationGrid, bottomMenu;
    
    @FXML
    private TextField pidFind, lNameFind;
    
    @FXML
    private TextField PID, fName, lName, diag, dAdmit, dRelease;
    
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
    
    
    @FXML
    public void clearClick(ActionEvent e) throws SQLException{
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
        
    }
    
    @FXML
    public void saveClick() throws SQLException{
        pdao = new PatientDAO();
        indao = new InpatientDAO();
        sdao = new SurgicalDAO();
        mdao = new MedicationDAO();
        PatientBean pb;
        InpatientBean ipb;
        SurgicalBean sb;
        MedicationBean mb;
        
        
        switch(whichPaneVisible()){
            case 1:
                pb = new PatientBean();
                if(!PID.getText().isEmpty()){
                    pb.setPatientID(Integer.valueOf(PID.getText().trim()));
                    pb.setFirstName(fName.getText());
                    pb.setLastName(lName.getText());
                    pb.setDiagnosis(diag.getText());
                    pdao.update(pb, pb.getPatientID());
                } else{
                    pb.setFirstName(fName.getText());
                    pb.setLastName(lName.getText());
                    pb.setDiagnosis(diag.getText());
                    pdao.createPatient(pb);
                }

            case 2:
                ipb = new InpatientBean();
                if(!inpID.getText().isEmpty()){
                    ipb.setID(Integer.valueOf(inpID.getText().trim()));
                    ipb.setPatientID(Integer.valueOf(inpPid.getText().trim()));
                    ipb.setDateOfStay(Date.valueOf(dateOfStay.getText()));
                    ipb.setRoomNumber(inpRNum.getText());
                    ipb.setDailyRate(Double.valueOf(inpDRate.getText().trim()));
                    ipb.setSupplies(Double.valueOf(inpSupp.getText().trim()));
                    ipb.setServices(Double.valueOf(inpServ.getText().trim()));
                    indao.update(ipb, Integer.valueOf(inpID.getText().trim()));
                } else{
                    ipb.setPatientID(Integer.valueOf(inpPid.getText().trim()));
                    ipb.setDateOfStay(Date.valueOf(dateOfStay.getText()));
                    ipb.setRoomNumber(inpRNum.getText());
                    ipb.setDailyRate(Double.valueOf(inpDRate.getText().trim()));
                    ipb.setSupplies(Double.valueOf(inpSupp.getText().trim()));
                    ipb.setServices(Double.valueOf(inpServ.getText().trim()));
                    indao.createInpatientRecord(ipb);
                }
                
            case 3:
                sb = new SurgicalBean();
                if(!surgID.getText().isEmpty()){
                    sb.setID(Integer.valueOf(surgID.getText().trim()));
                    sb.setPatientID(Integer.valueOf(pidSurg.getText().trim()));
                    sb.setDateOfSurgery(Date.valueOf(dateSurg.getText()));
                    sb.setSurgery(surg.getText());
                    sb.setRoomFee(Double.valueOf(surgRFee.getText().trim()));
                    sb.setSurgeonFee(Double.valueOf(surgFee.getText().trim()));
                    sb.setSupplies(Double.valueOf(surgSupp.getText().trim()));
                    sdao.update(sb, Integer.valueOf(medID.getText().trim()));
                } else{
                    sb.setPatientID(Integer.valueOf(pidSurg.getText().trim()));
                    sb.setDateOfSurgery(Date.valueOf(dateSurg.getText()));
                    sb.setSurgery(surg.getText());
                    sb.setRoomFee(Double.valueOf(surgRFee.getText().trim()));
                    sb.setSurgeonFee(Double.valueOf(surgFee.getText().trim()));
                    sb.setSupplies(Double.valueOf(surgSupp.getText().trim()));
                    sdao.createSurgicalRecord(sb);
                }
                
            case 4:
                mb = new MedicationBean();
                if(!medID.getText().isEmpty()){
                    mb.setID(Integer.valueOf(medID.getText().trim()));
                    mb.setPatientID(Integer.valueOf(pidMed.getText().trim()));
                    mb.setDateOfMed(Date.valueOf(dateMed.getText()));
                    mb.setMed(med.getText());
                    mb.setUnitCost(Double.valueOf(medUCost.getText().trim()));
                    mb.setUnits(Double.valueOf(medUnits.getText().trim()));
                    mdao.update(mb, Integer.valueOf(medID.getText().trim()));
                } else{
                    mb.setPatientID(Integer.valueOf(pidMed.getText().trim()));
                    mb.setDateOfMed(Date.valueOf(dateMed.getText()));
                    mb.setMed(med.getText());
                    mb.setUnitCost(Double.valueOf(medUCost.getText().trim()));
                    mb.setUnits(Double.valueOf(medUnits.getText().trim()));
                    mdao.createMedicationRecord(mb);
                }
                //medID, pidMed, medUCost, dateMed, medUnits, med;
        }
    }
    
    @FXML
    public void delClick() throws SQLException{
        madao = new MasterDAOScripts();
        pdao = new PatientDAO();
        indao = new InpatientDAO();
        sdao = new SurgicalDAO();
        mdao = new MedicationDAO();
        int result;
        int id;
        String msg = "Records deleted";
        String header = "Deleted";
        
        switch(whichPaneVisible()){
            case 1:
                id = Integer.valueOf(PID.getText().trim());
                madao.deleteRecordsByID(id);
                bottomMenu.setDisable(true);
                patientPane.setVisible(false);
                showInfoMsg(msg, header);
                
            case 2:
                id = Integer.valueOf(inpID.getText().trim());
                result = indao.delete(id);
                bottomMenu.setDisable(true);
                inpatientPane.setVisible(false);
                showInfoMsg(msg, header);
                
            case 3:
                id = Integer.valueOf(surgID.getText().trim());
                result = sdao.delete(id);
                bottomMenu.setDisable(true);
                surgicalPane.setVisible(false);
                showInfoMsg(msg, header);
                
            case 4:
                id = Integer.valueOf(medID.getText().trim());
                result = mdao.delete(id);
                bottomMenu.setDisable(true);
                medicationPane.setVisible(false);
                showInfoMsg(msg, header);
                
            default:
                return;
        }
        
        
        
    }
    
    @FXML
    public void repClick(){
        double total = 0;
        int numOfDaysStay = 0;
        String msg;
        String header = "Total Patient Cost";
        
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
    public void exitClick(){
        System.exit(0);
    }
    
    //////////////////////////////////////////////////////FIND FUNCTION////////////////////////////////////////////////////
    
    @FXML
    private void clickFindBtn(ActionEvent e) throws SQLException{
        bottomMenu.setDisable(false);
        inpatientPane.setVisible(false);
        surgicalPane.setVisible(false);
        medicationPane.setVisible(false);
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
        
        int pid;
        String lastName;
        pid = Integer.parseInt(pidFind.getText().trim());
        lastName = lNameFind.getText().trim();
        
        
        if (!PID.getText().isEmpty()){
            master  = madao.findRecordsByID(pid);
        } else {
            master =  madao.findRecordsByLName(lastName);
        }
        
        ptb = (PatientBean) master.get(0);
        arIPB = (ArrayList<InpatientBean>) master.get(1);
        arSB = (ArrayList<SurgicalBean>) master.get(2);
        arMB = (ArrayList<MedicationBean>) master.get(3);
        
        setPatientView(ptb);
        setInpatientView(arIPB, 0);
        setSurgicalView(arSB, 0);
        setMedicationView(arMB, 0);
    }
    
    ///////////////////////////////////////////SETTING VIEWS/////////////////////////////////////////////////
    
    
    public void setPatientView(PatientBean pb){
        PID.setText(String.valueOf(pb.getPatientID()));
        fName.setText(pb.getFirstName());
        lName.setText(pb.getLastName());
        diag.setText(pb.getDiagnosis());
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
    
    
    //////////////////////////////////////////////////////DETAIL RECORD BUTTONS///////////////////////////////////////////////////////////
    
    
    @FXML
    public void inpBtnClick(){
        if (!arIPB.isEmpty()){
            patientPane.setVisible(false);
            inpatientPane.setVisible(true);
        }
    }
    
    @FXML
    public void surgBtnClick(){
        if(!arSB.isEmpty()){
            patientPane.setVisible(false);
            surgicalPane.setVisible(true);
        }
    }
    
    @FXML
    public void medBtnClick(){
        if(!arMB.isEmpty()){
            patientPane.setVisible(false);
            medicationPane.setVisible(true);
        }
    }
    
    @FXML
    public void nextBtnPress(){
        switch(whichPaneVisible()){
            case 2:
                if (arIPB.size() > 1 && getIPBPageIndex() < arIPB.size()){
                    setIPBPageIndex(getIPBPageIndex()+1);
                    setInpatientView(arIPB, (getIPBPageIndex()-1));
                }
            case 3:
                if (arSB.size() > 1 && getSurgPageIndex() < arSB.size()){
                    setSurgPageIndex(getSurgPageIndex()+1);
                    setSurgicalView(arSB, (getSurgPageIndex()-1));
                }
            case 4:
                if (arMB.size() > 1 && getMedPageIndex() < arMB.size()){
                    setMedPageIndex(getMedPageIndex()+1);
                    setMedicationView(arMB, (getMedPageIndex()-1));
                }
            default:
                return;
        }
    }
    
    @FXML
    public void prevBtnPress(){
        switch(whichPaneVisible()){
            case 2:
                if (arIPB.size() > 1 && getIPBPageIndex() > 1){
                    setIPBPageIndex(getIPBPageIndex()-1);
                    setInpatientView(arIPB, (getIPBPageIndex()-1));
                }
            case 3:
                if (arSB.size() > 1 && getSurgPageIndex() > 1){
                    setSurgPageIndex(getSurgPageIndex()-1);
                    setSurgicalView(arSB, (getSurgPageIndex()-1));
                }
            case 4:
                if (arMB.size() > 1 && getMedPageIndex() > 1){
                    setMedPageIndex(getMedPageIndex()-1);
                    setMedicationView(arMB, (getMedPageIndex()-1));
                }
            default:
                break;
        }
    }
    
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
