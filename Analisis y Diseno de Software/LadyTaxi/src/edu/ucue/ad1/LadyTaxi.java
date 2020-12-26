/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucue.ad1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class LadyTaxi {

    private int id;
    private String taxi;
    private int telefono;
    private String direccion;
    
    private List<ConjuntoTaxis> taxis;

    public LadyTaxi(int id, String taxi, int telefono, String direccion) {
        this.id = id;
        this.taxi = taxi;
        this.telefono = telefono;
        this.direccion = direccion;
        this.taxis = taxis = new ArrayList<>();
    }
    
    public List<Taxi> iniciarSolicitud(ConjuntoTaxis taxis){
        if (taxis == null)
            throw new IllegalArgumentException("El parámetro 'taxis' no puede contener un valor nulo");
                    
        List<Taxi> listataxis = taxis.getTaxis();
        
        return listataxis;
        
    }
    public List<SolicitudServicio>solicitarTaxi(Taxi taxi, String fecha, String hora, int id){
        if (taxi == null)
            throw new IllegalArgumentException("El parámetro 'taxi' no puede contener un valor nulo");
        
        if (fecha == null || fecha.trim().length() != 10)
            throw new IllegalArgumentException("El parámetro 'fecha' no puede contener un valor nulo o no representar una fecha");
        
        if (hora == null || hora.trim().length() != 5)
            throw new IllegalArgumentException("El parámetro 'hora' no puede contener un valor nulo o no representar una hora");
        
        List<SolicitudServicio> taxisLibres = taxi.taxisLibres(fecha, hora);
        
        return taxisLibres;
        
    }
    public List<ReservaTaxi> pedirTaxi(Taxi taxi,String fecha, String hora, String nombreClienta){
        List<ReservaTaxi> crearPedido = taxi.crearPedido(fecha, hora,nombreClienta);
        
        guardarPedido(crearPedido);
        
        return crearPedido;
        
    }

    private void guardarPedido(List<ReservaTaxi> crearPedido) {
         System.out.println("Pedido guardado");
    
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the taxi
     */
    public String getTaxi() {
        return taxi;
    }

    /**
     * @param taxi the taxi to set
     */
    public void setTaxi(String taxi) {
        this.taxi = taxi;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
