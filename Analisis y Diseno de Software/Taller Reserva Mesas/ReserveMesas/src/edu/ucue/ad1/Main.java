/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.ad1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lainiguez
 */
public class Main {
    
    public static void main(String[] args) 
    {
        CadenaRestaurantes cadena = new CadenaRestaurantes(1, "KFC");
        cadena.addRestaurante("KFC Remigio", "Remigio Crespo");
        cadena.addRestaurante("KFC Mall del Río", "Dirección del mall");
        cadena.addRestaurante("KFC Centro Histórico", "Benigno Malo");
        
        for (Restaurante restaurante : cadena.getRestaurantes()) {
            for (int i = 0; i < 3; i++) {
                restaurante.addUbicacion("Ubicacion "+restaurante.getNombre() + " - " + i);
            }            
        }
        
        for (Restaurante restaurante : cadena.getRestaurantes()) {
            for (Ubicacion ubicacion : restaurante.getUbicaciones()) 
            {
                for (int i = 5; i < 8; i++) {
                    ubicacion.addMesa(" - Mesa :" + i, i, TipoMesa.NE);
                }
            }            
        }
        
        TerminalPuntoReserva tpr = new TerminalPuntoReserva(1, "TPR Mall del Río");
        
        cadena.addTerminal(tpr);
        
        //--SECUENCIA 1 ------------------------------------------------------------------
        List<Restaurante> restaurantes = tpr.iniciarReserva(cadena);
        
        // Interfaz usuario selección restaurante-------------------------------
        System.out.println("Seleccione un restaurante: ");
        int i = 0;
        for (Restaurante restaurante : restaurantes) 
        {
            i ++;
            System.out.println(i + " " +restaurante.getNombre());
        }
        
        Scanner scan = new Scanner(System.in);
        int opc = scan.nextInt();
        Restaurante restauranteSel = restaurantes.get(opc);
        

        
        
        //--SECUENCIA 2 ------------------------------------------------------------------
        List<Mesa> mesasLibres =  tpr.listarMesas(restauranteSel, "12/07/2016", "08:00");
        
        // Interfaz usuario selección mesa-------------------------------
        System.out.println("Seleccione una mesa: ");
        i = 0;
        for (Mesa mesa : mesasLibres) {
            i ++;
            System.out.println(i + " ---- " +mesa.getNumero() + " - Ubicación:" + mesa.getUbicacion().getNombre());
        }
        opc = scan.nextInt();
        Mesa mesaSel = mesasLibres.get(opc);
        
        
        
        //--SECUENCIA 3 ------------------------------------------------------------------
        System.out.println(
           tpr.reservar(mesaSel, 6, "12/07/2016", "08:00", "Juan Pérez")
        );
        
    }
}
