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
public class Principal {

    public static void main(String[] args) {
        Silla s = new Silla();
        Tenedor[] tenedores = new Tenedor[5];
        for (int i = 0; i < tenedores.length; i++) {
            tenedores[i] = new Tenedor(i);
        }
        Filosofo[] filosofos = new Filosofo[5];
        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i] = new Filosofo(i, tenedores[i], tenedores[(i + 1) % 5], s);
        }
        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i].start();
        }
    }

}
