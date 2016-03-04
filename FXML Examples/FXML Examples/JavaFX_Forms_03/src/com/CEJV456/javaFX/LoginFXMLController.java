/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CEJV456.javaFX;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginFXMLController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text actiontarget;

    @FXML
    protected void handleSubmitButtonAction(
            ActionEvent event) {
        if (passwordField.getText().equals("Go")) {
            actiontarget.setText("Signed in as "
                    + usernameField.getText() + "!");
        } else {
            actiontarget.setText(
                    "Password not valid");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}

