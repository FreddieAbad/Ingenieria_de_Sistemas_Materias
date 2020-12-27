/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Filosofo extends Thread {

    private int id;
    private Tenedor izda, dcha;
    private Silla s;

    public Filosofo(int id, Tenedor izda, Tenedor dcha, Silla s) {
        this.id = id;
        this.izda = izda;
        this.dcha = dcha;
        this.s = s;
    }

    public void run() {
        while (true) {
            try {
                s.qSilla(id);
                izda.qTenedor(id);
                dcha.qTenedor(id);
                //comer
                dcha.sTenedor(id);
                izda.sTenedor(id);
                s.sSilla(id);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
