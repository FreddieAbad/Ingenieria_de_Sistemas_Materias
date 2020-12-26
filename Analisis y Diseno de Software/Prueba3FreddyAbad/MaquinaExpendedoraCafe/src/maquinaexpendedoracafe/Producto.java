/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaexpendedoracafe;

/**
 *
 * @author Usuario
 */
public class Producto {
    private String idProducto;
    private int precioProducto;
    
    private Consumicion cons;

    public Producto(String idProducto, int precioProducto, Consumicion cons) {
        this.idProducto = idProducto;
        this.precioProducto = precioProducto;
        this.cons = cons;
    }
    
}
