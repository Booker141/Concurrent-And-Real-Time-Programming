/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SERGIO
 */

/*1. Una base de datos de la DGT puede abstraerse de forma elegante mediante
un array de objetos de clase Conductor.java. Desarrolle una clase Conductores.java.
Como toda base de datos, sus elementos deben estar protegidos frente a transacciones
concurrentes sobre los mismos. Para lograr esto, determine un API de
la clase anterior cuyos metodos esten sincronizados y sus datos sean privados.
Escriba ahora un diseno de hilos que haga uso de la base de dato anterior en
usaConductores.java.*/

public class Conductores {
    private static Conductor[] datos = new Conductor[100];
	private static boolean[] ocupado = new boolean[100];

	public Conductores(){
		iniciarVectorOcupado();
	} 



	/**
	*inicializa el vector ocupado a falso
	*/
	private void iniciarVectorOcupado(){
		for(int i=0;i<100;i++)
                    ocupado[i] = false;
	}
	/**
	*Funcion que introduce un conductor en el vector datos
	*@param p Conductor a introducir
	*/
	synchronized void introducirConductor(Conductor p){
		int i = 0;
		while(ocupado[i])
                    i++;
		datos[i] = p;
		ocupado[i] = true;
	}
	/**
	*Funcion que borra un conductor del vector 
	*@param dni variable con la que se busca el donductor a borrar
	*/
	synchronized void borrarConductor(String dni){
		int i = 0;
		while(i<100){
			if(ocupado[i]){
                            if(datos[i].getdni().equals(dni))
                                datos[i]=null;
			}
			i++;
		}	
		
	}
	/**
	*Metodo que busca un conductor y muestra sus datos por la pantalla
	*@param s cadena con el que se busca el Conductor
	*@param op contiene 1 si se esta buscando por dni o 2 si se esta buscando por nombre
	*/
	synchronized void buscarConductor(String string, int opcion){
		int i=0;
		while(i<100){
			if(ocupado[i]){
                            if((datos[i].getdni().equals(string) && opcion==1 )||( datos[i].getnombre().equals(string) && opcion==2))
                                System.out.println(datos[i]);
			}
			i++;
		}
		
	}
}
