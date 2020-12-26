
public class Area_Perimetro_de_Figuras {

    public static void main(String[] args) {
        Figura figuras[] = new Figura[3];
        figuras[0] = new Circulo(10);
        figuras[1] = new Cuadrado(10);
        figuras[2] = new Triangulo(10, 5);
        

        for (int i = 0; i < figuras.length; i++) {

            
            System.out.println("FIGURA "+(i+1));
            
            System.out.println("Area del " + figuras[i] + " es " + figuras[i].area());

            System.out.println("Perímetro del " + figuras[i] + " es " + figuras[i].perimetro());
            
            System.out.println();

        }
                

    }

}
