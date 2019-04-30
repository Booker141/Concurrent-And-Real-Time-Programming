
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

/*2. Utilizando la clase anterior Poligono, escriba, mediante uso de herencia
por extension de clase, una clase Triangulo.java, que represente a objetos de
este tipo. Dotelo de nuevos metodos propios de la clase, y sobrescriba algunos
de los heredados . Escriba ahora un programa que haga uso de todo lo anterior
llamado UsaTodo.java, y que cree objetos de todas las clases anteriores,
y haga uso de sus metodos. En particular, el programa debe mostrar la compatibilidad
de tipos de la superclase con la subclase. Haga lo propio para clases
Pentagono.java, Cuadrado.java y Hexagono.java.*/

public class UsaTodo {
    public static void main(String[] args){
		double x,y;
		Scanner entrada = new Scanner(System.in);
		Punto[] p=new Punto[3];
		
		System.out.println("Introduzca las coordenadas del punto 1: ");
		x=entrada.nextDouble();
		y=entrada.nextDouble();
		p[1]=new Punto(x,y);
		
		System.out.println("Introduzca las coordenadas del punto 2: ");
		x=entrada.nextDouble();
		y=entrada.nextDouble();
		p[2]=new Punto(x,y);
		
		System.out.println("Introduzca las coordenadas del punto 3: ");
		x=entrada.nextDouble();
		y=entrada.nextDouble();
		p[3]=new Punto(x,y);
		
		Triangulo tri = new Triangulo(p);
		System.out.println("El perimetro es: " + tri.perimetro());
		System.out.println("El Area es: " + tri.getArea());
	}
}
