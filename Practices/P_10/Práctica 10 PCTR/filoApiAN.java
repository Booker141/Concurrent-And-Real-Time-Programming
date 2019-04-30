
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*4. Escriba una solucion al problema de los filosofos utilizando un monitor que em-
plea los recursos del API de alto nivel. Guarde el monitor en filoApiAN.java.
Escriba una tarea Runnable que modele a los cinco filosofos, y activelos mediante
un ejecutor de capaciadad fija. Guarde todo esto en usaFiloApiAn.java.*/

public class filoApiAN {
    
    static Semaphore[] tenedor = new Semaphore[5];

	public filoApiAN(){
		for(int i=0; i<5; i++)
			tenedor[i]= new Semaphore(1);
	}
        
	/**
	 * Metodo empezarComer
         * Empieza a comer cuando tenga dos tenedores
	 * @param IDFil numero identidad del filosofo
	 */
        
	public synchronized void empezarComer(int IDFil){
		System.out.println("Filosofo " + IDFil + " meditando...");
		try {
			tenedor[IDFil].acquire();
			tenedor[(IDFil+1)%5].acquire();
		} catch (InterruptedException e) {}
		finComer(IDFil);
	}
        
	/**
	 * Metodo finComer
	 * Termina de comer y medita
	 * @param IDFil numero identidad del filosofo
	 */
        
	public void finComer(int IDFil){
		try{
			System.out.println("Filosofo " + IDFil + " comiendo...");
			tenedor[IDFil].release();
			tenedor[(IDFil+1)%5].release();
		}catch(Exception e){}
	}
	
}
