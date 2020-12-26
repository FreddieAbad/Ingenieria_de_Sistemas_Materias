package Class;

import javax.swing.JOptionPane;

public class Customer extends Person{

    public Customer(int ruc, String nombre, String direccion, String correo) {
        super(ruc, nombre, direccion, correo);
    }
    
    @Override
    public void seeInfo(){
        JOptionPane.showMessageDialog(null,"RUC: "+super.getRuc()+"\nNOMBRE: "+super.getNombre()
                +"\nDIRECCION: "+ super.getDireccion() +"\nCORREO: "+super.getCorreo()
                +"","**INFO CLIENTE**",JOptionPane.INFORMATION_MESSAGE);    
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
