/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaexpendedoracafe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Pedido {
    private String idPedido;
    private int costoPedido;
    private int cantidadPedido;
    private String hora;
    
    private List <MaquinaExpendedora> mee;

    public Pedido(String idPedido, int costoPedido, int cantidadPedido, String hora) {
        if (idPedido == null || idPedido.trim().length() == 0) {
            throw new IllegalArgumentException("Llene el campo de IDPEDIDO para ocntinuar");
        }
        if (costoPedido == 0 ) {
            throw new IllegalArgumentException("Llene el campo de COSTO DE PEDIDO para ocntinuar");
        }
        if (cantidadPedido == 0) {
            throw new IllegalArgumentException("Llene el campo de CANTIDAD DE PEDIDO para ocntinuar");
        }
        
        this.idPedido = idPedido;
        this.costoPedido = costoPedido;
        this.cantidadPedido = cantidadPedido;
        this.hora = hora;
        
        mee = new ArrayList<>();
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public int getCostoPedido() {
        return costoPedido;
    }

    public void setCostoPedido(int costoPedido) {
        this.costoPedido = costoPedido;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(int cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    
    
    public List<MaquinaExpendedora> getMee() {
        return mee;
    }   
}
