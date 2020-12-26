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
 * @author User
 */
public class ConjutoTaxis {
    private int id;
    private String taxi;
    private int telefono;
    private String direccion;
    
    private List<LadyTaxi> empresa;
    private List<Taxi> taxis;

    public ConjutoTaxis(int id, String taxi, int telefono, String direccion) {
        this.id = id;
        this.taxi = taxi;
        this.telefono = telefono;
        this.direccion = direccion;
       
        empresa = new ArrayList<>();
        taxis = new ArrayList<>();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the taxi
     */
    public String getTaxi() {
        return taxi;
    }

    /**
     * @param taxi the taxi to set
     */
    public void setTaxi(String taxi) {
        this.taxi = taxi;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
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

    /**
     * @return the empresa
     */
    public List<LadyTaxi> getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(List<LadyTaxi> empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the taxis
     */
    public List<Taxi> getTaxis() {
        return taxis;
    }

    /**
     * @param taxis the taxis to set
     */
    public void setTaxis(List<Taxi> taxis) {
        this.taxis = taxis;
    }
    
    
}
