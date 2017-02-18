 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

import MapaMinas.*;
import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.AbstractButton;

/**
 *
 * @author JJ
 */
public class Minas extends Application{
    @Override
    public void start(Stage primaryStage) {
        App Aplication = new App();
        //new Thread(Aplication.start());
        Thread t = new Thread(Aplication);
        t.start();
        Aplication.build();
        primaryStage.setTitle("Buscaminas");
        primaryStage.setScene(Aplication.getScene());
        primaryStage.show();
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}   
