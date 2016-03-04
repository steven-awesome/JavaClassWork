/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2class13fxex28;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author st_morr
 */
public class Ex292 extends Application {
    
    int num;
    
    @Override
    public void start(Stage primaryStage) {        

        TextField ta = new TextField();
        
                // Create a handler for changing text
    EventHandler<ActionEvent> eventHandler = e -> {
        int seconds= Integer.parseInt(ta.getText());
        ta.setText(seconds-1+"");
      if (ta.getText().length() != 0) {
        ta.setText(String.valueOf(Integer.valueOf(ta.getText().trim())-1));
      }
      else {
        ta.setText("Programming is fun");
      }
    };
    
    // Create an animation for alternating text
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(500), eventHandler));
    animation.setCycleCount(num);
        
        ta.setOnKeyPressed(new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent event) {
                   
                    if (event.getCode().equals(ENTER)){
                        num = Integer.parseInt(ta.getText());
                      animation.play();
                    }
                }

            });
        

        
        StackPane root = new StackPane();
        root.getChildren().add(ta);
        
        
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
