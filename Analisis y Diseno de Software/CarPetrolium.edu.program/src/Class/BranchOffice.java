package Class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class BranchOffice {
    
    Manager gerente;
    
    private String nombreSucursal,direccionSucursal;
    private List<Administrator> administradores;

    public BranchOffice(String nombreSucursal, String direccionSucursal,Manager gerente) {
       
      
        /*if(this.getAdministradores().size() > 1){
            JOptionPane.showMessageDialog(null,"Solo un admin","**INFO ADMINISTRADOR**",JOptionPane.ERROR_MESSAGE);
              throw new IllegalArgumentException("EN CADA SUCULSAL SOLO PUEDE EXISITIR UN ADMINISTRADOR");
        }else */if(nombreSucursal == null){
            JOptionPane.showMessageDialog(null,"NOMBRE DE SUCURSAL = NULL","**INFO ADMINISTRADOR**",JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("NOMBRE DE LA SUCURSAR == NULL");
        }else if(direccionSucursal == null){
            JOptionPane.showMessageDialog(null,"DIRECCION DE LA SUCURSAL = NULL","**INFO ADMINISTRADOR**",JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("DIRECCION DE LA SUCURSAR == NULL");
        } else if(gerente == null){
            JOptionPane.showMessageDialog(null,"NOMBRE DE SUCURSAL = NULL","**INFO ADMINISTRADOR**",JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("EL GERENTE NO AH SIDO IDENTIFICADO");
        }
        
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.gerente = gerente;
        this.administradores = new ArrayList<>();
    }


    public String getNombreSucursal() {
        return nombreSucursal;
    }   

    public Manager getGerente() {
        return gerente;
    }

    public List<Administrator> getAdministradores() {
        return administradores;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }
    
    public void setDireccionSucursa(String direccionSucursa) {
        this.direccionSucursal = direccionSucursa;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
    
    public void createAdministrator(Administrator administrador){
        this.administradores.add(administrador);
    }
    
    public void seeInfo(){
        JOptionPane.showMessageDialog(null,"nombre: "+ this.getNombreSucursal()+"\nDireccion: "+this.getDireccionSucursal()
                +"\nnum Admin: " + administradores.size()+"\nNumSucursales: "+this.gerente.getSucursales().size()+"\nGerente: "+this.gerente.getNombre(),"**INFO SUCURSAL**",1);
    }
    
    @Override
    public String toString(){
        return "NOMBRE: " + this.getNombreSucursal() + "\nDIRECCION: " + this.getDireccionSucursal()+"\n";
    }
    
}
