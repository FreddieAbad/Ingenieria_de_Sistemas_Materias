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

/**
 Implementacion de un cliente de eco usando UDP.
 */
public class ClienteUDP {

    public static void main(String[] argv) {
        int puerto = 5000;
        int tiempoespera=30000;
        if (argv.length == 3) {
            System.err.println("Formato: ClienteUDP <maquina> <puerto> <mensaje>");
            System.exit(-1);
        }
        DatagramSocket sDatagram = null;
        try {
            // Creo el socket no orientado a conexión, en cualquier puerto 
            sDatagram = new DatagramSocket(puerto);
            // timeout de 30 segs
            sDatagram.setSoTimeout(tiempoespera);
            // Obtengo la dirección IP del servidor (recibida en el primer argumento por linea de comandos)
            InetAddress dirServidor = InetAddress.getByName(argv[0]);
            // Obtengo el puerto del servidor (recibido en el segundo argumento por linea de comandos)
            int puertoServidor = Integer.parseInt(argv[1]);
            // Obtengo el mensaje(tercer argumento de la linea de comandos)
            String mensaje = argv[2];

            byte[] envInfo = new byte[1024];
            envInfo = mensaje.getBytes();
            // Preparo el datagrama que vamos a enviar y lo enviamos
            DatagramPacket envPaquete = new DatagramPacket(
                    envInfo, envInfo.length,
                    dirServidor, puertoServidor
            );
            // Envio el datagrama
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
            // Recibo el mensaje
            sDatagram.receive(recPaquete);
            System.out.println(
                    "CLIENTE: Recibido "
                    + new String(recPaquete.getData(), 0, recPaquete.getLength())
                    + " de " + recPaquete.getAddress().toString() + ":"
                    + recPaquete.getPort()
            );
        } catch (SocketTimeoutException e) {
            System.err.println("3 segs sin recibir nada");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Cerramos el socket para liberar la conexión
            sDatagram.close();
        }
    }
}
