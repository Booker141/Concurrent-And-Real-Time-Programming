/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.*;
/**
 *
 * @author SERGIO

/*2. Utilizando la clase anterior Poligono, escriba, mediante uso de herencia
por extension de clase, una clase Triangulo.java, que represente a objetos de
este tipo. Dotelo de nuevos metodos propios de la clase, y sobrescriba algunos
de los heredados . Escriba ahora un programa que haga uso de todo lo anterior
llamado UsaTodo.java, y que cree objetos de todas las clases anteriores,
y haga uso de sus metodos. En particular, el programa debe mostrar la compatibilidad
de tipos de la superclase con la subclase. Haga lo propio para clases
Pentagono.java, Cuadrado.java y Hexagono.java.*/

public class Triangulo extends Poligono {
    	double altura;
	/**
	 * Constructor 
	 * @param p Array de puntos que lo representan
	 */
	public Triangulo(Punto[] p){
		
		super(p,3);
		double base=Math.sqrt(Math.pow(p[0].x-p[1].x,2)+Math.pow(p[0].y-p[1].y,2));
		double hipotenusa=Math.sqrt(Math.pow(p[1].x-p[2].x,2)+Math.pow(p[1].y-p[2].y,2));
		this.altura=Math.sqrt(Math.pow(hipotenusa, 2)-Math.pow(base, 2));
	}
	/**
	 * Metodo observador de Altura
	 * @return Devuelve la altura del triangulo
	 */
	public double getAltura(){return altura;}
	/**
	 * Metodo que Calcula el Area
	 * @return Devuelve el Area
	 */
	public double getArea(){
		double base=Math.sqrt(Math.pow(p[0].x-p[1].x,2)+Math.pow(p[0].y-p[1].y,2));
		return (altura*base)/2;
	}
	/**
	 * Metodo que transforma a String
	 */
	public String toString(){
		return p[1]+" "+p[2]+" "+p[3];
	}
}
