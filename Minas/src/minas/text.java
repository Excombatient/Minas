/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import minas.Minas;

/**
 *
 * @author JJ
 */
public class text {
    public static void createTXT(){
    String uname = Minas.rename();
    String puntos = Minas.punts();
    try{
    File TextFile = new File("puntuacion.txt"); 
    FileWriter writer = new FileWriter(TextFile, true);
    //PrintWriter writer = new PrintWriter("puntuacion.txt", "UTF-8");
    writer.write("User: "+uname +"   ");
    writer.write("Puntuacio: "+puntos+"------");
    writer.close();
    
} catch (IOException e) {
   // do something
}
    }
}
