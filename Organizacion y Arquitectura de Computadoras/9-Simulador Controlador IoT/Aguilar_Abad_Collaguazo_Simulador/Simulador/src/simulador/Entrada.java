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
public class Entrada {

    private Memoria memoria;
    private String salida = "";
    private CPU cpu;

    public Entrada(Memoria memoria, CPU cpu) {
        this.memoria = memoria;
        this.cpu = cpu;
    }

    public void guardarDato(String dato) {
        boolean entrar = false;
        if (dato.contains("ADD")) {
            dato = dato.replace("ADD", "1");
            entrar = true;
        } else if (dato.contains("SUB")) {
            dato = dato.replace("SUB", "2");
            entrar = true;
        } else if (dato.contains("LOAD")) {
            dato = dato.replace("LOAD", "3");
            entrar = true;
        } else if (dato.contains("STORE")) {
            dato = dato.replace("STORE", "4");
            entrar = true;
        } else if (dato.contains("JMP")) {
            dato = dato.replace("JMP", "5");
            entrar = true;
        }
        if (dato.contains(" [")) {
            if (dato.contains("]")) {
                dato = dato.replace(" [", "");
                dato = dato.replace("]", "");
            } else {
                entrar = false;
            }
        } else {
            if (dato.contains("]")) {
                entrar = false;
            }
        }
        try {
            if (entrar == true) {

                String operacion[] = dato.split(" ");
                String memtemp[][] = memoria.getMemoria();

                if (operacion.length == 3) {

                    if (operacion[1].equals("4")) {
                        memtemp[Integer.parseInt(operacion[0])][1] = operacion[2];
                    }
                    
                } else if (operacion.length == 2) {
                    if (operacion[1].substring(0).length() == 1) {
                        if (memoria.getOpcodes().contains(operacion[1].substring(0))){
                            setSalida(memoria.getMemoria()[Integer.parseInt(operacion[0])][1]);
                        } 
                    }
                    else if (memoria.getOpcodes().contains(operacion[1].substring(0, 1)) && Integer.valueOf(operacion[1].substring(1)) < 99) {
                        memtemp[Integer.parseInt(operacion[0])][1] = operacion[1];
                    }
                }

            } else {
                cpu.setProgramCounter(Integer.valueOf(dato));
            }
        } catch (Exception e) {
            System.out.println("Entrada error");
        }

    }

    /**
     * @return the salida
     */
    public String getSalida() {
        return salida;
    }

    /**
     * @param salida the salida to set
     */
    public void setSalida(String salida) {
        this.salida = salida;
    }
}
