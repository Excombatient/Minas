/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapaMinas;

import java.util.HashMap;
import java.util.Map;
import minas.Rectangle;

/**
 *
 * @author Marc
 */
public abstract class MapaMinas{
    public static Map<String,Rectangle> Mapa = new HashMap();

    public static Map<String, Rectangle> getMapa() {
        return Mapa;
    }
    
}
