import javax.swing.*;
public class Planta extends SerVivo
{
    private int x;

    public static void Planta(String[] args)
    {
        SerVivo Pcarnivora= new SerVivo ("Carne","Normal","Normal");
        JOptionPame.showMessageDialog(null,"Datos de la planta \n"+"\nAlimentacion: "+
        SerVivo.getAlimentar()+"\nCrecimiento: "+SerVivo.getCrecer()+"\nReproduccion:"+
        SerVivo.getReproducir());
    }

}
