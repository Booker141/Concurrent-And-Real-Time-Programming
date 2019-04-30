
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

/*3. La integral definida en [0âˆ’1] de una funcion real de variable real f(x) puede
calcularse mediante un metodo de Monte Carlo (probabilÄ±stico) inscribiendo
la curva de la funcion en un cuadrado de lado igual a la unidad. Para aproximar
el valor de la integral, se generan puntos aleatorios en el marco determinado por
el cuadrado, y se cuentan unicamente aquellos puntos que estan situados bajo
la curva. La razon entre el numero de puntos bajo la curva y el numero total
de puntos es una aproximacion al valor buscado que naturalmente, conforme
mayor es el numero de puntos, mejora la aproximacion. Escriba un programa
java que permita realizar tal calculo, leyendo desde teclado el numero de puntos
con el cual genera la aproximacion para las funciones siguientes:
f(x) = sin(x)
f(x) = x
Guarde el programa en intDefinidaMonteCarlo.java*/

public class intDefinidaMonteCarlo{

	public static void main (String[] args) {
            
		Scanner scan = new Scanner(System.in);
		double X=0, Y=0, y1, y2;
		int puntosSc = 0, puntosBc = 0, totalpuntos = 0;
		System.out.println("Introduzca el numero de puntos: ");
		totalpuntos = scan.nextInt();
		for(int i=0; i<totalpuntos; i++){
			X = Math.random();
			Y = Math.random();
			y1 = Math.sin(X);
			y2 = X;
			if(Y<y1)
                            puntosSc++;
			if(Y<y2)
                            puntosBc++;
			
		}
		
		System.out.println("Aproximacion de la integral de f(x)= sin(x) :" + ((double)puntosSc/totalpuntos));
		System.out.println("Aproximacion de la integral de f(x)= x :" + ((double)puntosBc/totalpuntos));
		

	}

}
