/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.test;

import com.encuestas.ec.bo.EncuestaBo;
import com.encuestas.ec.bo.PreguntaBo;
import com.encuestas.ec.bo.RespuestaBo;
import com.encuestas.ec.bo.UsuarioBo;
import com.encuestas.ec.entity.Encuesta;
import com.encuestas.ec.entity.Pregunta;
import com.encuestas.ec.entity.Respuesta;
import com.encuestas.ec.entity.Usuario;

/**
 *
 * @author Freddie
 */
public class Test {

    EncuestaBo ebo = new EncuestaBo();
    Encuesta encuesta = new Encuesta();

    PreguntaBo pbo = new PreguntaBo();
    Pregunta pregunta = new Pregunta();

    RespuestaBo rbo = new RespuestaBo();
    Respuesta respuesta = new Respuesta();

    UsuarioBo ubo = new UsuarioBo();
    Usuario usuario = new Usuario();

    String mensaje = "";

    public void insertarEncuesta() {
        encuesta.setNombre("Encuesta 1");
        encuesta.setDescripcion("Cualquier cosa");
        encuesta.setIdEncuesta(1);
        encuesta.setTipoEncuesta(1);
        mensaje = ebo.agregarEncuesta(encuesta);
        System.out.println(mensaje);
    }

    public void insertarPregunta() {
        pregunta.setPregunta("Pregunta 3");
        pregunta.setTipoRespuesta(3);
        pregunta.setIdPregunta(3);
        pregunta.setIdEncuesta(2);
        mensaje = pbo.agregarPregunta(pregunta);
        System.out.println(mensaje);
    }

    public void insertarRespuesta() {
        respuesta.setRespuesta("Respuesta 3");
        respuesta.setIdRespuesta(3);
        respuesta.setIdPregunta(2);
        mensaje = rbo.agregarRespuesta(respuesta);
        System.out.println(mensaje);
    }

    public void insertarUsuario() {
        usuario.setCedula("0304496766");
        usuario.setContrasena("contrasena");
        usuario.setDireccion("Catolica");
        usuario.setEmail("sdfasdf@asdfasd.com");
        usuario.setEstadoCivil("S");
        usuario.setGenero('M');
        usuario.setNombres("Fredd Abad");
        usuario.setTelefono("072340585");
        mensaje = ubo.agregarUsuario(usuario);
        System.out.println(mensaje);
    }

    public void modificarEncuesta() {
        encuesta.setIdEncuesta(1);
        encuesta.setNombre("Encuesta modificada");
        encuesta.setDescripcion("Cualquier cosa modificada");
        encuesta.setTipoEncuesta(2);
        mensaje = ebo.modificarEncuesta(encuesta);
        System.out.println(mensaje);
    }

    public void modificarPregunta() {
        pregunta.setPregunta("Pregunta 1 modificada");
        pregunta.setTipoRespuesta(1);
        pregunta.setIdPregunta(1);
        pregunta.setIdEncuesta(2);
        mensaje = pbo.modificarPregunta(pregunta);
        System.out.println(mensaje);
    }
    
    public void modificarUsuario() {
        usuario.setCedula("0304496766");
        usuario.setContrasena("contrasena");
        usuario.setDireccion("Catolica");
        usuario.setEmail("sdfasdf@asdfasd.com");
        usuario.setEstadoCivil("S");
        usuario.setGenero('M');
        usuario.setNombres("Freddieee Abad");
        usuario.setTelefono("072340585");
        
        mensaje=ubo.modificarUsuario(usuario);
        System.out.println(mensaje);
    }

    public void modificarRespuesta() {
        respuesta.setRespuesta("Respuesta 1 modificada");
        respuesta.setIdRespuesta(1);
        respuesta.setIdPregunta(2);
        mensaje = rbo.modificarRespuesta(respuesta);
        System.out.println(mensaje);
    }

    public void eliminarEncuesta() {
        mensaje = ebo.eliminarEncuesta(1);
        System.out.println(mensaje);
    }

    public void eliminarPregunta() {
        mensaje = pbo.eliminarPregunta(1);
        System.out.println(mensaje);
    }

    public void eliminarRespuesta() {
        mensaje = rbo.eliminarRespuesta(1);
        System.out.println(mensaje);
    }
    
    public void eliminarUsuario(){
        mensaje=ubo.eliminarUsuario("0104496765");
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Test test = new Test();
        //test.insertarEncuesta();
        //test.modificarEncuesta();
        //test.eliminarEncuesta();

        //test.insertarPregunta();
        //test.modificarPregunta();
        //test.eliminarPregunta();
        //test.insertarRespuesta();
        //test.modificarRespuesta();
        //test.eliminarRespuesta();
        
        //test.insertarUsuario();
        //test.modificarUsuario();
        test.eliminarUsuario();
    }
}
