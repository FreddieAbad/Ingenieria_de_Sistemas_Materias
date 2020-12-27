/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion2FComiendo;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Hilo filósofo. Su método run() realiza un bucle infinito que consite en
 * invocar a los métodos pensar() y comer(): ... -&gt; pensar -&gt; comer ...

 */
public class Filosofo extends Thread {

    /**
     * Índice que identifica al filósofo (un entero del 0 al 4)
     */
    private final int idFilosofo;

    /**
     * Array de semáforos. Cada semáfaro es un palillo.
     */
    private final Semaphore[] palillos_semaforo;

    /**
     * Array de enteros 2 dimensiones. Por cada valor de su primer índice
     * (filas) almacena los palillos que necesita el filósofo de ese índice para
     * comer. Por ejemplo: el filósofo de índice 0 necesita los palillos de
     * índices {0,4}, el de índice 1 los de índices {1,0}, etc...
     */
    private final int[][] palillosFilosofo;

    /**
     * El índice del palillo a la izquierda del filósofo. Se obtiene en el
     * constructor a partir del array de enteros palillosFilósofo.
     */
    private final int palilloIzquierdo;

    /**
     * El índice del palillo a la derecha del filósofo. Se obtiene en el
     * constructor a partir del array de enteros palillosFilósofo.
     */
    private final int palilloDerecho;

    /**
     * Número aleatorio para simular el tiempo que tardan los filósofos en comer
     * y pensar.
     */
    private final Random tiempoAleatorio = new Random();

    /**
     * Constructor de tres parámetros, cada uno de los cuales se guardará en una
     * variable local para usarla cuando sea necesario.
     *
     * @param idFilosofo int: índice que identifica a cada filósofo (entero del
     * 0 al 4).
     * @param palillos_semaforo Semaphore[]: array de semáforos, uno por cada
     * palillo.
     * @param palillosFilosofo int[][]: array de enteros 2 dimensiones. Por cada
     * valor de su primer índice (filas) almacena los palillos que necesita el
     * filósofo de ese índice para comer. Por ejemplo: el filósofo de índice 0
     * necesita los palillos de índices {0,4}, el de índice 1 los de índices
     * {1,0}, etc...
     */
    public Filosofo(int idFilosofo, Semaphore[] palillos_semaforo, int[][] palillosFilosofo) {
        this.idFilosofo = idFilosofo;
        this.palillos_semaforo = palillos_semaforo;
        this.palillosFilosofo = palillosFilosofo;
        this.palilloIzquierdo = palillosFilosofo[idFilosofo][0];
        this.palilloDerecho = palillosFilosofo[idFilosofo][1];
    }

    /**
     * Imprimir un mensaje "Filosófo n está hambriento" mientras trata de
     * conseguir los 2 palillos que necesita para comer. Una vez conseguidos,
     * mostrará un mensaje "Filósofo n está comiendo".&lt;br&gt; Para simular
     * esta actividad, dormirá el hilo un tiempo aleatorio. Cuando termine,
     * mostrará un mensaje "El filósofo n ha terminado de comer", indicando los
     * palillos que quedan libres.
     */
    protected void comer() {
        // El filósofo tratará de coger primero el pallillo de su izquierda.
        // Si lo consigue, tratará entonces de coger el palillo de su derecha
        // El método tryAcquire() adquiere un permiso del semáforo si es
        // posible y devuelve true en ese caso. Devuelve false si no da permiso.
        if (palillos_semaforo[palilloIzquierdo].tryAcquire()) {
            if (palillos_semaforo[palilloDerecho].tryAcquire()) {
                System.out.println("FILÓSOFO " + idFilosofo + " ESTÁ COMIENDO.");
                try {
                    // Simular el tiempo que tarda el filósofo en comer,
                    // entre 0.5 y 1 segundos:
                    sleep(tiempoAleatorio.nextInt(1000) + 500);
                } catch (InterruptedException ex) {
                    System.out.println("Error : " + ex.toString());
                }
                System.out.println("Filósofo " + idFilosofo + " ha terminado de comer.Libera los palillos " + palilloIzquierdo + " y " + palilloDerecho);
                // Ya que ha terminado de comer libera el semáforo-palillo de su derecha:
                palillos_semaforo[palilloDerecho].release();
            }
            // Y libera también el semáforo palillo de su izuierda.
            palillos_semaforo[palilloIzquierdo].release();
        } else { // el filósofo no ha podido coger el pallillo, no puede comer.
            System.out.println("Filósofo " + idFilosofo + " está hambriento.");
        }
    }

    /**
     * Imprimir un mensaje "Filósofo n está pensando". Para simular esta
     * actividad, dormirá el hilo un tiempo aleatorio.
     */
    protected void pensar() {
        System.out.println("Filósofo " + idFilosofo + " está pensando.");
        try {
            // El tiempo que tarda el filósofo en pensar, entre 100 y 1000 milisegundos:
            Filosofo.sleep(tiempoAleatorio.nextInt(1000) + 100);
        } catch (InterruptedException ex) {
            System.out.println("Error en el método pensar(): " + ex.toString());
        }
    }

    /**
     * Bucle infinito: ... -&gt; llamar al método pensar() -&gt; Llamar al
     * método comer() ...
     */
    @Override
    public void run() {
        while (true) {
            pensar();
            comer();
        }
    }
}
