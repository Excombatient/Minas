package minas;

import MapaMinas.*;
import java.util.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.AbstractButton;

/**
 *
 * @author JJ
 */
public class Minas extends Application{
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
                  scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                  App Aplication = new App();
                  Thread t = new Thread(Aplication);
                  t.start();
                  Aplication.build();
                  primaryStage.setTitle("Buscaminas");
                  primaryStage.setScene(Aplication.getScene());
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
