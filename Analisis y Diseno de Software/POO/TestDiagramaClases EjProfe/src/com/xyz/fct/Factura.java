/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyz.fct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lainiguez
 */
public class Factura 
{
    private String numero;
    private Date fecha;
    
    private Cliente cliente;
    private List<DetalleFactura> detalles;
    
    private double subtotal;
    private double descuento;
    private double iva;
    private double total;

    public Factura(String numero, Date fecha, Cliente cliente) {
        
        if (numero == null)
            throw new IllegalArgumentException("El parámetro número de factura no puede contener un valor nulo");

        if (fecha == null)
            throw new IllegalArgumentException("El parámetro fecha de factura no puede contener un valor nulo");
        
        if (cliente == null)
            throw new IllegalArgumentException("El cliente de la factura no puede contener un valor nulo");
        
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cliente.agregar(this);
        
        this.detalles = new ArrayList<>();
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the detalles
     */
    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void agregar(double cantidad, double descuento, Producto producto)
    {
        DetalleFactura det = new DetalleFactura(cantidad, descuento, this, producto);
        detalles.add(det);
        
        det.calcularTotales();
        
        subtotal += det.getSubtotal();
        this.descuento += det.getValorDescuento();
        iva += det.getIva();
        total += det.getTotal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }
}
