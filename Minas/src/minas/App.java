/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

import MapaMinas.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

/**
 *
 * @author MarcS
 */
public class App extends MapaMinas implements Runnable{
    private Scene scene;
    private int sec=0;
    private int Cont=0;
    
    public void build(StageManage<Stage> MainStage){
        List<String> bombs = new ArrayList<>();
        Set<Rectangle> Detectades = new HashSet<Rectangle>();
        App.Random R = new App.Random();
        R.rand(bombs);
        Pane root = new Pane();
        Label User = new Label();
        User.setText("user: " + Minas.rename());
        User.setLayoutX(10);
        User.setLayoutY(10);
        root.getChildren().add(User);
        for(int i = 3;i<20;i++){
            for(int n = 0; n<20; n++){
                Rectangle btn = new Rectangle();
                btn.setText("   ");
                btn.setPos((i-3)+"-"+n);
                btn.compareTo(bombs);
                btn.setOnMouseClicked((MouseEvent event) -> {
                    MouseButton button = event.getButton();
                    if(button==MouseButton.PRIMARY){
                        if (!btn.isUsed()){
                            btn.selectRect();
                        }
                    }else if(button==MouseButton.SECONDARY){
                        if(!btn.isUsed() && !btn.isCould()){
                            btn.setText(" ? ");
                            btn.setStyle("-fx-base: #FF0000;");
                            btn.setCould(true);
                            btn.setUsed(true);
                            Detectades.add(btn);
                            
                        }else if(btn.isUsed() && btn.isCould()){
                            btn.setText("   ");
                            btn.setCould(false);
                            btn.setUsed(false);
                            btn.setStyle("-fx-base: #F0E7E7;");
                            Detectades.remove(btn);
                        }
                    }
                    if (Detectades.size()==20 || btn.getText().equals(" B ")){
                        try {
                            btn.setText(" B ");
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                            System.out.println("Error on the sleep");
                        }
                        Minas.SetPunts((search(bombs,Detectades,Mapa)*10)-(sec/10));
                        text.createTXT();
                        leerTXT.EndStage(MainStage);
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

    public int search(List<String> Bomb, Set<Rectangle> Detect, Map<String,Rectangle> Map){
    
        for(int i=0; i!= Bomb.size();i++){
            if(Detect.contains(Map.get(Bomb.get(i)))){
                Cont++;
            }
        }
        return Cont;
    }
    
    @Override
    public void run() {
        System.out.println("Hello from a thread!");
        while(true){
            try{
                sec++;
                Thread.sleep(1000);
            } catch (InterruptedException iex) {
                System.out.println("Exception in var sec thread: "+iex.getMessage());
            }
        }
    }
    
    class Random{
            public List<String> rand(List<String> A){
                String Test;
                for(int i = 0; i<20;i++){
                   do{
                        Test = randomizer(0,16)+"-"+randomizer(0,19);
                   }while(A.contains(Test));
                   A.add(Test);
                   System.out.println(A.get(A.size()-1));
                }
                return A;
            }
            public int randomizer(int min, int max){
                return(min + (int)(Math.random() * ((max - min) + 1)));
                }
        }
    
}
