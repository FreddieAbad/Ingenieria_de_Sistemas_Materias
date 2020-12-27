/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {
    private Random r=new Random();
    private Buffer b;
    private int iter;

    public Productor(Buffer b, int iter) {
        this.b=b;
        this.iter=iter;
    
    }
    @Override
    public void run(){
        for (int i = 0; i < iter; i++) {
            
            try {
                int aux=r.nextInt(100);
                System.out.println(i+" : Productor produce "+aux);
                b.poner(aux);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        
        }
    }
    
}
