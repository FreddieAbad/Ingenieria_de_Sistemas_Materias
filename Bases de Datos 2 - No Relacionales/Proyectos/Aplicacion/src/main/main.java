/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Negocio.OracleServidor;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ediss
 */
public class main {

    public static void main(String[] args) throws SQLException {
        
        System.out.println("LEER FICHERO");
        OracleServidor dbserver = OracleServidor.getInstance();
        
        try { 
            CsvReader reader = new CsvReader("carriers.csv", ',');
            reader.readHeaders();
            System.out.println("Leyendo...");
            while (reader.readRecord()){
                //System.out.println("Code: "+reader.get(0)+"\tDesc: "+reader.get(1));
                dbserver.insertRecord(reader.get(0), reader.get(1));
            }
            System.out.println("Carga finalizada con éxito");
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
