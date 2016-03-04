/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenebuildertest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author fista
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField txtk, txtm;
    
    @FXML
    private void handleKiloAction(KeyEvent event) {
        
        if (event.getCode().equals(ENTER)){
            double kilo = Double.parseDouble(txtk.getText());
        
            txtm.setText("");
            txtm.setText(String.valueOf(kilo/1.6));
        }
        
        
    }
    
    @FXML
    private void handleMileAction(KeyEvent event) {
        
        if (event.getCode().equals(ENTER)){
            double mile = Double.parseDouble(txtm.getText());
        
            txtk.setText("");
            txtk.setText(String.valueOf(mile*1.6));
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
