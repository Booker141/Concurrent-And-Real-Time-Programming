/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package newtonraphson;

/**
 *
 * @author SERGIO
 */

/*2. Escriba un programa en java para encontrar el cero de una funcion f(x)
mediante el metodo de Newton-Raphson. Este metodo iterativo construye una
sucesion x0, x1, x2, ... de aproximaciones a la solucion utilizando la formula.
La aproximacion inicial sera introducida por teclado, junto con el numero de
iteraciones que permitiran obtener la aproximacion a la raız de la funcion f(x).
El programa ira imprimiendo en pantalla las sucesivas aproximaciones que va
calculando. Aplique su programa a las funciones siguientes:

f(x) = cos(x) − x^3 en[0,1].
f(x) = x^2 - 5 en [2,3].

Guarde su programa en un fichero llamado NewtonRaphson.java*/

import java.util.*;


public class NewtonRaphson{
    
	public static double funcion1(int n, double aproximacion){
            
		double solucion = aproximacion;
		for(int i=0;i<n;i++){
			solucion = solucion -((Math.cos(solucion)-solucion*solucion*solucion)/((solucion*-1)*Math.cos(solucion)-3*solucion*solucion));	
		}
		return solucion;
                
	}
        
	public static double funcion2(int n, double aproximacion){
            
		double solucion = aproximacion;
		for(int i=0;i<n;i++){
			solucion = solucion -((solucion*solucion-5)/(2*solucion));	
		} 
		return solucion;
	}

	public static void main(String[] args){
            
		Scanner scan = new Scanner(System.in);
		double aprox;
		int n;
		
		
		do{
		System.out.println("Introduzca la aproximacion de f(x)= cos(x)- x^3 en el intervalo [0,1]: ");
		aprox=scan.nextDouble();
		}while(aprox<0 || aprox>1);
		System.out.println("Introduzca numero de repeticiones: ");
		n = scan.nextInt();
		System.out.println("La aproximacion para " + n + " veces es: " + funcion1(n,aprox));
		
		
		do{
		System.out.println("Introduzca la aproximacion f(x)= x^2-5 en el intervalo [2,3]: ");
		aprox = scan.nextDouble();
		}while(aprox<2 || aprox>3);
		System.out.println("Introduzca numero de veces: ");
		n = scan.nextInt();
		System.out.println("La aproximacion para " + n + " veces es: " + funcion2(n,aprox));
		

	}

}