package Class;

import javax.swing.JOptionPane;

public class EmployeeServiceStation extends Person {
    
    private Dispenser dispensador;
    private String cargo;
    public EmployeeServiceStation(int ruc, String nombre, String direccion, String correo,Dispenser dispensador,String cargo) {
        super(ruc, nombre, direccion, correo);
        if(dispensador == null)
            throw new IllegalArgumentException("EL DISPENSADOR NO AH SIDO IDENTIFICADO");
        this.dispensador = dispensador;
        this.cargo = cargo;
    }
    
    @Override
    public void seeInfo() {
          JOptionPane.showMessageDialog(null, "RUC: "+super.getRuc()+"\nNOMBRE: "+super.getNombre()
                +"\nDIRECCION: "+ super.getDireccion() +"\nCORREO: "+super.getCorreo()
                +"\nCARGO: " +  cargo,"**INFO EMPLEADO**",JOptionPane.INFORMATION_MESSAGE);    
    }
    
    @Override
    public String toString(){
        return super.getNombre();
    }
    
}
