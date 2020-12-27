/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.sd.clienteudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

/**
 *
 * @author paul
 */
/** Ejemplo que implementa un cliente de eco usando UDP. */
public class ClienteUDP {
    
    public static void main(String args[]) {
        if (args.length != 3) {
        System.err.println("Formato: ClienteUDP <maquina> <puerto> <mensaje>");
        System.exit(-1);
        }
        DatagramSocket sDatagram = null;
        try {
            // Creamos el socket no orientado a conexión
            // (en cualquier puerto libre)
            sDatagram = new DatagramSocket();
            // Establecemos un timeout de 30 segs
            sDatagram.setSoTimeout(30000);
            // Obtenemos la dirección IP del servidor
            // (recibida en el primer argumento por linea de comandos)
            InetAddress dirServidor = InetAddress.getByName(args[0]);
            // Obtenemos el puerto del servidor
            // (recibido en el segundo argumento por linea de comandos)
            int puertoServidor = Integer.parseInt(args[1]);
            // Obtenemos el mensaje
            // (tercer argumento de la linea de comandos)
            String mensaje = args[2];

            byte[] envInfo = new byte[1024];
            envInfo = mensaje.getBytes();
            // Preparamos el datagrama que vamos a enviar y lo enviamos
            DatagramPacket envPaquete = new DatagramPacket(
                    envInfo, envInfo.length,
                    dirServidor, puertoServidor
            );
            // Enviamos el datagrama
            sDatagram.send(envPaquete);
            System.out.println(
                    "CLIENTE: Enviando "
                    + new String(envPaquete.getData()) + " a "
                    + envPaquete.getAddress().toString() + ":"
                    + envPaquete.getPort()
            );

            // Preparamos el datagrama de recepción
            byte[] recInfo = new byte[1024];
            DatagramPacket recPaquete = new DatagramPacket(recInfo, recInfo.length);
            // Recibimos el mensaje
            sDatagram.receive(recPaquete);
            System.out.println(
                    "CLIENTE: Recibido "
                    + new String(recPaquete.getData(), 0, recPaquete.getLength())
                    + " de " + recPaquete.getAddress().toString() + ":"
                    + recPaquete.getPort()
            );
        } catch (SocketTimeoutException e) {
            System.err.println("30 segs sin recibir nada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Cerramos el socket para liberar la conexión
            sDatagram.close();
        }
    }
}
