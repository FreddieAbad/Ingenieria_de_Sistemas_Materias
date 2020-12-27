/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Proyecto MED Dell
 */
public class consumidor extends Thread{
    private contenedor var;
    private int id;
    public consumidor (contenedor v, int idc){
        this.var=v;
        this.id = idc;
    }
    public void run(){
        for (int i = 0; i < id; i++) {
            
            try {
                System.out.println((i+1)+" CONSUMIDOR "+this.id+" : "+var.get());
            } catch (InterruptedException ex) {
                Logger.getLogger(consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}
