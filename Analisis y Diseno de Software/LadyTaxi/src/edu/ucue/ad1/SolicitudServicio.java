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
public class SolicitudServicio {
    private static Iterable<SolicitudServicio> getServicio;

    /**
     * @return the getServicio
     */
    public static Iterable<SolicitudServicio> getGetServicio() {
        return getServicio;
    }

    /**
     * @param aGetServicio the getServicio to set
     */
    public static void setGetServicio(Iterable<SolicitudServicio> aGetServicio) {
        getServicio = aGetServicio;
    }
    private int idServicio;
    private String idCuenta;
    private String fecha;
    private String hora;
    private int idClienta;
    private List<ConjuntoTaxis> taxis;
    private ReservaTaxi reserva;

    public SolicitudServicio(int idServicio, String idCuenta, String fecha, String hora, int idClienta, ReservaTaxi reserva) {
         if (idCuenta == null)
            throw new IllegalArgumentException("El parámetro 'idCuenta' no puede contener un valor nulo");
        
        if (fecha == null || fecha.trim().length() != 10)
            throw new IllegalArgumentException("El parámetro 'fecha' no puede contener un valor nulo o no representar una fecha");
        
        if (hora == null || hora.trim().length() != 5)
            throw new IllegalArgumentException("El parámetro 'hora' no puede contener un valor nulo o no representar una hora");
        
        this.idServicio = idServicio;
        this.idCuenta = idCuenta;
        this.fecha = fecha;
        this.hora = hora;
        this.idClienta = idClienta;
        this.reserva = reserva;
        this.taxis = taxis = new ArrayList<>();
        
    }

    SolicitudServicio(String fecha, String hora, ReservaTaxi aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the idServicio
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    /**
     * @return the idCuenta
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * @param idCuenta the idCuenta to set
     */
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the idClienta
     */
    public int getIdClienta() {
        return idClienta;
    }

    /**
     * @param idClienta the idClienta to set
     */
    public void setIdClienta(int idClienta) {
        this.idClienta = idClienta;
    }

    /**
     * @return the reserva
     */
    public ReservaTaxi getReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(ReservaTaxi reserva) {
        this.reserva = reserva;
    }
    
      public List<ConjuntoTaxis> getTaxis() {
        return taxis;
    }

    void addTaxi(int idServicio,int idClienta){
        
        ConjuntoTaxis taxis= new ConjuntoTaxis (getIdServicio() + idServicio,idClienta,this);
        
    }

    boolean isTaxiLibre(String fecha, String hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
