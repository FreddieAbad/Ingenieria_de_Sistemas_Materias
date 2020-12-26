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
public class Respuesta {
    private int idRespuesta;
    private int idPregunta;
    private String respuesta;

    public Respuesta() {
    }

    public Respuesta(int idRespuesta, int idPregunta, String respuesta) {
        this.idRespuesta = idRespuesta;
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Respuesta{" + "idRespuesta=" + idRespuesta + ", idPregunta=" + idPregunta + ", respuesta=" + respuesta + '}';
    }
    
}
