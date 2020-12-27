/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos;

/**
 *
 * @author USUARIO
 */
public class Silla {

    private int sLibre = 4;

    public synchronized void qSilla(int i) throws InterruptedException {
        while (sLibre == 0) {
            wait();
            System.out.println("Filosofo " + i + " coge una silla");
            sLibre--;

        }
    }

    public synchronized void sSilla(int i) {
        sLibre++;
        System.out.println("Filosofo " + i + " suelta una silla");
        notify();
    }
}
