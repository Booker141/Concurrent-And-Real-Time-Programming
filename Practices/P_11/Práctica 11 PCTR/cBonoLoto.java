
import java.rmi.Naming;
import java.util.Scanner;

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

public class cBonoLoto {
    	public static void main(String[] args)throws Exception{
		Scanner teclado = new Scanner(System.in);
		int[] bono = new int [6];
		boolean ConPremio;
		System.out.println("Introduzca los numeros de la bonoLoto: ");
		for(int i=0;i<6;i++){
			bono[i] = teclado.nextInt();
		}
		iBonoLoto ref = (iBonoLoto)Naming.lookup("//localhost/BonoLoto");
		ConPremio = ref.compApuesta(bono);
		if(ConPremio){
			System.out.println("¡Enhorabuena! ");
		}
		else{
			System.out.println("Lo sentimos, no ha tocado");
		}
	}
}
