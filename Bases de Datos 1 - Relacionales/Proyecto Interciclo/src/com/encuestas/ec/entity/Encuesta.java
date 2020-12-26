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

    private int IDENCUESTA;
    private String NOMBRE;
    private String DESCRIPCION;
    private int IDTIPOENCUESTA;

    public Encuesta() {
    }

    public Encuesta(int IDENCUESTA, String NOMBRE, String DESCRIPCION, int IDTIPOENCUESTA) {
        this.IDENCUESTA = IDENCUESTA;
        this.NOMBRE = NOMBRE;
        this.DESCRIPCION = DESCRIPCION;
        this.IDTIPOENCUESTA = IDTIPOENCUESTA;
    }

    public int getIDENCUESTA() {
        return IDENCUESTA;
    }

    public void setIDENCUESTA(int IDENCUESTA) {
        this.IDENCUESTA = IDENCUESTA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public int getIDTIPOENCUESTA() {
        return IDTIPOENCUESTA;
    }

    public void setIDTIPOENCUESTA(int IDTIPOENCUESTA) {
        this.IDTIPOENCUESTA = IDTIPOENCUESTA;
    }

    @Override
    public String toString() {
        return "Encuesta{" + "IDENCUESTA=" + IDENCUESTA + ", NOMBRE=" + NOMBRE + ", DESCRIPCION=" + DESCRIPCION + ", IDTIPOENCUESTA=" + IDTIPOENCUESTA + '}';
    }

}
