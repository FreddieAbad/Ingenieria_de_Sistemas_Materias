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
class MaquinaExpendedora {
    private String idMaquina;
    
    private Pedido idpedido;
    private estadoMaquina state;
    
    public MaquinaExpendedora(String idMaquina, Pedido idpedido) {
        if (idMaquina == null || idMaquina.trim().length() == 0) {
            throw new IllegalArgumentException("Llene el campo de IDMAQUINA para ocntinuar");
        }
        if (idpedido == null) {
            throw new IllegalArgumentException("Llene el campo de IDPEDIDO para ocntinuar");
        }
        
        this.idMaquina = idMaquina;
        this.idpedido = idpedido;
    }
    
    
    
            
}
