/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productorconsumidor;

/*
    Tendra somoforos
*/

import java.util.concurrent.*;
public class Buffer {
    private int[] bufferB;
    private int i=0,j=0;
    private Semaphore mutex= new Semaphore(1, true);
    private Semaphore hayDatos= new Semaphore(0,true);
    private Semaphore hayEspacio;

    public Buffer(int tam) {
        bufferB= new int[tam];
        hayEspacio= new Semaphore(bufferB.length,true);
        
    }
    public void poner(int dato) throws InterruptedException{
        hayEspacio.acquire(); // veo si hay espacio donde poner o paro
        mutex.acquire();
        bufferB[i]=dato;
        System.out.println("Productor produce "+dato);
        i=(i+1)%bufferB.length;
        mutex.release();
        hayDatos.release();//agrego dato mas
        
    }
    public int extraer() throws InterruptedException{
        hayDatos.acquire();
        mutex.acquire();
        int aux=j;
        j=(j+1)%bufferB.length;
        System.out.println("Consumidor consume "+bufferB[aux]);
        mutex.release();//modifica mutex
        hayEspacio.release();
        return bufferB[aux];
                
    }
    
}
