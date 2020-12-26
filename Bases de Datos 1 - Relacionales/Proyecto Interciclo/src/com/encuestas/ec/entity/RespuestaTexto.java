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
public class RespuestaTexto {

    private int IDRESPUESTATEXTO;
    private int IDPREGUNTA;
    private int IDENCUESTA;
    private String RESPUESTA;
    private String IDUSUARIO;

    public RespuestaTexto() {
    }

    public RespuestaTexto(int IDRESPUESTATEXTO, int IDPREGUNTA, int IDENCUESTA, String RESPUESTA, String IDUSUARIO) {
        this.IDRESPUESTATEXTO = IDRESPUESTATEXTO;
        this.IDPREGUNTA = IDPREGUNTA;
        this.IDENCUESTA = IDENCUESTA;
        this.RESPUESTA = RESPUESTA;
        this.IDUSUARIO = IDUSUARIO;
    }

    public int getIDRESPUESTATEXTO() {
        return IDRESPUESTATEXTO;
    }

    public void setIDRESPUESTATEXTO(int IDRESPUESTATEXTO) {
        this.IDRESPUESTATEXTO = IDRESPUESTATEXTO;
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

    public String getRESPUESTA() {
        return RESPUESTA;
    }

    public void setRESPUESTA(String RESPUESTA) {
        this.RESPUESTA = RESPUESTA;
    }

    public String getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(String IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    @Override
    public String toString() {
        return "RespuestaTexto{" + "IDRESPUESTATEXTO=" + IDRESPUESTATEXTO + ", IDPREGUNTA=" + IDPREGUNTA + ", IDENCUESTA=" + IDENCUESTA + ", RESPUESTA=" + RESPUESTA + ", IDUSUARIO=" + IDUSUARIO + '}';
    }

}
