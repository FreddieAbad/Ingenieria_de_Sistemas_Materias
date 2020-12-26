//Clase Hija 1

public class Cuadrado extends Figura {
    //Atributos encapsulados
    private int lado;
    
    //Constructor
    public Cuadrado (int lado) {
        this.lado = lado;
    }
    
    //Polimorfismo
    @Override
    public double perimetro () {
        return (this.lado*4);
    }
    
    @Override
    public double area () {
        return (Math.pow(lado, 2));
    }
    
    @Override
    public String toString () {
        return "Cuadrado";
    }
}
