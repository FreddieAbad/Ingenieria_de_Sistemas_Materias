
/**
 * Write a description of class circulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class circulo extends Figuras
{
   private float lado;
    
    public float getLado(){
        return lado;
    }
    public void setLado(float nuevoLado){
        lado=nuevoLado;
    }
     public double perimetro () {
        return (2*Math.PI*this.lado);
    }
    
    public double area () {
        return (Math.PI*(Math.pow(lado, 2)));
    }
}
