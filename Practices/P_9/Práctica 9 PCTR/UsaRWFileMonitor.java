
import java.util.concurrent.*;

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

public class UsaRWFileMonitor implements Runnable {
    static RWFileMonitor monitor;
	private final int numeroHilo;
	/**
	*Metodo Constructor
	*@param n identificador del hilo
	*/
	public UsaRWFileMonitor(int n){this.numeroHilo = n;}
	/**
	*Metodo del hilo
	*/
    @Override
	public void run(){
		try{
		switch(numeroHilo){
			case 0:
			monitor.StartWrite();
			monitor.EndWrite();
			break;
			case 1:
			monitor.StartRead();
			monitor.EndRead();
			break;
		}
		}catch(Exception e){}
	}
	
	public static void main(String[] args)throws Exception{
		monitor = new RWFileMonitor();
		ExecutorService exe=Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			exe.execute(new UsaRWFileMonitor(i%2));
		}
		exe.shutdown();
		exe.awaitTermination(1,TimeUnit.DAYS);

	}
}
