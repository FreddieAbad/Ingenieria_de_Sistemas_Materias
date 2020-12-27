/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

/**
 *
 * @author XaviO_o
 */
public class Comunicador {
    private Memoria memoria;
    private Entrada entrada;
    private CPU cpu;

    public Comunicador() {
        memoria = new Memoria();
        cpu = new CPU(memoria);
        entrada = new Entrada(getMemoria() , getCpu());
    }

    /**
     * @return the memoria
     */
    public Memoria getMemoria() {
        return memoria;
    }

    /**
     * @param memoria the memoria to set
     */
    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }
    
    public void guardarDato(String dato){
        getEntrada().guardarDato(dato);
    }
    
    public void ejecutarSiguiente(boolean contador){
        if (!contador && cpu.getRegistroInstruccion() != 0) {
            cpu.unidadControl();
        }else{
            cpu.setMAR(cpu.getProgramCounter());
            cpu.setMDR(Integer.valueOf(memoria.getMemoria()[cpu.getMAR()][1]));
            cpu.setRegistroInstruccion(cpu.getMDR());
            cpu.setProgramCounter(cpu.getProgramCounter() + 1);
        }
        
    }
    
    public void vaciar() {
        this.memoria.vaciarMemoria();
        this.cpu.vaciarCPU();
    }

    /**
     * @return the entrada
     */
    public Entrada getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the cpu
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * @param cpu the cpu to set
     */
    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    
    
    
}
