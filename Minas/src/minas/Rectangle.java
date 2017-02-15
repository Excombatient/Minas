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
    private int Minas=0;
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
    
    public void selectRect(){
        System.out.println("Position: "+ this.getPos());
        this.setText(" "+ this.getMinas());
        this.setUsed(true);
    }

    @Override
    public int compareTo(List<String> other){
        String[] T = this.getPos().split("-");
        for(int i=0; other.size() > i;i++){
            String[] O = other.get(i).split("-");
            int a = Integer.parseInt(T[0]) - Integer.parseInt(O[0]);
            int b = Integer.parseInt(T[1]) - Integer.parseInt(O[1]);
            if(Integer.compare(a , 0)==0 && Integer.compare(b , 0)==0){    
                this.setMinas(-1);
                 System.out.println(other.get(i)+"---"+this.getPos());
                return 0;
            }else if( (a == 0 && b == 1) || (a == 0 && b == -1) || (a == 1) && (b == 1) || (a == 1 && b == -1) || (a == 1 && b == 0) || (a == -1 && b == 1) || (a == -1 && b == -1) || (a == -1 && b == 0)){
                this.setMinas(this.getMinas()+1);
            }else{
            }
        }
        return (this.getMinas());
    }
}
