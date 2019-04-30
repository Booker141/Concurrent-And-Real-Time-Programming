
import java.io.*;
import java.util.concurrent.locks.ReentrantLock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*2. Utilizando cerrojos de clase ReentrantLock y colas Condition, adapte
con estas herramientas el monitor de los lectores/escritores que utilizo en la
practica anterior. Renombre al monitor como RWMonitorAN.java. Utilicelo de
nuevo para acceder de forma controlada a una fichero externo de disco.*/

public class RWMonitorAN {
    
  volatile int readers = 0;
  volatile boolean writing = false;
  volatile boolean escrito = false;
  private  RandomAccessFile archivo = null;
  private final ReentrantLock cerrojo1 = new ReentrantLock();
  private final ReentrantLock cerrojo2 = new ReentrantLock();

  public RWMonitorAN(){
		try{
                    archivo = new RandomAccessFile("datos.dat", "rw");
		}catch(FileNotFoundException e){System.out.println("No se encontrado el archivo.");}
  }
 
  synchronized void StartRead() {
	  
    while (writing || !escrito)
      try {
         wait();
      } catch (InterruptedException e) {}
    cerrojo1.lock();
    try{
        readers = readers + 1;
    System.out.println("Lector inicia lectura...");
    try{
        try {
                archivo.seek(0);
		archivo.readInt();
	} catch (EOFException e) {
		
		archivo.close();
		
	}
    }catch (IOException e){System.out.println("Problemas con el archivo.");}
    notifyAll();
    }finally{cerrojo1.unlock();}
    EndRead();
  }

  synchronized void EndRead() {
    readers = readers - 1;
    if (readers == 0) notifyAll();
    System.out.println("Lector finaliza lectura...");
  }
 
  synchronized void StartWrite() {
    while (writing || (readers != 0))
      try {
         wait();
      } catch (InterruptedException e) {}
    cerrojo2.lock();
    try{
    writing = true;
    System.out.println("Escritor inicia escritura...");
    try{
        try {
		archivo.seek(archivo.getFilePointer() - 1);
		archivo.writeInt(1);
	
	} catch (EOFException e) {
	
	archivo.close();
	
	}
    System.out.println("Escritura del archivo finalizada ");
    }catch (IOException e){System.out.println("Hubo problemas con el archivo. ");}
    notifyAll();
    }finally{cerrojo2.unlock();}
    EndWrite();
  }

  synchronized void EndWrite() {
    writing = false;
    escrito = true;
    notifyAll();
    System.out.println("Escritor finaliza escritura...");
  }
}
