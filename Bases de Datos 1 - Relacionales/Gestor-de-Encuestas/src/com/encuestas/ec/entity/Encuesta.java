/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.entity;

/**
 *
 * @author Freddie
 */
public class Encuesta {
    private int idEncuesta;
    private String nombre;
    private String descripcion;
    private int tipoEncuesta;

    public Encuesta() {
    }

    public Encuesta(int idEncuesta, String nombre, String descripcion, int tipoEncuesta) {
        this.idEncuesta = idEncuesta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoEncuesta = tipoEncuesta;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipoEncuesta() {
        return tipoEncuesta;
    }

    public void setTipoEncuesta(int tipoEncuesta) {
        this.tipoEncuesta = tipoEncuesta;
    }

    @Override
    public String toString() {
        return "Encuesta{" + "idEncuesta=" + idEncuesta + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipoEncuesta=" + tipoEncuesta + '}';
    }
    
}
