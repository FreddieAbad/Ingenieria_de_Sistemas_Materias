
/**
 * Write a description of class cuerpo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cuerpo
{
    //creo un array de tipo Organos
   private Organos[] organos;
   
   public cuerpo(){
       //ayuda con el polimorfismo
       organos=new Organos[3];
       organos[0]=new pezon();
       organos[1]=new teta();
    }
}
