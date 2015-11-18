package taxcalculator;

import java.util.Scanner;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ryan
 * JavaFX Tax Calculator Form Layout
 * and Basic JavaFX Button Event Handler
 */
public class TaxCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Tax Calculator");
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(pane, 300, 275);

        Text sceneTitle = new Text("Tax Calculator");
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL,20));
        pane.add(sceneTitle, 0, 0, 2, 1);
        Label total = new Label("Income:");
        pane.add(total, 0, 1);
        final TextField totalField = new TextField();
        pane.add(totalField, 1, 1);
        Label percent = new Label("% Tax:");
        pane.add(percent,0,2);
        final TextField percentField = new TextField();
        pane.add(percentField, 1, 2);

        Button calculateButton = new Button("Calculate");        
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().add(calculateButton);
        pane.add(hbox, 1, 4);

        final Text taxMessage = new Text();
        pane.add(taxMessage, 1, 6);
        final Text incomeErrorMessage = new Text();
        pane.add(incomeErrorMessage, 1, 7);
        final Text taxErrorMessage = new Text();
        pane.add(taxErrorMessage, 1, 8);
        

        calculateButton.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent t) {
                Double income = 0.0;
                Double tax = 0.0;
                String s = "";

                try{
                 income = Double.parseDouble(totalField.getText());
                 if (income < 0){
                     s+= "The value for income cannot be negative\n";
                     income = 0.0;
                 }
                }
                catch (Exception e){
                    incomeErrorMessage.setText("The value for income should be number");
                }
                try{
                 tax = Double.parseDouble(percentField.getText())/100;
                 if (tax < 0 || tax > 1){
                     s+= "The value for tax% should be between 0 to 100\n";
                     tax = 0.0;
                 }
                }
                catch(Exception e){
                    taxErrorMessage.setText("The value for tax% should be number");
                }
                
                taxMessage.setText("Tax incurred:"+income*tax);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}