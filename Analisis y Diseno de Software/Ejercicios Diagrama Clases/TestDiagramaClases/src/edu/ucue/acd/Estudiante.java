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
public class Estudiante {
    
    private String cedula;
    private String nombres;
    private String apellidos;
    private int edad;
    
    private List<Asignatura> asignaturas;

    public Estudiante(String cedula, String nombres, String apellidos, int edad) {
        
        if (cedula == null || !isCedulaValida(cedula))
            throw new IllegalArgumentException("El parámetro cedula es inválido");
        
        if (nombres == null)
            throw new IllegalArgumentException("El parámetro nombres no puede contener un valor nulo");

        if (apellidos == null)
            throw new IllegalArgumentException("El parámetro apellidos no puede contener un valor nulo");
        
        if (edad < 17)
            throw new IllegalArgumentException("El parámetro edad no puede contener un valor menor a 17");
        
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        
        this.asignaturas = new ArrayList<>();
    }
    
    public void agregar(Asignatura asignatura)
    {
        this.asignaturas.add(asignatura);
    }
    
    public void remover(Asignatura asignatura)
    {
        this.asignaturas.remove(asignatura);
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    
    

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
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

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    private boolean isCedulaValida(String cedula) {
        if (cedula.trim().length() != 10)
            return false;
        
        //programar el algoritmo de validación de la cédula
        return true;
    }
            
    
}
