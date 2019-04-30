import java.util.*;
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
public class resImagenParFin implements Runnable {
    	static int tamano = 20000;
	static int imagen[][] = new int[tamano][tamano];
	private int numero;
	public resImagenParFin(int numero){
		this.numero = numero;
	}
	public static void iniciarImagen(){
		Random aleatorio = new Random();
		for(int i=0;i<tamano;i++){
			for(int j=0;j<tamano;j++){
				imagen[i][j] = aleatorio.nextInt(20);
			}
		}
	}
	public static void imprimir(){
		for(int i=0;i<tamano;i++){
			for(int j=0;j<tamano;j++){
				System.out.print(" " + imagen[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void run(){
		int i = numero;
		for(int j=0;j<tamano;j++){
			int ianterior = i-1;
			int janterior = j-1;
			if(janterior<0)janterior = tamano-1;
			if(ianterior<0)ianterior = tamano-1;
			synchronized(imagen){
				imagen[i][j] = (4*imagen[i][j]-imagen[(i+1)%tamano][j]-imagen[i][(j+1)%tamano]-imagen[ianterior][j]-imagen[i][janterior])/8;
			}
		}
	}
	public static void main(String[] args)throws Exception{
		iniciarImagen();
		System.out.println("Imagen inicial:");
		imprimir();
		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); //Preparación del cronometro
		d.setTime(inicCronom); //Activación del cronometro
		ExecutorService pool= Executors.newFixedThreadPool(tamano);
		for(int i=0;i<tamano;i++){
			pool.execute(new resImagenParFin(i));
		}
		pool.shutdown();
		pool.awaitTermination(1,TimeUnit.DAYS);
		long finCronom = System.currentTimeMillis(); //Pausa del cronometro
		d.setTime(finCronom);
		System.out.println("Imagen modificada: ");
		imprimir();
		System.out.println("Tiempo: " + (finCronom - inicCronom) + " milisegundos");
	}
}
