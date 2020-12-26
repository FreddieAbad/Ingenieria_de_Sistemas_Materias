package PolimorfismoAutos;


/**
 * Write a description of class VehiculoManual here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VehiculoManual extends VehiculoCombustibleFosil
{
   public VehiculoManual(){
       super("10","Corsa","Diesel");
   }    
   public void acelerar(){
       System.out.println("Acelerando vehiculo, marcha manual");
   }
   public void frenar(){
       System.out.println("Frenando vehiculo, marcha manual");
   }
}
