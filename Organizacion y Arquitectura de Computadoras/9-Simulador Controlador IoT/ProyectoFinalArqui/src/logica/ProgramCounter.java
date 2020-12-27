/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import tools.OperacionBinario;

/**
 *
 * @author XaviO_o
 */
public class ProgramCounter {

    public int controladorDigito1 = 0;
    public int controladorDigito2 = 0;
    public String hexade1 = "0";
    public String hexade2 = "0";
    OperacionBinario operaciones = new OperacionBinario();
    public String Q0_0 = "0";
    public String Q0_1 = "0";
    public String Q0_2 = "0";
    public String Q0_3 = "0";

    public String Q1_0 = "0";
    public String Q1_1 = "0";
    public String Q1_2 = "0";
    public String Q1_3 = "0";

    public void reset() {
        controladorDigito1 = 0;
        controladorDigito2 = 0;
        
        hexade1 = "0";
        hexade2 = "0";

        Q0_0 = "0";
        Q0_1 = "0";
        Q0_2 = "0";
        Q0_3 = "0";
        Q1_0 = "0";
        Q1_1 = "0";
        Q1_2 = "0";
        Q1_3 = "0";
    }

    public void pulsarClock() {
        System.out.println("hola munfo");
        if (controladorDigito2 < 16) {
            if (controladorDigito1 < 16) {
                
                controladorDigito1++;
                String binario1 = operaciones.cambiarDecimalBinario(controladorDigito1);
                String binario1vec[] = operaciones.cambiarLogitudPalabra(binario1, 4);
                System.out.println(binario1);
                if (binario1vec[0].equals("1")) {
                    Q0_0 = "1";
                }
                if (binario1vec[1].equals("1")) {
                    Q0_1 = "1";
                }
                if (binario1vec[2].equals("1")) {
                    Q0_2 = "1";
                }
                if (binario1vec[3].equals("1")) {
                    Q0_3 = "1";
                }
                hexade1 = operaciones.dec2hexString(controladorDigito1);

            } else {
                controladorDigito2++;
                String binario2 = operaciones.cambiarDecimalBinario(controladorDigito2);
                String binario2vec[] = operaciones.cambiarLogitudPalabra(binario2, 4);
                if (binario2vec[0].equals("1")) {
                    Q1_0 = "1";
                }
                if (binario2vec[1].equals("1")) {
                    Q1_1 = "1";
                }
                if (binario2vec[2].equals("1")) {
                    Q1_2 = "1";
                }
                if (binario2vec[3].equals("1")) {
                    Q1_3 = "1";
                }
                hexade2 = operaciones.dec2hexString(controladorDigito2);
            }
        }
    }

}
