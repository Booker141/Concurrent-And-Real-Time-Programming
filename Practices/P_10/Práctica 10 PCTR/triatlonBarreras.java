
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
public class triatlonBarreras implements Runnable {
    	CyclicBarrier barrera1 = null;
	CyclicBarrier barrera2 = null;
	CyclicBarrier barrera3 = null;
	private int numCorredor;
	private int tDormir;
	public static long[] tiempo = new long[100];
        
	/**
	 * Constructor del triatlon
	 * @param barrera barrera que posee el numero de corredores que han de esperar en ella
	 * @param IDCorredor numero identificador del corredor y a su vez del hilo que lo simula
	 * @param tSleep tiempo que estara en la funcion sleep
	 */
        
	public triatlonBarreras(CyclicBarrier barrera, int IDCorredor,int tSleep){
		barrera1 = barrera;
		barrera2 = barrera;
		barrera3 = barrera;
		this.numCorredor = IDCorredor;
		this.tDormir = tSleep;
		
		
	}

	public void run(){
            
                        Date date = new Date();
                        try{int i = barrera1.await();}
			catch(BrokenBarrierException e){}
			catch(InterruptedException e){}
			long inicioCronom = System.currentTimeMillis(); //Preparacion del cronometro
			date.setTime(inicioCronom);
                        
			try{
                                wait(tDormir);
			}catch(Exception e){}
                        
			long finalCronom = System.currentTimeMillis(); //Pausa del cronometro
			date.setTime(finalCronom);
			tiempo[numCorredor] = (finalCronom-inicioCronom);
			System.out.println("Ha superado el corredor numero " + numCorredor + " la posta de natacion");
			
			
			
			try{int j = barrera2.await();}
			catch(BrokenBarrierException e){}
			catch(InterruptedException e){}
			inicioCronom = System.currentTimeMillis(); //Preparacion del cronometro
			date.setTime(inicioCronom);
                        
			try{
                                wait(tDormir);
			}catch(Exception e){}
                        
			finalCronom = System.currentTimeMillis(); //Pausa del cronometro
			date.setTime(finalCronom);
			tiempo[numCorredor]=tiempo[numCorredor]+(finalCronom-inicioCronom);
			System.out.println("Ha superado el corredor numero " + numCorredor + " la posta de carrera ciclista");
			
			
			try{int h = barrera3.await();}
			catch(BrokenBarrierException e){}
			catch(InterruptedException e){}
			inicioCronom = System.currentTimeMillis(); //Preparacion del cronometro
			date.setTime(inicioCronom);
                        
			try{
				wait(tDormir);
			}catch(Exception e){}
                        
			finalCronom = System.currentTimeMillis(); //Pausa del cronometro
			date.setTime(finalCronom);
			tiempo[numCorredor]=tiempo[numCorredor]+(finalCronom-inicioCronom);
			System.out.println("Ha superado el corredor " + numCorredor + " la posta de carrera a pie");
			System.out.println("Tiempo total del corredor numero " + numCorredor + " : " + tiempo[numCorredor] );
		
		
	}

	public static void main(String []arg){
		Random random = new Random();
		int numeroCorredores = 100;
		CyclicBarrier barrera = new CyclicBarrier(numeroCorredores);
		Thread a[]=new Thread[numeroCorredores];
	    
	    for(int i=0;i<numeroCorredores;i++){
	    	a[i] = new Thread(new triatlonBarreras(barrera,i,(random.nextInt()+500)));
	    	a[i].start();
	    	
	    }
	    for(int i=0;i<numeroCorredores;i++){
                
	    	try{
	    		a[i].join();
	    	}catch(InterruptedException e){}
	    }
	    long mejorTiempo = tiempo[0];
	    int Corredor = 0;
		for(int i=1;i<100;i++){
			if(mejorTiempo>tiempo[i]){
				mejorTiempo = tiempo[i];
				Corredor = i;
			}
		}
		System.out.println("El mejor tiempo lo tiene el corredor " + Corredor + " con un tiempo de " + mejorTiempo);
	}

}
