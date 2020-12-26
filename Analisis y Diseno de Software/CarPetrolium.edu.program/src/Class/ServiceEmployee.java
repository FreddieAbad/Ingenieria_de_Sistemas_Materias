package Class;

import javax.swing.JOptionPane;

public class ServiceEmployee {

    private double costoUnitario;
    private int codigo;
    private String servicio;

    public ServiceEmployee(int codigo, String servicio, double costoUnitario) {
        if(codigo == 0)
            throw new IllegalArgumentException("CODIGO NULO");
        if(costoUnitario == 0)
            throw new IllegalArgumentException("IMPOSIBLE UN COSTO DE 0");
        if(servicio == null)
            throw new IllegalArgumentException("FALTA DESCRICION");
        this.costoUnitario = costoUnitario;
        this.codigo = codigo;
        this.servicio = servicio;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString(){
        return this.servicio;
    }

    public void seeInfo(){
        JOptionPane.showMessageDialog(null, "DETALLE: "+ this.getServicio() + "\nCOSTO UNITARIO: "+ this.getCostoUnitario() 
                +"","**INFO SERVICIO**",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
