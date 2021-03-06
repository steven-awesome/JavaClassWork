/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CEJV456.javaFX;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author IT
 */
public class Forms_02 extends Application {
    
    /**
     * The stage and the scene are created in the start. If the root is more
     * than 2 or 3 lines then it should be a separate method.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        // Set Window's Title
        primaryStage.setTitle("JavaFX Form 02");
        Scene scene = new Scene(createUserInterface(), 300, 275);
        scene.getStylesheets().add("styles/Login.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create the user interface in the root
     *
     * @return
     */
    private GridPane createUserInterface() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        final Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        actiontarget.setId("actiontarget");
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(event -> actiontarget.setText("Sign in button pressed"));

        return grid;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
