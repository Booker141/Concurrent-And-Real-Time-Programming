/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

public class monitorCadena_1 {
      private int numeroSlots = 0;
      private Matriz[] buffer;
      private int putIn = 0, takeOut = 0;
      private int contador = 0;
      
      public monitorCadena_1(int numeroSlots) {
        this.buffer = null;
        this.numeroSlots = numeroSlots;
        buffer = new Matriz[numeroSlots];
      }
      
      public synchronized void insertar (double[][] valor) {
        while (contador == numeroSlots)
          try {
            wait();
          } catch (InterruptedException e) {
            System.err.println("Interrupcion del wait()");
          }

        buffer[putIn] = new Matriz();
        putIn = (putIn + 1) % numeroSlots;
        contador++;                   
        notifyAll();  
      }
      
      public synchronized double[][] extraer () {
        Matriz valor;
        while (contador == 0)
          try {
            wait();
          } catch (InterruptedException e) {
            System.err.println("Interrupcion del wait()");
          }
        valor = buffer[takeOut];
        takeOut = (takeOut + 1) % numeroSlots;
        contador--;                           
        notifyAll();
        return valor.Matriz;
      }
}
