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
public class Asignatura {
 
    private String id;
    private String nombre;
    private List<Estudiante> estudiantes;

    public Asignatura(String id, String nombre) {
        
        if (id == null)
            throw new IllegalArgumentException("El parámetro id no puede contener un valor nulo");
        
        if (nombre == null)
            throw new IllegalArgumentException("El parámetro nombre no puede contener un valor nulo");
        
        
        this.id = id;
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }
    
    public void agregar(Estudiante estudiante)
    {
        this.estudiantes.add(estudiante);
        estudiante.agregar(this);
    }
    
    public void remover(Estudiante estudiante)
    {
        this.estudiantes.remove(estudiante);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
