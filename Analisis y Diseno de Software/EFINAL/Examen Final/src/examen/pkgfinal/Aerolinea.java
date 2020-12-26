/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.pkgfinal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
class Aerolinea {
    private String nombre;
    private String idVuelo;
    
    private  List<Vuelo> vuelo;
    private TipoAeronave tipoae;

    public Aerolinea(String nombre, String idVuelo) {
        this.nombre = nombre;
        this.idVuelo = idVuelo;
        
        this.vuelo=vuelo=new ArrayList<>();
        this.tipoae=tipoae;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public List<Vuelo> getVuelo() {
        return vuelo;
    }

    public TipoAeronave getTipoae() {
        return tipoae;
    }

    
   
}
