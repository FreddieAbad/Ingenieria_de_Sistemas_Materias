/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Proyecto MED Dell
 */
class productor extends Thread{
    private contenedor var;
    private int id;
    private int valor;
    private Random aleatorio;
    
    public productor (contenedor v, int idp){
        this.var=v;
        this.id=idp;
        aleatorio = new Random();
       
    }
    
    public void run(){
        
         while (Boolean.TRUE){
            this.valor=aleatorio.nextInt(300);
             try {
                 var.set(this.valor);
             } catch (InterruptedException ex) {
                 Logger.getLogger(productor.class.getName()).log(Level.SEVERE, null, ex);
             }
            System.out.println("PROD"+this.id+":"+this.valor);
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    } 
}
}