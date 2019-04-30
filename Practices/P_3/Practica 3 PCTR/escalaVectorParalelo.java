
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

/*4. Se desea realizar el escalado de una vector de n´umero enteros de 108 componentes
Escriba un programa secuencial escalaVector.java que haga el trabajo de escalado. Ahora, escriba una version paralela multihebrada y
llamela escalaVectorParalelo.java. Escriba una tabla (recuerde que debe
desarrollar el documento con WriteLatex) de analisis tablaCPU.java que
debera recoger de forma aproximada los picos de uso maximo de la CPU (en
tanto por ciento) como una funci´on del tama˜no del vector (104, 105, 106...) y del
tipo de procesamiento empleado.*/

public class escalaVectorParalelo extends Thread {
    public static double c;
	static double[] vec = new double[100];
	private int inicioV,finV;
	/**
	 * Constructor 
	 * @param ini Posicion inicial con la que trabajara el Hilo
	 * @param fin Posicion Final con la que trabajara el Hilo
	 */
	public escalaVectorParalelo(int ini,int fin){
		this.inicioV=ini;
		this.finV=fin;
	}
	public void run(){

		for(int i=inicioV;i<finV;i++){
			vec[i]=vec[i]*c;
		}
	
	}
	public static void main(String[] args)throws Exception{
	Scanner entrada = new Scanner(System.in);
	int tam=100/4;
	int inicio=0;
	int fin=tam-1;
	System.out.println("Introduzca la constante: ");
	c = entrada.nextDouble();
	System.out.println("Vector sin escalar");
	for(int i=0;i<(tam*4);i++){
		vec[i]=Math.floor(Math.random()*(0-(10+1))+(10));
		System.out.println(vec[i]);
	}
	escalaVectorParalelo[] h = new escalaVectorParalelo[4];
	for(int i=0;i<4;i++){
		h[i]=new escalaVectorParalelo(inicio,fin);
		inicio=fin+1;
		fin=fin+tam;
	}
	for(int i=0;i<4;i++){
		h[i].start();
	}
	for(int i=0;i<4;i++){
		h[i].join();
	}
	System.out.println("Vector Escalado");
	for(int i=0;i<(tam*4);i++)System.out.println(vec[i]);
	
	}	
}
