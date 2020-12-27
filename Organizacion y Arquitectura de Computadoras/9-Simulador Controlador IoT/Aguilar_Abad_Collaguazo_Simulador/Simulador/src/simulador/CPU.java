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
public class CPU {

    private int programCounter = 0;
    private int registroInstruccion = 0;
    private int MAR = 0;
    private int MDR = 0;
    private int controlUnit = 0;
    private int acumulador = 0;
    private int ALU = 0;

    private Memoria mem;

    public CPU(Memoria men) {
        this.mem = men;
    }

    public void unidadControl() {
        setControlUnit(getRegistroInstruccion());
        String opcode = String.valueOf(getControlUnit()).substring(0, 1);
        String pos = String.valueOf(getControlUnit()).substring(1);
        if (opcode.equals(getMem().getOpcodes().get(2))) {
            MAR = Integer.valueOf(pos);
            MDR = Integer.valueOf(mem.getMemoria()[MAR][1]);
            acumulador = MDR;
        } else if (opcode.equals(getMem().getOpcodes().get(0))) {
            ALU = acumulador;
            MAR = Integer.valueOf(pos);
            MDR = Integer.valueOf(mem.getMemoria()[MAR][1]);
            acumulador = MDR;
            ALU += acumulador;
            acumulador = ALU;
        } else if (opcode.equals(getMem().getOpcodes().get(3))) {
            MAR = Integer.valueOf(pos);
            MDR = acumulador;
            mem.getMemoria()[MAR][1] = String.valueOf(MDR);
        } else if (opcode.equals(getMem().getOpcodes().get(4))) {
            MAR = Integer.valueOf(pos);
            MDR = Integer.valueOf(mem.getMemoria()[MAR][1]);
            programCounter = MAR;
        } else if (opcode.equals(getMem().getOpcodes().get(1))) {
            ALU = acumulador;
            MAR = Integer.valueOf(pos);
            MDR = Integer.valueOf(mem.getMemoria()[MAR][1]);
            acumulador = MDR;
            ALU -= acumulador;
            acumulador = ALU;
        }

    }

    public void vaciarCPU() {
        int programCounter = 0;
        int registroInstruccion = 0;
        int MAR = 0;
        int MDR = 0;
        int controlUnit = 0;
        int acumulador = 0;
        int ALU = 0;
    }

    /**
     * @return the programCounter
     */
    public int getProgramCounter() {
        return programCounter;
    }

    /**
     * @param programCounter the programCounter to set
     */
    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

    /**
     * @return the registroInstruccion
     */
    public int getRegistroInstruccion() {
        return registroInstruccion;
    }

    /**
     * @param registroInstruccion the registroInstruccion to set
     */
    public void setRegistroInstruccion(int registroInstruccion) {
        this.registroInstruccion = registroInstruccion;
    }

    /**
     * @return the MAR
     */
    public int getMAR() {
        return MAR;
    }

    /**
     * @param MAR the MAR to set
     */
    public void setMAR(int MAR) {
        this.MAR = MAR;
    }

    /**
     * @return the MDR
     */
    public int getMDR() {
        return MDR;
    }

    /**
     * @param MDR the MDR to set
     */
    public void setMDR(int MDR) {
        this.MDR = MDR;
    }

    /**
     * @return the controlUnit
     */
    public int getControlUnit() {
        return controlUnit;
    }

    /**
     * @param controlUnit the controlUnit to set
     */
    public void setControlUnit(int controlUnit) {
        this.controlUnit = controlUnit;
    }

    /**
     * @return the mem
     */
    public Memoria getMen() {
        return getMem();
    }

    /**
     * @param men the mem to set
     */
    public void setMen(Memoria men) {
        this.setMem(men);
    }

    /**
     * @return the acumulador
     */
    public int getAcumulador() {
        return acumulador;
    }

    /**
     * @param acumulador the acumulador to set
     */
    public void setAcumulador(int acumulador) {
        this.acumulador = acumulador;
    }

    /**
     * @return the mem
     */
    public Memoria getMem() {
        return mem;
    }

    /**
     * @param mem the mem to set
     */
    public void setMem(Memoria mem) {
        this.mem = mem;
    }

    /**
     * @return the ALU
     */
    public int getALU() {
        return ALU;
    }

    /**
     * @param ALU the ALU to set
     */
    public void setALU(int ALU) {
        this.ALU = ALU;
    }

}
