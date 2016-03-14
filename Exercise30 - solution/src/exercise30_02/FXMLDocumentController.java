/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise30_02;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author IT
 */
public class FXMLDocumentController implements Initializable {

    @FXML

    private TextField txtF1, txtF2, txtF3, txtF4;
    private Text text;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        calculateLoanPayment();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void calculateLoanPayment() {
        // Get values from text fields
        double annualInterestRate
                = Double.parseDouble(txtF3.getText());
        int numberOfYears = Integer.parseInt(txtF2.getText());
        double investmentAmount
                = Double.parseDouble(txtF1.getText());

        double monthlyInterestRate = annualInterestRate / 1200;
        double futureValue = investmentAmount
                * Math.pow(1 + monthlyInterestRate, numberOfYears * 12);

        // Display monthly payment and total payment
        txtF4.setText(String.format("$%.2f", futureValue));

    }

}
