/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.entity;

public class Consultas {

    private String columnas;
    private String tablas;
    private String complemento;
    private int joinInt;

    /*
    columnas refiere a los listados
    tablas son las tablas de las consultas a realizar
    complemento es join, where, etc
    joinInt es de los tipos de listado de Select
        1
        2
        3 Inner Join final
     */
    public Consultas() {
    }

    public Consultas(String columnas, String tablas, String complemento, int joinInt) {
        this.columnas = columnas;
        this.tablas = tablas;
        this.complemento = complemento;
        this.joinInt = joinInt;
    }

    public String getColumnas() {
        return columnas;
    }

    public void setColumnas(String columnas) {
        this.columnas = columnas;
    }

    public String getTablas() {
        return tablas;
    }

    public void setTablas(String tablas) {
        this.tablas = tablas;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getJoinInt() {
        return joinInt;
    }

    public void setJoinInt(int joinInt) {
        this.joinInt = joinInt;
    }

    @Override
    public String toString() {
        return "Consultas{" + "columnas=" + columnas + ", tablas=" + tablas + ", complemento=" + complemento + ", joinInt=" + joinInt + '}';
    }

}
