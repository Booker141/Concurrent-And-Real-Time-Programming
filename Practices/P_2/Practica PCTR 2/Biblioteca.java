
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

/*1. Escriba una clase en java para modelar la entidad Paciente (de una consulta
medica), y que considere al menos los atributos siguientes: nombre, dni, direcci
on, telefono y compania de seguros. Guarde su trabajo en Paciente.java. Modele
ahora una consulta abstrayendola como una coleccion de paciente. Disene
un menu de usuario que permite insertar, borrar y consultar pacientes utilizando
diferentes parametros de busqueda. Guarde su trabajo en Biblioteca.java*/

public class Biblioteca {
    
    private static Paciente[] Datos=new Paciente[100];
	private static boolean[] ocupado=new boolean[100];
	/**
	*inicializa el vector auxiliar de boolean a falso
	*/
	static void iniciarOcupados(){
		for(int i=0;i<100;i++)ocupado[i]=false;
	}
	/**
	*Funcion que introduce el paciente en el vector de datos
	*@param p instancia del objeto paciente a introducir
	*/
	static void introducirPaciente(Paciente p){
		int i=0;
		while(ocupado[i])i++;
		Datos[i]=p;
		ocupado[i]=true;
	}
	/**
	*Funcion que borra un paciente del vector de Pacientes
	*@param dni parametro con el que se busca el paciente a borrar
	*/
	static void borrarPaciente(String dni){
		int i=0;
		while(i<100){
			if(ocupado[i]){
			if(Datos[i].getdni().equals(dni))Datos[i]=null;
			}
			i++;
		}	
		
	}
	/**
	*Metodo que busca un paciente y muestra sus datos por la pantalla
	*@param s String con el que se busca el paciente
	*@param op contiene 1 si se esta buscando por dni o 2 si se esta buscando por nombre
	*/
	static void buscarPaciente(String s,int op){
		int i=0;
		while(i<100){
			if(ocupado[i]){
			if((Datos[i].getdni().equals(s) && op==1 )||( Datos[i].getnombre().equals(s) && op==2))System.out.println(Datos[i]);
			}
			i++;
		}
		
	}
	/**
	*Funcion Main
	*/
	public static void main(String[] args){
		iniciarOcupados();
		Scanner entrada=new Scanner(System.in);
		String nombre,dni,direccion,compania,fnac;
		int op,tel;
		do{
		System.out.println("Menu: ");
		System.out.println("1.Introducir Paciente");
		System.out.println("2.Borrar Paciente");
		System.out.println("3.Buscar Paciente");
		System.out.println("0.Salir");
		op=entrada.nextInt();
		entrada.nextLine();
		switch(op){
			case 1: System.out.println("Introduzca nombre:");
				nombre=entrada.nextLine();
				System.out.println("Introduzca dni:");
				dni=entrada.nextLine();
				System.out.println("Introduzca direccion:");
				direccion=entrada.nextLine();
				System.out.println("Introduzca Fecha de nacimiento:");
				fnac=entrada.nextLine();
				System.out.println("Introduce la compaÃ±ia:");
				compania=entrada.nextLine();
				System.out.println("Introduce el telefono:");
				tel=entrada.nextInt();
				Paciente p=new Paciente(nombre,dni,direccion,compania,fnac,tel);
				introducirPaciente(p);
				break;
			case 2:	System.out.println("Introduzca el dni del paciente a borrar:");
				dni=entrada.nextLine();
				borrarPaciente(dni);
				break;
			case 3:	System.out.println("\n1.Buscar por dni\n2.Buscar por nombre\n");
				op=entrada.nextInt();
				entrada.nextLine();
				switch(op){
					case 1:	System.out.println("Introduzca dni:");
						dni=entrada.nextLine();
						buscarPaciente(dni,op);
						break;
					case 2: System.out.println("Introduzca nombre:");
						nombre=entrada.nextLine();
						buscarPaciente(nombre,op);
						break;
				}
				break;
				
		}
		}while(op!=0);
	}
}
