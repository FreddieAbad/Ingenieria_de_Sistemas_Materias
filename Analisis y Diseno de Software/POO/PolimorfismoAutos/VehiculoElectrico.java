
public class VehiculoElectrico extends Vehiculo
{
   private int duracionBateria; 
   private int cargaBateria;
   public VehiculoElectrico(String id, String nombre){
       super(id,nombre);
       this.duracionBateria=duracionBateria;
   }
   
   public void cargar(){
       if(cargaBateria==0){
           for(int i=0; i<=100; i++)
           cargaBateria++;
       }
   }
   
   protected void acelerar(){
       if(cargaBateria>0){
           cargaBateria-=1;
           System.out.println("Acelerando vehiculo electrico"+getNombre());
       }else{
        System.out.println("No se puede acelerar no hay bateria");
       }
   }
   
   protected void frenar(){
       System.out.println("Frenando vehiculo electrico"+getNombre());
   }
}
