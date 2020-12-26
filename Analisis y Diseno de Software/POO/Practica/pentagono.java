
/**
 * Write a description of class pentagono here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pentagono extends Figuras
{
  private float lado;
  private float apotema;
    
    public float getLado(){
        return lado;
    }
    public void setLado(float nuevoLado){
        lado=nuevoLado;
    }
    
    public float getApotema(){
        return apotema;
    }
    public void setApotema(float nuevoApotema){
        apotema=nuevoApotema;
    }
    
    public double perimetro () {
        return (this.lado*5);
    }
    
    public double area () {
        return ((lado*5*this.apotema)/2);
    }
}
