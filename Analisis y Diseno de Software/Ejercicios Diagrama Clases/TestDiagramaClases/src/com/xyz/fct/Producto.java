/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyz.fct;

/**
 *
 * @author lainiguez
 */
public class Producto {
    
    private String codigo;
    private String descripcion;
    private double precio;
    private boolean grabaIVA;

    public Producto(String codigo, String descripcion, double precio, boolean grabaIVA) {
        
        /*
        Proteger el estado inicial del objeto
        */
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.grabaIVA = grabaIVA;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the grabaIVA
     */
    public boolean isGrabaIVA() {
        return grabaIVA;
    }

    /**
     * @param grabaIVA the grabaIVA to set
     */
    public void setGrabaIVA(boolean grabaIVA) {
        this.grabaIVA = grabaIVA;
    }
    
    
    
}
