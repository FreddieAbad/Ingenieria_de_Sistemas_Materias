/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.sd.servidortcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paul
 */
public class ThreadServidor extends Thread {
    
    Socket socket;
    
    public ThreadServidor(Socket s) {
        // Almacenamos el socket de la conexión
        socket = s;
    }
    
    public void run() {
        try {
            // Establecemos el canal de entrada
            BufferedReader sEntrada = new BufferedReader(new InputStreamReader(
                                        socket.getInputStream()));
            // Establecemos el canal de salida
            PrintWriter sSalida = new PrintWriter(socket.getOutputStream(), true);
            // Recibimos el mensaje del cliente
            String mensaje = sEntrada.readLine();
            InetAddress dirCliente = socket.getInetAddress();
            int puertoCliente = socket.getPort(); 
            
            System.out.println(
                        "SERVIDOR: Recibido "
                        + mensaje
                        + " de " + dirCliente.toString() + ":"
                        + puertoCliente
                    );
            // Enviamos el eco al cliente
            sSalida.println(mensaje);
            System.out.println(
                        "SERVIDOR: Enviando "
                        + mensaje
                        + " de " + dirCliente.toString()+ ":"
                        + puertoCliente
                    );
            // Cerramos los flujos
            sEntrada.close();
            sSalida.close();

        } catch (SocketTimeoutException e) {
            System.err.println("30 segs sin recibir nada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                // Cerramos el socket
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
