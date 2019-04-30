/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*1. Pruebe los algoritmos de control con variables comunes recogidos en el
guion de practicas numero 5. Familiaricese con la tecnica de control de la
e.m. basada en el uso variables compartidas, con el uso en java de variables
volatile y con las diferentes aproximaciones al algoritmo de Dekker. Modifique
el fichero Dekker.java para que funcione con tres procesos. Guarde su trabajo
en algDekker.java y escriba un corto documento analisis.pdf que recoja el
comportamiento obtenido y su interpretacion del mismo.*/

public class algDekker {
    /* Iteraciones que dara cada hilo */
	    static final int iteraciones = 2000000;
	    /* Recurso compartido */
	    static volatile int enteroCompartido = 0;
	    /* Representa el deseo del hilo P de entrar en la seccion critica */
	    static volatile boolean wantp = false;
	    /* Representa el deseo del hilo Q de entrar en la seccion critica */  
	    static volatile boolean wantq = false;
	    /* Representa el deseo del hilo R de entrar en la seccion critica */
	    static volatile boolean wantr = false;
	    /* Representa de quien es el turno */
	    static volatile int turn = 1;

	    class P extends Thread {
	        public void run() {
	            for (int i=0; i<iteraciones; ++i) {
	                /* Seccion no critica */
	                wantp = true;
	                while (wantq || wantr) {
	                    if (turn == 2 || turn==3) {
	                        wantp = false;
	                        while (turn == 2 || turn==3)
	                            Thread.yield();
	                        wantp = true;
	                    }
	                }
	                
	                /* Seccion critica */
	                enteroCompartido=enteroCompartido+2;
	                
	                /* Fin Seccion critica */
	                
	                turn = 2;
	                wantp = false;
	            }
	        }
	    }
	    
	    class Q extends Thread {
	        public void run() {
	            for (int i=0; i<iteraciones; ++i) {
	                /* Seccion no critica */
	                wantq = true;
	                while (wantp || wantr) {
	                    if (turn == 1 || turn==3) {
	                        wantq = false;
	                        while (turn == 1 || turn==3)
	                            Thread.yield();
	                        wantq = true;
	                    }
	                }
	                
	                /* Seccion critica */
	                --enteroCompartido;
	                /* Fin Seccion critica */
	                
	                turn = 3;
	                wantq = false;
	            }
	        }
	    }
	    class R extends Thread {
	        public void run() {
	            for (int i=0; i<iteraciones; ++i) {
	                /* Seccion no critica */
	                wantr = true;
	                while (wantp || wantq) {
	                    if (turn == 1 || turn==2) {
	                        wantr = false;
	                        while (turn == 1 || turn==2)
	                            Thread.yield();
	                        wantr = true;
	                    }
	                }
	                /* Seccion critica */
	                --enteroCompartido;
	                /* Fin Seccion critica */
	                
	                turn = 1;
	                wantr = false;
	            }
	        }
	    }

	    algDekker() {
	        Thread p = new P();
	        Thread q = new Q();
	        Thread r = new R();
	        p.start();
	        q.start();
	        r.start();
	        try {
	            p.join();
	            q.join();
	            r.join();
	            System.out.println("El valor del recurso compartido es: "  +  enteroCompartido);
	            System.out.println("Deberia ser 0.");
	        }
	        catch (InterruptedException e) {}
	    }

	    public static void main(String[] args) {
	        new algDekker();
	    }
}
