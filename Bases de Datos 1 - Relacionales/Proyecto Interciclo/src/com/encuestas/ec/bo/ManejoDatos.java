/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.bo;

import com.encuestas.ec.dao.OperationData;
//import Clases.Categoria;
import com.encuestas.ec.entity.Consultas;
import com.encuestas.ec.entity.ConsultasGenericas;
import com.encuestas.ec.entity.Encuesta;
import com.encuestas.ec.entity.Opciones;
import com.encuestas.ec.entity.Pregunta;
import com.encuestas.ec.entity.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author danny
 */
public class ManejoDatos {

    private static ManejoDatos MimanejoDeDatos;

    public static ManejoDatos GestionarDatos() {
        if (MimanejoDeDatos == null) {
            MimanejoDeDatos = new ManejoDatos();
        }
        return MimanejoDeDatos;
    }

    public Object obtenerRegistros(String nombreTabla, ArrayList<String> atributos, ArrayList<String> condiciones, ArrayList<String> Funciones, ArrayList<String> orderBy) throws SQLException, Exception {
        ConsultasGenericas o = new ConsultasGenericas(nombreTabla);
        if (atributos != null) {
            o.setAtributos(atributos);
        }
        if (condiciones != null) {
            o.setCondiciones(condiciones);
        }
        if (Funciones != null) {
            o.setFunciones(Funciones);
        }
        if (orderBy != null) {
            o.setOrderBy(orderBy);
        }
        System.err.println("" + o.toString());
        return OperationData.ObtenerDatos().realizarConsulta(o);
    }

    public void insertarRegistro(String[] args) throws SQLException, Exception {
        String tabla = (String) args[0];
        switch (tabla) {
            case "Usuario":
                Usuario categoria = new Usuario((String) args[1], (String) args[2], (String) args[3], (String) args[4], (String) args[5], (String) args[6], (String) args[7], (String) args[8]);
                OperationData.ObtenerDatos().insertarRegistro(categoria);
                break;
            case "Encuesta":
                Encuesta encuesta = new Encuesta(Integer.parseInt((String) args[1]), (String) args[2], (String) args[3], Integer.parseInt((String) args[4]));
                OperationData.ObtenerDatos().insertarRegistro(encuesta);
                break;
            case "Pregunta":
                Pregunta pregunta = new Pregunta(Integer.parseInt((String) args[1]), Integer.parseInt((String) args[2]), Integer.parseInt((String) args[3]), (String) args[4]);
                OperationData.ObtenerDatos().insertarRegistro(pregunta);
                break;
            case "Opciones":
                Opciones opciones = new Opciones(Integer.parseInt((String) args[1]), Integer.parseInt((String) args[2]), Integer.parseInt((String) args[3]), Integer.parseInt((String) args[4]), (String) args[5]);
                OperationData.ObtenerDatos().insertarRegistro(opciones);
                break;
            default:
                break;
        }
    }

    public void modificarRegistro(String[] args) throws SQLException, Exception {
        String tabla = (String) args[0];
        Object registroAnterior = args[1];
    }

    public void obtener(String nombreTabla, ArrayList<String> atributos, ArrayList<String> condiciones) throws SQLException, Exception {
        ConsultasGenericas o = new ConsultasGenericas(nombreTabla);
        if (atributos != null) {
            o.setAtributos(atributos);
        }
        if (condiciones != null) {
            o.setCondiciones(condiciones);
        }
        OperationData.ObtenerDatos().eliminarRegistro(o);
    }

    public void eliminarRegistro(Object[] args) throws SQLException, Exception {
        ArrayList<ArrayList<Object>> contenedor = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> nombreArrayList = new ArrayList<Object>();
        ArrayList<Object> atributos = new ArrayList<Object>();
        ArrayList<Object> valor = new ArrayList<Object>();
        contenedor.add(nombreArrayList);
        contenedor.add(atributos);
        contenedor.add(valor);
        ManejoDatos.GestionarDatos().eliminarRegistro(args);
    }

    public String getAtributoPrimario(String nombreTabla) throws SQLException, Exception {
        return OperationData.ObtenerDatos().getCampoPrimario(nombreTabla);

    }

    public ArrayList<String> getAtributosTabla(String arg) throws SQLException, Exception {
        ArrayList<String> nombres = new ArrayList();
        ArrayList<ArrayList<String>> resultado = (ArrayList<ArrayList<String>>) OperationData.ObtenerDatos().getAtributosTablas(arg);
        for (int i = 1; i < resultado.size(); i++) {
            nombres.add(resultado.get(i).get(0));
        }
        return nombres;
    }

    public ArrayList<String> getNombresTablas() throws SQLException, Exception {
        ArrayList<String> nombres = new ArrayList();
        ArrayList<ArrayList<String>> resultado = (ArrayList<ArrayList<String>>) OperationData.ObtenerDatos().getNombreTablas();
        for (int i = 1; i < resultado.size(); i++) {
            nombres.add(resultado.get(i).get(0));
        }
        System.out.println("" + resultado.toString());
        return nombres;
    }
}
