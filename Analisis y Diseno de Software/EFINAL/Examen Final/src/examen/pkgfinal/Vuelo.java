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
class Vuelo {
    private String idVuelo;
    private Aeronave aeronave;
    private List<TipoPiloto> tpiloto;
    private List<Salida> salida;
    private List<Llegada> llegada;

    public Vuelo(String idVuelo, List<TipoPiloto> tpiloto, List<Salida> salida,List<Llegada> llegada) {
        this.idVuelo = idVuelo;
        
        this.tpiloto = tpiloto=new ArrayList<>();
        this.salida = salida=new ArrayList<>();
        this.llegada = llegada=new ArrayList<>();
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }
    String imprimir() {
        String vuelo = "";
        
        vuelo += "Vuelo: " + getIdVuelo()+ "\n";
        vuelo += "TipoAeronave: " + getHora()+ "\n";
        vuelo += "EstadoAeronave: " + getMesa().getUbicacion().getRestaurante().getNombre() + "\n";
        vuelo += "Aeronlinea: " + getMesa().getUbicacion().getNombre() + "\n";
        vuelo += "AeropuertoLlegada: " + getMesa().getNumero() + "\n";
        vuelo += "AeropuertoSalida: " + getNombre() + "\n";
        
        return vuelo;
    }
    public List<EstadoActualAeronave> verEstadoAeronave(String idVuelo)
    {
        
    }
    
            

            
}
