
/**
 * Write a description of class cuadrado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cuadrado  extends Figuras

{
    private float lado;
    
    public float getLado(){
        return lado;
    }
    public void setLado(float nuevoLado){
        lado=nuevoLado;
    }
        public double perimetro () {
        return (this.lado*4);
    }
    

    public double area () {
        return (Math.pow(lado, 2));
    }
    

    public String toString () {
        return "Cuadrado";
    }
}
