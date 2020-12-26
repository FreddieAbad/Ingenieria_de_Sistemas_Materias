/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.acd;

/**
 *
 * @author lainiguez
 */
public class Profesor {
    
    private int id;
    private String nombres;
    private String apellidos;
    private String profesion;
    
    private Departamento departamento;

    public Profesor(int id, String nombres, String apellidos, Departamento departamento) {
        
        if (id <100)
            throw new IllegalArgumentException(
                        "El atributo id debe tener un valor mayor o igual a 100");

        if (nombres == null)
            throw new IllegalArgumentException(
                        "El atributo nombres no puede contener un valor nulo");

        if (apellidos == null)
            throw new IllegalArgumentException(
                        "El atributo apellidos no puede contener un valor nulo");

        if (departamento == null)
            throw new IllegalArgumentException(
                        "El atributo departamento no puede contener un valor nulo");
        
        
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.departamento = departamento;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
}
