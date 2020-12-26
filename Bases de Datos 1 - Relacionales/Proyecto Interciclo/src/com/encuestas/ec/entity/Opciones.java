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
public class Opciones {

    int IDOPCION;
    int IDPREGUNTA;
    int IDENCUESTA;
    int IDSELECCION;
    String NOMBREOPCION;

    public Opciones() {
    }

    public Opciones(int IDOPCION, int IDPREGUNTA, int IDENCUESTA, int IDSELECCION, String NOMBREOPCION) {
        this.IDOPCION = IDOPCION;
        this.IDPREGUNTA = IDPREGUNTA;
        this.IDENCUESTA = IDENCUESTA;
        this.IDSELECCION = IDSELECCION;
        this.NOMBREOPCION = NOMBREOPCION;
    }

    public int getIDOPCION() {
        return IDOPCION;
    }

    public void setIDOPCION(int IDOPCION) {
        this.IDOPCION = IDOPCION;
    }

    public int getIDPREGUNTA() {
        return IDPREGUNTA;
    }

    public void setIDPREGUNTA(int IDPREGUNTA) {
        this.IDPREGUNTA = IDPREGUNTA;
    }

    public int getIDENCUESTA() {
        return IDENCUESTA;
    }

    public void setIDENCUESTA(int IDENCUESTA) {
        this.IDENCUESTA = IDENCUESTA;
    }

    public int getIDSELECCION() {
        return IDSELECCION;
    }

    public void setIDSELECCION(int IDSELECCION) {
        this.IDSELECCION = IDSELECCION;
    }

    public String getNOMBREOPCION() {
        return NOMBREOPCION;
    }

    public void setNOMBREOPCION(String NOMBREOPCION) {
        this.NOMBREOPCION = NOMBREOPCION;
    }

    @Override
    public String toString() {
        return "Opciones{" + "IDOPCION=" + IDOPCION + ", IDPREGUNTA=" + IDPREGUNTA + ", IDENCUESTA=" + IDENCUESTA + ", IDSELECCION=" + IDSELECCION + ", NOMBREOPCION=" + NOMBREOPCION + '}';
    }

}
