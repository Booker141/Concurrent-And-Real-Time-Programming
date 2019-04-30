
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
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

/*3. Se desea efectuar el cálculo remoto de la aproximación a pi mediante
el ya conocido método de Monte-Carlo. Para desarrollar esta aproximación
distribuida, un cliente RMI enviará una petición remota al servidor que efec-
túa el cálculo, indicándole con cuántos puntos contribuye al mismo. Diferen-
tes cliente podrán, mediante sus respectivas llamadas al servidor, contribuir
a mejorar la aproximación remota, que sera única y de precisión crecien-
te. El servidor deberá ofrecer también un método de reset(), que cual-
quier cliente podrá invocar para reiniar el cálculo. Escriba una arquitetura
RMI completa con ficheros. iPiMonteCarlo.java, CPiMonteCarlo.java y
SPiMonteCarlo.java.*/

public class SPiMonteCarlo extends iPiMonteCarlo {
    	Random random = new Random();
	private int contador = 0;
	private int puntos = 0;
	private double aproximacion = 0;
	static ReentrantLock cerrojo = new ReentrantLock();
	public SPiMonteCarlo()throws RemoteException{super();}
	
	public void reset()throws RemoteException{
		cerrojo.lock();
		try{
                    contador = 0;
                    puntos = 0;
		}finally{cerrojo.unlock();}
	}
	public void masPuntos(int nPuntos)throws RemoteException{
		double x,y;
		cerrojo.lock();
		try{
			puntos = puntos + nPuntos;
			for(int i=0;i<nPuntos;i++){
				x = random.nextDouble();
				y = random.nextDouble();
				if((y*y)<(1-(x*x))){
				contador++;
				}
			}
			aproximacion =(double)4*contador/puntos;
			System.out.println("La aproximacion a pi es: " + aproximacion +  " con numero de puntos: " + puntos);
		}finally{cerrojo.unlock();}
		
		
		
	}
	public static void main(String []arg)throws Exception{
	
		SPiMonteCarlo ORemoto = new SPiMonteCarlo();
		Naming.bind("Servidor", (Remote) ORemoto);
		System.out.println("Sevidor Remoto listo...");
		
	
	}

}
