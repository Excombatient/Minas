 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

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
public class Minas extends Application {
    @Override
    public void start(Stage primaryStage) {
        Map<String,Rectangle> Mapa = new HashMap();
        List<String> bombs = new ArrayList<>();
        Random R = new Random();
        R.rand(bombs);
        Pane root = new Pane();
        for(int i = 3;i<20;i++){
            for(int n = 0; n<20; n++){
                Rectangle btn = new Rectangle();
                btn.setText("   ");
                btn.setPos((i-3)+"-"+n);
                btn.compareTo(bombs);
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!btn.isUsed()){
                            btn.selectRect();
                            //Mirar per si minas es 0, mostrar els costats i així tota l'estona
                            //comprobar que funciona el author
                        }
                   }
                });
                Mapa.put(btn.getPos(), btn);
                btn.setLayoutX(25*n);
                btn.setLayoutY(25*i);
                root.getChildren().add(btn);
            }
        }
        
        Scene scene = new Scene(root, 500, 500);
        /*root.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (!event.getSource()b .isUsed()){
                            System.out.println("Position: "+ event.getSource().getPos());
                            System.out.println("Compare to: "+event.compareTo(bombs));
                            event.setUsed(true);
                        }
                   }
                });*/
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
    
        class Random{
            public List<String> rand(List<String> A){
                for(int i = 0; i<10;i++){
                   A.add(randomizer(0,16)+"-"+randomizer(0,19));
                   System.out.println(A.get(A.size()-1));
                }
                return A;
            }
            public int randomizer(int min, int max){
                return(min + (int)(Math.random() * ((max - min) + 1)));
                }
        }
}   
