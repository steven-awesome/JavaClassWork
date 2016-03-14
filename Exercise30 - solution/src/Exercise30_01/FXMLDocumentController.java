/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise30_01;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author IT
 */
public class FXMLDocumentController implements Initializable {

    @FXML

    private TextField tfMile, tfKilometer;

    @FXML
    private void mileAction(ActionEvent event) {
        try {
            double mile = new Double(tfMile.getText().trim()).doubleValue();
            double kilometer = mile / 0.6241;
            tfKilometer.setText(new Double(kilometer).toString());
        } catch (Exception ex) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong Inputs");

            String s = "The TextFields should be filled with proper numbers.";
            alert.setContentText(s);
            alert.show();

        }
    }

    @FXML
    private void kilometerAction(ActionEvent event) {
       try {
            double kilometer = new Double(tfKilometer.getText().trim()).doubleValue();
            double mile = 0.6241 * kilometer;
            tfMile.setText(new Double(mile).toString());
        } catch (Exception ex) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong Inputs");

            String s = "The TextFields should be filled with proper numbers.";
            alert.setContentText(s);
            alert.show();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
