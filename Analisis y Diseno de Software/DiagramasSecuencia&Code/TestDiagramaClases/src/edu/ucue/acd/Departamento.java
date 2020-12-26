/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.acd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lainiguez
 */
public class Departamento {
    
    private int id;
    private String nombre;
    
    private List<Profesor> profesores;
    
    private Secretaria secretaria;

    public Departamento(int id, String nombre) {
        
        if (nombre == null)
            throw new IllegalArgumentException(
                    "El atributo nombre de departamento no puede contener un valor nulo");
 
            
        this.id = id;
        this.nombre = nombre;
        profesores = new ArrayList<>();
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
    protected List<Profesor> getProfesores() {
        return profesores;
    }
    
    public void agregarProfesor(Profesor p)
    {
        profesores.add(p);
    }
    
    public void eliminarProfesor(Profesor p){
        profesores.remove(p);
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    
}
