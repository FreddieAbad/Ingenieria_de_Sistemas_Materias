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
    private int idPregunta;
    private int idEncuesta;
    private int idTipoRespuesta;
    private String pregunta;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, int idEncuesta, int tipoRespuesta, String pregunta) {
        this.idPregunta = idPregunta;
        this.idEncuesta = idEncuesta;
        this.idTipoRespuesta = tipoRespuesta;
        this.pregunta = pregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public int getTipoRespuesta() {
        return idTipoRespuesta;
    }

    public void setTipoRespuesta(int tipoRespuesta) {
        this.idTipoRespuesta = tipoRespuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "idPregunta=" + idPregunta + ", idEncuesta=" + idEncuesta + ", tipoRespuesta=" + idTipoRespuesta + ", pregunta=" + pregunta + '}';
    }
    
}
