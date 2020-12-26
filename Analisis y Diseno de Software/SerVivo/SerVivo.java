
public class SerVivo
{
    // instance variables - replace the example below with your own
    private String alimentar;
    private String crecer;
    private String reproducir;

    /**
     * Constructor for objects of class SerVivo
     */
    public SerVivo(){}
    public SerVivo(String alimentar, String crecer, String reproducir){
        this.alimentar=alimentar;
        this.crecer=crecer;
        this.reproducir=reproducir;
    }

    /**
     * An example of a method - replace this comment with your own
     */
    public String getAlimentar(){
        return alimentar;
    }
    public String getCrecer(){
        return crecer;
    }
    public String getReproducir(){
        return reproducir;
    }
    
}
