/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ediss
 */
public class ConexionOracle {
    Parametros par = new Parametros();
    private final String url = par.URL;
    private final String user = par.usuarioBD;
    private final String passw = par.passw;
    private final Connection conn;

    public ConexionOracle() {
        try {
            conn = DriverManager.getConnection(url, user, passw);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Connection getConn() {
        return conn;
    }    
}
