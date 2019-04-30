
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

public class CPiMonteCarlo {
    	public static void main(String []arg)throws Exception{
            
		Scanner teclado = new Scanner(System.in);
		
		int opcion = 10;
		int puntos;
		iPiMonteCarlo RefORemoto = (iPiMonteCarlo)Naming.lookup("//localhost/Servidor");
		while(opcion!=0){
		System.out.print("Menu\n1.Incluir mas puntos a la aproximacion\n2.Reset\n0.Salir\n");
		opcion = teclado.nextInt();
		switch(opcion){
		case 1:
			System.out.println("Numero de puntos a incluir en la aproximacion: ");
			puntos = teclado.nextInt();
			RefORemoto.masPuntos(puntos);
			
			break;
		case 2:
			RefORemoto.reset();
			System.out.println("Servidor a 0");
			 
			break;
		}
		}
	}
}
