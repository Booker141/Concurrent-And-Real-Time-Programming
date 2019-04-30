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

public class Cuadrado extends Poligono {
    	double lado;
	/**
	 * Constructor 
	 * @param p	Array de puntos
	 */
	public Cuadrado(Punto[] p){
		super(p,4);
		lado=Math.sqrt(Math.pow(p[0].x-p[1].x,2)+Math.pow(p[0].y-p[1].y,2));
	}
	/**
	 * Metodo observador de lado
	 * @return El lador del Poligono
	 */
	public double getLado(){return lado;}
	/**
	 * Metodo getArea
	 * @return double Devuelve el Area
	 */
	public double getArea(){return lado*lado;}
	/**
	 * Metodo sobreescrito que calcula el perimetro
	 * @return Devuelve el Perimetro
	 */
	public double perimetro(){return lado*4;}
    
}
