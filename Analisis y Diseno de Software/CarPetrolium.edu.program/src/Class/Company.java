package Class;

import javax.swing.JOptionPane;

public class Company {
    
    private int ruc;
    private String nombre,direccion,correo,permiOperacion,fecha;

    public Company(int ruc, String nombre, String direccion, String correo, String permiOperacion,String fecha) {
        
        if(ruc == 0)
            throw new IllegalArgumentException("EL RUC DE LA EMPRESA == NULL");
        if(nombre == null)
            throw new IllegalArgumentException("NOMBRE DE LA EMPRESA == NULL");
        if(direccion == null)
            throw new IllegalArgumentException("DIRECCION PRINCIPAL DE LA EMPRESA == NULL");
        if(correo == null)
            throw new IllegalArgumentException("CORREO DE LA EMPRESA == NULL");
        if(permiOperacion == null)
            throw new IllegalArgumentException("PERMISO DE OPERACION == NULL");
        if(fecha == null)
            throw new IllegalArgumentException("NO EXISTE FECHA DE REGISTRO");
        
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.permiOperacion = permiOperacion;
        this.fecha = fecha;
    }

    public Company() {
        
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPermiOperacion() {
        return permiOperacion;
    }

    public double getRuc() {
        return ruc;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPermiOperacion(String permiOperacion) {
        this.permiOperacion = permiOperacion;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }
    
    public void seeInfo() {
        JOptionPane.showMessageDialog(null,"RUC: 0"+ruc+"\nNOMBRE: "+nombre
                +"\nDIRECCION: "+direccion+"\nCORREO: "+correo
                +"\nPERMISO DE OPERACION: "+permiOperacion
                + "\nFECHA DE CREACION: "+fecha,"**INFO EMPRESA**",1);
    }

    @Override
    public String toString(){
        return "RUC: "+ ruc + "\nNOMBRE: " + nombre + "\nDIRECCION: " + direccion + "\nCORREO: " + correo+"\n";
    }
    
    
}
