 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author JJ
 */
public class Minas extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        for(int i = 3;i<20;i++){
            for(int n = 0; n<20; n++){
                Rectangle btn = new Rectangle();
                btn.setText("   ");
                btn.setPos((i-3)+"-"+n);  
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                    System.out.println("Position: "+ btn.getPos());
                   }
                });
                btn.setLayoutX(25*n);
                btn.setLayoutY(25*i); 
                root.getChildren().add(btn);
            }
            
        }
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("Buscaminas");
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
