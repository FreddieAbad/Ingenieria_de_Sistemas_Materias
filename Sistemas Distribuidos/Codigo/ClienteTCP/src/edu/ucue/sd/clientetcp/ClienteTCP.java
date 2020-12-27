/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.sd.clientetcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 *
 * @author paul
 */
public class ClienteTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length != 3) {
            System.err.println("Formato: ClienteTCP <maquina> <puerto> <mensaje>");
            System.exit(-1);
        }
        Socket socket = null;
        try {
            // Obtenemos la dirección IP del servidor
            InetAddress dirServidor = InetAddress.getByName(args[0]);
            // Obtenemos el puerto del servidor
            int puertoServidor = Integer.parseInt(args[1]);
            // Obtenemos el mensaje
            String mensaje = args[2];
            // Creamos el socket y establecemos la conexión con el servidor
            socket = new Socket(dirServidor, puertoServidor);
            // Establecemos un timeout de 30 segs
            socket.setSoTimeout(30000);
            System.out.println("CLIENTE: Conexion establecida con "
            + dirServidor.toString() + " al puerto " + puertoServidor);
            // Establecemos el canal de entrada
            BufferedReader sEntrada = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
            // Establecemos el canal de salida
            PrintWriter sSalida = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("CLIENTE: Enviando " + mensaje);
            // Enviamos el mensaje al servidor
            sSalida.println(mensaje);
            // Recibimos la respuesta del servidor
            String recibido = sEntrada.readLine();
            System.out.println("CLIENTE: Recibido " + recibido);
            // Cerramos los flujos y el socket para liberar la conexión
            sSalida.close();
            sEntrada.close();

        } catch (SocketTimeoutException e) {
            System.err.println("30 segs sin recibir nada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
