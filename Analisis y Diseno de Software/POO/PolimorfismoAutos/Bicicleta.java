
public class Bicicleta extends Vehiculo
{
   private String color;
   private String tipo;
   private boolean andando;
   public Bicicleta(String id, String nombre, String color, String tipo){
       super(id,nombre);
       this.color=color;
       this.tipo=tipo;
   }
   public String getColor(){
       return this.color;
    }
   
   public String getTipo(){
       return this.tipo;
    }
    
   public void pedalear(){
       if(!andando)
            andando=true;
       acelerar();
   }    
    protected void acelerar(){
       System.out.println("Acelerando"+getNombre());
   }
   
   protected void frenar(){
       System.out.println("Frenando"+getNombre());
   }
}
