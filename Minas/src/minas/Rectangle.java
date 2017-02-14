/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;

import java.util.List;
import javafx.scene.control.Button;

/**
 *
 * @author Marc
 */
public class Rectangle extends Button implements Comparable<List<String>>{
    private String pos;
    private int Minas;
    private boolean used;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }  

    public int getMinas() {
        return Minas;
    }

    public void setMinas(int Minas) {
        this.Minas = Minas;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Override
    public int compareTo(List<String> other){
        for(int i=0; other.size() > i;i++){
            int a = Integer.parseInt(this.getPos().replace("-", "")) - Integer.parseInt(other.get(i).replace("-", ""));
            if(Integer.compare(Integer.parseInt(this.getPos().replace("-", "")), Integer.parseInt(other.get(i).replace("-", ""))) == 0){
                return 0;
            }else if( a == 11 || a == 10 || a == 9 || a == 1 || a == -11 || a == -10 || a == -9 || a == -1){
                this.setMinas(this.getMinas()+1);                
            }
        }
        this.setText(" "+ this.getMinas()+ " ");
        return 0;
    }
}
