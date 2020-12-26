/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyz.fct;

import java.util.Date;

/**
 *
 * @author lainiguez
 */
public class TestFacturacion {
    
    public static void main(String[] args) {
        
        Producto tabaco = new Producto("001", "Tabaco XYZ", 0.35, true);
        Producto leche = new Producto("002","Leche XYZ", 0.8,false);
        Producto pan = new Producto("003", "Pan XYZ",0.20,false);
        
        
        Cliente cliente = new Cliente("0102156429", "Luis", "Iñiguez", "Av. 12 de abril");
        
        Factura factura = new Factura("001-001-000000001", new Date(), cliente);
        factura.agregar(10, 0, tabaco);
        factura.agregar(2, 0, leche);
        factura.agregar(20, 0, pan);
        
        System.out.println("Subtotal: " + factura.getSubtotal());
        System.out.println("Descuento: " + factura.getDescuento());
        System.out.println("IVA: " + factura.getIva());
        System.out.println("Total: " + factura.getTotal());
    }
}
