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
    private GridPane patientGrid;
    
    @FXML
    private TextField pidFind, lNameFind;
    
    @FXML
    private Button findBtn, inpBtn, surgBtn, medBtn, prevBtn, nextBtn;
    
    @FXML
    private Hyperlink clear, save, del, rep, exit;
    
    @FXML
    private Pagination pgn;
    
    @FXML
    private TextField PID, fName, lName, diag, dAdmit, dRelease;
    
    @FXML
    private TextField inpID, inpPid, inpDRate, dateOfStay, inpSupp, inpRNum, inpServ;
    
    @FXML
    private TextField surgID, pidSurg, surgRFee, dateSurg, surgFee, surg, surgSupp;
    
    @FXML
    private TextField medID, pidMed, medUCost, dateMed, medUnits, med;
    
    @FXML
    public void clearClick(ActionEvent e) throws SQLException{
        for (Node node : patientGrid.getChildren()) {
            System.out.println("Id: " + node.getId());
            if (node instanceof TextField) {
                // clear
                ((TextField)node).setText("");
    }
}
    }
    
    @FXML
    public void saveClick() throws SQLException{
        PatientDAO pdao = new PatientDAO();
        InpatientDAO indao = new InpatientDAO();
        SurgicalDAO sdao = new SurgicalDAO();
        MedicationDAO mdao = new MedicationDAO();
        PatientBean pb;
        InpatientBean ipb;
        SurgicalBean sb;
        MedicationBean mb;
        
        
        switch(whichPaneVisible()){
            case 1:
                pb = new PatientBean();
                pb.setPatientID(Integer.valueOf(PID.getText()));
                pb.setFirstName(fName.getText());
                pb.setLastName(lName.getText());
                pb.setDiagnosis(diag.getText());
                if (PID.getText().isEmpty()){
                    pdao.createPatient(pb);
                }else {
                    pdao.update(pb, pb.getPatientID());
                }
                
            case 2:
                ipb = new InpatientBean();
                ipb.setPatientID(Integer.valueOf(inpPid.getText()));
                ipb.setDateOfStay(Date.valueOf(dateOfStay.getText()));
                ipb.setRoomNumber(inpRNum.getText());
                ipb.setDailyRate(Double.valueOf(inpDRate.getText().trim()));
                ipb.setSupplies(Double.valueOf(inpSupp.getText()));
                ipb.setServices(Double.valueOf(inpServ.getText()));
                if (inpID.getText().isEmpty()){
                    indao.createInpatientRecord(ipb);
                } else {
                    indao.update(ipb, Integer.valueOf(inpID.getText().trim()));
                }
        }
    }
    
    @FXML
    public void delClick(){
        
    }
    
    @FXML
    public void repClick(){
        
    }
    
    @FXML
    public void exitClick(){
        System.exit(0);
    }
    
    
    @FXML
    private void clickFindBtn(ActionEvent e) throws SQLException{
        inpatientPane.setVisible(false);
        surgicalPane.setVisible(false);
        medicationPane.setVisible(false);
        setIPBPageIndex(1);
        setSurgPageIndex(1);
        setMedPageIndex(1);
        
        //PatientBean ptb = new PatientBean(Integer.parseInt(PID.getText()), fName.getText(), lName.getText(), diag.getText(), Date.valueOf(dAdmit.getText()), Date.valueOf(dRelease.getText()));
        PatientDAO pdao = new PatientDAO();
        MasterDAOScripts mdao = new MasterDAOScripts();
        ArrayList master = new ArrayList();
        PatientBean ptb = new PatientBean();
        arIPB = new ArrayList();
        arSB = new ArrayList();
        arMB = new ArrayList();
        
        int pid;
        String lastName;
        pid = Integer.parseInt(pidFind.getText().trim());
        lastName = lNameFind.getText().trim();
        
        
        if (!PID.getText().isEmpty()){
            master  = mdao.findRecordsByID(pid);
        } else {
            master =  mdao.findRecordsByLName(lastName);
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
    //surgID, pidSurg, surgRFee, dateSurg, surgFee, surg, surgSupp
    
    public void setMedicationView(ArrayList<MedicationBean> mb, int index){
        medID.setText(String.valueOf(mb.get(index).getID()));
        pidMed.setText(String.valueOf(mb.get(index).getPatientID()));
        medUCost.setText(String.valueOf(mb.get(index).getUnitCost()));
        dateMed.setText(mb.get(index).getDateOfMed().toString());
        medUnits.setText(String.valueOf(mb.get(index).getUnits()));
        med.setText(mb.get(index).getMed());
    }
    //medID, pidMed, medUCost, dateMed, medUnits, med
    
    
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
                break;
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
