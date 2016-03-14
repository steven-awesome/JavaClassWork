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
import javafx.scene.layout.Pane;

/**
 *
 * @author fista
 */
public class FXMLDocumentController implements Initializable {
    
    ArrayList<InpatientBean> arIPB = new ArrayList();
    ArrayList<SurgicalBean> arSB = new ArrayList();
    ArrayList<MedicationBean> arMB = new ArrayList();
    
    @FXML
    private Pane patientPane, inpatientPane, surgicalPane, medicationPane;
    
    @FXML
    private Label label;
    
    @FXML
    private TextField pidFind, lNameFind;
    
    @FXML
    private Button findBtn, inpBtn, surgBtn, medBtn;
    
    @FXML
    private Hyperlink clear, save, del, rep, exit;
    
    @FXML
    private Pagination pgn;
    
    @FXML
    private TextField PID, fName, lName, diag, dAdmit, dRelease;
    
    @FXML
    private TextField inpPid, inpDRate, dateOfStay, inpSupp, inpRNum, inpServ;
    
    @FXML
    private TextField pidSurg, surgRFee, dateSurg, surgFee, surg, surgSupp;
    
    @FXML
    private TextField pidMed, medUCost, dateMed, medUnits, med;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    public void clearClick(ActionEvent e) throws SQLException{
        for (Node node : patientPane.getChildren()) {
            System.out.println("Id: " + node.getId());
            if (node instanceof TextField) {
                // clear
                ((TextField)node).setText("");
    }
}
    }
    
    @FXML
    public void saveClick(){
        
    }
    
    @FXML
    public void delClick(){
        
    }
    
    @FXML
    public void repClick(){
        
    }
    
    @FXML
    public void exitClick(){
        
    }
    
    @FXML
    private void clickFindBtn(ActionEvent e) throws SQLException{
        
        //PatientBean ptb = new PatientBean(Integer.parseInt(PID.getText()), fName.getText(), lName.getText(), diag.getText(), Date.valueOf(dAdmit.getText()), Date.valueOf(dRelease.getText()));
        PatientDAO pdao = new PatientDAO();
        MasterDAOScripts mdao = new MasterDAOScripts();
        ArrayList master = new ArrayList();
        PatientBean ptb = new PatientBean();
        ArrayList<InpatientBean> arIPN = new ArrayList();
        
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
        
        PID.setText(String.valueOf(ptb.getPatientID()));
        fName.setText(ptb.getFirstName());
        lName.setText(ptb.getLastName());
        diag.setText(ptb.getDiagnosis());
        patientPane.setVisible(true);
        
        inpPid.setText(String.valueOf(arIPB.get(0).getPatientID()));  //inpDRate, dateOfStay, inoSupp, inpRNum, inpServ
        inpDRate.setText(String.valueOf(arIPB.get(0).getDailyRate()));
        dateOfStay.setText(arIPB.get(0).getDateOfStay().toString());
        inpSupp.setText(String.valueOf(arIPB.get(0).getSupplies()));
        inpRNum.setText(arIPB.get(0).getRoomNumber());
        inpServ.setText(String.valueOf(arIPB.get(0).getServices()));
        
    }
    
    @FXML
    public void inpBtnClick(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
