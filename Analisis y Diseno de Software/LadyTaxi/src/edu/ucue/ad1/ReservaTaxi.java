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
public class ReservaTaxi {
 
    private int idSolicitud;
    private String fecha;
    private String hora;
    private estadoTaxi estado;
    
    private Taxi taxi;
    private List<SolicitudServicio> pedirTaxi;

    public ReservaTaxi(int idSolicitud, String fecha, String hora, Taxi taxi) {
        if (taxi == null)
            throw new IllegalArgumentException("El parámetro 'taxi' no puede contener un valor nulo");
        
        if (fecha == null || fecha.trim().length() != 10)
            throw new IllegalArgumentException("El parámetro 'fecha' no puede contener un valor nulo o no representar una fecha");
        
        if (hora == null || hora.trim().length() != 5)
            throw new IllegalArgumentException("El parámetro 'hora' no puede contener un valor nulo o no representar una hora");
        
        this.idSolicitud = idSolicitud;
        this.fecha = fecha;
        this.hora = hora;
        this.taxi = taxi;
        pedirTaxi =new ArrayList<>();
        
        
    }
    public void ocupado(){
        
        this.estado=estadoTaxi.OCUPADA;
        
    }
    public void addReserva(String Fecha, String hora){
        SolicitudServicio pedido = new SolicitudServicio(fecha,hora,this);
        pedirTaxi.add(pedido);
    }
    public List<SolicitudServicio> getPedirTaxi() {
        return pedirTaxi;
    }
    
     public boolean isTaxiLibre(String fecha, String hora)
    {
        for (SolicitudServicio solicita : pedirTaxi) {
            if (solicita.getFecha().equals(fecha) && hora.equals(hora))
                return false;
        }
        
        return true;
    }
}
