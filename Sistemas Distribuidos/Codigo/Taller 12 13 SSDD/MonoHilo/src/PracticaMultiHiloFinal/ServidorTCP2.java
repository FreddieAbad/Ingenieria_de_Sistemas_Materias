/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaMultiHiloFinal;
//SERVIDOR TCP 

import java.net.*;
import java.io.*;

/**
 *
 * @author USUARIO
 */
public class ServidorTCP2 {

    public static void main(String argv[]) {
        if (argv.length != 1) {
            System.err.println("Formato: ServidorTCP <puerto>");
            System.exit(-1);
        }
        ServerSocket sSocket = null;
        try {
        // creo el socket del servidor 
            sSocket = new ServerSocket(Integer.parseInt(argv[0]));
        // establezco un timeout de 30 segs 
            sSocket.setSoTimeout(30000);

            while (true) {

        //------------------------VERSION MULTIHILO-------------------------------... 
        // Creo un objeto ThreadServidor, pasándole la nueva conexión 
                ThreadServidor ts = new ThreadServidor(sSocket.accept());

        // Inicio su ejecución con el método start() 
                ts.start();
            }
        } catch (SocketTimeoutException e) {
            System.err.println("30 segs sin recibir nada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
        //Cierro el socket del servidor 
            try {
                sSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
