/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2class13fxex28;

import business.FileReading;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;

/**
 *
 * @author fista
 */
public class JFXEx28 extends Application {
    
    FileReading fr = new FileReading();
    
    @Override
    public void start(Stage primaryStage) {
        TextArea tf = new TextArea();
        Button btn = new Button();
        btn.setText("View");
        tf.setWrapText(true);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    tf.setText(fr.read());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        
        
        
        BorderPane bp = new BorderPane();
        bp.getChildren().add(btn);
        
        
        
        HBox hb = new HBox();
        hb.getChildren().addAll(tf, btn);
        
        
        
        bp.setBottom(new CustomPane("bottom"));
        bp.setCenter(hb);
        
        Scene scene = new Scene(bp, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class CustomPane extends StackPane {
        public CustomPane(String title) {
          getChildren().add(new Label(title));
          setStyle("-fx-border-color: red");
          setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
          }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
