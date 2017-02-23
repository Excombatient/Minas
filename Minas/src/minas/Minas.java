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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author JJ
 */
public class Minas extends Application{
    private static String name;
    private static String punt;
    StageManage<Stage> Main = new StageManage();
    @Override
    public void start(Stage primaryStage) {
        Persona user = new Persona();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(grid, 300, 275);
        Main.setMainStage(primaryStage);
        Main.getMainStage().setScene(scene);
        
        Text scenetitle = new Text("Minas");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0 , 2, 1);
        
        Label userName = new Label("User : ");
        grid.add(userName, 0, 1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        Button btn = new Button("Empezar Partida");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,1,4);
        
            
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
            String u = userTextField.getText();
            name = u;
            System.out.println("user: " +name);
                  scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                  App Aplication = new App();
                  Thread t = new Thread(Aplication);
                  t.start();
                  Aplication.build(Main);
                  primaryStage.setTitle("Buscaminas");
                  primaryStage.setScene(Aplication.getScene());
                  user.creaxml();
            }
        });
        
        primaryStage.show();
    }
    public void setScene(Scene scene){
        Main.getMainStage().setScene(scene);
    }
    
    public static String rename(){
        return name;
    }
    
    public static void SetPunts(int Punt){
    punt = Integer.toString(Punt);
    }
    
    public static String punts(){
        return punt;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}   
