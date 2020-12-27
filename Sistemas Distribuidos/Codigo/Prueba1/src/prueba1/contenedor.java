/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Proyecto MED Dell
 */
public class contenedor {
    /*
    private int num;
    private Boolean haynum= Boolean.FALSE;
    
    public int get(){
        haynum = Boolean.FALSE;
        return num;
    }
    
    public void set(int valor){
        haynum = Boolean.TRUE;
        num=valor;       
    }*/
    private int[] bufferB;
    private int i=0,j=0;
    private Semaphore mutex= new Semaphore(1, true);
    private Semaphore hayDatos= new Semaphore(0,true);
    private Semaphore hayEspacio;

    public contenedor(int tam) {
        bufferB= new int[tam];
        hayEspacio= new Semaphore(bufferB.length,true);
        
    }
    public   void set(int dato) throws InterruptedException{
        hayEspacio.acquire(); // verifico si hay espacio donde poner o detengo
        mutex.acquire();
        bufferB[i]=dato;
        i=(i+1)%bufferB.length;
        mutex.release();
        hayDatos.release();//Agrego datos 
        
    }
    public   int get() throws InterruptedException{
        hayDatos.acquire();
        mutex.acquire();
        int aux=j;
        j=(j+1)%bufferB.length;
        mutex.release();//modifica mutex
        hayEspacio.release();
        return bufferB[aux];
                
    }
    
}
