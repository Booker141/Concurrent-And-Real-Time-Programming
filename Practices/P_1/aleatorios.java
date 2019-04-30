/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author SERGIO
 */

/*6. Una tarea que sera de utilidad durante el curso es la generacion de numeros
aleatorios. En Java, esto puede lograrse de dos manera diferentes. Comencemos
ahora por la primera; escriba un programa llamado aleatorios.java que haga uso
del metodo random() de la clase Math para generar una secuencia de numeros
aleatorios. La longitud de la secuencia sera fijada mediante un argumento leido
por el programa desde la linea de comandos de una ventana de terminal.*/

public class aleatorios {
    
	public static int aleatorios(int principio,int fin){
		int numeroAleatorio=(int)Math.floor(Math.random()*(principio-(fin+1))+(fin));
		return numeroAleatorio;
                
	}
        
	public static void main(String[] arg){
            
		Scanner scan = new Scanner(System.in);
		int principio, fin, longitud;
		System.out.println("Introduzca la longitud de la secuencia: ");
		longitud = scan.nextInt();
		System.out.println("Introduzca los valores en los que estaran contenido los aleatorios: ");
		principio = scan.nextInt();
		fin = scan.nextInt();
		for(int i=0;i<longitud;i++){
			System.out.println(aleatorios(principio,fin));
                        
		}
	}
}
