/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minas;


import java.util.List;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.Skin;

/**
 * Declaracion clase Rectangle
 * @author Marc
 * @version 19/02/17
 */
public class Rectangle extends Button implements Comparable<List<String>>{
    private String pos;
    private int Minas=0;
    private int checks=0;
    private boolean Used;
    private boolean Could;
    
    Map<String,Rectangle> Mapa = MapaMinas.MapaMinas.getMapa();

    public boolean isCould() {
        return Could;
    }

    public void setCould(boolean Could) {
        this.Could = Could;
    }
    
       /**
     * metodo 
     * @return used 
     */
    public boolean isUsed() {
        return Used;
    }
     /**
     * metodo del constructor
     * @param used 
     */
    public void setUsed(boolean used) {
        this.Used = used;
    }  
    /**
     * metodo para obtener minas
     * @return int Minas
     */
    public int getMinas() {
        return Minas;
    }
    /**
     * metodo para obtener minas
     * @param Minas 
     */
    public void setMinas(int Minas) {
        this.Minas = Minas;
    }
    /**
     * metodo para obtener pos (posicion)
     * @return String pos
     */
    public String getPos() {
        return pos;
    }
    /**
     * metodo
     * @param pos 
     */
    public void setPos(String pos) {
        this.pos = pos;
    }
    /**
     * Classe para obtener las minas con la posicion
     */
    public void selectRect(){
        System.out.println("Position: "+ this.getPos());
        switch (this.getMinas()) {
            case -1:
                this.setText(" B ");
                break;
            case 0:
                String[] T = getPos().split("-");
                if (Integer.parseInt(T[1])<=19 && Integer.parseInt(T[1])>=0 && checks==0){
                    checks++;
                    if(!this.isCould())
                        this.setText(" "+ (this.getMinas()!=0?this.getMinas():"  "));
                    if(Integer.parseInt(T[1]) != 0 && Integer.parseInt(T[1]) != 19){
                        Mapa.get(T[0]+"-"+Integer.toString((Integer.parseInt(T[1])+1))).selectRect();
                        Mapa.get(T[0]+"-"+Integer.toString((Integer.parseInt(T[1])-1))).selectRect();
                    }
                }
                
                if (Integer.parseInt(T[0])<16 && Integer.parseInt(T[0])>=0 && checks==1){   
                    checks++;   
                    this.setText(" "+ (this.getMinas()!=0?this.getMinas():"  "));
                    if(Integer.parseInt(T[0]) != 0){
                        Mapa.get(Integer.toString((Integer.parseInt(T[0])+1))+"-"+T[1]).selectRect();
                        Mapa.get(Integer.toString((Integer.parseInt(T[0])-1))+"-"+T[1]).selectRect();
                    }
                }
                break;
            default:
                this.setText(" "+ this.getMinas());
                break;
        }
        this.setStyle("-fx-base: #FFFFFF;");
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




