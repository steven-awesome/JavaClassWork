/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationtest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author st_morr
 */
public class JavaFXApplicationTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Label userName = new Label("User Name");
        grid.add(userName, 0, 1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Button btnSign = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnSign);
        grid.add(hbBtn, 1, 3, 2, 1);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        final Text actiontarget2 = new Text();
        grid.add(actiontarget2, 1, 7);
        
        btnSign.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget2.setFill(Color.FIREBRICK);
                actiontarget.setText(userTextField.getText());
                actiontarget2.setText(pwBox.getText());
            }
        });
        
        Button btnCancel = new Button("Cancel");
        HBox hbBtn2 = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnCancel);
        grid.add(hbBtn2, 2, 3);
        
        
        
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setText("");
                actiontarget2.setText("");
            }
        });
        
        Button btnExit = new Button("Exit");
        HBox hbBtn3 = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnExit);
        grid.add(hbBtn3, 2, 3);
        
        
        
        
        
        Stage second = new Stage();
        second.setTitle("Second Stage");
        second.show();
        //added Exit button after second stage so it closes both stages
        btnExit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                primaryStage.hide();
                second.hide();
            }
        });
        
        
        Scene scene = new Scene(grid, 300, 275);
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
