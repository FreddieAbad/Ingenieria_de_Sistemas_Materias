/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.ArrayList;

/**
 *
 * @author XaviO_o
 */
public class Memoria {
    private String memoria[][] = new String[100][2];
    private String sumar =  "1";
    private String restar = "2";
    private String cargar = "3";
    private String store =  "4";
    private String jmp =  "5";
    
    private ArrayList<String> opcodes = new ArrayList<>();
    
    public Memoria() {
        opcodes.add(sumar);
        opcodes.add(restar);
        opcodes.add(cargar);
        opcodes.add(store);
        opcodes.add(jmp);
        for (int i = 0; i < 100; i++) {
            memoria[i][0] = String.valueOf(i);
            memoria[i][1] = "0";
        }
        
    }
    
    public void vaciarMemoria(){
        for (int i = 0; i < memoria.length; i++) {
            getMemoria()[i][1] = "0";
        }
    }

    /**
     * @return the memoria
     */
    public String[][] getMemoria() {
        return memoria;
    }

    /**
     * @param memoria the memoria to set
     */
    public void setMemoria(String[][] memoria) {
        this.setMemoria(memoria);
    }


    /**
     * @return the sumar
     */
    public String getSumar() {
        return sumar;
    }

    /**
     * @param sumar the sumar to set
     */
    public void setSumar(String sumar) {
        this.sumar = sumar;
    }

    /**
     * @return the restar
     */
    public String getRestar() {
        return restar;
    }

    /**
     * @param restar the restar to set
     */
    public void setRestar(String restar) {
        this.restar = restar;
    }

    /**
     * @return the cargar
     */
    public String getCargar() {
        return cargar;
    }

    /**
     * @param cargar the cargar to set
     */
    public void setCargar(String cargar) {
        this.cargar = cargar;
    }

    /**
     * @return the store
     */
    public String getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(String store) {
        this.store = store;
    }

    /**
     * @return the opcodes
     */
    public ArrayList<String> getOpcodes() {
        return opcodes;
    }

    /**
     * @param opcodes the opcodes to set
     */
    public void setOpcodes(ArrayList<String> opcodes) {
        this.opcodes = opcodes;
    }
}
