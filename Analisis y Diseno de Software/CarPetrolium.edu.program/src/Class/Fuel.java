package Class;

import javax.swing.JOptionPane;

public class Fuel {
    
    private double octanaje,costoGalon;
    private String tipoCombustible,nombre;
    Dispenser dispensador;

    public Fuel(double octanaje, double costoGalon, String tipoCombustible, String nombre, Dispenser dispensador) {
        
        if(octanaje == 0)
            throw new IllegalArgumentException("EXISTENTE COMBUSTIBLE ==> NULL");
        if(costoGalon == 0)
            throw new IllegalArgumentException("COSTO POR GALON DEL COMBUSTIBLE ==> NULL");
        if(tipoCombustible == null)
            throw new IllegalArgumentException("TIPO DE COMBUTIBLE ==> NULL");
        if(nombre == null)
            throw new IllegalArgumentException("NOMBRE DEL COMBUSTIBLE ==> NULL");
        if(dispensador == null)
            throw new IllegalArgumentException("EL AH SIDO IDENTIFICADO EL DISPENSADOR");
        
        this.octanaje = octanaje;
        this.costoGalon = costoGalon;
        this.tipoCombustible = tipoCombustible;
        this.nombre = nombre;
        this.dispensador = dispensador;
    }
    
    public void seeInfo(){
        JOptionPane.showMessageDialog(null, "TIPO: "+ this.getTipoCombustible() + "\nNOMBRE: "+ this.getNombre() + "\nCOSTO: "+ this.getCostoGalon() + "\nEXISTENCIA: "+ this.getOctanaje()
                +" GALONES","**INFO COMBUSTIBLE**",JOptionPane.INFORMATION_MESSAGE);
    }

    public void setCostoGalon(double costoGalon) {
        this.costoGalon = costoGalon;
    }

    public void setDispensador(Dispenser dispensador) {
        this.dispensador = dispensador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOctanaje(double octanaje) {
        this.octanaje = octanaje;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public double getCostoGalon() {
        return costoGalon;
    }

    public Dispenser getDispensador() {
        return dispensador;
    }

    public String getNombre() {
        return nombre;
    }

    public double getOctanaje() {
        return octanaje;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
