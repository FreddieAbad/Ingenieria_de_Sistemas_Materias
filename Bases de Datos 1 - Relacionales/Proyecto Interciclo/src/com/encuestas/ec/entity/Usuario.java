/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.entity;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 *
 * @author Freddie
 */
public class Usuario {

    private String CEDULA;
    private String NOMBRES;
    private String DIRECCION;
    private String CORREO;
    private String TELEFONO;
    private String CONTRASENA;
    private String GENERO;
    private String ESTADOCIVIL;

    public Usuario() {
    }

    public Usuario(String CEDULA, String NOMBRES, String DIRECCION, String CORREO, String TELEFONO, String CONTRASENA, String GENERO, String ESTADOCIVIL) {
        this.CEDULA = CEDULA;
        this.NOMBRES = NOMBRES;
        this.DIRECCION = DIRECCION;
        this.CORREO = CORREO;
        this.TELEFONO = TELEFONO;
        this.CONTRASENA = CONTRASENA;
        this.GENERO = GENERO;
        this.ESTADOCIVIL = ESTADOCIVIL;
    }

    public String getCEDULA() {
        return CEDULA;
    }

    public void setCEDULA(String CEDULA) {
        this.CEDULA = CEDULA;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getCONTRASENA() {
        return CONTRASENA;
    }

    public void setCONTRASENA(String CONTRASENA) {
        this.CONTRASENA = CONTRASENA;
    }

    public String getGENERO() {
        return GENERO;
    }

    public void setGENERO(String GENERO) {
        this.GENERO = GENERO;
    }

    public String getESTADOCIVIL() {
        return ESTADOCIVIL;
    }

    public void setESTADOCIVIL(String ESTADOCIVIL) {
        this.ESTADOCIVIL = ESTADOCIVIL;
    }

    @Override
    public String toString() {
        return "Usuario{" + "CEDULA=" + CEDULA + ", NOMBRES=" + NOMBRES + ", DIRECCION=" + DIRECCION + ", CORREO=" + CORREO + ", TELEFONO=" + TELEFONO + ", CONTRASENA=" + CONTRASENA + ", GENERO=" + GENERO + ", ESTADOCIVIL=" + ESTADOCIVIL + '}';
    }

    /*
    public static void main(String[] args) {
        Object obj = new Usuario();
        Class c = obj.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        System.out.println(nombreClase.getClass());
        String sentencia = "(";

        try {
            Usuario claseTratar = new Usuario();
            Class classTreat = claseTratar.getClass();
            // Retorna atributos de la clase
            Field[] fields = classTreat.getDeclaredFields();
            
            System.out.println("..." + Arrays.toString(fields));
            System.out.println();
            String atributo,tipoAtributo;
            LinkedList<String> tipoValores = new LinkedList<String>();
            int posicion;
            for (int i = 0; i < fields.length; i++) {
                posicion = fields[i].toString().split(Pattern.quote(".")).length - 1;
                atributo = fields[i].toString().split(Pattern.quote("."))[posicion];
                
                //obj.tipoValores(fields[i].toString());
                posicion=atributo.getClass().toString().split(Pattern.quote(".")).length;
                tipoAtributo=atributo.getClass().toString().split(Pattern.quote("."))[posicion-1].substring(0,1);
                tipoValores.add(tipoAtributo);
                System.out.println("Atributo = " + atributo +tipoAtributo);
                if (i != fields.length - 1) {
                    sentencia = sentencia + atributo.toUpperCase() + ",";
                } else {
                    sentencia = sentencia + atributo.toUpperCase() + ")";
                }
                //valores.add(atributo);
            }
            //System.out.println(valores);
            System.out.println(tipoValores);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void callGetter(Object obj, String fieldName) {
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            System.out.println("" + pd.getReadMethod().invoke(obj));
        } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     */
}
