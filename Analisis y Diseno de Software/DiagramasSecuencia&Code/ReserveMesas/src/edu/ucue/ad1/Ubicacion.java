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
public class Ubicacion {
    private String nombre;
    private Restaurante restaurante;
    private List<Mesa> mesas;

    public Ubicacion(String nombre, Restaurante restaurante) {
        
        if (nombre == null || nombre.trim().length() == 0)
            throw new IllegalArgumentException("El parámetro 'nombre' no puede contener un valor nulo");
        
        if (restaurante == null)
            throw new IllegalArgumentException("El parámetro 'restaurante' no puede contener un valor nulo");
        
        this.nombre = nombre;
        this.restaurante = restaurante;
        this.mesas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }
    
    
}
