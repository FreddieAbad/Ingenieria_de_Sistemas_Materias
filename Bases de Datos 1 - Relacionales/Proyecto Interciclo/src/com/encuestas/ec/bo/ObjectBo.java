/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.bo;

import com.encuestas.ec.dao.ObjectDao;
import com.encuestas.ec.db.Conexion;
import com.encuestas.ec.entity.Encuesta;
import com.encuestas.ec.entity.Usuario;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JTable;

/**
 *
 * @author Freddie
 */
public class ObjectBo {

    private String mensaje = "";
    private ObjectDao odao = new ObjectDao();

    public String agregarObjeto(Object objeto) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = odao.agregarObjeto(con, objeto);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String agregarObjetoE(String ce) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = odao.agregarObjetoE(con,ce);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    public String comparacionObjeto(Object objeto,String datoComparar, String cedula) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = odao.comparacionObjeto(con, datoComparar, objeto,cedula);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String modificarObjeto(Object objeto) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = odao.modificarObjeto(con, objeto);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
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
        System.out.println(sentencia + sentenciaPK + "$$$$$");
        return new Object[]{sentenciaPK, sentencia};
    }

    public String eliminarObjeto(Object objeto, String id, int booleanoTipoDato) { //0 es int 1 string

        //valores eliminar
        Connection con = Conexion.getConnection();
        try {
            mensaje = odao.eliminarObjeto(con, objeto, id, booleanoTipoDato);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
        return mensaje;
    }

    public int getMaxID(Object objeto) {
        Connection con = Conexion.getConnection();
        int id = odao.getMaxID(con, objeto);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    public int getMaxIDFK(Object objeto, String[] whereStat, Object[] whereStat2, int[] typeDataW) {
        Connection con = Conexion.getConnection();
        int id = odao.getMaxIDFK(con, objeto, whereStat, whereStat2, typeDataW);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    public int contarObjeto(Object objeto, String[] whereStat, Object[] whereStat2, int[] typeDataW) {
        Connection con = Conexion.getConnection();
        int id = odao.contarObjeto(con, objeto, whereStat, whereStat2, typeDataW);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    public void listarObjeto(JTable table, Object objeto, String[] columnas, String[] labelsTablas, Object[] lblsTablas, int[] dataty) throws SQLException {
        Connection con = Conexion.getConnection();
        odao.listarObjeto(con, table, objeto, columnas, labelsTablas, lblsTablas, dataty);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarObjetoE(JTable table, Object objeto, String[] columnas) throws SQLException {//,String[] labelsTablas,Object[] lblsTablas,int[] dataty
        Connection con = Conexion.getConnection();
        odao.listarObjetoE(con, table, objeto, columnas);//,labelsTablas,lblsTablas,dataty
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarObjetoFK(JTable table, Object objeto, String[] columnas, String[] labelsTablas, Object[] lblsTablas, int[] dataty) throws SQLException {
        Connection con = Conexion.getConnection();
        odao.listarObjetoFK(con, table, objeto, columnas, labelsTablas, lblsTablas, dataty);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarObjetoIJ(JTable table, Object objeto, String columnas, String tablas, String complemento) throws SQLException {
        Connection con = Conexion.getConnection();
        odao.listarObjetoIJ(con, table, objeto, columnas, tablas, complemento);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarObjetoGenerico(JTable tabla, Object objeto) {
        Connection con = Conexion.getConnection();
        odao.listarObjetoGenerico(con, tabla, objeto);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public String deshabilitarCambiosObjeto() {
        Connection con = Conexion.getConnection();
        mensaje = odao.deshabilitarCambiosObjeto(con);
        return mensaje;
    }

    public String confirmarCambiosObjeto() {
        Connection con = Conexion.getConnection();
        mensaje = odao.confirmarCambiosObjeto(con);
        return mensaje;
    }

    public String quitarCambiosObjeto() {
        Connection con = Conexion.getConnection();
        mensaje = odao.quitarCambiosObjeto(con);
        return mensaje;
    }

    //REFACTORIZAR
    public List<String> responderPreguntas(Object objeto, int idEncuesta, String valorConsultar, String nombreTablas, String filtros, int totalRegistros) { //// select count(distinct IDENTIFICADOR) from pregunta where IDPREGUNTA=1
        Connection con = Conexion.getConnection();
        String atributosListar = valorConsultar;
        String filtrosBD = filtros;
        List<String> mensaje2 = new ArrayList<String>();
        try {
            mensaje2 = odao.responderPreguntas(con, atributosListar, nombreTablas, filtros, totalRegistros);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje2;
    }

    public List<String> responderOpciones(Object objeto, int idEncuesta, String valorConsultar, String nombreTablas, String filtros, int totalRegistros) { //// select count(distinct IDENTIFICADOR) from pregunta where IDPREGUNTA=1
        Connection con = Conexion.getConnection();
        String atributosListar = valorConsultar;
        String filtrosBD = filtros;
        List<String> mensaje2 = new ArrayList<String>();
        try {
            mensaje2 = odao.responderOpciones(con, atributosListar, nombreTablas, filtros, totalRegistros);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje2;
    }
    /*
    public static void main(String[] args) {
        Encuesta usuario = new Encuesta();
        ObjectBo obo = new ObjectBo();
        //     LinkedList<String> listaNombreValores = (LinkedList<String>) obo.obtenerNombreValores(usuario);
        //       obo.obtenerNombreValoresStr(listaNombreValores);
        //       obo.obtenerIncognita(4);
        //      obo.obtenerNombreValoresUpdtStr(listaNombreValores);
    }
     */
}
/*
///
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
                //System.out.println("Atributo = " + atributo);

                posicion = atributo.getClass().toString().split(Pattern.quote(".")).length;
                tipoAtributo = atributo.getClass().toString().split(Pattern.quote("."))[posicion - 1].substring(0, 1).toUpperCase();
                tipoValores.add(tipoAtributo);
            }
            //System.out.println(valores);
        } catch (SecurityException e) {
            System.out.println(e.toString());
        }
        //return new valores, tipoValores;
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
        System.out.println(sentencia);
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
        System.out.println(incognita);
        return incognita;
    }
///
 */
