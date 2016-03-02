/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2class13fxex28;

import business.MileKiloCalc;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author st_morr
 */
public class Java2Class13FXEX28 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MileKiloCalc mkc = new MileKiloCalc();
        TextField txtfld1 = new TextField();
        TextField txtfld2 = new TextField();
        
        Label label1 = new Label();
        Label label2 = new Label();
        
        label1.setText("Mile");
        label2.setText("Kilometer");
        
        Alert alert = new Alert(AlertType.ERROR);
        

            txtfld1.setOnKeyPressed(new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode().equals(ENTER)){
                        txtfld2.setText("");
                        if (!txtfld1.getText().isEmpty()){
                            try { 
                                txtfld2.setText(mkc.mileToKilo(txtfld1.getText()));
                            } catch (Exception ex) {
                                alert.showAndWait();
                            }
                        }
                    }
                }

            });
        
        txtfld2.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(ENTER)){
                    txtfld1.setText("");
                    if (!txtfld2.getText().isEmpty()){
                        try { 
                            txtfld1.setText(mkc.kiloToMile(txtfld2.getText()));
                        } catch (Exception ex) {
                            alert.showAndWait();
                        }
                    }
                }
                
                
            }
            
        });
                
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(label1, 0, 0);
        root.add(txtfld1, 1, 0);
        root.add(label2, 0, 1);
        root.add(txtfld2, 1, 1);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
