/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;
import java.util.Random;
//cambio de variables
/// c= consumdr v=vndedor p=productr
public class Prueba1 {
    private static contenedor vndedor;
    private static productor productr;
    private static consumidor consumidr;

    public static void main(String[] args) {
        vndedor=new contenedor(100000);
        
       // Casos de prueba, quitar los comentarios para verificar los salidas respectivas
       productr=new productor(vndedor,1);
        consumidr=new consumidor(vndedor,5);
        /*
        productr=new productor(vndedor,1);
        consumidr=new consumidor(vndedor,5);
        */
      /*  productr=new productor(vndedor,10);
        consumidr=new consumidor(vndedor,1);
        */
        productr.start();
        consumidr.start();
        
        
        
    }
    
}
