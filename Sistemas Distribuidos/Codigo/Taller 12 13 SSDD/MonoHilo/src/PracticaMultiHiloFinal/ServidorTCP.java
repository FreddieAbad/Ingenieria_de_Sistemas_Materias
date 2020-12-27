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


import java.io.*; 

import java.net.*; 
/**Ejemplo que implementa un servidor de eco usando TCP.*/ 
public class ServidorTCP {

    public static void main(String argv[]) throws IOException {
        int Puerto = 5000;
        Socket skCliente = null;
        ServerSocket skServidor = null;
        BufferedReader entrada;
        DataOutputStream salida;
        String llego;
        if (argv.length != 1) {
            System.err.println("Formato servidor TCP<Puerto>");
            System.exit(-1);
        }
        try {
            // Creamos el socket del servidor. 
            skServidor = new ServerSocket(Puerto);
            System.out.println("CLIENTE: Conexion establecida con el puerto " + Puerto);
            // Establece un timeout de 30 segs. 
            skServidor.setSoTimeout(30000); // Esperamos posibles conexiones. 
            skCliente = skServidor.accept();
            System.out.println("Ya se conecto al cliente.");
            // Establecemos el canal de entrada. 
            entrada = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
            // Establecemos el canal de salida. 
            salida = new DataOutputStream(skCliente.getOutputStream());
            do { // Recibimos el mensaje. 
                llego = entrada.readLine();
                System.out.println("Llego: " + llego);
                // Enviamos el eco al cliente. 
                salida.writeInt(llego.length());
            } while (llego.length() != 0);
            System.out.println("Ya termine de recibir.");
            // Cerramos los flujos. 
            entrada.close();
        } catch (SocketTimeoutException e) {
            System.err.println("30 segs. sin recibir mensaje");
        }catch(Exception e) { 
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace ();
        }finally { 
        // Cerramos el socket. 
            skCliente.close();
            skServidor.close();
            } 
        } 
    }
