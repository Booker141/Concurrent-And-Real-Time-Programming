
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

/*3. Escriba un programa en java que lea una secuencia de valores numericos
cuya longitud sera determinada por el usuario mediante un parametro transferido
desde la linea de comandos del sistema. El programa leera la secuencia, y
debera calcular e imprimir parametros estadisticos estandar como media, moda,
varianza y desviacion tipica, ofreciendo al usuario un menu (estructurado
mediante switch) donde elegira el estadistico que desea calcular. Guarde su trabajo
en un fichero llamado Estadistica.java. Elabora tambien un documento llamado
estadisticos.pdf, que contendra la expresion matematica de las ecuaciones
que deinen a cada estadistico, y una breve descripcion textual de su significado.*/

public class Estadistica {
    
	private static int[] v;
	private static int tamano;
        
        /**
	*Funcion que calcula la media a partir del vector declarado en la clase 
     * @return 
	*/
        
	public static double media(){
		double solucion=0;
		for (int i=0;i<tamano;i++){
			solucion = solucion + v[i];
		}
		return ((double)solucion/tamano);
	
	}
        
	/**
	*Metodo que calcula la moda 
     * @return 
	*/
        
	public static int moda(){
	int numeroRepeticiones;
	int repeticion=0,numero;
	numero=v[0];
	for(int i=0;i<tamano;i++){
		numeroRepeticiones=0;
		for(int j=0;j<tamano;j++){
			if(v[i]==v[j]){
				numeroRepeticiones=numeroRepeticiones+1;
			}
		}
		if(numeroRepeticiones>repeticion){
			numero=v[i];
			repeticion=numeroRepeticiones;
		}
	}
	return numero;
	}
        
	/**
	*Metodo que calcula la varianza
	*Usa el Metodo media
     * @return 
	*/
        
	public static double varianza(){
		int suma=0;
		for(int i=0;i<tamano;i++){
			suma=suma+(v[i]*v[i]);
		}
		return ((double)((double)suma/tamano)-(media()*media()));
	}
        
	/**
	*Metodo que calcula la desviacion tipica
	*Usa el Metodo Varianza
     * @return 
	*/
        
	public static double desTipica(){
		return Math.sqrt(varianza()); //La desviacion tipica resulta de la raiz cuadrada de la varianza
	}
        
	public static void main(String[] args){
		int op;
		Scanner entrada = new Scanner(System.in);
		tamano = Integer.valueOf(args[0]); //Tamaño vector
		v=new int[tamano];
		System.out.println("Introduce los valores numericos de la secuencia: ");
		for(int i=0; i<tamano;i++){
			System.out.println("Introduce el valor numero " + (i+1) + ":");
			v[i]=entrada.nextInt();
		}
		do{
		System.out.println("Menu:\n1.Media\n2.Moda\n3.Varianza\n4.Desviacion Tipica\n0.Salir");
		op=entrada.nextInt();
		switch(op){
                    
		case 1:	System.out.print(media());
				break;
		case 2:	System.out.print(moda());
				break;
		case 3:	System.out.print(varianza());
				break;
		case 4:	System.out.print(desTipica());
				break;
                                
		}
		}while(op!=0);
		
	}
}

