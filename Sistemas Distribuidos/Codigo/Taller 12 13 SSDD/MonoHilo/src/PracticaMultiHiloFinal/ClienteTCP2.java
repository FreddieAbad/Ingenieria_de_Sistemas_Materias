/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticaMultiHiloFinal;

import java.net.*;
import java.io.*;

/**
 *
 * @author USUARIO
 */
public class ClienteTCP2 {

    public static void main(String argv[]) {
        if (argv.length != 3) {
            System.err.println("Formato: ClienteTCP <maquina> <puerto> <mensaje>");
            System.exit(-1);
        }
        Socket socket = null;

        try {
        // 1.-Obtengo la dirección IP del servidor 
            InetAddress dirServidor = InetAddress.getByName(argv[0]);

        // 2.-Obtengo el puerto del servidor 
            int puertoServidor = Integer.parseInt(argv[1]);

        // 3.-Obtengo el mensaje 
            String mensaje = argv[2];

        // 4.-Creo el socket (orientado a conxión) y establecemos la conexión con el servidor 
        //constructor: Socket(InetAddress address, int port) 
            socket = new Socket(dirServidor, puertoServidor);

        // 5.-Establezco un timeout de 30 segs 
            socket.setSoTimeout(30000);
            System.out.println("CLIENTE: Conexion establecida con "
                    + dirServidor.toString() + " al puerto " + puertoServidor);

        // 6.-Establezco el canal de entrada 
            BufferedReader sEntrada = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

        // 7.-Establezco el canal de salida 
            PrintWriter sSalida = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("CLIENTE: Enviando " + mensaje);

            // 8.-Envio el mensaje al servidor 
            sSalida.println(mensaje);

        // 9.-recibo la respuesta del servidor 
            String recibido = sEntrada.readLine(); //sEntrada es el canal por el que nos entran mensajes del servidor 
            System.out.println("CLIENTE: Recibido " + recibido);

        // 10.-cierro los flujos y el socket para liberar la conexión 
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


