/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.ad1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lainiguez
 */
public class TerminalPuntoReserva {
    
    private int id;
    private String nombre;
    
    private List<CadenaRestaurantes> cadenas;

    public TerminalPuntoReserva(int id, String nombre ) {
        this.id = id;
        this.nombre = nombre;
        this.cadenas = cadenas = new ArrayList<>();
    }
    
    
    
    public List<Restaurante> iniciarReserva(CadenaRestaurantes cadena)
    {
        if (cadena == null)
            throw new IllegalArgumentException("El parámetro 'cadena' no puede contener un valor nulo");
                    
        List<Restaurante> restaurantes = cadena.getRestaurantes();
        
        return restaurantes;
    }
    
    
    public List<Mesa> listarMesas(Restaurante restaurante, String fecha, String hora)
    {
        if (restaurante == null)
            throw new IllegalArgumentException("El parámetro 'restaurante' no puede contener un valor nulo");
        
        if (fecha == null || fecha.trim().length() != 10)
            throw new IllegalArgumentException("El parámetro 'fecha' no puede contener un valor nulo o no representar una fecha");
        
        if (hora == null || hora.trim().length() != 5)
            throw new IllegalArgumentException("El parámetro 'hora' no puede contener un valor nulo o no representar una hora");
        
        List<Mesa> mesasLibres = restaurante.listarMesasLibres(fecha, hora);
        
        return mesasLibres;
    }
    
    
    
    public String reservar(Mesa mesa, int numPersonas, String fecha, String hora, String nombre)
    {
        Reserva reserva = new Reserva(fecha, hora, numPersonas, nombre, mesa);
        guardarReserva(reserva);
        
        return reserva.imprimir();
    }

    
    public void comprobarDisponibilidadMesa()
    {
        
    }
    
    public void solicitarSugerencias()
    {
        
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cadenas
     */
    public List<CadenaRestaurantes> getCadenas() {
        return cadenas;
    }


    private void guardarReserva(Reserva reserva) {
        System.out.println("Reserva guardada");
    }
}
