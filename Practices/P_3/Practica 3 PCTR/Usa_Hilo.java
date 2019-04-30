
import java.io.PrintStream;

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

public class Usa_Hilo extends Thread {
    
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception 
		  { 
		  	  int n=10000;
		      Thread p = new Thread((Runnable) new Hilo(n,0)); 
		      Thread q = new Thread((Runnable) new Hilo(n,1)); 
		      p.start(); 
		      q.start(); 
		      p.join(); 
		      q.join(); 
                      System.out.println(Hilo.n); 
		  } 

}
