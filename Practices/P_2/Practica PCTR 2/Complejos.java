/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*4. Utilice arrays para implantar una clase que modele numero complejos.
Dotela de metodos que permitan calcular suma, resta, modulo, producto y cociente.
Guarde su trabajo en Complejos.java. Escriba ahora un programa llamado
usaComplejos.java que presenta un menu de usuario que permitira elegir
la operacion a realizar y posteriormente leera los datos necesarios para hacerla,
ofreciendo finalmente el resultado en pantalla.*/

public class Complejos {
    
    	public double[] n=new double[2];
	public Complejos(){}
	public Complejos(double real,double imag){
		n[0]=real;
		n[1]=imag;
	}
        
	/**
	*Realiza la suma de dos complejos y devuelve la solucion en un Complejo
	*@param b Complejo que se pasa por parametro
     * @return 
	*/
        
	public Complejos suma(Complejos b){
		Complejos c=new Complejos();
		c.n[0]=n[0]+b.n[0];
		c.n[1]=n[1]+b.n[1];
		return c;
	}
        
	/**
	*Realiza la resta de dos complejos y devuelve la solucion en un Complejo
	*@param b Complejo que se pasa por parametro
     * @return 
	*/
        
	public Complejos resta(Complejos b){
		Complejos c=new Complejos();
		c.n[0]=n[0]-b.n[0];
		c.n[1]=n[1]-b.n[1];
		return c;
	}
        
	/**
	*Realiza el modulo del complejo
     * @return 
	*/
        
	public double modulo(){
		return Math.sqrt(n[0]*n[0]+n[1]*n[1]);
	}
        
	/**
	*Realiza el producto de un complejo y un numero p, devuelve la solucion en un complejo
	*@param p double
     * @return 
	*/
        
	public Complejos producto(double p){
		return (new Complejos(n[0]*p,n[1]*p));
	}
        
	/**
	*Realiza el cociente de un complejo entre un double, devuelve la solucion en un complejo
	*@param c double
     * @return 
	*/
        
	public Complejos cociente(double c){
		return (new Complejos(n[0]/c,n[1]/c));
	}
        
	/**
	*Convierte a String la clase complejo
     * @return 
	*/
        
            @Override
	public String toString(){
		return n[0]+"+("+n[1]+")i ";
	}
	
}
