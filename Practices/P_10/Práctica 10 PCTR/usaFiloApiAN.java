
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

/*4. Escriba una solucion al problema de los filosofos utilizando un monitor que em-
plea los recursos del API de alto nivel. Guarde el monitor en filoApiAN.java.
Escriba una tarea Runnable que modele a los cinco filosofos, y activelos mediante
un ejecutor de capaciadad fija. Guarde todo esto en usaFiloApiAn.java.*/

public class usaFiloApiAN implements Runnable {
    
    	private int IDFil;
	public filoApiAN monitor = new filoApiAN();

	public usaFiloApiAN(int IDFil){
		this.IDFil = IDFil;
	}

            @Override
	public void run(){
		monitor.empezarComer(IDFil);
	}

	public static void main(String[] args) {
		int numeroFil = 5;
		ExecutorService ejecutor = Executors.newFixedThreadPool(numeroFil);
		
		for(int j=0; j<numeroFil; j++)
		ejecutor.execute(new usaFiloApiAN(j));
		

	}

}
