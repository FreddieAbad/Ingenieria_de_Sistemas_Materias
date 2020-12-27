/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor= new ServerSocket(4500);
            Socket clienteNuevo=servidor.accept();//pausa hasta que llege 
            ObjectInputStream entrada= new ObjectInputStream(clienteNuevo.getInputStream());
            System.out.println("Objeto Llego");
            System.out.println("Mandando Mensaje al Cliente");
            String mensaje= (String) entrada.readObject();
            System.out.println("Mensaje "+mensaje);
            ObjectOutputStream respuesta= new ObjectOutputStream(clienteNuevo.getOutputStream());
            respuesta.writeObject("Hola cliente");
            System.out.println("Mensaje enviado");
            clienteNuevo.close();
            servidor.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
