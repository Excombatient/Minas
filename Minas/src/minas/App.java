/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

import MapaMinas.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *
 * @author Marc
 */
public class App extends MapaMinas implements Runnable{
    private Scene scene;
    private int sec=0;
    
    public void build(){
        List<String> bombs = new ArrayList<>();
        App.Random R = new App.Random();
        R.rand(bombs);
        Pane root = new Pane();
        for(int i = 3;i<20;i++){
            for(int n = 0; n<20; n++){
                Rectangle btn = new Rectangle();
                btn.setText("   ");
                btn.setPos((i-3)+"-"+n);
                btn.compareTo(bombs);
                btn.setOnAction((ActionEvent event) -> {
                    if (!btn.isUsed()){
                        btn.selectRect();
                        //Mirar per si minas es 0, mostrar els costats i així tota l'estona
                    }
                });
                Mapa.put(btn.getPos(), btn);
                btn.setLayoutX(25*n);
                btn.setLayoutY(25*i);
                root.getChildren().add(btn);
            }
        }
        
        scene = new Scene(root, 500, 500);
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
    
    public Scene getScene(){
    return this.scene;
    }
    
    @Override
    public void run() {
        System.out.println("Hello from a thread!");
        while(true){
            try{
                sec++;
                Thread.sleep(100);
            } catch (InterruptedException iex) {
                System.out.println("Exception in var sec thread: "+iex.getMessage());
            }
        }
    }
    
    class Random{
            public List<String> rand(List<String> A){
                for(int i = 0; i<20;i++){
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
