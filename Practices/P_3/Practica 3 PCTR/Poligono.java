/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*1. Utilice la clase Punto.java que tiene disponible en la carpeta de la practica
para escribir una clase Poligono.java.*/

public class Poligono {
    
    private int numeropuntos;
    Punto[] p;
 
    public Poligono(){}
    /**
     * Constructor
     * @param p Array de Puntos
     * @param numeropuntos numero de puntos
     */
    public Poligono(Punto[] p,int numeropuntos){
        
        this.p = new Punto[numeropuntos];
        this.p = p;
        this.numeropuntos = numeropuntos;
 
    }
    /**
     * Metodo observador de puntos
     * @return numero de puntos del poligono
     */
    public int npuntos(){return numeropuntos;}
    /**
     * Metodo nlados
     * @return devuelve el numero de lados del poligono
     */
    public int nlados(){return numeropuntos;}
    /**
     * Metodo el cual calcula el perimetro del poligono 
     * @return double con el perimetro del poligono
     */
    public double perimetro(){
    	double sol=0;
    	for(int i=0;i<numeropuntos;i++){
    		sol=sol+Math.sqrt(Math.pow(p[i%numeropuntos].x-p[(i+1)%numeropuntos].x,2)+Math.pow(p[i%numeropuntos].y-p[(i+1)%numeropuntos].y,2));	
    	}
    	return sol;
    }

  
     
}
