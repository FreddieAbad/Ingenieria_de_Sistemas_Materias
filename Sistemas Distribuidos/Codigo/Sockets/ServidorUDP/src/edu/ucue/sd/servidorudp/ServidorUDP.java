/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.sd.servidorudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketTimeoutException;

/**
 *
 * @author paul
 */
public class ServidorUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        if (args.length != 1) {
            System.err.println("Formato: ServidorUDP <puerto>");
            System.exit(-1);
        }
        try {
            // Creamos el socket datagrama
            DatagramSocket sDatagram = new DatagramSocket(Integer.parseInt(args[0]));
            // Establecemos un timeout de 30 segs
            sDatagram.setSoTimeout(30000);
            byte array[] = new byte[1024];
            DatagramPacket dgramRec, dgramEnv = null;
            //dgramRec = new DatagramPacket(array, array.length);
            while (true) {
                // Preparamos un datagrama para recepción
                dgramRec = new DatagramPacket(array, array.length);
 
                // Recibimos el mensaje
                sDatagram.receive(dgramRec);
 
                // Recabamos informacion
                String mensaje = new String(dgramRec.getData());
                InetAddress dirCliente = dgramRec.getAddress();
                int puertoCliente = dgramRec.getPort();
 
                System.out.println(
                    "SERVIDOR: Recibido "
                    + new String(dgramRec.getData(), 0, dgramRec.getLength())
                    + " de " + dirCliente.toString() + ":"
                    + puertoCliente
                );
 
                // Preparamos el datagrama que vamos a enviar
                dgramEnv = new DatagramPacket(
                    mensaje.getBytes(), mensaje.getBytes().length,
                    dirCliente, puertoCliente
                );
 
                // Enviamos el mensaje
                sDatagram.send(dgramEnv);
                System.out.println(
                    "SERVIDOR: Enviando "
                    + new String(dgramEnv.getData(), 0, dgramEnv.getLength())
                    + " de " + dgramEnv.getAddress().toString() + ":"
                    + dgramEnv.getPort()
                );
            }
        } catch (SocketTimeoutException e) {
            System.err.println("30 segs sin recibir nada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally{
            // Cerramos el socket
        }
    }
    
}
