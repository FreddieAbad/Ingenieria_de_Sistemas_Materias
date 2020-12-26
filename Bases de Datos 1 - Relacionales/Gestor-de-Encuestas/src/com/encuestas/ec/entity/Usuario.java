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
public class Usuario {

    private String nombres;
    private String cedula;
    private String direccion;
    private String telefono;
    private String email;
    private String contrasena;
    private char genero;
    private String estadoCivil;

    public Usuario() {
    }

    public Usuario(String nombres, String cedula, String direccion, String telefono, String email, String usuario, String contrasena, char genero, String estadoCivil) {
        this.nombres = nombres;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contrasena = contrasena;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Usuario{" + " nombres=" + nombres + ", cedula=" + cedula + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", contrasena=" + contrasena + ", genero=" + genero + ", estadoCivil=" + estadoCivil + '}';
    }

}
