/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.ad1;

/**
 *
 * @author Usuario
 */
public class ReservaMesa {
    private String fecha;
    private String hora;
    private Mesa mesa;

    public ReservaMesa(String fecha, String hora, Mesa mesa) {
        if (fecha==null ||fecha.trim().length() !=0)
            throw new IllegalArgumentException("No puede tener fecha vacia");
        this.fecha = fecha;
        this.hora = hora;
        this.mesa = mesa;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
            
    
}
