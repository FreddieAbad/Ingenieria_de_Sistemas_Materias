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
                // Establecemos el canal de entrada
                BufferedReader sEntrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                // Establecemos el canal de salida
                PrintWriter sSalida = new PrintWriter(clienteSocket.getOutputStream(), true);
                // Recibimos el mensaje del cliente     
                String mensaje = sEntrada.readLine();
                InetAddress dirCliente = clienteSocket.getInetAddress();
                int puertoCliente = clienteSocket.getPort(); 

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
                clienteSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }           
        }
    }
    
}
