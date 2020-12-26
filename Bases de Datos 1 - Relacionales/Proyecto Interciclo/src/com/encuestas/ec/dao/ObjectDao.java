/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.dao;

import com.encuestas.ec.entity.Encuesta;
import com.encuestas.ec.entity.Usuario;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import oracle.ucp.jdbc.proxy.CallableStatementProxyFactory;

/**
 *
 * @author Freddie
 */
public class ObjectDao {

    private String mensaje = "";

    public String agregarObjeto(Connection con, Object objeto) throws SQLException {
        LinkedList<String> listaNombreValores = (LinkedList<String>) obtenerNombreValores(objeto);
        String nombreValores = obtenerNombreValoresStr(listaNombreValores);
        String incognita = obtenerIncognita(listaNombreValores.size());
        int totalValores = listaNombreValores.size();

        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        PreparedStatement pst = null;
        String sql = "INSERT INTO " + nombreClase.toUpperCase() + nombreValores + " VALUES" + incognita;
        PropertyDescriptor pd;
        int temporalInt, posicion, contador;
        String temporalStr, atributo;
        try {
            pst = con.prepareStatement(sql);
            for (int i = 0; i < totalValores; i++) {
                pd = new PropertyDescriptor(listaNombreValores.get(i), objeto.getClass());
                posicion = pd.getReadMethod().invoke(objeto).getClass().toString().split(Pattern.quote(".")).length - 1;
                atributo = pd.getReadMethod().invoke(objeto).getClass().toString().split(Pattern.quote("."))[posicion].substring(0, 1);
                contador = i + 1;
                if (atributo.equals("I")) {
                    temporalInt = (int) pd.getReadMethod().invoke(objeto);
                    pst.setInt(contador, temporalInt);
                } else {
                    temporalStr = (String) pd.getReadMethod().invoke(objeto);
                    pst.setString(contador, temporalStr);
                }
            }
            pst.execute();
            pst.close();
            mensaje = "1";
        } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SQLException e) {
            mensaje = "0 " + e.getMessage();
            e.printStackTrace();
        }
        return mensaje;
    }

    public String agregarObjetoE(Connection con,String ceR) throws SQLException {
        String valorEnc = "";
        ResultSet rs1;
        try {
            CallableStatement csta = con.prepareCall("{call conteoEncuestaUsuario(?,?)}");
            csta.setString(1, ceR);
            csta.registerOutParameter(2, java.sql.Types.INTEGER);
            csta.execute();
            valorEnc = String.valueOf(csta.getInt("suscripcion"));
            System.out.println(valorEnc + "^");
            if (valorEnc.equals("0")) {
                System.out.println("CONTRATA UN PLAN");
            } else {
                System.out.println("TIENES ACCESO GRATUITO");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (!valorEnc.equals("1")) {
            mensaje = "1";
        } else {
            mensaje = "0";
        };

        return mensaje;
    }

    public String modificarObjeto(Connection con, Object objeto) {
        LinkedList<String> valoresUpdateL = (LinkedList<String>) obtenerNombreValores(objeto);
        String valoresUpdate = (String) obtenerNombreValoresUpdtStr(valoresUpdateL)[1];
        String valorPK = (String) obtenerNombreValoresUpdtStr(valoresUpdateL)[0];
        int totalValores = valoresUpdateL.size();

        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        PreparedStatement pst = null;
        String sql = "UPDATE " + nombreClase.toUpperCase() + " SET " + valoresUpdate
                + " WHERE " + valorPK; //IDENCUESTA=? ,IDTIPORESPUESTA=?,PREGUNTA=?   valorPK es IDPREGUNTA=? el ultimo set es el PK
        // System.out.println(sql);
        PropertyDescriptor pd;
        int temporalInt, posicion, contador;
        String temporalStr, atributo;
        try {
            pst = con.prepareStatement(sql);
            for (int i = 0; i < totalValores; i++) {
                if (i == totalValores - 1) {
                    pd = new PropertyDescriptor(valoresUpdateL.get(0), objeto.getClass());
                } else {
                    pd = new PropertyDescriptor(valoresUpdateL.get(i + 1), objeto.getClass());
                }
                posicion = pd.getReadMethod().invoke(objeto).getClass().toString().split(Pattern.quote(".")).length - 1;
                atributo = pd.getReadMethod().invoke(objeto).getClass().toString().split(Pattern.quote("."))[posicion].substring(0, 1);
                contador = i + 1;
                if (atributo.equals("I")) {
                    temporalInt = (int) pd.getReadMethod().invoke(objeto);
                    pst.setInt(contador, temporalInt);
                } else {
                    temporalStr = (String) pd.getReadMethod().invoke(objeto);
                    pst.setString(contador, temporalStr);
                }
            }
            pst.execute();
            pst.close();
            mensaje = "1";
        } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | SQLException e) {
            mensaje = "0 " + e.getMessage();
            e.printStackTrace();
        }
        return mensaje;
    }

    public String eliminarObjeto(Connection con, Object objeto, String id, int booleanoTipoDato) {
        LinkedList<String> listaNombreValoresUpdt = (LinkedList<String>) obtenerNombreValores(objeto);
        String valorPK = (String) obtenerNombreValoresUpdtStr(listaNombreValoresUpdt)[0];
        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];

        PreparedStatement pst = null;
        String sql = "DELETE FROM " + nombreClase + " WHERE " + valorPK;
        try {
            pst = con.prepareStatement(sql);
            if (booleanoTipoDato == 0) {
                pst.setInt(1, Integer.parseInt(id));
            } else {
                pst.setString(1, id);
            }
            mensaje = "Eliminado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Eliminado InCorrectamente" + e.getMessage();
        }
        return mensaje;
    }

    public LinkedList<String> obtenerNombreValores(Object objeto) {
        LinkedList<String> valores = new LinkedList<>();
        String atributo, tipoAtributo;
        LinkedList<String> tipoValores = new LinkedList<String>();
        int posicion;
        try {
            Class classTreat = objeto.getClass(); //Class classTreat = claseTratar.getClass();
            Field[] fields = classTreat.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                posicion = fields[i].toString().split(Pattern.quote(".")).length - 1;
                atributo = fields[i].toString().split(Pattern.quote("."))[posicion];
                valores.add(atributo);

                posicion = atributo.getClass().toString().split(Pattern.quote(".")).length;
                tipoAtributo = atributo.getClass().toString().split(Pattern.quote("."))[posicion - 1].substring(0, 1).toUpperCase();
                tipoValores.add(tipoAtributo);
            }
        } catch (SecurityException e) {
            System.out.println(e.toString());
        }
        System.out.println(":) " + valores.toString());
        return valores;
    }

    public String obtenerNombreValoresStr(LinkedList<String> valores) {
        String sentencia = "(";
        for (int i = 0; i < valores.size(); i++) {
            if (i != valores.size() - 1) {
                sentencia = sentencia + valores.get(i).toUpperCase() + ",";
            } else {
                sentencia = sentencia + valores.get(i).toUpperCase() + ")";
            }
        }
        return sentencia;
    }

    public String obtenerIncognita(int longitud) {
        String incognita = "(";
        for (int i = 0; i < longitud + 1; i++) {
            if (i == longitud) {
                incognita = incognita + ")";
            } else {
                incognita = incognita + "?";
                if (i < longitud - 1) {
                    incognita = incognita + ",";
                }
            }
        }
        return incognita;
    }

    public Object[] obtenerNombreValoresUpdtStr(LinkedList<String> valores) {
        String sentencia = "", sentenciaPK = "";
        for (int i = 0; i < valores.size(); i++) {
            if (i == 0) {
                sentenciaPK = sentencia + valores.get(i).toUpperCase() + "=?";
            } else {
                if (i != valores.size() - 1) {
                    sentencia = sentencia + valores.get(i).toUpperCase() + "=? ,";
                } else {
                    sentencia = sentencia + valores.get(i).toUpperCase() + "=?";
                }
            }
        }
        return new Object[]{sentenciaPK, sentencia};
    }

    public int getMaxID(Connection con, Object objeto) {
        LinkedList<String> listaNombreValoresUpdt = (LinkedList<String>) obtenerNombreValores(objeto);
        String valorPK = (String) obtenerNombreValoresUpdtStr(listaNombreValoresUpdt)[0];
        valorPK = valorPK.substring(0, valorPK.length() - 2);
        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(" + valorPK + ")+1 FROM " + nombreClase;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar ID" + e.getMessage());
        }
        return id;
    }

    public int getMaxIDFK(Connection con, Object objeto, String[] whereStat, Object[] whereStat2, int[] typeDataW) {
        LinkedList<String> listaNombreValoresUpdt = (LinkedList<String>) obtenerNombreValores(objeto);
        String valorPK = (String) obtenerNombreValoresUpdtStr(listaNombreValoresUpdt)[0];
        valorPK = valorPK.substring(0, valorPK.length() - 2);
        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String valorWhere = valoresWhereFK(whereStat, whereStat2, typeDataW);
        // System.out.println(">>" + valorWhere);
        String sql = "SELECT MAX(" + valorPK + ") FROM " + nombreClase.toUpperCase() + " WHERE " + valorWhere;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar ID" + e.getMessage());
        }
        return id;
    }

    public int contarObjeto(Connection con, Object objeto, String[] whereStat, Object[] whereStat2, int[] typeDataW) {
        LinkedList<String> listaNombreValoresUpdt = (LinkedList<String>) obtenerNombreValores(objeto);
        String valorPK = (String) obtenerNombreValoresUpdtStr(listaNombreValoresUpdt)[0];
        valorPK = valorPK.substring(0, valorPK.length() - 2);
        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String valorWhere = valoresWhereFK(whereStat, whereStat2, typeDataW);

        String sql = "SELECT COUNT(DISTINCT " + valorPK + ") FROM " + nombreClase.toUpperCase() + " WHERE " + valorWhere;
        //   System.out.println("sqllllll"+sql);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar ID" + e.getMessage());
        }
        return id;
    }

    public String comparacionObjeto(Connection con, String datoComparar, Object objeto, String CEDULA) {
        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        String sql = "SELECT CONTRASENA FROM USUARIO WHERE CEDULA= '" + CEDULA + "'";//IDPREGUNTA";
        System.out.println(sql);
        String respuesta = "";
        Statement st = null;
        ResultSet rs = null;
        String PS = "";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println((rs).toString());
            while (rs.next()) {
                PS = rs.getString("CONTRASENA");
                System.out.println(PS);
            }
            if (PS.equals(datoComparar)) {
                System.out.println("OK");
                respuesta = "1";
            } else {
                System.out.println("NO");
                respuesta = "0";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
        return respuesta;
    }

    public void listarObjeto(Connection con, JTable tabla, Object objeto, String[] columnas, String[] whereStat, Object[] whereStat2, int[] typeDataW) {
        LinkedList<String> listaNombreValoresUpdt = (LinkedList<String>) obtenerNombreValores(objeto);
        String valorPK = (String) obtenerNombreValoresUpdtStr(listaNombreValoresUpdt)[0];
        valorPK = valorPK.substring(0, valorPK.length() - 2);
        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        String valorWhere = valoresWhere(whereStat, whereStat2, typeDataW);
        DefaultTableModel model;
        //String[] columnas = {"IDPREGUNTA", "IDENCUESTA", "IDTIPOENCUESTA", "PREGUNTA"};
        model = new DefaultTableModel(null, columnas);
        String valoresConsult = Arrays.toString(columnas).substring(1);
        valoresConsult = valoresConsult.substring(0, valoresConsult.length() - 1);
        String sql = "SELECT " + valoresConsult + " FROM " + nombreClase.toUpperCase() + " WHERE " + valorWhere + " ORDER BY " + valorPK.toUpperCase();//IDPREGUNTA";
//        System.out.println(sql);
        String[] filas = new String[columnas.length];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < columnas.length; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }

    public void listarObjetoE(Connection con, JTable tabla, Object objeto, String[] columnas) throws SQLException {//, String[] whereStat, Object[] whereStat2, int[] typeDataW
        LinkedList<String> listaNombreValoresUpdt = (LinkedList<String>) obtenerNombreValores(objeto);
        String valorPK = (String) obtenerNombreValoresUpdtStr(listaNombreValoresUpdt)[0];
        valorPK = valorPK.substring(0, valorPK.length() - 2);
        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        String valoresConsult = Arrays.toString(columnas).substring(1);
        valoresConsult = valoresConsult.substring(0, valoresConsult.length() - 1);
        String sql = "SELECT " + valoresConsult + " FROM " + nombreClase.toUpperCase() + " ORDER BY " + valorPK.toUpperCase();//IDPREGUNTA";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        tabla.setModel(DbUtils.resultSetToTableModel(rs));
    }

    public void listarObjetoFK(Connection con, JTable tabla, Object objeto, String[] columnas, String[] whereStat, Object[] whereStat2, int[] typeDataW) {
        LinkedList<String> listaNombreValoresUpdt = (LinkedList<String>) obtenerNombreValores(objeto);
        String valorPK = (String) obtenerNombreValoresUpdtStr(listaNombreValoresUpdt)[0];
        valorPK = valorPK.substring(0, valorPK.length() - 2);
        Class c = objeto.getClass();
        String nombreClase = c.getName().toString().split(Pattern.quote("."))[4];
        Object[] clave = {whereStat2[0]}; // TOMA EL NOMBRE DEL CAMPO FK 
        String[] clave2 = {whereStat[0]}; // TOMA EL VALOR DEL CAMPO FK 
        String valorWhere = valoresWhereFK(clave2, clave, typeDataW);
        DefaultTableModel model;
        model = new DefaultTableModel(null, columnas);
        String valoresConsult = Arrays.toString(columnas).substring(1);
        valoresConsult = valoresConsult.substring(0, valoresConsult.length() - 1);
        String sql = "SELECT " + valoresConsult + " FROM " + nombreClase.toUpperCase() + " WHERE " + valorWhere + " ORDER BY " + whereStat[0].toUpperCase();//IDPREGUNTA";
        String[] filas = new String[columnas.length];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < columnas.length; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }

    public void listarObjetoIJ(Connection con, JTable tabla, Object objeto, String columnas, String tablas, String complemento) {
        String sql = "SELECT " + columnas + " FROM " + tablas + " " + complemento;
        //System.out.println(sql);
        int tamano = columnas.split(",").length;
        DefaultTableModel model;
        model = new DefaultTableModel(null, columnas.split(","));
        String[] filas = new String[tamano];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < tamano; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }

    public void listarObjetoGenerico(Connection con, JTable tabla, Object objeto) {

        LinkedList<String> listaNombreValores = (LinkedList<String>) obtenerNombreValores(objeto);
        System.out.println("ssss : " + listaNombreValores);
        String columnas = listaNombreValores.get(0);
        String tablas = listaNombreValores.get(1);
        String complemento = listaNombreValores.get(2);
        String joinInt = listaNombreValores.get(3);
        int joinValue;
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(listaNombreValores.get(0), objeto.getClass()); // 0 columnas
            columnas = (String) pd.getReadMethod().invoke(objeto);

            pd = new PropertyDescriptor(listaNombreValores.get(1), objeto.getClass()); // 1 tablas
            tablas = (String) pd.getReadMethod().invoke(objeto);
            tablas = "(" + tablas + ")";

            pd = new PropertyDescriptor(listaNombreValores.get(3), objeto.getClass()); // 3 joinValue
            joinValue = (int) pd.getReadMethod().invoke(objeto);

            pd = new PropertyDescriptor(listaNombreValores.get(2), objeto.getClass()); //2 complement
            if (joinValue == 1) {
                complemento = " " + pd.getReadMethod().invoke(objeto); //1 VACIO
            }
            if (joinValue == 3) {
                complemento = " INNER JOIN " + pd.getReadMethod().invoke(objeto); // 2 INNER
            }
            if (joinValue == 2) {
                complemento = " ORDER BY " + pd.getReadMethod().invoke(objeto);// 3 ORDER
            }
        } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        String sql = "SELECT " + columnas + " FROM " + tablas + " " + complemento;
        sql = sql.toUpperCase();
        System.out.println(">>>" + sql);
        int tamano = columnas.split(",").length;
        DefaultTableModel model;
        model = new DefaultTableModel(null, columnas.split(","));
        String[] filas = new String[tamano];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < tamano; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }

    public String valoresWhere(String[] val1, Object[] val2, int[] datatype) {
        String valorFinal = "(";
        //Object[] a = {int,String,int,String};
        for (int i = 0; i < val1.length; i++) {
            if (i == val1.length - 1) {
                if (datatype[i] == 1) {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = " + val2[i].toString() + ")";
                } else {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = '" + val2[i].toString() + "')";
                }
            }
            if (i == 0) {
                if (datatype[i] == 1) {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = " + val2[i].toString() + " AND ";
                } else {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = '" + val2[i].toString() + "' AND ";
                }
            }
            if (i != 0 && i != val1.length - 1) {
                if (datatype[i] == 1) {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = " + val2[i].toString() + " AND ";
                } else {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = '" + val2[i].toString() + "' AND ";
                }
            }
        }
        return valorFinal;
    }

    public String valoresWhereFK(String[] val1, Object[] val2, int[] datatype) {
        String valorFinal = "(";
        //Object[] a = {int,String,int,String};
        for (int i = 0; i < val1.length; i++) {
            if (i != 0 && i != val1.length - 1) {
                if (datatype[i] == 1) {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = " + val2[i].toString() + " AND ";
                } else {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = '" + val2[i].toString() + "' AND ";
                }
            }
            if (i == val1.length - 1) {
                if (datatype[i] == 1) {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = " + val2[i].toString() + ")";
                } else {
                    valorFinal = valorFinal.toString() + val1[i].toString() + " = '" + val2[i].toString() + "')";
                }
            }
        }
        return valorFinal;
    }

    public String confirmarCambiosObjeto(Connection con) {
        String mensaje = "";
        try {
            con.commit();
            mensaje = "1";
        } catch (SQLException e) {
            mensaje = "0 " + e.getMessage();
            e.printStackTrace();
        }
        return mensaje;
    }

    public String deshabilitarCambiosObjeto(Connection con) {
        String mensaje = "";
        try {
            con.setAutoCommit(false);
            mensaje = "1";
        } catch (SQLException e) {
            mensaje = "0 " + e.getMessage();
            e.printStackTrace();
        }
        return mensaje;
    }

    public String quitarCambiosObjeto(Connection con) {
        String mensaje = "";
        try {
            con.rollback();
            mensaje = "1";
        } catch (SQLException e) {
            mensaje = "0 " + e.getMessage();
            e.printStackTrace();
        }
        return mensaje;
    }

    /*
    SELECT P.IDPREGUNTA,P.PREGUNTA,P.IDENCUESTA,O.IDSELECCION,O.NOMBREOPCION FROM PREGUNTA P, OPCIONES O WHERE (P.IDENCUESTA=1 AND P.IDTIPORESPUESTA=2);

    
    Nombre Atributoslistar [P.IDPREGUNTA,P.PREGUNTA,P.IDENCUESTA,O.IDSELECCION,O.NOMBREOPCION]
    Nombre Tablas  [PREGUNTA,OPCIONES]
    Filtros [P.IDENCUESTA=1,P.IDTIPORESPUESTA=2]
     */
    public List<String> responderPreguntas(Connection con, String atributosListar, String nombreTablas, String filtros, int totalRegistros) throws SQLException {
        String sql = "SELECT " + atributosListar + " FROM " + nombreTablas + " WHERE (" + filtros + ")";
        //System.out.println("JOIN>" + sql);
        List<String> filas = new ArrayList<String>();
        DefaultTableModel model;
        int columnas = atributosListar.split(",").length;
        String[] cabeceras = atributosListar.split(",");
        for (int i = 0; i < columnas; i++) {
            filas.add(cabeceras[i]);
        }
        Statement st = null;
        ResultSet rs = null;
        int j = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 1; i <= columnas; i++) {
                    filas.add(rs.getString(i));
                }
                j = j + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
        return filas;
    }

    public List<String> responderOpciones(Connection con, String atributosListar, String nombreTablas, String innerJ, int totalRegistros) throws SQLException {
        String sql = "SELECT " + atributosListar + " FROM " + nombreTablas + " " + innerJ;
        // System.out.println("JOIN>" + sql);
        List<String> filas = new ArrayList<String>();
        DefaultTableModel model;
        int columnas = atributosListar.split(",").length;
        String[] cabeceras = atributosListar.split(",");
        for (int i = 0; i < columnas; i++) {
            filas.add(cabeceras[i]);
        }
        Statement st = null;
        ResultSet rs = null;
        int j = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 1; i <= columnas; i++) {
                    filas.add(rs.getString(i));
                }
                j = j + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
        return filas;
    }

}
