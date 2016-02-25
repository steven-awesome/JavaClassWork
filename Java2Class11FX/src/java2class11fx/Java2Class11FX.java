/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2class11fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author st_morr
 */
public class Java2Class11FX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        Button btn4 = new Button();
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        btn1.setText("Add");
        btn2.setText("Subtract");
        btn3.setText("Multiply");
        btn4.setText("Divide");
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        hbox1.setPadding(new Insets(0,3,10,3));
        
        l1.setText("Number 1: ");
        l2.setText("Number 2: ");
        l3.setText("Number 3: ");
        l1.setMinWidth(60);
        l2.setMinWidth(60);
        l3.setMinWidth(60);
        
        GridPane pane = new GridPane();
        pane.add(hbox1, 1, 0);
        pane.add(hbox2, 1, 1);
        
        hbox2.setAlignment(Pos.CENTER);
        
        hbox1.getChildren().addAll(l1, t1, l2, t2, l3, t3);
        hbox2.getChildren().addAll(btn1, btn2, btn3, btn4);
        
        btn1.setOnAction(event -> {
            t3.setText(String.valueOf(Double.valueOf(t1.getText()) + Double.valueOf(t2.getText())));
        });
        
        btn2.setOnAction(event -> {
            t3.setText(String.valueOf(Double.valueOf(t1.getText()) - Double.valueOf(t2.getText())));
        });
        
        btn3.setOnAction(event -> {
            t3.setText(String.valueOf(Double.valueOf(t1.getText()) * Double.valueOf(t2.getText())));
        });
        
        btn4.setOnAction(event -> {
            t3.setText(String.valueOf(Double.valueOf(t1.getText()) / Double.valueOf(t2.getText())));
        });
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                t3.setText(String.valueOf(Double.valueOf(t1.getText()) + Double.valueOf(t2.getText())));
            }
        });
        
        
        
        Scene scene = new Scene(pane, 300, 250);
        
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
