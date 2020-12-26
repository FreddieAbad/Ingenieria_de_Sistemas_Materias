//Clase Hija 3

public class Triangulo extends Figura {
    //Atributos encapsulados
    private int base;
    private int altura;
    
    //Constructor
    public Triangulo (int base, int altura) {
        this.altura = altura;
        this.base = base;
    }
    
    //Polimorfismo
    @Override
    public double perimetro () {
        return (this.base*3);
    }
    
    @Override
    public double area () {
        return ((this.base*this.altura)/2);
    }
    
    @Override
    public String toString () {
        return "Triangulo";
    }
}
