/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*3. Utilizando herencia de la clase Thread, genere una condicion de concurso
sobre una variable comun n (valor inicial 0) entre dos hilos que respectivamente
incrementen y decrementen el mismo numero de veces a n. Active ambos hilos
concurrentemente utilizando una co-rutina y compruebe que, aunque el valor
teorico final debe ser cero, en la practica no tiene por que ser ası. Guarde su
codigo en Hilo.java y Usa Hilo.java. Escriba una corta tabla de prueba junto
con el analisis de lo ocurrido en un documento en tabla.pdf (recuerde que
debe desarrollar el documento conWriteLatex) donde recogera el numero
de iteraciones que realizaron los hilos y el valor final obtenido para n.*/

public class Hilo extends Thread {
    private final int tipodeHilo; 
    public static int n=0; 
    private final int numVueltas; 
    /**
     * Constructor
     * @param numVueltas numero de veces que se va a repetir
     * @param tipodeHilo 0 hilo p que incrementa, 1 hilo q que decrementa
     */
    public Hilo(int numVueltas, int tipodeHilo) 
    {
    this.numVueltas = numVueltas; 
    this.tipodeHilo = tipodeHilo;
    } 
 
    @Override
    public void run() 
    { 
      switch(tipodeHilo){ 
        case 0: for(int i=0; i<numVueltas; i++)n++; break; 
        case 1: for(int i=0; i<numVueltas; i++)n--; break; 
      } 
 
    } 
  
}
