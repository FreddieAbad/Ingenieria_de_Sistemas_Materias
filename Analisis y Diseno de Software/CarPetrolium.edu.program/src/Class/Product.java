package Class;

import javax.swing.JOptionPane;

public class Product {
    
    private double costoUnitario;
    private int codigo,existencia;
    private String descripcion;

    public Product(int codigo, double costoUnitario, int existencia, String descripcion) {
        if(codigo == 0)
            throw new IllegalArgumentException("CODIGO NULO");
        if(costoUnitario == 0)
            throw new IllegalArgumentException("IMPOSIBLE UN COSTO DE 0");
        if(existencia == -1)
            throw new IllegalArgumentException("REVICE LA EXISTENCIA");
        if(descripcion == null)
            throw new IllegalArgumentException("FALTA DESCRICION");
        
        this.codigo = codigo;
        this.costoUnitario = costoUnitario;
        this.existencia = existencia;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString(){
        return this.descripcion;
    }

    public void seeInfo(){
        JOptionPane.showMessageDialog(null, "DETALLE: "+ this.getDescripcion() + "\nCOSTO UNITARIO: "+ this.getCostoUnitario() + "\nEXISTENCIA: "+ this.getExistencia()
                +" UNIDADES","**INFO PRODUCTO**",JOptionPane.INFORMATION_MESSAGE);
    }
}
