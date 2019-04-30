
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*3. La programación de monitores facilita mucho al programador el utilizar
un recurso cuando el monitor ya ha sido previamente programado por
alguien. Ilustraremos esto utilizando el monitor para control de un sistema con
múltiples lectores y escritores disponible en la carpeta de la práctica (Fichero
RWmonitor.java). Modifique el código de modo que las lecturas y escrituras se
hagan sobre un fichero1 de disco externo de números enteros llamado datos.dat.
El nuevo monitor se llamará RWFileMonitor.java. Escriba ahora un diseño de
hilos sobre el monitor anterior que lance varios lectores y escritores concurrentemente,
y guárdelo en UsaRWFileMonitor.java.*/

public class RWFileMonitor {
  static File file = new File("datos.dat");
  static RandomAccessFile fichero;
  volatile int readers = 0;
  volatile boolean writing = false;
  public RWFileMonitor()throws Exception{
    try{
      fichero=new RandomAccessFile(file,"rw");
    }catch(FileNotFoundException e){
      System.out.println("No se ha encontrado el fichero ");
    }
  }
  
  synchronized void StartRead()throws Exception {
    while (writing)
      try {
         wait();
      } catch (InterruptedException e) {}
    readers = readers + 1;
    System.out.println("Lector inicia lectura...");
    notifyAll();
  }

  synchronized void EndRead()throws Exception {
      
      try{
        fichero.seek(0);
        System.out.println(fichero.readLine());
      }catch(IOException e){
        System.out.println("Error de escritura");
      }
    readers = readers - 1;
    if (readers == 0) notifyAll();
    System.out.println("Lector finaliza lectura...");
  }
  
  synchronized void StartWrite()throws Exception {
    while (writing || (readers != 0))
      try {
         wait();
      } catch (InterruptedException e) {}
    writing = true;
    System.out.println("Escritor inicia escritura...");
  }
  
  synchronized void EndWrite() throws Exception{
      try{
        fichero.writeBytes("Escritura del hilo");
      }catch(IOException e){
        System.out.println("Error de escritura");
      }
    writing = false;
    notifyAll();
    System.out.println("Escritor finaliza escritura...");
  }
}
