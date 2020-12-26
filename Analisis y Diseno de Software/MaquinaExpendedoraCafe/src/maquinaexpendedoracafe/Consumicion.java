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
public class Consumicion {
    private String code;
    private int totalCobro;
    
    private MaquinaExpendedora maquina;
    private Receta receta;

    public Consumicion(String code, int totalCobro, MaquinaExpendedora maquina) {
        this.code = code;
        this.totalCobro = totalCobro;
        
        this.maquina = maquina;
        this.receta = receta;
    }
    
    
}
