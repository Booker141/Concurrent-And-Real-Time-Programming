
import java.io.*;
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
public class ficheroSeguro implements Runnable{
    static File file = new File("fichero.txt");
	static RandomAccessFile fichero;
	static Semaphore semaforo = new Semaphore(1);
	private int numerohilo;
	/**
	*Metodo Constructor
	*@param n numero identificador de hilo
	*/
	public ficheroSeguro(int n){this.numerohilo = n;}

	public void run(){
		try{
			semaforo.acquire();
			System.out.println("Escribiendo hilo " + numerohilo);
			try{
				fichero.writeBytes("Escribe el hilo " + numerohilo + " ");
			}catch(IOException e){
				System.out.println("Error en escritura");
			}
			semaforo.release();
		}catch(InterruptedException e){}
	}
	
	public static void main(String[] args)throws Exception{
		try{
			fichero = new RandomAccessFile(file,"rw");
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}
		ExecutorService exe=Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			exe.execute(new ficheroSeguro(i));
		}
		exe.shutdown();
		exe.awaitTermination(1,TimeUnit.DAYS);
		System.out.println("Fichero escrito ");
	}
}
