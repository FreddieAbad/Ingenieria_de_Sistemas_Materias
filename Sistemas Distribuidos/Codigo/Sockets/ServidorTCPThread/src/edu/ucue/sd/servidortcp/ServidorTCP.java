/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.sd.servidortcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 *
 * @author paul
 */
public class ServidorTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length != 1) {
            System.err.println("Formato: ServidorTCP <puerto>");
            System.exit(-1);
        }
        ServerSocket serverSocket = null;
        Socket clienteSocket = null;
        try {
            // Creamos el socket del servidor
            serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            // Establecemos un timeout de 30 segs
            serverSocket.setSoTimeout(30000);
            while (true) {
                // Esperamos posibles conexiones
                clienteSocket = serverSocket.accept();
                // Creamos un objeto ThreadServidor, pasándole la nueva conexión
                ThreadServidor tServidor = new ThreadServidor(clienteSocket);
                // Iniciamos su ejecución con el método start()
                tServidor.run();
            }
        } catch (SocketTimeoutException e) {
            System.err.println("30 segs sin recibir nada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                //Cerramos el socket
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }           
        }
    }
    
}
