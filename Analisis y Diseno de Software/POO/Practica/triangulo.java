
/**
 * Write a description of class triangulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class triangulo extends Figuras
{
   private float lado;
   private float altura;
    
    public float getLado(){
        return lado;
    }
    public void setLado(float nuevoLado){
        lado=nuevoLado;
    }
    public float getAltura(){
        return altura;
    }
    public void setAltura(float nuevaAltura){
        altura=nuevaAltura;
    }
    
    public double perimetro () {
        return (this.lado*3);
    }
    
    public double area () {
        return ((this.lado*this.altura)/2);
    }
}
