/**
 * Abstract class Vehiculo - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Vehiculo
{
    private String id;
    private String nombre;
    
    public Vehiculo(String id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }
    
    public String getId(){
        return this.id;
    }    
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }
    protected abstract void acelerar();
    protected abstract void frenar();
}
