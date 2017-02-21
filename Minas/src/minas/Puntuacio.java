/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 *
 * @author JJ
 */
public class Puntuacio {
    
  public static void leeXML() {

    try {

	File puntuacio = new File("C:\\Users\\JJ\\Desktop\\Daw\\persona.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(puntuacio);

	doc.getDocumentElement().normalize();

	NodeList nList = doc.getElementsByTagName("minas");
        
	System.out.println("\n ----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			//System.out.println("mina id : " + eElement.getAttribute("id"));
			System.out.println("User : " + eElement.getElementsByTagName("user").item(0).getTextContent());
			System.out.println("puntuacio : " + eElement.getElementsByTagName("puntuacion").item(0).getTextContent());

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
   }
}