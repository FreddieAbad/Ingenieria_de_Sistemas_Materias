package Class;

import javax.swing.JOptionPane;

public class Employee extends Person{
    String cargo;

    public Employee(String cargo, int ruc, String nombre, String direccion, String correo) {
        super(ruc, nombre, direccion, correo);
        if(cargo == null)
            throw new IllegalArgumentException("EL CARGO NO EXISTE");
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public String toString(){
        return super.getNombre();
    }
    
    public void SeeInfo(){
        JOptionPane.showMessageDialog(null, "CEDULA: "+ this.getRuc() + "\nNOMBRE: "+ this.getNombre() + "\nDIRECCION: "+ this.getDireccion() + "\nCORREO: "+ this.getCorreo()
                +"\nCARGO: " + this.getCargo(),"**INFO EMPLEADO**",JOptionPane.INFORMATION_MESSAGE);
    }
}
