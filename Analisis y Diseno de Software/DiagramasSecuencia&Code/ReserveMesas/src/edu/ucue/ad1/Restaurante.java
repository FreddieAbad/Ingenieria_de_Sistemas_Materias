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
public class Restaurante {
    
    private String nombre;
    private String direccion;    
    private CadenaRestaurantes cadena;
    private List<Ubicacion> ubicaciones;

    public Restaurante(String nombre, String direccion, CadenaRestaurantes cadena) 
    {
        if (nombre == null || nombre.trim().length() == 0)
            throw new IllegalArgumentException("El parámetro 'nombre' no puede contener un valor nulo");
        
        if (direccion == null || direccion.trim().length() == 0)
            throw new IllegalArgumentException("El parámetro 'direccion' no puede contener un valor nulo");

        if (cadena == null)
            throw new IllegalArgumentException("El parámetro 'cadena de restaurantes' no puede contener un valor nulo");
        
        this.nombre = nombre;
        this.direccion = direccion;
        this.cadena = cadena;
        ubicaciones = new ArrayList<>();
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CadenaRestaurantes getCadena() {
        return cadena;
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    List<Mesa> listarMesasLibres(String fecha, String hora) {
        
        List<Mesa> mesasLibres = new ArrayList<>();
        
        for (Ubicacion ubicacion : ubicaciones) {
            
            for (Mesa mesa : ubicacion.getMesas()) {
                    agregarMesaLibre(mesasLibres, mesa);         ///para cada una de las ubicaciones obtenga las mesas
            }
            
        }
        
        return mesasLibres;
    }

    private void agregarMesaLibre(List<Mesa> mesasLibres, Mesa mesa)
    {
        if (mesa.getEstado().equals(EstadoMesa.LIBRE))
            mesasLibres.add(mesa);                                      ///agregar mesa libre dado un estado libre
    }
}
