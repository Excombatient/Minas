/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

/**
 * classe para obtener el documento XML
 * @author JJ
 */

public class Persona {

   public static void creaxml() {
       String uname = Minas.rename();
       String puntos = Minas.punts();
    
      try {
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.newDocument();
         
         // mina
         Element rootElement = doc.createElement("minas");
         doc.appendChild(rootElement);

         // partida
         Element mina = doc.createElement("partida");
         rootElement.appendChild(mina);

         // user
         Element user = doc.createElement("user");
         user.appendChild(doc.createTextNode(uname));
         mina.appendChild(user);

         // Puntuacio
         Element puntuacio = doc.createElement("puntuacion");
         puntuacio.appendChild(doc.createTextNode(puntos));
         mina.appendChild(puntuacio);
         
         // write the content into xml file
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(doc);
         StreamResult result = new StreamResult(new File("C:\\Users\\JJ\\Desktop\\Daw\\persona.xml"));
         transformer.transform(source, result);
         
         // Output to console for testing
         StreamResult consoleResult = new StreamResult(System.out);
         transformer.transform(source, consoleResult);
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
    
}