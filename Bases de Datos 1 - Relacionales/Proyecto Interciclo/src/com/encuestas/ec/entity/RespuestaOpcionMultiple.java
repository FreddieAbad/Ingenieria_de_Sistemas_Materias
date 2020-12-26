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
public class RespuestaOpcionMultiple {

    private int IDRESPUESTAOPCIONMULTIPLE;
    private int IDPREGUNTA;
    private int IDENCUESTA;
    private int IDOPCION;
    private String IDUSUARIO;

    public RespuestaOpcionMultiple() {
    }

    public RespuestaOpcionMultiple(int IDRESPUESTAOPCIONMULTIPLE, int IDPREGUNTA, int IDENCUESTA, int IDOPCION, String IDUSUARIO) {
        this.IDRESPUESTAOPCIONMULTIPLE = IDRESPUESTAOPCIONMULTIPLE;
        this.IDPREGUNTA = IDPREGUNTA;
        this.IDENCUESTA = IDENCUESTA;
        this.IDOPCION = IDOPCION;
        this.IDUSUARIO = IDUSUARIO;
    }

    public int getIDRESPUESTAOPCIONMULTIPLE() {
        return IDRESPUESTAOPCIONMULTIPLE;
    }

    public void setIDRESPUESTAOPCIONMULTIPLE(int IDRESPUESTAOPCIONMULTIPLE) {
        this.IDRESPUESTAOPCIONMULTIPLE = IDRESPUESTAOPCIONMULTIPLE;
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

    public int getIDOPCION() {
        return IDOPCION;
    }

    public void setIDOPCION(int IDOPCION) {
        this.IDOPCION = IDOPCION;
    }

    public String getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(String IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    @Override
    public String toString() {
        return "RespuestaOpcionMultiple{" + "IDRESPUESTAOPCIONMULTIPLE=" + IDRESPUESTAOPCIONMULTIPLE + ", IDPREGUNTA=" + IDPREGUNTA + ", IDENCUESTA=" + IDENCUESTA + ", IDOPCION=" + IDOPCION + ", IDUSUARIO=" + IDUSUARIO + '}';
    }

}
