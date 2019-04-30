
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

/*4. Se desea realizar el escalado de un vector de numero enteros de 108 componentes
Escriba un programa secuencial escalaVector.java que haga el trabajo de escalado. Ahora, escriba una version paralela multihebrada y
llamela escalaVectorParalelo.java. Escriba una tabla (recuerde que debe
desarrollar el documento con WriteLatex) de analisis tablaCPU.java que
debera recoger de forma aproximada los picos de uso maximo de la CPU (en
tanto por ciento) como una funci´on del tama˜no del vector (104, 105, 106...) y del
tipo de procesamiento empleado.*/

public class escalaVector {
    /**
	 * Metodo que escala el vector
	 * @param v vector a escalar 
	 * @param d Factor de escalado
	 * @return Vector Escalado
	 */
	public static double[] escala(double[] v,double d){
		double[] vector = v;
		for(int i=0;i<v.length;i++){
			vector[i] = vector[i]*d;
		}
		return vector;
	}

public static void main(String[] arg){
	Scanner entrada = new Scanner(System.in);
	int longitud = 5;
	double[] vec = new double[longitud];
	double d;
	System.out.println("Introduce el factor de escalado: ");
	d = entrada.nextDouble();
	System.out.println("Vector sin escalar");
	for(int i=0;i<longitud;i++){
		vec[i]=Math.floor(Math.random()*(0-(10+1))+(10));
		System.out.println(vec[i]);
	}
	vec=escala(vec,d);
	System.out.println("Vector Escalado");
	for(int i=0;i<longitud;i++)
            System.out.println(vec[i]);
}
}
