
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*1. Se desea disponer de un sistema remoto para jugar a la BonoLoto.
El servidor genera aleatoriamente seis números entre 1 y 49 que deberán
ser acertados. Los clientes envían una apuesta al servidor con un array que
incluye los seis números que definen la apuesta. El servidor contesta al clien-
te si acertó o no con su apuesta. Implemente una arquitectura RMI que
permita jugar a la BonoLoto en red para estas especificaciones. Guarde su
interfaz en iBonoLoto.java y su servidor y cliente en cBonoLoto.java y
sBonoLoto.java.*/

public class sBonoLoto extends UnicastRemoteObject implements  iBonoLoto{
    Random random = new Random();
	private final int[] premio = new int[6];
    @Override
	public  void resetServidor() throws RemoteException{
		for(int i=0;i<5;i++){
			premio[i] = random.nextInt(48) + 1;
		}
		System.out.println("Numero premiado: ");
		for(int i=0;i<6;i++){
                    System.out.print(premio[i] + "|");
		}
		System.out.println();
	}
	
	public boolean compApuesta(int[] apuesta)throws RemoteException{
		int cont = 0;
		boolean identico = true;
		while(cont<6 && identico){
		identico =(apuesta[cont]==premio[cont]);
		cont++;
		}
		return identico;
	}
	
	public sBonoLoto()throws RemoteException{resetServidor();}
	
	public static void main(String[] args)throws Exception{
		int i = 0;
		Scanner teclado = new Scanner(System.in);
		iBonoLoto remoto = new sBonoLoto();
		Naming.bind("BonoLoto",remoto);
		System.out.println("Servidor listo...");
		
	}
	
}
