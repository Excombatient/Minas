package minas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author JJ
 */
public class leerTXT{
    private static final String FILENAME = "puntuacion.txt";
                
    public static void EndStage(StageManage<Stage> primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.getMainStage().setScene(scene);
        
        Text scenetitle = new Text("Puntuacion de Usuarios");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle,0,0,1, 1);
        
        ArrayList<String> jugadores = new ArrayList<String>();   
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILENAME));
			while ((sCurrentLine = br.readLine()) != null) {
                            System.out.println(sCurrentLine);
                            jugadores.add(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
        System.out.println("hola"+jugadores);
        String listString = "";

        for (String s : jugadores){
            listString += s + "\n";
        }

        System.out.println(listString);
        Text area  = new Text(listString);
        grid.add(area,0,5, 4, 4);
    }
    }
