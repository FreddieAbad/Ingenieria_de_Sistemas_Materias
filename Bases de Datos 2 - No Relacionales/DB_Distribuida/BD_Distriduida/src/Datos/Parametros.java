/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Edisson
 */
public class Parametros {
    String usuarioBD = "root";
    String passw = "";
    String Puerto="3306";
    String nombreBD="bd_distribuida";
    String URL="jdbc:mysql://localhost:"+Puerto+"/"+nombreBD+"?autoReconnect=true&useSSL=false";
}
