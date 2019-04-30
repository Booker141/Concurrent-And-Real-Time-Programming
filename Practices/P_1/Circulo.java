/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package circulo;

/**
 *
 * @author SERGIO
 */

/*1. Escriba un programa en java para calcular el volumen de un cono. Declare
una constante que guarde el valor de pi. Suponga un cono de 14,2 cm de diametro
en la base y de 20 cm de altura . Guardelo en un fichero llamado Circulo.java*/

public class Circulo {
	
	public static double pi=3.14; //Declaración variable pi
	
	
	public static void main(String[] args) {
	
		double diametro=14.2;
                double altura=20;
                double volumen;
		volumen = VolumenCono(diametro,altura);
		System.out.println("El volumen del cono es: " + volumen + " metros cubicos");
		
		
	}
        
        static double VolumenCono(double diam,double alt){
		
		double volumen=0;
		volumen=(pi*(diam/2)*(diam/2)*alt)/3; //volumen= (pi*(radio^2)*altura)/3
		return volumen;
	}
}
