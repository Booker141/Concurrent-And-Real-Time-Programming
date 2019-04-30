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

public class resImagenParGru {
    	static int tamano = 20000;
	static int imagen[][]=new int[tamano][tamano];
	private int principio, fin;
	public resImagenParGru(int principio,int fin){
		this.principio = principio;
		this.fin = fin;
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
		for(int i=principio;i<fin;i++){
			for(int j=0;j<tamano;j++){
				int ianterior=i-1;
				int janterior=j-1;
				if(janterior<0)janterior = tamano-1;
				if(ianterior<0)ianterior = tamano-1;
				synchronized(imagen){
					imagen[i][j]=(4*imagen[i][j]-imagen[(i+1)%tamano][j]-imagen[i][(j+1)%tamano]-imagen[ianterior][j]-imagen[i][janterior])/8;
				}
			}
		}
	}
	public static void main(String[] args)throws Exception{
		int nNuc = Runtime.getRuntime().availableProcessors();
		iniciarImagen();
		System.out.println("Imagen inicial: ");
		imprimir();
		int tam = tamano/nNuc;
		int principio = 0;
		int fin = tam-1;
		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); //Preparación del cronometro
		d.setTime(inicCronom); //Activacio del cronometro
		ExecutorService pool = Executors.newFixedThreadPool(nNuc);
		for(int i=0;i<nNuc;i++){
			pool.execute(new resImagenParFin(i));
			principio=fin+1;
			fin=fin+tam;
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
