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
public class CadenaRestaurantes {
    
    private int id;
    private String nombre;
    
    private List<TerminalPuntoReserva> terminales;
    private List<Restaurante> restaurantes;

    public CadenaRestaurantes(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        terminales = new ArrayList<>();
        restaurantes = new ArrayList<>();
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

    public List<TerminalPuntoReserva> getTerminales() {
        return terminales;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }
    
    public void addRestaurante(String nombre, String direccion)
    {
        Restaurante restaurante = new Restaurante(nombre, direccion, this);
        restaurantes.add(restaurante);
    }

    void addTerminal(TerminalPuntoReserva tpr) {
        terminales.add(tpr);
    }

    
    
}
