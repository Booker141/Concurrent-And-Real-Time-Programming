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

public class Hexagono extends Poligono {
    private double radio;
	/**
	 * Constructor
	 * @param p Array de Puntos
	 */
	public Hexagono(Punto[] p){
		super(p,6);
		radio=getLado();
	}
	/**
	 * Metodo observador de radio
	 * @return Devuelve el radio en el que esta circunscrito el hexagono
	 */
	public double getRadio(){return radio;}
	/**
	 * Metodo getLado
	 * @return Devuelve el tamano de un lado
	 */
	public double getLado(){
		return Math.sqrt(Math.pow(p[0].x-p[1].x,2)+Math.pow(p[0].y-p[1].y,2));
	}
	/**
	 * Metodo getApotema
	 * @return	Devuelve el tamaÃ±o de la apotema
	 */
	public double getApotema(){
		return Math.sqrt(Math.pow(radio, 2)-(Math.pow((	radio/2), 2)));
	}
	/**
	 * Metodo getArea
	 * @return Devuelve el Area 
	 */
	public double getArea(){
		return (perimetro()*getApotema())/2;
	}
}
