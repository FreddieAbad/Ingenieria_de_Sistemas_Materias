
/**
 * Write a description of class Principal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Principal
{
    public static void main(String args[]){
        cuadrado miCuadrado=new cuadrado();
        miCuadrado.setLado(14.56f);
        System.out.println("CUADRADO \nLADO: "+miCuadrado.getLado());
        System.out.println("Area Cuadrado: "+miCuadrado.area());
        System.out.println("Perimetro Cuadrado: "+miCuadrado.perimetro());
       
        triangulo miTriangulo=new triangulo();
        miTriangulo.setLado(16.5f);
        miTriangulo.setAltura(3.5f);
        System.out.println(miTriangulo.getLado());
        System.out.println("TRIANGULO \nLADO: "+miTriangulo.getLado());
        System.out.println("Area Cuadrado: "+miTriangulo.area());
        System.out.println("Perimetro Cuadrado: "+miTriangulo.perimetro());
        
        pentagono miPentagono=new pentagono();
        miPentagono.setLado(15.6f);
        miPentagono.setApotema(4.3f);
        System.out.println(miPentagono.getLado());
        System.out.println("PENTAGONO \nLADO: "+miPentagono.getLado());
        System.out.println("Area Pentagono: "+miPentagono.area());
        System.out.println("Perimetro Pentagono: "+miPentagono.perimetro());
        
        circulo miCirculo=new circulo();
        miCirculo.setLado(14.56f);
        System.out.println(miCirculo.getLado());
        System.out.println("CIRCULO \nLADO: "+miCirculo.getLado());
        System.out.println("Area Circulo: "+miCirculo.area());
        System.out.println("Perimetro Circulo: "+miCirculo.perimetro());
    
    }
}
