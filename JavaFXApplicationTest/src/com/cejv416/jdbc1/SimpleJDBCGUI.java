package com.cejv416.jdbc1;


import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Display a table in an TextArea
 * @author Amin
 */
public class SimpleJDBCGUI extends Application {

    private final FishDAO_01 fishDAO;

    /**
     * This is the default constructor
     */
    public SimpleJDBCGUI() {
        super();
        fishDAO = new FishDAOImpl_01();
        //initialize();
    }



    /**
     * @param args
     */
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple JDBC");

        TextInputDialog dialog = new TextInputDialog("true");
        dialog.setTitle("TestText");
        dialog.setHeaderText("Please enter the column");
                     
        Optional<String> result = dialog.showAndWait();
        String entered = "none.";
                     
        if (result.isPresent()){
            entered = result.get();
        }
        
        


        final TextArea text = new TextArea();
        text.setDisable(false);
        text.setEditable(false);


        String data;
        try {
                data = fishDAO.retrieveData(entered);
            } catch (SQLException ex) {
                Logger.getLogger(SimpleJDBCGUI.class.getName()).log(Level.SEVERE, null, ex);
                data = "Error loading data";
            }
            text.setText(data);



            Scene scene = new Scene(text, 300, 300);
            primaryStage.setScene(scene);


            primaryStage.show();
   }
    public static void main(String[] args) {
       launch(args);
    }
}
