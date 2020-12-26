/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.entity;

import java.util.ArrayList;

/**
 *
 * @author Freddie
 */
public class ConsultasGenericas {

    private String nombreTabla;
    private ArrayList<String> atributos;
    private ArrayList<String> condiciones;
    private ArrayList<String> orderBy;
    private ArrayList<String> funciones;

    public ConsultasGenericas(String nombreTabla) {
        this.atributos = new ArrayList();
        this.condiciones = new ArrayList();
        this.funciones = new ArrayList();
        this.orderBy = new ArrayList();
        this.nombreTabla = nombreTabla;
    }

    public ArrayList<String> getFunciones() {
        return funciones;
    }

    public void setFunciones(ArrayList<String> funciones) {
        this.funciones = funciones;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public ArrayList<String> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<String> atributos) {
        this.atributos = atributos;
    }

    public ArrayList<String> getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(ArrayList<String> condiciones) {
        this.condiciones = condiciones;
    }

    public void addCondicion(String condicion) {
        this.condiciones.add(condicion);
    }

    public void addAtributos(String atributo) {
        this.atributos.add(atributo);
    }

    public ArrayList<String> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(ArrayList<String> orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        return "Consulta{" + "nombreTabla=" + nombreTabla + ", atributos=" + atributos.toString()
                + ", condiciones=" + condiciones.toString() + ", Funciones =" + funciones.toString() + '}'
                + ", orderBy=" + orderBy.toString() + '}';
    }

}
