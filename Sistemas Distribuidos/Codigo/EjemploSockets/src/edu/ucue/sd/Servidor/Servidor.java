/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.sd.Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paul
 */
public class Servidor {
    
    public static void main(String[] args) 
    {
        try {
            ServerSocket servidor = new ServerSocket(4500);
            Socket clienteNuevo = servidor.accept();
            ObjectInputStream entrada = new ObjectInputStream(clienteNuevo.getInputStream());
            System.out.println("Objeto llegó");
            System.out.println("Mandando otro mensaje al cliente");
            
            String mensaje = entrada.readObject().toString();
            System.out.println("Mensaje: "+mensaje);
            ObjectOutputStream resp = new ObjectOutputStream(clienteNuevo.getOutputStream());
            resp.writeObject("Hola cliente");
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
