/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.ad1;

/**
 *
 * @author lainiguez
 */
public class Mesa {
    
    private String numero;
    private int numPersonas;
    
    private Ubicacion ubicacion;
    private EstadoMesa estado;
    private TipoMesa tipoMesa;

    public Mesa(String numero, int numPersonas, TipoMesa tipo, Ubicacion ubicacion) {
        
        if (numero == null || numero.trim().length() == 0)
            throw new IllegalArgumentException("El parámetro 'numero' no puede estar vacío");
        
        if (numPersonas <= 0)
            throw new IllegalArgumentException("El parámetro 'numPersonas' no puede ser menor a cero");
        
        if (ubicacion == null)
            throw new IllegalArgumentException("El parámetro 'ubicacion' no puede contener un valor nulo");
        
        this.numero = numero;
        this.numPersonas = numPersonas;
        this.tipoMesa = tipo;
        this.ubicacion = ubicacion;
        this.estado = EstadoMesa.LIBRE;
    }
    
    public void ocupar()
    {
        
        this.estado = EstadoMesa.OCUPADA;
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
     * @return the numPersonas
     */
    public int getNumPersonas() {
        return numPersonas;
    }

    /**
     * @param numPersonas the numPersonas to set
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setTipoMesa(TipoMesa tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    public TipoMesa getTipoMesa() {
        return tipoMesa;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
/*
    public  boolean isMesaLibre(String fecha, String hora)
    {
        for(ReservaMesa reserva : ){
            if(reserva.getFecha().equals(fecha) && hora.equals(hora))
                return false;
        }
        return true;
        
        }
    
    
    }
  */          
            }
