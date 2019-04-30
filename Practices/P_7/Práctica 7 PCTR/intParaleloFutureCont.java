

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
public class intParaleloFutureCont implements Callable<Integer> {
    private int veces;
	private double Ay,Ax,y1;
	private Random r;
	/**
	*Metodo constructor
	*@param n numero de puntos que va a general el hilo
	*/
	public intParaleloFutureCont(int n){
		this.veces=n;
		this.r=new Random();
	}
	/**
	*Metodo call
	*@return cont numero de punto dentro de la funcion
	*/
	public Integer call(){
		int cont=0;
		for(int i=0;i<veces;i++){
			Ax=r.nextDouble();
			Ay=r.nextDouble();
			y1=Math.sin(Ax);
			if(Ay<y1){
					cont++;
			}
		}
		return cont;
	}
	/**
	*Metodo de Subramanian
	*@param Nn numero de cores de la maquina
	*@param cb coeficiente de bloqueo
	*@return res numero de hilos a usar en el programa
	*/
	public static int Subramanian(int Nn,double cb){
		double Nt;
		int res;
		Nt=(double)Nn/(1-cb);
		System.out.println("Se ejecutaran " + Nt + " Hilos");
		res=(int)Math.round(Nt);
		
		return res;
	}
	public static void main(String[] args)throws Exception{
		int cont = 0;
		int n = 10000;
		int nt = Subramanian(Runtime.getRuntime().availableProcessors(),0.5);
		ExecutorService exe=Executors.newFixedThreadPool(nt);
		ArrayList<Future<Integer>> solucion= new ArrayList<Future<Integer>>();
		System.out.println("Se van a lanzar " + n + " puntos");
		Date d = new Date();
   		long inicCronom = System.currentTimeMillis(); //Preparacion del cronometro
    	d.setTime(inicCronom); //Activacion del cronometro
		for(int i=0;i<nt;i++){
			solucion.add(exe.submit(new intParalelaFutureCont(n/nt)));
		}
		exe.shutdown();
		exe.awaitTermination(1,TimeUnit.DAYS);
		long finCronom = System.currentTimeMillis(); //se para el cronometro
    	d.setTime(finCronom);
  		System.out.println("Tiempo: " + (finCronom - inicCronom) + " milisegundos");
		for(Future<Integer> iter: solucion){
			cont=cont+iter.get();
		}
		System.out.println("Aproximacion de la integral de f(x)=sin(x): " + ((double)cont/n));

	}
}
