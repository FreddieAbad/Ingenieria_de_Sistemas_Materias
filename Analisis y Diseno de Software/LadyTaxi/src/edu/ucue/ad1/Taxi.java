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
public class Taxi {

    private int idTaxi;
    private String estado;
    private String ubicacion;
    
    private ConjuntoTaxis taxis;
    private List<SolicitudServicio> solicitud;
    private Object taxisLibres;

    public Taxi(int idTaxi, String estado, String ubicacion, ConjuntoTaxis taxis, List<SolicitudServicio> solicitud) {
        this.idTaxi = idTaxi;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.taxis = taxis;
        solicitud = new ArrayList<>();
        
        
    }

    Taxi(int i, SolicitudServicio aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    List<SolicitudServicio> taxisLibres(Taxi taxi,String fecha, String hora, int id) {
         List<SolicitudServicio> taxisLibres= new ArrayList<>();
         for(SolicitudServicio solicitudes: solicitud){
             for(SolicitudServicio taxilibre: SolicitudServicio.getGetServicio()){
                 agregarTaxiLibre(taxi,fecha,hora,id);
             }
         }
         return taxisLibres;
    }

   

    /**
     * @return the idTaxi
     */
    public int getIdTaxi() {
        return idTaxi;
    }

    /**
     * @param idTaxi the idTaxi to set
     */
    public void setIdTaxi(int idTaxi) {
        this.idTaxi = idTaxi;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the solicitud
     */
    public List<SolicitudServicio> getSolicitud() {
        return solicitud;
    }

    /**
     * @param solicitud the solicitud to set
     */
    public void setSolicitud(List<SolicitudServicio> solicitud) {
        this.solicitud = solicitud;
    }


    private void agregarTaxiLibre(List<SolicitudServicio> taxisLibres, SolicitudServicio taxis,String fecha, String hora) {
        if(taxis.isTaxiLibre(fecha,hora))
            taxisLibres.add(taxis);
    }

    List<SolicitudServicio> taxisLibres(String fecha, String hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List<ReservaTaxi> crearPedido(String fecha, String hora, String nombreClienta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void agregarTaxiLibre(Taxi taxi, String fecha, String hora, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
