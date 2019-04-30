/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author SERGIO
 */
/*2. Escriba un programa en java que reciba como argumentos desde la linea
de comandos dos nuumeros naturales n y m y despliegue en pantalla el valor de la
funcion de Ackermann evaluada sobre esos argumentos. Guarde su trabajo en
Ack.java. Desarrolle una pequena tabla (recuerde que debe desarrollar el
documento con WriteLatex) donde escribiria algunas combinaciones de n, m
y Ack(m; n). ¿Que observa en relacion con esta prueba y esta particularisima
funcion? ¿Cree que la concurrencia podria jugar algun papel util para evaluarla
mejor? ¿Por que? Guarde la tabla y sus impresiones en un fichero llamado
analisis.pdf.*/

public class Ack {

	public static int Ackermann(int n,int m){
		if(m==0)return n+1;
		else if(m>0 && n==0)return Ackermann(m-1,1);
		else return Ackermann(m-1,Ackermann(m,n-1));
		
	}
	/**
	*Funcion Main
     * @param args
	*/
	public static void main(String args[]){
            
		int n, m;
                Scanner input = new Scanner(System.in);
                System.out.print("Introduzca un valor para la variable n: ");
                n=input.nextInt();
                System.out.print("Introduzca una valor para la variable m: ");
                m=input.nextInt();
                System.out.println("El resultado de la funcion de Ackermann para esos calores es: " + Ackermann(n,m));
                
	}
}

