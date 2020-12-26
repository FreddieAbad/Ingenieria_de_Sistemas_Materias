//Clase Hija 2

public class Circulo extends Figura {
    //Atributos encapsulados
    private int radio;
    
    //Constructor
    public Circulo (int radio){
        this.radio = radio;
    }
    
    //Polimorfismo
    @Override
    public double perimetro () {
        return (2*Math.PI*this.radio);
    }
    
    @Override
    public double area () {
        return (Math.PI*(Math.pow(radio, 2)));
    }
    
    @Override
    public String toString () {
        return "Circulo";
    }
    
    
}
