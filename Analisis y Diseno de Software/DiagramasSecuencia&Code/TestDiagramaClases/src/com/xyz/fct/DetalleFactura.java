/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyz.fct;

/**
 *
 * @author lainiguez
 */
public class DetalleFactura {
    
    private double cantidad;
    private double precio;
    private double descuento;
    
    private Factura factura;
    private Producto producto;
    
    private double subtotal;
    private double valorDescuento;
    private double iva;
    private double total;

    public DetalleFactura(double cantidad, double descuento, Factura factura, Producto producto) 
    {
        
        if (factura == null)
            throw new IllegalArgumentException("El parámetro factura no puede contener un valor nulo");
        
        if (producto == null)
            throw new IllegalArgumentException("El parámetro producto no puede contener un valor nulo");
            
        this.cantidad = cantidad;
        this.precio = producto.getPrecio();
        this.descuento = descuento;
        this.factura = factura;
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }


    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }


    public Producto getProducto() {
        return producto;
    }

    
    public void calcularTotales()
    {
        double porcentajeIva = (producto.isGrabaIVA()? 0.14 : 0);
        
        
        subtotal = cantidad * precio;
        valorDescuento = getSubtotal() * descuento;        
        iva = (getSubtotal() - descuento) * porcentajeIva;        
        total = (getSubtotal() - descuento) + getIva();
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @return the valorDescuento
     */
    public double getValorDescuento() {
        return valorDescuento;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }
    
}
