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
public class Reserva {
    
    private String fecha;
    private String hora;
    private int numPersonas;
    
    private String nombre;
    
    private Mesa mesa;
    private EstadoReserva estado;

    public Reserva(String fecha, String hora, int numPersonas, String nombre, Mesa mesa) {
        
        if (fecha == null || fecha.trim().length() != 8)
            throw new IllegalArgumentException("El paŕametro 'fecha' no puede contener un valor nulo o no representar una fecha");

        if (hora == null || hora.trim().length() != 5)
            throw new IllegalArgumentException("El parámetro 'hora' no puede contener un valor nulo o no representar una hora");
        
        if (numPersonas <= 0)
            throw new IllegalArgumentException("El parámetro 'numPersonas' no puede ser menor a 1");
        
        if (nombre == null || nombre.trim().length() == 0)
            throw new IllegalArgumentException("El parámetro 'nombre' no puede contener un valor nulo");
        
        if (mesa == null)
            throw new IllegalArgumentException("El parámetro 'mesa' no puede contener un valor nulo");
            
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.nombre = nombre;
        this.mesa = mesa;
        this.estado = EstadoReserva.ACTIVA;
    }

    String imprimir() {
        String ticket = "";
        
        ticket += "Fecha: " + getFecha() + "\n";
        ticket += "Hora: " + getHora()+ "\n";
        ticket += "Restaurante: " + getMesa().getUbicacion().getRestaurante().getNombre() + "\n";
        ticket += "Ubicación: " + getMesa().getUbicacion().getNombre() + "\n";
        ticket += "Mesa: " + getMesa().getNumero() + "\n";
        ticket += "A nombre de: " + getNombre() + "\n";
        
        return ticket;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumPersonas() {
        return numPersonas;
    }
    
    
}
