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
public class Pregunta {

    private int IDPREGUNTA;
    private int IDENCUESTA;
    private int IDTIPORESPUESTA;
    private String PREGUNTA;

    public Pregunta() {
    }

    public Pregunta(int IDPREGUNTA, int IDENCUESTA, int IDTIPORESPUESTA, String PREGUNTA) {
        this.IDPREGUNTA = IDPREGUNTA;
        this.IDENCUESTA = IDENCUESTA;
        this.IDTIPORESPUESTA = IDTIPORESPUESTA;
        this.PREGUNTA = PREGUNTA;
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

    public int getIDTIPORESPUESTA() {
        return IDTIPORESPUESTA;
    }

    public void setIDTIPORESPUESTA(int IDTIPORESPUESTA) {
        this.IDTIPORESPUESTA = IDTIPORESPUESTA;
    }

    public String getPREGUNTA() {
        return PREGUNTA;
    }

    public void setPREGUNTA(String PREGUNTA) {
        this.PREGUNTA = PREGUNTA;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "IDPREGUNTA=" + IDPREGUNTA + ", IDENCUESTA=" + IDENCUESTA + ", IDTIPORESPUESTA=" + IDTIPORESPUESTA + ", PREGUNTA=" + PREGUNTA + '}';
    }

}
