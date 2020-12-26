/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.ad1;

/**
 *
 * @author lainiguez
 */
public class ReservaMesa {
    
    private String fecha;
    private String hora;
    
    private Mesa mesa;

    public ReservaMesa(String fecha, String hora, Mesa mesa) {
        
        if (fecha == null || fecha.trim().length() != 10)
            throw new IllegalArgumentException("El parámetro 'fecha' no puede contener un valor nulo");
        
        if (hora == null || hora.trim().length() != 5)
            throw new IllegalArgumentException("El parámetro 'hora' no puede contener un valor nulo");
                
        if (mesa == null)
            throw new IllegalArgumentException("El parámetro 'mesa' no puede contener un valor nulo");
                
        this.fecha = fecha;
        this.hora = hora;
        this.mesa = mesa;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the mesa
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * @param mesa the mesa to set
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    
}
