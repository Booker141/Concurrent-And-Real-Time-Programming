
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
public class calculopiParalelouniCont implements Runnable {
    	private int veces;
	private double Ay,Ax,y1;
	private Random r;
	static Object o = new Object();
	static volatile int cont=0;
	/**
	*Constructor
	*@param n numero de puntos a lanzar
	*/
	public calculopiParalelouniCont(int n){
		this.veces=n;
		this.r = new Random();
	}

	public void run(){

		for(int i=0;i<veces;i++){
			Ax=r.nextDouble();
			Ay=r.nextDouble();
			if(Math.pow(Ax, 2)+Math.pow(Ay, 2)<=1){
				synchronized(o){
					cont++;
				}
			}
		}
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
		System.out.println("se ejecutaran " + Nt + " Hilos");
		res=(int)Math.round(Nt);
		
		return res;
	}
	public static void main(String[] args)throws Exception{
		int n=100000;
		int nt=Subramanian(Runtime.getRuntime().availableProcessors(),0.5);
		ExecutorService exe=Executors.newFixedThreadPool(nt);

		System.out.println("Se van a lanzar " + n + " puntos");
		Date d = new Date();
   		long inicCronom = System.currentTimeMillis(); //Preparacion del cronometro
    	d.setTime(inicCronom); //Activacion del cronometro
		for(int i=0;i<nt;i++){
			exe.execute(new calculopiParalelouniCont(n/nt));
		}
		exe.shutdown();
		exe.awaitTermination(1,TimeUnit.DAYS);
		long finCronom = System.currentTimeMillis(); //Pausa del cronometro
    	d.setTime(finCronom);
  		System.out.println("Tiempo: " + (finCronom - inicCronom) + " milisegundos");
		System.out.println("Aproximacion de la integral: " + (4*(double)cont/n));

	}
}
