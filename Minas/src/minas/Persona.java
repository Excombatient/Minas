/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

import javafx.application.Application;
import static javafx.application.Application.launch;
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
 * @author JJ
 */
public class Persona extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        
        Text scenetitle = new Text("Minas");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0 , 2, 1);
        
        Label userName = new Label("User Name: ");
        grid.add(userName, 0, 1);
        
        TextField userTextField = new TextField();
        //userTextField.getText(); <--- muestra la string recojida
        grid.add(userTextField, 1, 1);
        
        Button btn = new Button("Empezar Partida");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,1,4);
        
        //final Text actiontarget = new Text();
        //    grid.add(actiontarget, 1, 6);
            
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                //actiontarget.setFill(Color.FIREBRICK);
               // actiontarget.setText("Signed"+" "+userTextField.getText());
               Label secondLabel = new Label("Buscaminas");
               
               StackPane secondaryLayout = new StackPane();
               secondaryLayout.getChildren().add(secondLabel);
               
               Scene secondScene = new Scene(secondaryLayout, 200, 100);
               
               Stage secondStage = new Stage();
               secondStage.setTitle("Second Stage");
               secondStage.setScene(secondScene);
               
               secondStage.setX(primaryStage.getX() +250);
               secondStage.setY(primaryStage.getY() +150);
               
               secondStage.show();
               primaryStage.close();
            }
        });
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}