/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaMonohiloFinal;

/**
 *
 * @author USUARIO
 */
import java.net.*;
/** Implementacion de un servidor de eco usando UDP. */
public class ServidorUDP {
    
    public static void main(String[] argv) throws SocketException {
        int puerto=5000;
        int tiempoespera=30000;
        if (argv.length == 1) {
            System.err.println("Formato: ServidorUDP <puerto>");
            System.exit(-1);
        }
        try {
            // Creo el socket datagrama
            DatagramSocket sDatagram = new DatagramSocket(puerto);
            // Establezco un timeout
            sDatagram.setSoTimeout(tiempoespera);
            byte array[] = new byte[1024];
            DatagramPacket dgramRec, datagramaEnvio = null;
            while (true) {
                // Preparo datagrama para recepción
                dgramRec = new DatagramPacket(array, array.length);
 
                // Recibo el mensaje
                sDatagram.receive(dgramRec);
 
                // Recabo informacion
                String mensaje = new String(dgramRec.getData());
                InetAddress direccionCliente = dgramRec.getAddress();
                int puertoCliente = dgramRec.getPort();
 
                System.out.println("SERVIDOR: Recibido "
                    + new String(dgramRec.getData(), 0, dgramRec.getLength())
                    + " de " + direccionCliente.toString() + ":"
                    + puertoCliente
                );
 
                // Preparo el datagrama que vamos a enviar
                datagramaEnvio = new DatagramPacket(
                    mensaje.getBytes(), mensaje.getBytes().length,
                    direccionCliente, puertoCliente
                );
 
                // Envio el mensaje
                sDatagram.send(datagramaEnvio);
                System.out.println("SERVIDOR: Enviando"
                    + new String(datagramaEnvio.getData(), 0, datagramaEnvio.getLength())
                    + " de " + datagramaEnvio.getAddress().toString() + ":"
                    + datagramaEnvio.getPort()
                );
            }
        } catch (SocketTimeoutException e) {
            System.err.println("3 segs sin recibir nada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
