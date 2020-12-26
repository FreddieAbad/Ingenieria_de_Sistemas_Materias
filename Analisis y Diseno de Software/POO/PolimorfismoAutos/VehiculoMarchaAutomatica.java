
public class VehiculoMarchaAutomatica extends VehiculoCombustibleFosil
{
   public VehiculoMarchaAutomatica(){
       super("100","Sportage","Gasolina");
   }    
   public void acelerar(){
       System.out.println("Acelerando vehiculo, marcha automatica");
   }
   public void frenar(){
       System.out.println("Frenando vehiculo, marcha automatica");
   }
}
