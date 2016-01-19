/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFXClass2;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author st_morr
 */
public class MainWindowController extends Application {
    private Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) {
        
    }
    
    public void mainWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(MainWindowController.Class.getResource("/MainWindowView.fxml"));
            AnchorPane pane = loader.load();
            Main mainWindowController = loader.getController();
            
            Scene scene = new Scene(pane);
            
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IOException e){
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
