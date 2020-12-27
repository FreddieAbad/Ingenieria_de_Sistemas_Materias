/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaMultiHiloFinal;

/**
 *
 * @author USUARIO
 */
import java.net.*;
import java.io.*;

/**
 * Thread que atiende una conexión de un servidor de eco.
 */
public class ThreadServidor extends Thread {

    Socket socket;

    public ThreadServidor(Socket s) {
        // Almaceno el socket de la conexión 
        socket = s;
    }

    public void run() {
        try {
            // Establezco el canal de entrada 
            BufferedReader canalEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Establezco el canal de salida 
            PrintWriter canalSalida = new PrintWriter(socket.getOutputStream(), true);
            // Recibo el mensaje del cliente 
            String mensajeRecibido = canalEntrada.readLine();
            // Envio el eco al cliente 
            canalSalida.println(mensajeRecibido);
            // Cierro los flujos 
            canalEntrada.close();
            canalSalida.close();
        } catch (SocketTimeoutException e) {
            System.err.println("30 segs sin recibir nada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Cierro el socket 
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
