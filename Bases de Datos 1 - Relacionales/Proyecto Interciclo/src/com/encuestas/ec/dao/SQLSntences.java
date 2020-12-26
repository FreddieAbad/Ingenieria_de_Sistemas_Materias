/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.dao;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import com.encuestas.ec.entity.ConsultasGenericas;
import com.encuestas.ec.db.Conexion;

/**
 *
 * @author danny
 */
public class SQLSntences {

    public static String insertarRegistro(Object obj) throws Exception {
        String consulta = "INSERT INTO " + "`" + nombreClase(obj) + "`" + " "
                + "(" + getAtributosValores(obj)[0] + ")" + " "
                + "VALUES (" + getAtributosValores(obj)[1] + ");";
        System.out.println(consulta);
        return consulta;
    }

    static String modificarRegistro(Object oA, Object o) throws Exception {
        String condAnterior = oA.toString();
        //String valActual = getCondicion(o, ",");

        // return "UPDATE " + nombreClase(o) + " SET " + valActual + " WHERE " + condAnterior + ";";
        return "";
    }

    public static String eliminarRegistro(ConsultasGenericas o) throws Exception {
        String consulta;
        System.out.println(o.getAtributos().get(0));
        System.out.println(o.getCondiciones().get(0));
        //  String 
        consulta = "DELETE FROM" + " " + o.getNombreTabla() + " "
                + "WHERE" + " " + getCondicion(o, "AND");
        System.out.println("consulta eliminar registro" + consulta);
        return consulta;
    }

    public static String Eliminar(Object NombreClase) {
        //return NombreClase;
        return "";
    }

    private static String getCondicion(ConsultasGenericas o, String separador) throws Exception {

        // try {
        ArrayList<String> atributos = new ArrayList();
        ArrayList<String> valores = new ArrayList();

        atributos = o.getAtributos();
        valores = o.getCondiciones();
        System.out.println("---" + atributos.get(0));
        System.out.println("===" + valores.get(0));
        String condicion = "";

        for (int i = 0; i < atributos.size(); i++) {

            if ((i + 1) != atributos.size()) //condicion=condicion + atributos.get(i) + "='" + valores.get(i) + "' " + separador + " ";
            {
                condicion = condicion + valores.get(i) + "' " + separador + " ";
            } else // condicion=condicion + atributos.get(i) + "='" + valores.get(i) + "'";
            {
                condicion = condicion + valores.get(i);
            }

        }
        System.out.println("entra en eliminar " + condicion);
        return condicion;

//        } catch (IllegalArgumentException | IllegalAccessException ex) {
//            throw new Exception("Error con los atributos del objeto.");
//        }
    }

    private static String nombreClase(Object o) {
        return o.getClass().getSimpleName();
    }

    private static String[] getAtributosValores(Object o) throws Exception {
        String valores = "'";
        String atributos = "`";

        try {
            //Atributos del objeto
            int i = 0;
            for (Field f : o.getClass().getDeclaredFields()) {
                i++;
                f.setAccessible(true);
                if (i != o.getClass().getDeclaredFields().length) {
                    atributos = atributos + f.getName() + "`,`";
                } else {
                    atributos = atributos + f.getName() + "`";
                }
            }
            //Valores del objeto
            i = 0;
            for (Field f : o.getClass().getDeclaredFields()) {
                i++;
                f.setAccessible(true);
                if (i != o.getClass().getDeclaredFields().length) {
                    valores = valores + (String) f.get(o) + "','";
                } else {
                    valores = valores + (String) f.get(o) + "'";
                }
            }

        } catch (IllegalArgumentException | IllegalAccessException ex) {
            throw new Exception("Error con los atributos del objeto.");
        }

        String[] args = {atributos, valores};
        return args;
    }

    static String getObtenerConsulta(ConsultasGenericas o) {
        String consulta;
        consulta = "SELECT ";

        String nombreTabla = o.getNombreTabla();
        ArrayList<String> columnas = o.getAtributos();
        ArrayList<String> condiciones = o.getCondiciones();
        ArrayList<String> funciones = o.getFunciones();
        ArrayList<String> orderBy = o.getOrderBy();

        System.out.println("SQL" + columnas.toString());
        if (columnas != null && !columnas.isEmpty()) {
            for (int i = 0; i < columnas.size(); i++) {
                if (i + 1 != columnas.size()) {
                    consulta = consulta + columnas.get(i) + ",";
                } else {
                    consulta = consulta + columnas.get(i);
                }
            }
        }
        System.err.println("" + funciones.toString());
        if (funciones != null && !funciones.isEmpty()) {
            for (int i = 0; i < funciones.size(); i++) {
                if (i + 1 != funciones.size()) {
                    consulta = consulta + funciones.get(i) + ",";
                } else {
                    consulta = consulta + "" + "COUNT" + "(" + funciones.get(i) + ")";
                }
            }
        }
        if ((columnas == null && columnas.isEmpty()) || (funciones == null && funciones.isEmpty())) {
            consulta = consulta + "*";
        }
        consulta = consulta + " FROM " + nombreTabla;
        if (condiciones != null && !condiciones.isEmpty()) {
            consulta = consulta + " WHERE ";
            for (String condicione : condiciones) {
                consulta = consulta + condicione;
            }
        }

        if (orderBy != null && !orderBy.isEmpty()) {
            consulta = consulta + " ORDER BY " + orderBy.get(0) + " " + orderBy.get(1);
        }

        /*
         primer ensayo para estaprueba de laboratorio
         sin el + ";"
         */
        consulta = consulta;
        System.out.println(consulta);
        return consulta;
    }

    public static String getCampoPrimaria(String nombreTabla) throws SQLException {
        String consulta;
        consulta = "SELECT `COLUMN_NAME` FROM `information_schema`.`COLUMNS` "
                + "WHERE (`TABLE_SCHEMA` = '" + Conexion.obtenerConexion().getNombreBaseDD() + "') AND "
                + "(`TABLE_NAME` = '" + nombreTabla + "') AND (`COLUMN_KEY` = 'PRI')";
        return consulta;
    }

    /*Obtener el nombre de las tablas de la base de datos especificada*/
    public static String getNombreTablas() throws SQLException {
        return "select table_name from user_tables order by table_name";
    }

    /*Obtiene los atriburos de una tabla*/
    public static String getAtributosTabla(String nombreTabla) throws SQLException {
        return "SELECT " + "COLUMN_NAME" + " FROM " + "user_tab_cols "
                + "WHERE " + " TABLE_NAME = '" + nombreTabla + "'";
    }

}
